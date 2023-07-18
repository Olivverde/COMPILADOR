from antlr4 import *
from antlr4 import ParseTreeVisitor
from antlr4.tree.Tree import TerminalNodeImpl
from testLexer import testLexer
from testParser import testParser
from antlr4.tree.Trees import Trees
import pydot

class Lex_Ser():
    
    def main(self):
        
        with open("test.yapl", 'r') as file:
            input_stream = InputStream(file.read())
            
            lexer = testLexer(input_stream)
            token_stream = CommonTokenStream(lexer)
            parser = testParser(token_stream)
            
            tree = parser.prog()        
            visitor = TransformDot()
            visitor.visit(tree)
            dot = visitor.getDot()
            with open('ast.dot', 'w') as file:
                file.write(dot)
            
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
    
graphs = pydot.graph_from_dot_file('ast.dot')
graph = graphs[0]
graph.write_png('out.png')
graph.write_png('out.png')
    