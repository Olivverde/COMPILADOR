from colorama import *
from itertools import groupby
from prettytable import PrettyTable
from dist.testParser import testParser
from dist.testListener import testListener

"""
        _Author_
        Oliver
        
        _summary_
        Represents a symbol table used for tracking symbols (variables, functions, etc.) in a program's scope. 
"""
class SymbolTable():
    def __init__(self, name):
        # Initialize the symbol table with a name, an empty table, and a PrettyTable for formatting.
        self.scope_name = name
        self.to_pretty = PrettyTable()
        self.symbol_table = []  # List to store symbols
        self.this_off = 0  # Offset tracker

    def add(self, type, id, size, off, isPar):
        # Add a new symbol to the symbol table.
        # Parameters:
        #   - type: Data type of the symbol.
        #   - id: Identifier name.
        #   - size: Size of the symbol.
        #   - off: Offset of the symbol.
        #   - isPar: Indicates if the symbol is a parameter.
        self.symbol_table.append({
            "Type": type,
            "ID": id,
            "Size": size,
            "Offset": off,
            "Is Parameter": isPar
        })
        self.this_off += size  # Update the current offset

    def search(self, var_id):
        # Search for a symbol by its identifier.
        # Parameters:
        #   - var_id: Identifier name to search for.
        # Returns:
        #   - The symbol if found, None otherwise.
        this_symb = self.symbol_table.copy()
        this_symb.reverse()
        for symbol in this_symb:
            if symbol["ID"] == var_id:
                return symbol
        return None  # Symbol not found

    def getSize(self):
        # Calculate and return the total size of symbols in the symbol table.
        return sum([s["Size"] for s in self.symbol_table])

    def toTable(self):
        # Display the symbol table in a formatted table.
        self.to_pretty.field_names = ["Type", "ID", "Size", "Offset", "Is Parameter"]
        for symbol in self.symbol_table:
            self.to_pretty.add_row(list(symbol.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use

"""
        _Author_
        Oliver
        
        _summary_
        Represents a parameter table used for tracking function parameters.
"""
class ParameterTable():
    def __init__(self):
        # Initialize the parameter table with an empty table and a PrettyTable for formatting.
        self.to_pretty = PrettyTable()
        self.param_table = []  # List to store parameters

    def add_param(self, type, id):
        # Add a new parameter to the parameter table.
        # Parameters:
        #   - type: Data type of the parameter.
        #   - id: Identifier name of the parameter.
        self.param_table.append({
            "Type": type,
            "ID": id
        })

    def search(self, id):
        # Search for a parameter by its identifier.
        # Parameters:
        #   - id: Identifier name to search for.
        # Returns:
        #   - The parameter if found, None otherwise.
        this_par = self.param_table.copy()
        this_par.reverse()
        for par in this_par:
            if par["ID"] == id:
                return par
        return None  # Parameter not found

    def toTable(self):
        # Display the parameter table in a formatted table.
        self.to_pretty.field_names = ["Type", "ID"]
        for par in self.param_table:
            self.to_pretty.add_row(list(par.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use

    def free(self):
        # Display the parameter table and then clear it.
        self.toTable()
        self.param_table = []  # Clear the parameter table


"""
        _Author_
        Laura
        
        _summary_
        Represents a table for managing classes and their properties within a compiler or interpreter. 
"""
class ClassTable():
    def __init__(self):
        # Initialize the class table with a PrettyTable for formatting.
        self.to_pretty = PrettyTable()

        # Initialize the class table with default class entries.
        self.class_table = []
        self.add_class('IO', 'IO', "", ["out_string", "out_int", "in_string", "in_int"])
        self.add_class('Object', 'Object', "", ["abort", "type_name", "copy"])
        self.add_class('String', 'String', "", ["length", "concat", "substr"])
        self.add_class('Int', 'Int', "", [])
        self.add_class('Bool', 'Bool', "", [])

    def add_class(self, id, desc, inherits, methods):
        # Add a new class entry to the class table.
        # Parameters:
        #   - id: The class name.
        #   - desc: The class description.
        #   - inherits: The parent class the class inherits from.
        #   - methods: A list of methods associated with the class.
        self.class_table.append({
            "Id": id,
            "Description": desc,
            "inherits": inherits,
            "methods": methods
        })

    def search(self, id):
        # Search for a class by its identifier.
        # Parameters:
        #   - id: The class name to search for.
        # Returns:
        #   - The class entry if found, None otherwise.
        this_class = self.class_table.copy()
        this_class.reverse()
        for class_ in this_class:
            if class_["Id"] == id:
                return class_
        return None

    def add(self, class_name, method_name):
        # Add a method to a class by its name.
        for class_ in self.class_table:
            if class_["Id"] == class_name:
                class_["methods"].append(method_name)

    def toTable(self):
        # Display the class table in a formatted table.
        self.to_pretty.field_names = ["Id", "Description", "inherits", "Methods"]
        for class_ in self.class_table:
            self.to_pretty.add_row(list(class_.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use



"""
        _Author_
        Laura
        
        _summary_
        Represents a collection of error messages and provides a mechanism for adding and retrieving
        errors encountered during code analysis or compilation.
"""
class ErrorTypes():
    def __init__(self):
        # Initialize the error table.
        self.error_table = []

        # Define error messages as constants.
        self.redef = 'It is not possible to redefine an identifier more than once within the same scope'
        self.no_def = 'It is not possible to use an identifier that has not been defined'
        self.no_type = 'It is not possible to use a type that has not been defined'
        self.no_main = 'It is not possible to execute the program without a main function'
        self.main_her = 'The Main class cannot inherit from another class'
        self.no_her = 'It is not possible to inherit from a class that has not been defined'
        self.self_her = 'Recursive inheritance is not allowed'
        self.dif_no_par = 'It is not possible to call a function with a different number of parameters than defined'
        self.dif_type_par = 'It is not possible to call a function with a parameter type different from the defined type'
        self.dif_type_ret = 'It is not possible to return a different type than the defined return type'
        self.no_ret = 'It is not possible to return a value in a function that does not return anything'
        self.arithmetic_no_int = 'Arithmetic operations can only be performed with int or string concatenation types'
        self.cond_no_bool = 'Comparison operations require operands of the same data type'
        self.not_bool = 'The "not" operator can only be used on boolean expressions'
        self.not_int = 'The negation operator can only be used on integer expressions'
        self.if_no_bool = 'An "if" condition must have a boolean expression'
        self.if_no_match = 'The types of "if" branches do not match'
        self.while_no_bool = 'A "while" condition must have a boolean expression'
        self.diff_asign = 'It is not possible to assign a different type than the one defined'
        self.no_method = 'It is not possible to call a method or variable that has not been defined'

    def add_error(self, error, line, col):
        # Add a new error entry to the error table.
        # Parameters:
        #   - error: The error message.
        #   - line: The line number where the error occurred.
        #   - col: The column number where the error occurred.
        self.error_table.append({
            "error": error,
            "line": line,
            "col": col
        })
    
    def get_errors(self):
        # Get a list of error messages in a user-friendly format.
        ui_errors = []
        for error in self.error_table:
            ui_errors.append(f'Error: {error["error"]} at line {error["line"]}, column {error["col"]}')
        return ui_errors



"""
        _Author_
        Oliver
        
        _summary_
        Represents a table for managing methods and their properties within a compiler or interpreter.
"""
class MethodTable():
    def __init__(self):
        # Initialize the method table with a PrettyTable for formatting.
        self.to_pretty = PrettyTable()

        # Initialize the method table with default method entries.
        self.method_table = []
        self.add("Object", "abort", [], "Object")
        self.add("String", "type_name", [], "Object")
        self.add("Object", "copy", [], "Object")

        self.add("IO", "out_string", [{'type': 'String', 'id': 'x'}], "IO")
        self.add("String", "in_string", [], "IO")
        self.add("IO", "out_int", [{'type': 'Int', 'id': 'x'}], "IO")
        self.add("Int", "in_int", [], "IO")

        self.add("Int", "length", [], "String")
        self.add("String", "concat", [{'type': 'String', 'id': 's'}], "String")
        self.add("String", "substr", [{'type': 'Int', 'id': 'i'},{'type': 'Int', 'id': 'l'}], "String")

    def add(self, type, id, para, parent):
        # Add a new method entry to the method table.
        # Parameters:
        #   - type: The return type of the method.
        #   - id: The method name.
        #   - para: A list of method parameters with their types and identifiers.
        #   - parent: The parent class of the method.
        self.method_table.append({
            "type": type,
            "id": id,
            "param": para,
            "parent": parent
        })

    def search(self, id):
        # Search for a method by its identifier.
        # Parameters:
        #   - id: The method name to search for.
        # Returns:
        #   - The method entry if found, None otherwise.
        for method in self.method_table:
            if method["id"] == id:
                return method
        return None  # Method not found

    def toTable(self):
        # Display the method table in a formatted table.
        self.to_pretty.field_names = ["Type", "Id", "Parameters", "Parent"]
        for method in self.method_table:
            self.to_pretty.add_row(list(method.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use

    
  
"""
        _Author_
        Laura
        
        _summary_
        Represents a symbol table used for tracking symbols (variables, functions, etc.) in a program's scope. 
"""
class TypeTable():
    def __init__(self):
        # Initialize the type table with a PrettyTable for formatting.
        self.to_pretty = PrettyTable()

        # Constants for type descriptions
        self.PRIMITIVE = 'primitive'
        self.CLASS = 'object'

        # Initialize the type table with default primitive and class types
        self.type_table = []
        self.add('Int', 4, self.PRIMITIVE)
        self.add('String', 2, self.PRIMITIVE)
        self.add('Bool', 1, self.PRIMITIVE)
        self.add('void', 0, self.PRIMITIVE)
        self.add('SELF_TYPE', 0, self.CLASS)
        self.add('Object', 0, self.CLASS)
        self.add('IO', 0, self.CLASS)
    
    def add(self, type, size, desc):
        # Add a new type entry to the type table.
        # Parameters:
        #   - type: The data type.
        #   - size: The size of the type.
        #   - desc: The type description (primitive or class).
        self.type_table.append({
            "type": type,
            "size": size,
            "desc": desc
        })
    
    def search(self, type):
        # Search for a type by its name.
        # Parameters:
        #   - type: The type name to search for.
        # Returns:
        #   - The type entry if found, None otherwise.
        this_symb = self.type_table.copy()
        this_symb.reverse()
        for symbol in this_symb:
            if symbol["type"] == type:
                return symbol
        return None  # Type not found

    def toTable(self):
        # Display the type table in a formatted table.
        self.to_pretty.field_names = ["Type", "Size", "Description"]
        for symbol in self.type_table:
            self.to_pretty.add_row(list(symbol.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use
class ShowTable(testListener):
    def __init__(self) -> None:
        self.root = None

        self.STRING = "String"
        self.INT = "Int"
        self.BOOL = "Bool"
        self.IO = "io"
        self.VOID = "Void"
        self.ERROR = "error"

        self.data_type = {
            'String': self.STRING,
            'Int': self.INT,
            'Bool': self.BOOL,
            'io': self.IO,
            'void': self.VOID,
            'error': self.ERROR
        }

        self.scopes = []
        self.current_scope = None
        self.type_table = TypeTable()
        self.method_table = MethodTable()
        self.class_table = ClassTable()
        self.parameter_table = ParameterTable()

        self.node_type = {}

    
    def popscope(self):
        self.current_scope.totable()
        self.current_scope = self.scopes.pop()
    
    def newscope(self):
        self.scopes.append(self.current_scope)
        self.current_scope = SymbolTable()
    
    def find(self, var):
        lookup = self.current_scope.lookup(var)
        if lookup == 0:
            scope_reverse = self.scopes.copy()
            scope_reverse.reverse()
            for scope in scope_reverse:
                lookup2 = scope.lookup(var)
                if lookup2 != 0:
                    return lookup2
            return 0
        else:
            return lookup
        
    def intersection(self, a, b):
        return [v for v in a if v in b]
    
    def allequal(self, iterable):
        g = groupby(iterable)
        return next(g, True) and not next(g, False)
    
    def childrenhaserror(self, ctx):
        non_terminals = [self.node_type[i] for i in ctx.children if type(i) in [testParser.LocationContext, testParser.ExprContext, testParser.BlockContext, testParser.DeclarationContext]]
        if self.ERROR in non_terminals:
            return True
        return False

    def enterProgram(self, ctx: testParser.ProgramContext):
        self.root = ctx
        self.current_scope = SymbolTable()
    
    def enterClas_list(self, ctx: testParser.Class_prodContext):
        class_type = ctx.type_()[0].getText()
        try:
            inheritance = ctx.type_()[1].getText()
        except:
            inheritance = None

        if self.class_table.lookup(class_type) == 0:
            self.class_table.add(class_type, class_type, inheritance)
        
        else: # Error si hay clases duplicadas
            line = ctx.type_()[0].start.line
            col = ctx.type_()[0].start.column
            self.errors.add(line, col, "Clase duplicada: " + class_type)

    def exitClas_list(self, ctx: testParser.Class_prodContext):
        class_type = ctx.type_()[0].getText()
        self.parameter_table.clear()
        # self.popscope()
        print('Saliendo de: ' + class_type)

        if class_type == self.VOID:
            self.node_type[ctx] = self.ERROR
            line = ctx.type_()[0].start.line
            col = ctx.type_()[0].start.column
            self.errors.add(line, col, "Clase no puede ser tipo void")
            return
        
        self.node_type[ctx] = self.VOID

    def enterMethod_definition(self, ctx: testParser.ProgramContext):
        method_type = ctx.type_().getText()
        method_name = ctx.ID().getText()
        parameters = []

        if self.method_table.lookup(method_name) == 0:
            self.method_table.add(method_type, method_name, parameters)
        else:
            line = ctx.type_().start.line
            col = ctx.type_().start.column
            self.errors.add(line, col, "Se encontró un método duplicado: " + method_name)

        self.newscope()
        print(Fore.BLACK +  Style.BRIGHT +'Método: ' + method_name + Style.RESET_ALL)

    def exitProgram(self, ctx: testParser.ProgramContext):
        main_class = self.method_table.lookup("main")
        if main_class != 0:
            hasError = self.childrenhaserror(ctx)
            if hasError:
                print(Fore.RED +  Style.BRIGHT + "Se han encontrado errores" + Style.RESET_ALL)
        


        self.current_scope.totable()
        self.class_table.totable()
        self.method_table.totable()
        
        
        
        
        


