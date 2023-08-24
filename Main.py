from antlr4 import *
from antlr4 import ParseTreeVisitor
from antlr4.tree.Tree import TerminalNodeImpl
from antlr4.error.ErrorListener import ErrorListener
from testLexer import testLexer
from testParser import testParser
from testListener import testListener
from antlr4.tree.Trees import Trees
from prettytable.prettytable import NONE
from SymbolsTable import *
import networkx as nx
import matplotlib.pyplot as plt
import pydot
from colorama import *

class errorListener(ErrorListener):
    def _init_(self):
        self.hasError = False
        self.listErrors = []
        pass

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.hasError = True
        errorMsg = Fore.RED + f'Error encontrado en la línea {line}. ' \
                f'Motivo de fallo: {msg}' + Style.RESET_ALL
        self.listErrors.append(errorMsg)

    
    def getHasError(self):
        return self.hasError
class Lex_Ser():
    
    def main(self):
        
        # with open("testError.yapl", 'r') as file:
        with open("test.yapl", 'r') as file:
            input_stream = InputStream(file.read())
            
            lexer = testLexer(input_stream)
            lexer.removeErrorListeners()
            token_stream = CommonTokenStream(lexer)
            parser = testParser(token_stream)
            myError = errorListener() 
            parser.removeErrorListeners()
            parser.addErrorListener(myError)
            tree = parser.program()  

            if myError.getHasError():
                print(Style.BRIGHT + "Se ha(n) encontrado error(es)" + Style.RESET_ALL)
                for i in myError.listErrors:
                    print(i)
            else:
                printer = ShowTable()
                visitor = TransformDot()
                visitor.visit(tree)
                dot = visitor.getDot()
                walkerTree = ParseTreeWalker() # recorrer este árbol de análisis y aplicar logica
                walkerTree.walk(printer, tree)
                with open('ast.dot', 'w') as file:
                    file.write(dot)
                print(Fore.GREEN +'Árbol generado con éxito, visualize: ' + Style.BRIGHT + "out.png" + Style.RESET_ALL)

            
class TransformDot(ParseTreeVisitor):
    def __init__(self):
        super().__init__()
        self.dot = 'digraph AST {\n'
        self.id = 0

    def visitChildren(self, node):
        node_id = self.id
        for i in range(node.getChildCount()):
            child = node.getChild(i)
            if not isinstance(child, TerminalNodeImpl):
                self.id += 1
                child_id = self.id
                self.dot += '  node{} [label="{}"];\n'.format(child_id, child.getText())
                self.dot += '  node{} -> node{};\n'.format(node_id, child_id)
                self.visit(child)

    def terminalNode(self, node):
        self.dot += '  node{} [label="{}"];\n'.format(self.id, node.getText())
        if self.id != 0:
            self.dot += '  node{} -> node{};\n'.format(self.id - 1, self.id)

    def getDot(self):
        return self.dot + '}\n'

    
LS = Lex_Ser()
LS.main()
    
with open('ast.dot', 'r') as dot_file:
    dot_contents = dot_file.read()

graph = pydot.graph_from_dot_data(dot_contents)[0]

nx_graph = nx.DiGraph()

for edge in graph.get_edges():
    source = edge.get_source()
    target = edge.get_destination()
    nx_graph.add_edge(source, target)

pos = nx.spring_layout(nx_graph)  # Puedes cambiar el layout según tus preferencias
nx.draw(nx_graph, pos, with_labels=True, node_size=1000, font_size=10, font_color='black')

plt.savefig('out.png', format='png')

plt.show()