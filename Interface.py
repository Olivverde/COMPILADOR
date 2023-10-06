from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
import sys
from Main import Compiler

# Based on PyQt5 examples obtained from:: https://www.guru99.com/pyqt-tutorial.html


class defaultWindow(QMainWindow):
    def __init__(self, *args, **kwargs):
        
        # File to compile
        self.fpath = None

        self.edition_box = ""
        super(defaultWindow, self).__init__(*args, **kwargs)

        # Base window configuration
        self.setGeometry(100,100,1400,800)
        ff = QFontDatabase.systemFont(QFontDatabase.FixedFont)
        ff.setPointSize(12)

        # Window object configuration
        mainL = QVBoxLayout()
        self.tabs = QTabWidget()
        self.ttexto = QWidget()
        self.tresults = QWidget()

        self.tabs.addTab(self.ttexto, "Editor de texto:")
        self.tabs.addTab(self.tresults, "Salida:")
        mainL.addWidget(self.tabs)

        self.txteditor = QCodeEditor()
        
        self.txteditor.setFont(ff)
        
        self.errorbox = ScrollLabel()
        self.errorbox.setFont(ff)
        self.errorbox.setText("")

        self.tresults.layout = QVBoxLayout()
        self.tresults.layout.addWidget(self.errorbox)
        self.tresults.setLayout(self.tresults.layout)

        self.ttexto.layout = QVBoxLayout()
        self.ttexto.layout.addWidget(self.txteditor)


        self.ttexto.setLayout(self.ttexto.layout)

        cont = QWidget()
        cont.setLayout(mainL)
        self.setCentralWidget(cont)

        # Menu bar settings
        self.status_bar = QStatusBar()
        self.setStatusBar(self.status_bar)

        # File menu bar settings
        file_bar = QToolBar("Archivo")
        self.addToolBar(file_bar)

        # Open file button
        o_file_act = QAction("Abrir archivo", self)
        o_file_act.setStatusTip("Abrir archivo")
        o_file_act.triggered.connect(self.open_file)

        # Save file button
        save_file_act = QAction("Guardar archivo", self)
        save_file_act.setStatusTip("Guardar archivo")
        save_file_act.triggered.connect(self.save_file)

        # Save as button
        save_file_as_act = QAction("Guardar archivo como", self)
        save_file_as_act.setStatusTip("Guarda el archivo en una ruta especifica")
        save_file_as_act.triggered.connect(self.save_file_as)

        # Compile button
        compile_act = QAction("Compilar", self)
        compile_act.setStatusTip("Compilar archivo")
        compile_act.triggered.connect(self.compile)
        
        # Adding buttons to the file menu bar
        file_bar.addAction(o_file_act)
        file_bar.addAction(save_file_act)
        file_bar.addAction(save_file_as_act)
        file_bar.addAction(compile_act)

        self.show()

    # General error handling function
    def error(self, msg):
        error_box = QMessageBox(self)
        error_box.setIcon(QMessageBox.Critical)
        error_box.setText(msg)
        error_box.show()

    # Open file function
    def open_file(self):
        f_path, _ = QFileDialog.getOpenFileName(self, "Abrir archivo", "", "Archivos YAPL (*.YAPL);; Archivos de texto (*.txt);; Archivos CL (*.cl)")
        if f_path:
            try:
                with open(f_path, "r") as file:
                    text = file.read()
            except Exception as e:
                self.error(str(e))
            else:
                self.fpath = f_path
                self.txteditor.setPlainText(text)

    # Save changes function
    def save_file(self):
        if self.fpath is None:
            return self.save_file_as()
        self.save_in_path(self.fpath)
    
    # Function to save file to a known path
    def save_in_path(self, path):
        text = self.txteditor.toPlainText()
        try:
            with open(path, "w") as file:
                file.write(text)
        except Exception as e:
            self.error(str(e))
        else:
            self.fpath = path
    
    # Function to save file to a specific path
    def save_file_as(self):
        f_path, _ = QFileDialog.getSaveFileName(self, "Guardar archivo", "", "Archivos de texto (*.txt);; Archivos YAPL (*.YAPL);; Archivos CL (*.cl)")
        if f_path:
            self.save_in_path(f_path)
    
    # Function to compile file
    def compile(self):
        try:
            self.errorbox.setText("")
            if self.fpath is None:
                return self.save_file_as()
            
            self.save_in_path(self.fpath)

            hasError = False

            if self.txteditor.toPlainText() != "":
                to_compile = Compiler(self.fpath)

                errorText = ""

                if to_compile.LexErr != None:

                    lexerrs = "\n".join(to_compile.LexErr)
                    print("There are lexical errors")
                    errorText += "Lexical errors:\n"+lexerrs
                    hasError = True
                
                if to_compile.SintErr != None:
                    print("There are syntax errors")
                    errorText += "\n\nSyntax errors:\n"+to_compile.SintErr
                    hasError = True

                if to_compile.SemErr != None:
                    print("There are semantic errors")
                    errorText += "\n\nSemantic erros:\n"+to_compile.SemErr
                    hasError = True
                    
                if not hasError:
                    self.errorbox.setText(to_compile.code_to_print)
                else:
                    self.errorbox.setText(errorText)
        except:
            self.errorbox.setText("Something Went Wrong")

    def edit_tog_wrap(self):
        self.txteditor.setLineWrapMode(1 if self.txteditor.lineWrapMode() == 0 else 0)

class QLineNumberArea(QWidget):
    def __init__(self, editor):
        super().__init__(editor)
        self.codeEditor = editor

    def sizeHint(self):
        return QSize(self.codeEditor.lineNumberAreaWidth(), 0)

    def paintEvent(self, event):
        self.codeEditor.lineNumberAreaPaintEvent(event)

class QCodeEditor(QPlainTextEdit):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.lineNumberArea = QLineNumberArea(self)
        self.blockCountChanged.connect(self.updateLineNumberAreaWidth)
        self.updateRequest.connect(self.updateLineNumberArea)
        self.cursorPositionChanged.connect(self.highlightCurrentLine)
        self.updateLineNumberAreaWidth(0)

    def lineNumberAreaWidth(self):
        digits = 1
        max_value = max(1, self.blockCount())
        while max_value >= 10:
            max_value /= 10
            digits += 1
        space = 3 + self.fontMetrics().width('9') * digits
        return space

    def updateLineNumberAreaWidth(self, _):
        self.setViewportMargins(self.lineNumberAreaWidth(), 0, 0, 0)

    def updateLineNumberArea(self, rect, dy):
        if dy:
            self.lineNumberArea.scroll(0, dy)
        else:
            self.lineNumberArea.update(0, rect.y(), self.lineNumberArea.width(), rect.height())
        if rect.contains(self.viewport().rect()):
            self.updateLineNumberAreaWidth(0)

    def resizeEvent(self, event):
        super().resizeEvent(event)
        cr = self.contentsRect()
        self.lineNumberArea.setGeometry(QRect(cr.left(), cr.top(), self.lineNumberAreaWidth(), cr.height()))

    def highlightCurrentLine(self):
        extraSelections = []
        if not self.isReadOnly():
            selection = QTextEdit.ExtraSelection()
            lineColor = QColor(Qt.yellow).lighter(160)
            selection.format.setBackground(lineColor)
            selection.format.setProperty(QTextFormat.FullWidthSelection, True)
            selection.cursor = self.textCursor()
            selection.cursor.clearSelection()
            extraSelections.append(selection)
        self.setExtraSelections(extraSelections)

    def lineNumberAreaPaintEvent(self, event):
        painter = QPainter(self.lineNumberArea)

        painter.fillRect(event.rect(), Qt.lightGray)

        block = self.firstVisibleBlock()
        blockNumber = block.blockNumber()
        top = self.blockBoundingGeometry(block).translated(self.contentOffset()).top()
        bottom = top + self.blockBoundingRect(block).height()

        # Just to make sure I use the right font
        height = self.fontMetrics().height()
        while block.isValid() and (top <= event.rect().bottom()):
            if block.isVisible() and (bottom >= event.rect().top()):
                number = str(blockNumber + 1)
                painter.setPen(Qt.black)
                painter.drawText(0, top, self.lineNumberArea.width(), height, Qt.AlignRight, number)

            block = block.next()
            top = bottom
            bottom = top + self.blockBoundingRect(block).height()
            blockNumber += 1
            
class ScrollLabel(QScrollArea):

    # constructor
    def __init__(self, *args, **kwargs):
        QScrollArea.__init__(self, *args, **kwargs)

        # making widget resizable
        self.setWidgetResizable(True)

        # making qwidget object
        content = QWidget(self)
        self.setWidget(content)

        # vertical box layout
        lay = QVBoxLayout(content)

        # creating label
        self.label = QLabel(content)

        # setting alignment to the text
        self.label.setAlignment(Qt.AlignLeft | Qt.AlignTop)

        # making label multi-line
        self.label.setWordWrap(True)

        # adding label to the layout
        lay.addWidget(self.label)

    # the setText method
    def setText(self, text):
        # setting text to the label
        self.label.setText(text)

# Main
app = QApplication(sys.argv)
app.setApplicationName("Compis Project")
window = defaultWindow()
app.exec_()

