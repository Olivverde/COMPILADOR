# LIBS
from antlr4 import *
from SymbolsTable import *
import antlr4.Utils as Utils
from intermediateCode import *
from antlr4.tree.Trees import Trees
from antlr.testLexer import testLexer
from antlr.YAPLParser import YAPLParser
from antlr.YAPLListener import YAPLListener
from antlr4.tree.Trees import TerminalNode
from antlr4.error.ErrorListener import ErrorListener


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
        parser = YAPLParser(stream)

        parser.removeErrorListeners()
        listener = MyErrorListener()
        parser.addErrorListener(listener)
        parser.buildParseTrees = True
        tree = parser.program()
        rulenames = parser.ruleNames

        # Generate a pretty-printed parse tree
        self.prettyTree = TreeUtils().toPrettyTree(tree, rulenames)
        print(self.prettyTree)

        self.listErr = listener.getErrors()

        # Determine if syntax errors occurred
        if len(self.listErr) > 0:
            sintErr = ""
            for err in self.listErr:
                sintErr += err + "\n"
            self.SintErr = sintErr
            contentHasErr = True

        self.printer = outputHandler()
        walker = ParseTreeWalker()
        walker.walk(self.printer, tree)

        if len(self.printer.my_errors.get_errors()) > 0:
            SemErr = ""
            for err in self.printer.my_errors.get_errors():
                SemErr += err + "\n"
            self.SemErr = SemErr
            contentHasErr = True

        if not contentHasErr:
            lexer.reset()

            stream = CommonTokenStream(lexer)
            parser = YAPLParser(stream)

            parser.removeErrorListeners()
            listener = MyErrorListener()
            parser.addErrorListener(listener)
            parser.buildParseTrees = True
            tree = parser.program()
            # Through the tree again but now generating intermediate code
            self.codePrinter = Intermediate()
            walker = ParseTreeWalker()
            walker.walk(self.codePrinter, tree)

            self.this_code = self.codePrinter.code_generated
            
            self.code_to_print = '\n'.join(self.this_code)
        
        """ # If no syntax errors, proceed with semantic analysis
        if len(self.listErr) <= 0:
            self.printer = outputHandler()
            walker = ParseTreeWalker()
            walker.walk(self.printer, tree)
            if len(self.printer.my_errors.get_errors()) > 0:
                SemErr = ""
                for err in self.printer.my_errors.get_errors():
                    SemErr += err + "\n"
                self.SemErr = SemErr """
                

class outputHandler(YAPLListener):
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

        """ # Create a dictionary for mapping data type names to constants.
        self.data_types = {
            "String": self.STRING,
            "Int": self.INT,
            "Bool": self.BOOL,
            "void": self.VOID,
            "SELF_TYPE": self.SELF_TYPE,
            "IO": self.IO,
            "error": self.ERROR,
            "Object": self.OBJECT
        } """

        self.scopes = []
        self.scope_register = []
        self.current_scope = None

        # Initialize tables and error tracking objects.
        self.type_table = TypeTable()
        self.class_table = ClassTable()
        self.par_table = ParameterTable()
        self.method_table = MethodTable()
        self.my_errors = ErrorTypes()

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

    def enterProgram(self, ctx: YAPLParser.ProgramContext):
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
            if child.getText() == "String" or child.getText() == "Int" or child.getText() == "Bool" or child.getText() == "Object":
                continue

            if self.nodes_and_types[child.getText()] == self.ERROR:
                return True
        return False
    
    def exitProgram(self, ctx: YAPLParser.ProgramContext):
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

        
        ############################################################################# TEMPORARY DEPRECATED
        # print("--------------All types found ----------------")
        # for i in self.nodes_and_types:
        #     print("Structure: ", i, " Type: ", self.nodes_and_types[i])

    def enterClass(self, ctx: YAPLParser.ClassContext):
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
                if self.class_table.search(inherits) == None:
                    self.nodes_and_types[inherits] = self.ERROR
                    self.nodes_and_types[this_class] = self.ERROR
                    self.my_errors.add_error(self.my_errors.no_her, ctx.getChild(3).start.line, ctx.getChild(3).start.column)
                elif inherits == this_class:
                    self.nodes_and_types[this_class] = self.ERROR
                    self.my_errors.add_error(self.my_errors.self_her, ctx.getChild(3).start.line, ctx.getChild(3).start.column)
                elif inherits == "String" or inherits == "Int" or inherits == "Bool" or inherits == "Object":
                    self.nodes_and_types[this_class] = self.ERROR
                    self.my_errors.add_error(self.my_errors.prim_her, ctx.getChild(3).start.line, ctx.getChild(3).start.column)
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
            self.nodes_and_types[this_class] = self.ERROR

        # Push a new scope for the class.
        self.scope_push(this_class)

    def exitClass(self, ctx: YAPLParser.ClassContext):
        # Get the class name.
        this_class = ctx.var_type()[0].getText()

        # Calculate the size of the scope and update it in the type table.
        size_scope = self.current_scope.getSize()
        self.type_table.search(this_class)['size'] = size_scope

        #Errors in child nodes
        hasError = self.BelowNodesHasError(ctx)
        if hasError:
            self.nodes_and_types[ctx.getText()] = self.ERROR
        else:
            # Set the type of the class context to VOID.
            self.nodes_and_types[ctx.getText()] = self.VOID


        # Register the current scope and pop it from the stack.
        self.scope_register.append(self.current_scope)
        self.scope_pop()

    def exitString_expr(self, ctx: YAPLParser.String_exprContext):
        # Set the type of the string expression context to STRING.
        self.nodes_and_types[ctx.getText()] = self.STRING

    def exitInt_expr(self, ctx: YAPLParser.Int_exprContext):
        # Set the type of the integer expression context to INT.
        self.nodes_and_types[ctx.getText()] = self.INT

    def exitTrue_expr(self, ctx: YAPLParser.True_exprContext):
        # Set the type of the true expression context to BOOL.
        self.nodes_and_types[ctx.getText()] = self.BOOL

    def exitFalse_expr(self, ctx: YAPLParser.False_exprContext):
        # Set the type of the false expression context to BOOL.
        self.nodes_and_types[ctx.getText()] = self.BOOL

    def enterVar_expr(self, ctx: YAPLParser.Var_exprContext):
        # Get the parent context and check if it has a known type.
        parent = ctx.parentCtx.getText()
        if parent in self.nodes_and_types.keys():
            # Set the type of the variable expression context to the type of its parent.
            self.nodes_and_types[ctx.getText()] = self.nodes_and_types[parent]
        
    def exitVar_expr(self, ctx: YAPLParser.Var_exprContext):
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

    def enterClass_method(self, ctx: YAPLParser.Class_methodContext):
        # Get the method's name.
        methodsName = ctx.var_id()[0].getText()
        parameters = []

        # Check if the method is not redefined.
        if self.method_table.search(methodsName) == None:
            _type = ctx.return_type().var_type().getText()
            is_type = self.type_table.search(_type)

            # Check if the return type is valid.
            if is_type != None:
                child_s = ctx.getChildCount()
                for i in range(child_s):
                    if isinstance(ctx.getChild(i), YAPLParser.Var_typeContext):
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
                            #self.par_table.add(par_type, par_id)
                        else:
                            line = ctx.return_type().var_type().start.line
                            column = ctx.return_type().var_type().start.column
                            self.my_errors.add_error(self.my_errors.no_type, line, column)

                parent = ctx.parentCtx
                parent_name = parent.var_type()[0].getText()

                # Add the method to the method table and the class's list of methods.
                self.method_table.add(_type, methodsName, parameters, parent_name)
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

    def exitClass_method(self, ctx: YAPLParser.Class_methodContext):
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
        #self.par_table.free()
        self.scope_register.append(self.current_scope)
        copy_vars = self.current_scope
        self.scope_pop()
        self.current_scope.symbol_table += copy_vars.symbol_table

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

    def enterClass_attribute(self, ctx: YAPLParser.Class_attributeContext):
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

    def exitClass_attribute(self, ctx: YAPLParser.Class_attributeContext):
        self.nodes_and_types[ctx.getText()] = self.VOID
        
        if "<-" in ctx.getText():
            # If there is an assignment, check if the assigned type matches the declared type.
            type1 = ctx.var_type().getText()
            type2 = self.nodes_and_types[ctx.expr().getText()]

            if type1 == type2:
                self.nodes_and_types[ctx.var_id().getText()] = type2
            else:
                line = ctx.start.line
                column = ctx.start.column
                self.my_errors.add_error(self.my_errors.diff_asign, line, column)
                self.nodes_and_types[ctx.getText()] = self.ERROR
                self.nodes_and_types[ctx.var_id().getText()] = self.ERROR
        else:
            # If no assignment, set the attribute's type to the declared type.
            self.nodes_and_types[ctx.var_id().getText()] = ctx.var_type().getText()
      
    def exitNew_expr(self, ctx: YAPLParser.New_exprContext):
        # Get the type being instantiated with "new".
        type = ctx.var_type().getText()
        
        # Check if the type is defined in the type table.
        is_type = self.type_table.search(type)
        if is_type == None:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.no_type, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Set the type of the "new" expression to the instantiated type.
        self.nodes_and_types[ctx.getText()] = type

    def exitAdd_expr(self, ctx: YAPLParser.Add_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # Get the types of the operands.
        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]
        
        expec_type = ""

        # Check if the operation is valid (addition of integers or concatenation of strings).
        if (type1 == self.INT and type2 == self.INT) or (type1 == self.STRING and type2 == self.STRING):
            if type1 == self.INT:
                expec_type = self.INT
            else:
                expec_type = self.STRING
            self.nodes_and_types[ctx.getText()] = expec_type
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.arithmetic_no_int, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    # The exitSub_expr and exitMul_expr methods have similar functionality to exitAdd_expr,
    # so the comments for them will be omitted to avoid redundancy.
    def exitSub_expr(self, ctx: YAPLParser.Add_exprContext):
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        if type1 == self.INT and type2 == self.INT:
            self.nodes_and_types[ctx.getText()] = self.INT
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.arithmetic_no_int, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitMul_expr(self, ctx: YAPLParser.Add_exprContext):
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        if type1 == self.INT and type2 == self.INT:
            self.nodes_and_types[ctx.getText()] = self.INT
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.arithmetic_no_int, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitDiv_expr(self, ctx: YAPLParser.Add_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # Get the types of the operands.
        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        # Check if the operation is valid (division of integers).
        if type1 == self.INT and type2 == self.INT:
            self.nodes_and_types[ctx.getText()] = self.INT
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.arithmetic_no_int, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitLess_expr(self, ctx: YAPLParser.Less_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Get the types of the operands.
        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        # Check if the types of operands are the same (comparison between compatible types).
        if type1 == type2:
            self.nodes_and_types[ctx.getText()] = self.BOOL
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.cond_no_bool, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    # The exitEq_expr and exitLessEq_expr methods have similar functionality to exitLess_expr,
    # so the comments for them will be omitted to avoid redundancy.
    def exitEq_expr(self, ctx: YAPLParser.Less_exprContext):
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        if type1 == type2:
            self.nodes_and_types[ctx.getText()] = self.BOOL
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.cond_no_bool, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    # The exitNot_expr and exitNeg_expr methods have similar functionality to exitLess_expr,
    # so the comments for them will be omitted to avoid redundancy.
    def exitLessEq_expr(self, ctx: YAPLParser.Less_exprContext):
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        type1 = self.nodes_and_types[ctx.getChild(0).getText()]
        type2 = self.nodes_and_types[ctx.getChild(2).getText()]

        if type1 == type2:
            self.nodes_and_types[ctx.getText()] = self.BOOL
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.cond_no_bool, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitNot_expr(self, ctx: YAPLParser.Not_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # Get the type of the expression being negated.
        typeSingle = self.nodes_and_types[ctx.getChild(1).getText()]
        
        # Check if the negation is valid (applied to a boolean expression).
        if typeSingle == self.BOOL:
            self.nodes_and_types[ctx.getText()] = self.BOOL
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.not_bool, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitNeg_expr(self, ctx: YAPLParser.Neg_exprContext):
    # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # Get the type of the expression being negated.
        typeSingle = self.nodes_and_types[ctx.getChild(1).getText()]
        
        # Check if the negation is valid (applied to an integer expression).
        if typeSingle == self.INT:
            self.nodes_and_types[ctx.getText()] = self.INT
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.not_int, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitPar_expr(self, ctx: YAPLParser.Par_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # Set the type of the parenthesis expression to the type of its enclosed expression.
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.getChild(1).getText()]

    def exitVoid_expr(self, ctx: YAPLParser.Void_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return
        
        # A Void expression is considered as an error, as Void cannot be used as an expression.
        self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitAssign_expr(self, ctx: YAPLParser.Assign_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Get the types of the assignment.
        type1 = self.nodes_and_types[ctx.var_id().getText()]
        type2 = self.nodes_and_types[ctx.expr().getText()]

        # Check if the assignment is valid (types match).
        if type1 == type2:
            self.nodes_and_types[ctx.getText()] = self.VOID
        else:
            line = ctx.start.line
            column = ctx.start.column
            self.my_errors.add_error(self.my_errors.diff_asign, line, column)
            self.nodes_and_types[ctx.getText()] = self.ERROR

    def exitConditional_expr(self, ctx: YAPLParser.Conditional_exprContext):
        # Check if there is an error in any of the child nodes.
        error = self.BelowNodesHasError(ctx)
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Get the type of the conditional expression.
        if_type = self.nodes_and_types[ctx.expr()[0].getText()]

        # Check if the conditional expression is of type BOOL.
        if if_type != self.BOOL:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.expr()[0].start.line
            col = ctx.expr()[0].start.column
            self.my


        # Exit function for a loop expression
    
    def exitLoop_expr(self, ctx: YAPLParser.Loop_exprContext):
        # Check if there were any errors in child nodes
        error = self.BelowNodesHasError(ctx)
        
        # If there were errors, mark the current expression as an error and return
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Get the type of the loop condition expression
        while_type = self.nodes_and_types[ctx.expr()[0].getText()]

        # If the loop condition is not of type BOOL, mark the current expression as an error
        if while_type != self.BOOL:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.expr()[0].start.line
            col = ctx.expr()[0].start.column
            self.my_errors.add_error(self.my_errors.while_no_bool, line, col)
        else:
            # If the loop condition is of type BOOL, mark the current expression as OBJECT
            self.nodes_and_types[ctx.getText()] = self.OBJECT

    # Exit function for a branch expression
    def exitBr_expr(self, ctx: YAPLParser.Br_exprContext):
        # Check if there were any errors in child nodes
        error = self.BelowNodesHasError(ctx)
        
        # If there were errors, mark the current expression as an error and return
        if error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            return

        # Initialize a list to store the types of child expressions
        child_s__type = []

        # Iterate through the children of the branch expression
        for i in ctx.children:
            if not isinstance(i, TerminalNode):
                if i.getText() == 'self':
                    # If the child is 'self', append the type of 'self' with its parent class
                    child_s__type.append(self.nodes_and_types[i.getText() + self.method_table.search(self.current_scope.scope_name)['parent']])
                else:
                    # Otherwise, append the type of the child expression
                    child_s__type.append(self.nodes_and_types[i.getText()])

        # Set the type of the branch expression to the type of the last child expression
        self.nodes_and_types[ctx.getText()] = child_s__type[-1]

    # Exit function for a method call expression
    def exitmethod_call(self, ctx: YAPLParser.method_callContext):
        # Get the name of the method being called
        methodsName = ctx.var_id().getText()
        
        # Initialize a list to store the method call parameters
        parameters = []

        # Iterate through the children of the method call expression
        for ch in ctx.children:
            if isinstance(ch, YAPLParser.ExprContext):
                # If the child is an expression, append it as a parameter
                parameters.append(ch)

        # Search for details about the method in the method table
        method_detail = self.method_table.search(methodsName)
        
        # If the method is not found, mark the current expression as an error
        if method_detail == None:
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.var_id().start.line
            col = ctx.var_id().start.column
            self.my_errors.add_error(self.my_errors.no_method, line, col)
            return
                    
        # Get the parent class of the current method's scope
        method_parent = self.method_table.search(self.current_scope.scope_name)['type']
        
        # Check if the method being called is a valid method of the parent class
        if methodsName not in self.class_table.search(method_parent)['methods']:
            # If not valid, mark the current expression as an error
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.var_id().start.line
            col = ctx.var_id().start.column
            self.my_errors.add_error(self.my_errors.no_method, line, col)
            return
        
        # Check if the number of parameters in the method call matches the method's parameter count
        if len(parameters) != len(method_detail['param']):
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.var_id().start.line
            col = ctx.var_id().start.column
            self.my_errors.add_error(self.my_errors.dif_no_par, line, col)
            return

        # If there are no parameters, set the type of the method call to the return type of the method
        if len(parameters) == 0:
            self.nodes_and_types[ctx.getText()] = method_detail["type"]

        # Check the types of parameters and ensure they match the method's parameter types
        some_child_has_error = False
        for i in range(len(parameters)):
            this_par_type = self.nodes_and_types[parameters[i].getText()]
            if this_par_type == self.ERROR:
                # If a parameter has an error, mark the current expression as an error
                self.nodes_and_types[ctx.getText()] = self.ERROR
                return
            
            method_par_type = method_detail['param'][i]['type']

            if this_par_type != method_par_type:
                # If a parameter type doesn't match, mark the current expression as an error
                some_child_has_error = True
                line = parameters[i].start.line
                col = parameters[i].start.column
                self.my_errors.add_error(self.my_errors.dif_type_par, line, col)

        # If any parameter type didn't match, mark the current expression as an error
        if some_child_has_error:
            self.nodes_and_types[ctx.getText()] = self.ERROR
        else:
            # Set the type of the method call to the return type of the method
            self.nodes_and_types[ctx.getText()] = method_detail["type"]


        # Exit function for an expression expression
    
    def exitExpr_expr(self, ctx: YAPLParser.Expr_exprContext):
        # Get the type of the child expression
        childType = self.nodes_and_types[ctx.expr()[0].getText()]

        # Get the variable identifier from the context
        var_id = ctx.var_id().getText()
        
        # Initialize child_scope with the current scope
        child_scope = self.current_scope

        # Iterate through the scope_register to find the correct child_scope
        for i in self.scope_register:
            if i.scope_name == childType:
                child_scope = i

        # Search for the class details of the child expression's type
        child_class = self.class_table.search(childType) 

        # Check if the child class is not found or is an error
        if child_class == None or child_class == self.ERROR:
            # Mark the current expression as an error and report the issue
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.var_id().start.line
            col = ctx.var_id().start.column
            self.my_errors.add_error(self.my_errors.no_def, line, col)
            return
        
        # Check if the variable identifier exists in the child's scope
        if child_scope.search(var_id) != None:
            # Set the type of the current expression to the type of the variable
            self.nodes_and_types[ctx.getText()] = self.nodes_and_types[var_id]
        elif var_id in child_class['methods']:
            # If the variable is a method, it might be a method call
            methodsName = var_id
            parameters = []

            # Collect method call parameters from the context
            for ch in ctx.children:
                if isinstance(ch, YAPLParser.ExprContext):
                    parameters.append(ch)
            parameters.pop(0)  # Remove the first parameter which is the object itself

            # Search for details about the method in the method table
            method_detail = self.method_table.search(methodsName)
            
            # If the method is not found, mark the current expression as an error
            if method_detail == None:
                self.nodes_and_types[ctx.getText()] = self.ERROR
                line = ctx.var_id().start.line
                col = ctx.var_id().start.column
                self.my_errors.add_error(self.my_errors.no_method, line, col)
                return
                    
            # Get the parent class of the child expression's type
            method_parent = childType

            # Check if the method being called is a valid method of the parent class
            if methodsName not in self.class_table.search(method_parent)['methods']:
                # Mark the current expression as an error
                self.nodes_and_types[ctx.getText()] = self.ERROR
                line = ctx.var_id().start.line
                col = ctx.var_id().start.column
                self.my_errors.add_error(self.my_errors.no_method, line, col)
                return
            
            # Check if the number of parameters in the method call matches the method's parameter count
            if len(parameters) != len(method_detail['param']):
                self.nodes_and_types[ctx.getText()] = self.ERROR
                line = ctx.var_id().start.line
                col = ctx.var_id().start.column
                self.my_errors.add_error(self.my_errors.dif_no_par, line, col)
                return

            # If there are no parameters, set the type of the method call to the return type of the method
            if len(parameters) == 0:
                self.nodes_and_types[ctx.getText()] = method_detail["type"]

            # Check the types of parameters and ensure they match the method's parameter types
            some_child_has_error = False
            for i in range(len(parameters)):
                this_par_type = self.nodes_and_types[parameters[i].getText()]
                if this_par_type == self.ERROR:
                    # If a parameter has an error, mark the current expression as an error
                    self.nodes_and_types[ctx.getText()] = self.ERROR
                    return
                
                method_par_type = method_detail['param'][i]['type']

                if this_par_type != method_par_type:
                    some_child_has_error = True
                    line = parameters[i].start.line
                    col = parameters[i].start.column
                    self.my_errors.add_error(self.my_errors.dif_type_par, line, col)

            # If any parameter type didn't match, mark the current expression as an error
            if some_child_has_error:
                self.nodes_and_types[ctx.getText()] = self.ERROR
            else:
                # Set the type of the method call to the return type of the method
                self.nodes_and_types[ctx.getText()] = method_detail["type"]
        else:
            # If the variable is not found in child's scope, mark the current expression as an error
            self.nodes_and_types[ctx.getText()] = self.ERROR
            line = ctx.var_id().start.line
            col = ctx.var_id().start.column
            self.my_errors.add_error(self.my_errors.no_method, line, col)

        # Enter function for a let expression
    
    def enterLet_expr(self, ctx: YAPLParser.Add_exprContext):
        # Get the total number of child nodes
        child_s = ctx.getChildCount()
        
        # Iterate through the child nodes
        for i in range(child_s):
            # Check if the child node is of type 'Var_typeContext' (indicating a variable declaration)
            if isinstance(ctx.getChild(i), YAPLParser.Var_typeContext):
                # Get the variable type and identifier from the context
                type = ctx.getChild(i).getText()
                id = ctx.getChild(i-2).getText()

                # Check if the variable is not already defined in the current scope
                if self.current_scope.search(id) == None:
                    # Search for the type information in the type table
                    is_type = self.type_table.search(type)
                    
                    # If the type is not found, report an error
                    if is_type == None:
                        line = ctx.start.line
                        column = ctx.start.column
                        self.my_errors.add_error(self.my_errors.no_type, line, column)
                        self.nodes_and_types[ctx.getText()] = self.ERROR
                        return
                    
                    # Get the size and offset information for the variable
                    size = is_type["size"]
                    offset = self.current_scope.this_off
                    
                    # Add the variable to the current scope
                    self.current_scope.add(type, id, size, offset, False)
                    
                    # Set the type of the variable in the nodes_and_types dictionary
                    self.nodes_and_types[id] = type
                else:
                    # If the variable is already defined in the current scope, report a redefinition error
                    line = ctx.start.line
                    column = ctx.start.column
                    self.my_errors.add_error(self.my_errors.redef, line, column)
                    self.nodes_and_types[ctx.getText()] = self.ERROR

    # Exit function for a let expression
    def exitLet_expr(self, ctx: YAPLParser.Let_exprContext):
        # Set the type of the current expression to the type of the last expression in the 'let' block
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.expr()[-1].getText()]

path = "test/arith.cl"

to_compile = Compiler(path)
print(to_compile.printer.my_errors.get_errors())