
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
        Laura
        
        _summary_
        This class is a custom error listener used for capturing and handling syntax errors during parsing.
        It extends the base ErrorListener class and overrides the syntaxError method to customize error handling.

        _Attributes_
            hasErrors: A boolean flag that indicates whether syntax errors have been encountered.
            syntaxErrors: A list that stores syntax error messages. 
"""
  
class MyErrorListener(ErrorListener):
    def __init__(self):
        # Initialize error flags and a list to store syntax errors
        self.hasErrors = False
        self.syntaxErrors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        # Set the error flag to True
        self.hasErrors = True
        if "expecting" in msg:
            # If the error message contains "expecting," format a detailed error message
            errorMsg = f' -> At line {line}:{column}, found {str(offendingSymbol).split("=")[1].split(",")[0]}. Expected {msg.split("expecting")[1]}'
        else:
            # If no specific expectation is mentioned, use the provided error message
            errorMsg = msg
        # Append the error message to the list of syntax errors
        self.syntaxErrors.append(errorMsg)

    def hasError(self):
        # Check if any syntax errors occurred
        return self.hasErrors

    def getErrors(self):
        # Retrieve the list of syntax errors
        return self.syntaxErrors
    
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

class outputHandler(testListener):
    def __init__(self):
        # Initialize class attributes and data structures.
        self.root = None
        self.news = 0

        # Define primitive data types as constants.
        self.STRING = "String"
        self.INT = "Int"
        self.BOOL = "Bool"
        self.VOID = "void"
        self.SELF_TYPE = "SELF_TYPE"
        self.IO = "IO"
        self.ERROR = "error"
        self.OBJECT = "Object"

        # Create a dictionary for mapping data type names to constants.
        self.data_types = {
            "String": self.STRING,
            "Int": self.INT,
            "Bool": self.BOOL,
            "void": self.VOID,
            "SELF_TYPE": self.SELF_TYPE,
            "IO": self.IO,
            "error": self.ERROR,
            "Object": self.OBJECT
        }

        self.scopes = []
        self.scope_register = []
        self.current_scope = None

        # Initialize tables and error tracking objects.
        self.type_table = TypeTable()
        self.class_table = ClassTable()
        self.par_table = ParameterTable()
        self.method_table = MethodTable()
        self.my_errors = ErrorTypes() ##$$$$ PENDING

        self.nodes_and_types = {}

        super().__init__()

    # ... (other methods)
    
    def scope_pop(self):
        # Pop the current scope from the scope stack and print its contents.
        print("SCOPE:", self.current_scope.scope_name)
        self.current_scope.toTable()
        self.current_scope = self.scopes.pop()
        
    def scope_push(self, name):
        # Push a new scope onto the stack with the given name.
        self.scopes.append(self.current_scope)
        self.current_scope = SymbolTable(name)
    
    def get_var(self, id):
        # Search for a variable by its identifier within the current and outer scopes.
        this_var = self.current_scope.search(id)
        if this_var is None:
            revers_scopes = self.scopes.copy()
            revers_scopes.reverse()
            for scope in revers_scopes:
                this_var_new = scope.search(id)
                if this_var_new is not None:
                    return this_var_new
            return None
        else:
            return this_var
    
    def enterProgram(self, ctx: testParser.ProgramContext):
        # Initialize the program scope and add the "self" variable.
        self.root = ctx
        self.current_scope = SymbolTable(ctx.getText())
        self.current_scope.add("SELF_TYPE", "self", self.type_table.search("SELF_TYPE")['size'], self.current_scope.this_off, False)
    
    def BelowNodesHasError(self, ctx):
        # Check if any child nodes of the context have errors.
        for child in ctx.getChildren():
            if isinstance(child, TerminalNode):
                continue
            if child.getText() == 'self':
                if self.nodes_and_types[child.getText()+self.method_table.search(self.current_scope.scope_name)['parent']] == self.ERROR:
                    return True
                else:
                    return False
            if self.nodes_and_types[child.getText()] == self.ERROR:
                return True
        return False
    
    def exitProgram(self, ctx: testParser.ProgramContext):
        # Perform checks and print symbol tables and types.
        main_class = self.class_table.search("Main")
        if main_class is not None:
            if 'main' in main_class['methods']:
                if main_class["inherits"] != "":
                    self.nodes_and_types[ctx.getText()] = self.ERROR
                    self.my_errors.add_error(self.my_errors.main_her, 0, 0)
                else:
                    self.nodes_and_types[ctx.getText()] = self.VOID
            else:
                self.nodes_and_types[ctx.getText()] = self.ERROR
                self.my_errors.add_error(self.my_errors.no_main, 0, 0)
        else:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            self.my_errors.add_error(self.my_errors.no_main, 0, 0)
        
        # Print symbol tables and all types found.
        print("---------------Class Table---------------")
        self.class_table.toTable()
        print("\n\n---------------Type Table---------------")
        self.type_table.toTable()
        print("\n\n---------------Method Table---------------")
        self.method_table.toTable()

        print("--------------All types found ----------------")
        for i in self.nodes_and_types:
            print("Structure: ", i, " Type: ", self.nodes_and_types[i])
        
    def enterClass(self, ctx: testParser.ClassContext):
    # Get the class name and initialize variables.
        this_class = ctx.var_type()[0].getText()
        inherits = ""
        methods = []

        # Check if the class is already defined.
        if self.class_table.search(this_class) is None:
            # Check if the class inherits from another class.
            if ctx.getChild(2).getText() == "inherits":
                inherits = ctx.getChild(3).getText()
                
                # Validate the inheritance relationship.
                if self.class_table.search(inherits) is None:
                    self.my_errors.add_error(self.my_errors.no_her, ctx.getChild(3).start.line, ctx.getChild(3).start.column)
                elif inherits == this_class:
                    self.my_errors.add_error(self.my_errors.self_her, ctx.getChild(3).start.line, ctx.getChild(3).start.column)
                else:
                    methods = self.class_table.search(inherits)['methods'].copy()

            # Add the class to the class table.
            self.class_table.add_class(this_class, this_class, inherits, methods)
            self.type_table.add(this_class, 0, self.type_table.CLASS)
            self.nodes_and_types[this_class] = this_class
        else:
            # Class with the same name has already been defined.
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.redef, line, column)

        # Push a new scope for the class.
        self.scope_push(this_class)

    def exitClass(self, ctx: testParser.ClassContext):
            # Get the class name.
            this_class = ctx.var_type()[0].getText()

            # Calculate the size of the scope and update it in the type table.
            size_scope = self.current_scope.getSize()
            self.type_table.search(this_class)['size'] = size_scope

            # Set the type of the class context to VOID.
            self.nodes_and_types[ctx.getText()] = self.VOID

            # Register the current scope and pop it from the stack.
            self.scope_register.append(self.current_scope)
            self.scope_pop()

    def exitString_expr(self, ctx: testParser.String_exprContext):
        # Set the type of the string expression context to STRING.
        self.nodes_and_types[ctx.getText()] = self.STRING
        
    def exitInt_expr(self, ctx: testParser.Int_exprContext):
        # Set the type of the integer expression context to INT.
        self.nodes_and_types[ctx.getText()] = self.INT

    def exitTrue_expr(self, ctx: testParser.True_exprContext):
        # Set the type of the true expression context to BOOL.
        self.nodes_and_types[ctx.getText()] = self.BOOL
        
    def exitFalse_expr(self, ctx: testParser.False_exprContext):
        # Set the type of the false expression context to BOOL.
        self.nodes_and_types[ctx.getText()] = self.BOOL

    def enterVar_expr(self, ctx: testParser.Var_exprContext):
        # Get the parent context and check if it has a known type.
        parent = ctx.parentCtx.getText()
        if parent in self.nodes_and_types.keys():
            # Set the type of the variable expression context to the type of its parent.
            self.nodes_and_types[ctx.getText()] = self.nodes_and_types[parent]

    def exitVar_expr(self, ctx: testParser.Var_exprContext):
        # Get the parent context and check if it or the current context has a known type.
        parent = ctx.parentCtx.getText()
        if parent in self.nodes_and_types.keys() or ctx.getText() in self.nodes_and_types.keys():
            return

        # Get the identifier from the current context.
        id = ctx.getText()
        this_var = self.get_var(id)

        # Check if the variable is not defined.
        if this_var == None:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.no_def, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR
        else:
            # Check the type of the variable and set it accordingly.
            if this_var["type"] in [self.INT, self.BOOL, self.STRING]:
                self.nodes_and_types[ctx.getText()] = this_var["type"]
            elif this_var["type"] == "SELF_TYPE":
                # Handle SELF_TYPE by associating the type with its parent class.
                self.nodes_and_types[ctx.getText()+self.method_table.search(self.current_scope.scope_name)['parent']] = self.method_table.search(self.current_scope.scope_name)['parent']
                self.method_table.search(self.current_scope.scope_name)['type'] = self.method_table.search(self.current_scope.scope_name)['parent']
            else:
                self.nodes_and_types[ctx.getText()] = self.VOID
                
    def enterClass_method(self, ctx: testParser.Class_methodContext):
            # Get the method's name.
            methodsName = ctx.var_id()[0].getText()
            parameters = []

            # Check if the method is not redefined.
            if self.method_table.search(methodsName) == None:
                tipo = ctx.return_type().var_type().getText()
                is_type = self.type_table.search(tipo)

                # Check if the return type is valid.
                if is_type != None:
                    hijos = ctx.getChildCount()
                    for i in range(hijos):
                        if isinstance(ctx.getChild(i), testParser.Var_typeContext):
                            par_type = ctx.getChild(i).getText()
                            is_type = self.type_table.search(par_type)

                            # Check if the parameter type is valid.
                            if is_type != None:
                                par_id = ctx.getChild(i - 2).getText()
                                if par_id in [i['id'] for i in parameters]:
                                    line = ctx.getChild(i).start.line
                                    col = ctx.getChild(i).start.column
                                    self.my_errors.add_error(self.my_errors.redef, line, col)
                                parameters.append({"type": par_type, "id": par_id})
                                self.par_table.add(par_type, par_id)
                            else:
                                line = ctx.return_type().var_type().start.line
                                column = ctx.return_type().var_type().start.column
                                self.my_errors.add_error(self.my_errors.no_type, line, column)

                    parent = ctx.parentCtx
                    parent_name = parent.var_type()[0].getText()

                    # Add the method to the method table and the class's list of methods.
                    self.method_table.add(tipo, methodsName, parameters, parent_name)
                    self.class_table.search(parent_name)['methods'].append(methodsName)
                else:
                    line = ctx.return_type().var_type().start.line
                    column = ctx.return_type().var_type().start.column
                    self.my_errors.add_error(self.my_errors.no_type, line, column)
            else:
                line = ctx.var_id()[0].start.line
                column = ctx.var_id()[0].start.column
                self.my_errors.add_error(self.my_errors.redef, line, column)

            # Push a new scope for the method and add the parameters to it.
            self.scope_push(methodsName)
            for par in parameters:
                par_type = self.type_table.search(par['type'])
                size = par_type['size']
                off = self.current_scope.this_off
                self.current_scope.add(par['type'], par['id'], size, off, True)

    def exitClass_method(self, ctx: testParser.Class_methodContext):
        # Get the method type from the method table.
        method_type = self.method_table.search(self.current_scope.scope_name)

        # Check if the method type is not defined or is an error.
        if method_type == None or method_type == self.ERROR:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        method_type = method_type['type']

        # Determine the type of the expression inside the method.
        if ctx.expr().getText() != 'self':
            exit_type = self.nodes_and_types[ctx.expr().getText()]
        else:
            exit_type = self.nodes_and_types[ctx.expr().getText()+self.method_table.search(self.current_scope.scope_name)['parent']]

        # Free the parameter table and pop the current scope.
        self.par_table.free()
        self.scope_register.append(self.current_scope)
        self.scope_pop()

        # Check for return type mismatches and errors.
        if method_type == self.VOID and exit_type != self.VOID and exit_type != self.ERROR:
            self.nodes_and_types[ctx.getText()]  = self.ERROR
            line = ctx.return_type().start.line
            col = ctx.return_type().start.column
            self.my_errors.add_error(self.my_errors.no_ret, line, col)
            return
        
        if method_type != exit_type:
            if exit_type == self.ERROR:
                self.nodes_and_types[ctx.getText()] = self.ERROR
                return
            self.nodes_and_types[ctx.getText()]  = self.ERROR
            line = ctx.return_type().start.line
            col = ctx.return_type().start.column
            self.my_errors.add_error(self.my_errors.dif_type_ret, line, col)
        
        self.nodes_and_types[ctx.getText()] = self.VOID
        
    def enterClass_attribute(self, ctx: testParser.Class_attributeContext):
        # Get the type and identifier of the attribute.
        type = ctx.var_type().getText()
        id = ctx.var_id().getText()

        # Check if the attribute is not redefined.
        if self.current_scope.search(id) == None:
            is_type = self.type_table.search(type)

            # Check if the attribute type is valid.
            if is_type == None:
                line = ctx.start.line
                column = ctx.start.column
                self.my_errors.add_error(self.my_errors.no_type, line, column)
                self.nodes_and_types[ctx.getText()] = self.ERROR
                return
            
            size = is_type["size"]
            offset = self.current_scope.this_off
            self.current_scope.add(type, id, size, offset, False)
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.redef, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR