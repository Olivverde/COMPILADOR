
# LIBS
from antlr4 import *
from colorama import *
import antlr4.Utils as Utils
from antlr4.tree.Trees import Trees
from dist.testLexer import testLexer
from dist.testParser import testParser
from dist.testListener import testListener
from antlr4.error.ErrorListener import ErrorListener

class errorListener(ErrorListener):
    def __init__(self):
        super().__init__()  # Llamada al constructor de la clase base
        self.hasError = False
        self.listErrors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.hasError = True
        errorMsg = f'- Error encontrado en la línea {line}. ' \
                f'Motivo de fallo: {msg}'
        self.listErrors.append(errorMsg)

    def getHasError(self):
        return self.hasError

class Lex_Ser():
    
    def main(self):
        pass
        """  with open("./Test/hello_world.cl", 'r') as file:
            input_stream = InputStream(file.read())
            myError = errorListener()  # Cambio a minúsculas para la instancia
            lexer = testLexer(input_stream)
            token_stream = CommonTokenStream(lexer)
            parser = testParser(token_stream)
            parser.addErrorListener(myError)
            tree = parser.program()   
            lisp_tree_str = tree.toStringTree(recog=parser)
            
            if not myError.getHasError():
                print("No hay errores.")
        """
           
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

#plt.show()

