from antlr4 import *
from testLexer import testLexer
from testParser import testParser
from antlr4.tree.Trees import Trees
from ast_v import *
import pydot

def main():
    file_route = "test.yapl"
    
    with open(file_route, 'r') as file:
        input_stream = InputStream(file.read())
        
        lexer = testLexer(input_stream)
        token_stream = CommonTokenStream(lexer)
        parser = testParser(token_stream)
        
        tree = parser.prog()
        print(Trees.toStringTree(tree, None, parser))
        
        visitor = TransformDot()
        visitor.visit(tree)
        dot = visitor.getDot()
        with open('ast.dot', 'w') as file:
            file.write(dot)
        
if __name__ == "__main__":
    main()
    

    graphs = pydot.graph_from_dot_file('ast.dot')
    graph = graphs[0]
    graph.write_png('out.png')
    # graph.write_png('somefile.png')
    