from antlr4 import *
from testLexer import testLexer
from testParser import testParser
from antlr4.tree.Trees import Trees

def main():
    file_route = "test.yapl"
    
    with open(file_route, 'r') as file:
        input_stream = InputStream(file.read())
        
        lexer = testLexer(input_stream)
        token_stream = CommonTokenStream(lexer)
        parser = testParser(token_stream)
        
        tree = parser.prog()
        print(Trees.toStringTree(tree, None, parser))
        
if __name__ == "__main__":
    main()  
    