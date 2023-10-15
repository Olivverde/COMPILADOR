from prettytable import PrettyTable



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
            "type": type,
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
        return next((symbol for symbol in this_symb if symbol["ID"] == var_id), None)

    def getSize(self):
        # Calculate and return the total size of symbols in the symbol table.
        return sum(s["Size"] for s in self.symbol_table)

    def toTable(self):
        # Display the symbol table in a formatted table.
        self.to_pretty.field_names = ["Type", "ID", "Size", "Byte Offset Location", "Param? (T/F)"]
        for symbol in self.symbol_table:
            self.to_pretty.add_row(list(symbol.values()))
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
        return next((symbol for symbol in this_symb if symbol["type"] == type), None)

    def toTable(self):
        # Display the type table in a formatted table.
        self.to_pretty.field_names = ["Type", "Size", "Description"]
        for symbol in self.type_table:
            self.to_pretty.add_row(list(symbol.values()))
        print(self.to_pretty)
        self.to_pretty.clear_rows()  # Clear the table for future use



"""
        _Author_
        Oliver
        
        _summary_
        Represents a symbol table used for tracking symbols (variables, functions, etc.) in a program's scope. 
"""
class ParameterTable():
    def __init__(self):
        # Initialize the parameter table with an empty table and a PrettyTable for formatting.
        self.to_pretty = PrettyTable()
        self.param_table = []  # List to store parameters

    def add(self, type, id):
        # Add a new parameter to the parameter table.
        # Parameters:
        #   - type: Data type of the parameter.
        #   - id: Identifier name of the parameter.
        self.param_table.append({
            "type": type,
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
        return next((par for par in this_par if par["ID"] == id), None)

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
        return next((class_ for class_ in this_class if class_["Id"] == id), None)

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
        return next(
            (method for method in self.method_table if method["id"] == id), None
        )

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
        return [
            f'Error: {error["error"]} at line {error["line"]}, column {error["col"]}'
            for error in self.error_table
        ]