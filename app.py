from flask import *
import subprocess
from antlr4.InputStream import InputStream
from testLexer import testLexer
from testParser import testParser
from antlr4.error.ErrorListener import ErrorListener
from testLexer import testLexer
from SymbolsTable import *
from Main import *

app = Flask(__name__)

def antlrParse(data):
    input_code = data
    input_stream = InputStream(data)
    myError = errorListener()  # Cambio a minúsculas para la instancia
    lexer = testLexer(input_stream)
    token_stream = CommonTokenStream(lexer)
    parser = testParser(token_stream)
    parser.addErrorListener(myError)
    tree = parser.program()   
    lisp_tree_str = tree.toStringTree(recog=parser)
    
    if not myError.getHasError():
        print("No hay errores.")
        printer = ShowTable()
        visitor = TransformDot()
        visitor.visit(tree)
        walkerTree = ParseTreeWalker() # recorrer este árbol de análisis y aplicar logica
        walkerTree.walk(printer, tree)
    #printer = ShowTable()
    """ visitor = TransformDot()
                visitor.visit(tree)
                dot = visitor.getDot()
                walkerTree = ParseTreeWalker() # recorrer este árbol de análisis y aplicar logica
                #walkerTree.walk(printer, tree)
                with open('ast.dot', 'w') as file:
                    file.write(dot)
                print(Fore.GREEN +'Árbol generado con éxito, visualize: ' + Style.BRIGHT + "out.png" + Style.RESET_ALL) """

    return myError

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/upload', methods=['POST'])
def upload():
    content = ""
    if 'file' in request.files:
        file = request.files['file']
        if file.filename != '':   
            content = file.read().decode('utf-8')
    return render_template('index.html', content=content)

@app.route('/limpiar')
def limpiar():
    return render_template('index.html')

@app.route('/compile', methods=['POST'])
def compile_code():
    content = request.json.get('code', '')  # Obtener el contenido del código del campo JSON
    print('\ncontent', content)
    print('-----------------------------------------\n')
    cmd = ['python', 'Main.py']  # Comando para ejecutar el compilador
    process = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, stdin=subprocess.PIPE)
    stdout= antlrParse(content)  # Pasar el contenido del código como entrada estándar
    print('\n\nstdout', stdout)

    output=""
    if stdout.getHasError():
                print(Style.BRIGHT + "Se ha(n) encontrado error(es)" + Style.RESET_ALL)
                output="Se ha(n) encontrado error(es)"
                for i in stdout.listErrors:
                    output=output+"\n"+i
                    print(i)
    else:
         output='Funciona correctamente'


    return json.dumps({'result': "Compilo", 'output': output})


if __name__ == '__main__':
    app.run(debug=True)