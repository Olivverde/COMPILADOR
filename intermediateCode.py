from antlr.testListener import testListener
from SymbolsTable import *
from antlr.testParser import testParser
from antlr4.tree.Trees import TerminalNode

class Intermediate(testListener):
    def __init__(self):
        #Nodo inicial
        self.root = None

        #Secuencia para temporales, ifs y whiles
        self.temp_no = 0
        self.if_no = 0
        self.while_no = 0

        #Temporales en uso
        self.my_temps = []
        #Obtner algunos temporales
        self.set_some_temps()

        #Tipos de datos iniciales
        self.STRING = "String"
        self.INT = "Int"
        self.BOOL = "Bool"
        self.VOID = "void"
        self.SELF_TYPE = "SELF_TYPE"
        self.IO = "IO"
        self.ERROR = "error"
        self.OBJECT = "Object"

        #Manejo de scopes
        self.scopes = []
        self.scope_register = []
        self.current_scope = None

        #Estructuras a utilizar
        self.type_table = TypeTable()
        self.class_table = ClassTable()
        self.method_table = MethodTable()
        self.my_errors = ErrorTypes()

        #Codigo generado
        self.code_generated = []

        #Nodos, tipos y sus codigos
        self.nodes_and_types = {}
        self.nodes_and_codes ={}

        super().__init__()


    """
        _Author_
        Laura
        
        _summary_
        Get 5 temporary variables for now

        _Attributes_
            tmp: temporary var
            temp_no: set the number of tje temporary var
            my_temps: the 5 temporary variables are saved
    """
    def set_some_temps(self):
        for i in range(5):
            tmp = "t"+str(self.temp_no)
            self.temp_no += 1
            self.my_temps.append(tmp)


    """
        _Author_
        Laura
        
        _summary_
        Get more temporary

        _Attributes_
            my_temps: the 5 temporary variables are saved
    """
    def get_new_temp(self):
        if len(self.my_temps) == 0:
            self.set_some_temps()
        
        self.my_temps.sort()
        tmp = self.my_temps.pop(0)
        return tmp
    
    """
        _Author_
        Laura
        
        _summary_
        Return the temporary vars

        _Attributes_
            var: temporary variable
            isTemp: indicates if it is temporary
    """
    def temp_rt(self, tmp):
        var, isTemp = [*tmp]
        if isTemp:
            self.my_temps.append(var)

    """
        _Author_
        Laura
        
        _summary_
        Names for IFs and WHILEs structures

        _Attributes_
            flow: indicates the flow to which it belongs
    """
    def statement_labels(self, flow = ''):
        if flow == 'if':
            control = f'END_IF_{self.if_no}'
            trueIf = f'IF_TRUE_{self.if_no}'
            falseIf = f'IF_FALSE_{self.if_no}'
            self.if_no += 1
            return control, trueIf, falseIf
        elif flow == 'while':
            begin = f'BEGIN_WHILE_{self.while_no}'
            control = f'END_WHILE_{self.while_no}'
            trueWhile = f'WHILE_TRUE_{self.while_no}'
            falseWhile = f'WHILE_FALSE_{self.while_no}'
            self.while_no += 1
            return begin, control, trueWhile, falseWhile
        

    """
        _Author_
        Laura
        
        _summary_
        Leaving one scope and entering a new one
    """
    def scope_pop(self):
        print("SCOPE:", self.current_scope.scope_name)
        self.current_scope.toTable()
        self.current_scope = self.scopes.pop()

    """
        _Author_
        Laura
        
        _summary_
        Add a scope to the stack
    """
    def scope_push(self, name):
        self.scopes.append(self.current_scope)
        self.current_scope = SymbolTable(name)

    """
        _Author_
        Laura
        
        _summary_
        Add a scope to the stack

        _Attributes_
            offset_required: indicates whether the offset
    """
    def getTop(self, id, offset_required = None):
        var = self.current_scope.search(id)
        offs = 0
        if var != None:
            offs = var['off']
            if offset_required:
                offs = offset_required
            
            addr = f'R[{offs}]'
            return addr
        elif self.get_var(id) != None:
            var = self.get_var(id)
            if offset_required:
                offs = offset_required
            
            addr = f'self[{offs}]'
            return addr
        else:
            return f'R[{offset_required}]'

    """
        _Author_
        Laura
        
        _summary_
        Add a scope to the stack
    """
    def enterProgram(self, ctx: testParser.ProgramContext):
        #Define the root node
        self.root = ctx.getText()
        #Create symbol table
        self.current_scope = SymbolTable(ctx.getText())
        #Add the self symbol
        self.current_scope.add_symb("SELF_TYPE", "self", self.type_table.search("SELF_TYPE")['size'], self.current_scope.this_off, False)
    

    """
        _Author_
        Laura
        
        _summary_
        Exits the "Program" phase
    """
    def enterClass(self, ctx: testParser.ClassContext):
        # Gets the class name
        this_class = ctx.var_type()[0].getText()
        inherits = ""
        methods = []

        # Gets someone's si inherits methods
        if ctx.getChild(2).getText() in "inherits":
            inherits = ctx.getChild(3).getText()
            methods = self.class_table.search(inherits)['methods'].copy()

        # Add the class, the type and the node
        self.class_table.add_class(this_class, this_class, inherits, methods)
        self.type_table.add_type(this_class, 0, self.type_table.CLASS)
        self.nodes_and_types[this_class] = this_class

        # Add to the Stack
        self.scope_push(this_class)

    """
        _Author_
        Laura
        
        _summary_
        Exits the "True_exp" phase
    """
    def exitTrue_expr(self, ctx: testParser.True_exprContext):
        # BOOL type node, it does not have a code and its address is the same data that it brings
        self.nodes_and_types[ctx.getText()] = self.BOOL
        self.nodes_and_codes[ctx.getText()] = {
            "code": [],
            "addr": (ctx.getText(), False)
        }

    """
        _Author_
        Laura
        
        _summary_
        Finds and returns the identifier in the current scope or in the others
    """
    def get_var(self, id):
        this_var = self.current_scope.search(id)
        if this_var == None:
            revers_scopes = self.scopes.copy()
            revers_scopes.reverse()
            for scope in revers_scopes:
                this_var_new = scope.search(id)
                if this_var_new != None:
                    return this_var_new
            return None
        else:
            return this_var
    

    """
        _Author_
        Laura
        
        _summary_
        Exit the "False_exp" phase
    """
    def exitFalse_expr(self, ctx: testParser.False_exprContext):
        # BOOL type node, it does not have a code and its address is the same data that it brings
        self.nodes_and_types[ctx.getText()] = self.BOOL
        self.nodes_and_codes[ctx.getText()] = {
            "code": [],
            "addr": (ctx.getText(), False)
        }


    """
        _Author_
        Laura
        
        _summary_
        Exit the "String_exp" phase
    """
    def exitString_expr(self, ctx: testParser.String_exprContext):
        # STRING type node, it does not have a code and its address is the same data that it carries
        self.nodes_and_types[ctx.getText()] = self.STRING
        self.nodes_and_codes[ctx.getText()] = {
            "code": [],
            "addr": (ctx.getText(), False)
        }

    """
        _Author_
        Laura
        
        _summary_
        Exit the "Int_exp" phase
    """
    def exitInt_expr(self, ctx: testParser.Int_exprContext):
        # STRING type node, it does not have a code and its address is the same data that it carries
        self.nodes_and_types[ctx.getText()] = self.INT
        self.nodes_and_codes[ctx.getText()] = {
            "code": [],
            "addr": (ctx.getText(), False)
        }

    """
        _Author_
        Laura
        
        _summary_
        Entry the "enterVar_expr" phase
    """
    def enterVar_expr(self, ctx: testParser.Var_exprContext):
        # We define its node and type based on those of the parent
        parent = ctx.parentCtx.getText()
        if parent in self.nodes_and_types.keys():
            self.nodes_and_types[ctx.getText()] = self.nodes_and_types[parent]

    """
        _Author_
        Laura
        
        _summary_
        Exit the "exitVar_expr" phase
    """
    def exitVar_expr(self, ctx: testParser.Var_exprContext):
        # Verify that the father is already in the nodes and we exit
        parent = ctx.parentCtx.getText()
        if parent in self.nodes_and_types.keys() or ctx.getText() in self.nodes_and_types.keys():
            return
        
        id = ctx.getText()
        this_var = self.get_var(id)
        # Define node and its type based on primitive types
        if this_var["type"] in [self.INT, self.BOOL, self.STRING]:
            self.nodes_and_types[ctx.getText()] = this_var["type"]
        # Define its node and its type based on the type of the class to which it belongs and update the type of the method 
        elif this_var["type"] == "SELF_TYPE":
            self.nodes_and_types[ctx.getText()+self.method_table.search(self.current_scope.scope_name)['parent']] = self.method_table.search(self.current_scope.scope_name)['parent']
            self.method_table.search(self.current_scope.scope_name)['type'] = self.method_table.search(self.current_scope.scope_name)['parent']
        # Define the node and its type as null
        else:
            self.nodes_and_types[ctx.getText()] = self.VOID

        # Obtain value from the previous record and add it as the value of this record, it does not have code
        tget = self.getTop(id)
        code = {
            'addr': (tget, False),
            'code': []
        }
        self.nodes_and_codes[ctx.getText()] = code


    """
        _Author_
        Laura
        
        _summary_
        Entry the "Par_expr" phase
    """
    def enterPar_expr(self, ctx: testParser.Par_exprContext):
        # The son's code will be the same as the father's.
        if ctx.getText() in self.nodes_and_codes.keys():
            self.nodes_and_codes[ctx.expr().getText()] = self.nodes_and_codes[ctx.getText()]
    
    """
        _Author_
        Laura
        
        _summary_
        Exit the "Par_expr" phase
    """
    def exitPar_expr(self, ctx: testParser.Par_exprContext):
        # The nodes are created, the parent takes the type and code of the child
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.getChild(1).getText()]
        self.nodes_and_codes[ctx.getText()] = self.nodes_and_codes[ctx.getChild(1).getText()]

    """
        _Author_
        Laura
        
        _summary_
        Exit the "exitPar_expr" phase
    """
    def enterNot_expr(self, ctx: testParser.Not_exprContext):
        # We check if your code exists
        if ctx.getText() in self.nodes_and_codes.keys():

            # Define the code of the internal expression as the code of the parent
            self.nodes_and_codes[ctx.expr().getText()] = self.nodes_and_codes[ctx.getText()]
            
            # Define the base output states
            false = self.nodes_and_codes[ctx.getText()]['false']
            true = self.nodes_and_codes[ctx.getText()]['true']
            next_ = self.nodes_and_codes[ctx.getText()]['next']
            
            # Since it is not, we change the output between true and false
            self.nodes_and_codes[ctx.expr().getText()] = {
                'false': true,
                'true': false,
                'next': next_
            }

