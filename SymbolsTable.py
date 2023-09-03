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


class ClassTable():
    def __init__(self) -> None:
        self.pretty_table = PrettyTable()
        self._classes = []
    def add(self,type, id, inheritance):
        self._classes.append({
            'Type': type,
            'ID': id,
            'Inheritance': inheritance
        })
    def lookup(self, type):
        for _class in self._classes:
            if _class['Type'] == type:
                return _class
        return 0
    
    def totable(self):
        self.pretty_table.field_names = ['Type', 'ID', 'Inheritance']
        for i in self._classes:
            self.pretty_table.add_row(list(i.values()))

        print(Fore.CYAN + "\nClases" + Style.RESET_ALL)
        print(self.pretty_table)
        self.pretty_table.clear_rows()


class MethodTable():

    def __init__(self) -> None:
        self.pretty_table = PrettyTable()
        self._methods = []

    def add(self, type, id, parameters):
        self._methods.append({
            'Type': type,
            'ID': id,
            'Parameters': parameters,
        })
    
    def lookup(self, variable):
        for method in self._methods:
            if method['ID'] == variable:
                return method
        return 0
    
    def totable(self):
        self.pretty_table.field_names = ['Type', 'ID', 'Parameters']
        for i in self._methods:
            self.pretty_table.add_row(list(i.values()))

        print(Fore.YELLOW + "\nMétodos" + Style.RESET_ALL)
        print(self.pretty_table)
        self.pretty_table.clear_rows()
    
  
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
        self.current_scope = SymbolsTable()
    
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
        self.current_scope = SymbolsTable()
    
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
        
        
        
        
        


