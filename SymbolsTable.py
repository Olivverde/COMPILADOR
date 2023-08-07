from prettytable import PrettyTable
from testListener import testListener
from testParser import testParser
from itertools import groupby
from colorama import *

class SymbolsTable():
    def __init__(self) -> None:
        self.pretty_table = PrettyTable() #Implementación de tabla con formato correcto
        self._symbols = []
    
    def add(self, type, id, size, isParameter):
        self._symbols.append({
            'Type': type,
            'ID': id,
            'Size': size,
            'IsParameter': isParameter
        })
    
    def lookup(self, id):
        symbols_copy = self._symbols.copy()
        symbols_copy.reverse()
        for symbol in symbols_copy:
            if symbol['ID'] == id:
                return symbol
        return 0

    def getsize(self):
        return sum(symbol['size'] for symbol in self._symbols)
    
    def totable(self):
        self.pretty_table.field_names = ['Type', 'ID', 'Size','IsParameter']
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(Fore.YELLOW + "\nSímbolos" + Style.RESET_ALL)
        print(self.pretty_table)
        self.pretty_table.clear_rows()

class ParameterTable():
    def __init__(self) -> None:
        self.pretty_table = PrettyTable()
        self._symbols = []
        self.pretty_table.field_names = ['Type', 'ID']
    
    def add(self, type, id):
        self._symbols.append({
            'Type': type,
            'ID': id,
        })
    
    def lookup(self, variable):
        symbols_copy = self._symbols.copy()
        symbols_copy.reverse()
        for symbol in symbols_copy:
            if symbol['ID'] == variable:
                return symbol
        return 0

    def totable(self):
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(Fore.MAGENTA + "\nParámetros" + Style.RESET_ALL)
        print(self.pretty_table)
        self.pretty_table.clear_rows()
    
    def clear(self):
        self.totable()
        self._symbols = []


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
    
    
class TypeTable():
    def __init__(self) -> None:
        self.PRIMITIVE = 'primitive'
        self.OBJECT = 'object'
        self.IO = 'io'

        self._types = []
        self.add('int', self.PRIMITIVE, 0);
        self.add('string', self.PRIMITIVE, '""')
        self.add('bool', self.PRIMITIVE, False)
        self.add('void', self.PRIMITIVE, None)
    
    def add(self, type, description, default_value):
        self._types.append({
            'Type': type,
            'Description': description,
            'Default': default_value
        })
    
    def lookup(self, type):
        types_copy = self._types.copy()
        types_copy.reverse()
        for type in types_copy:
            if type['Type'] == type:
                return type
        return 0


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
    
    def enterClas_list(self, ctx: testParser.Clas_listContext):
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

    def exitClas_list(self, ctx: testParser.Clas_listContext):
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

    def enterMethod_definition(self, ctx: testParser.Method_definitionContext):
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

        

