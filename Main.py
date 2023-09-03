
# LIBS

import re
from antlr4 import *
from cmath import exp
from colorama import *
from re import S, search
from SymbolsTable import *
from operator import truediv
import antlr4.Utils as Utils
from itertools import groupby
from tkinter.messagebox import YES
from antlr4.tree.Trees import Trees
from multiprocessing import context
from dist.testLexer import testLexer
from dist.testParser import testParser
from dist.testListener import testListener
from antlr4.tree.Trees import TerminalNode
from unittest.mock import NonCallableMagicMock
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


"""
_Author_
Oliver

_summary_
This class provides utility methods for working with parse trees, specifically for generating a pretty-printed representation of a parse tree

_Attributes_
    eol: A string representing the end-of-line character(s).
    idents: A string representing the indentation used for each level of the parse tree.
    level: An integer representing the current indentation level. 
"""

class TreeUtils:
    def __init__(self):
        # Initialize constants for end-of-line and indentation
        self.eol = "\n"
        self.idents = "  "  # Two spaces for each level of indentation
        self.level = 0

    def toPrettyTree(self, t, rulenames):
        # Reset the indentation level to 0
        self.level = 0
        # Start processing the tree and return the formatted result
        return self.process(t, rulenames).replace("(?m)^\\s+$", "").replace("\\r?\\n\\r?\\n", self.eol)

    def process(self, t, ruleNames):
        if t.getChildCount() == 0:
            # If the current node has no children, escape whitespace in its text
            return Utils.escapeWhitespace(Trees.getNodeText(t, ruleNames), False)
        sb = ""
        sb += self.lead(self.level)  # Add indentation for the current level
        self.level += 1  # Increase the indentation level
        s = Utils.escapeWhitespace(Trees.getNodeText(t, ruleNames), False)
        sb += s + " "  # Append the text of the current node
        for i in range(t.getChildCount()):
            # Recursively process child nodes
            sb += self.process(t.getChild(i), ruleNames)
        
        self.level -= 1  # Decrease the indentation level
        sb += self.lead(self.level)  # Add indentation for the current level
        
        return sb

    def lead(self, level):
        sb = ""
        if level > 0:
            # Add the appropriate amount of indentation for the current level
            sb += self.eol
            for i in range(level):
                sb += self.idents

        return sb


"""
_Author_
Oliver

_summary_
Represents a token in the source code with attributes for token value, line number, and token type.

_Attributes_
    token: The actual token value.
    line: The line number where the token was found.
    token_type: The type of the token.
"""

class Tokens():
    def __init__(self, token, line, token_type):
        # Initialize a Token object with token value, line number, and token type
        self.token = token  # The actual token value
        self.line = line    # The line number where the token was found
        self.token_type = token_type  # The type of the token

# Example usage:
# my_token = Token("my_identifier", 10, "IDENTIFIER")



"""
_Author_
Oliver

_summary_
Checks if a given token represents an error (not equal to the error token testLexer.ERR_TOKEN).

_Attributes_
    token: The actual token value.
    line: The line number where the token was found.
    token_type: The type of the token.
"""

def getError(token):
    # Check if the given token is not equal to the error token (testLexer.ERR_TOKEN)
    return token != testLexer.ERR_TOKEN



"""
_Author_
Oliver

_summary_
Represents a compiler that performs lexical, syntax, and semantic analysis on a source code file.
"""

class Compiler:
    def __init__(self, file):
        # Initialize the compiler with the given file name
        filename = file
        self.LexErr = None  # Initialize lexical error as None
        self.SintErr = None  # Initialize syntax error as None
        self.SemErr = None  # Initialize semantic error as None

        print(f'Parsing file: {filename}')

        # Create a FileStream and lexer
        inputStream = FileStream(filename)
        lexer = testLexer(inputStream)
        stream = CommonTokenStream(lexer)

        contentHasErr = False
        errorTks = []
        actualTk = lexer.nextToken()

        # Token scanning loop
        while actualTk.type != Token.EOF:
            is_error = getError(actualTk.type)
            if not is_error:
                errorTks.append(f'-> Unrecognized character: {actualTk.text} at line: {actualTk.line}\n')
                contentHasErr = True
            
            actualTk = lexer.nextToken()

        # Determine if lexical errors occurred
        if not contentHasErr:
            self.LexErr = None
        else:
            self.LexErr = errorTks

        lexer.reset()

        stream = CommonTokenStream(lexer)
        parser = testParser(stream)

        parser.removeErrorListeners()
        listener = MyErrorListener() #################### PENDING
        parser.addErrorListener(listener)
        parser.buildParseTrees = True
        tree = parser.program()
        rulenames = parser.ruleNames

        # Generate a pretty-printed parse tree
        self.prettyTree = TreeUtils().toPrettyTree(tree, rulenames)

        self.listErr = listener.getErrors()

        # Determine if syntax errors occurred
        if len(self.listErr) > 0:
            sintErr = ""
            for err in self.listErr:
                sintErr += err + "\n"
            self.SintErr = sintErr
        
        # If no syntax errors, proceed with semantic analysis
        if len(self.listErr) <= 0:
            self.printer = YaplPrinter() ########### PENDING
            walker = ParseTreeWalker()
            walker.walk(self.printer, tree)
            if len(self.printer.my_errors.get_errors()) > 0:
                SemErr = ""
                for err in self.printer.my_errors.get_errors():
                    SemErr += err + "\n"
                self.SemErr = SemErr


"""
_Author_
Oliver & Laura

_summary_
PRINTERS COMING SOON
"""



