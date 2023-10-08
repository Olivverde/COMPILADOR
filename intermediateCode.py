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
        exit the "Not_expr" phase
    """
    def exitNot_expr(self, ctx: testParser.Not_exprContext):
        # The type of the child and the code of the inner expression are taken.
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.getChild(1).getText()]
        self.nodes_and_codes[ctx.getText()] = self.nodes_and_codes[ctx.expr().getText()]
    

    """
        _Author_
        Laura
        
        _summary_
        Entry the "Not_expr" phase
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

    """
        _Author_
        Laura
        
        _summary_
        Exit the "Eq_expr" phase
    """
    def exitEq_expr(self, ctx: testParser.Eq_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()
        # We grab the current code of the node
        this_code = self.nodes_and_codes[ctx.getText()]
        # change the code, add the children's code in case they have something before, then create the if structure and where to exit based on the true and false states
        to_set = self.nodes_and_codes[kid1]['code'] + self.nodes_and_codes[kid2]['code'] + \
                    ['IF ' + self.nodes_and_codes[kid1]['addr'][0] + f' {ctx.EQUAL_OP().getText()}= ' + self.nodes_and_codes[kid2]['addr'][0] + ' GOTO ' + this_code['true']] + \
                    ['GOTO ' + this_code['false']]

        # We set the state parameters and the code in case it will be used later
        false = self.nodes_and_codes[ctx.getText()]['false']
        true = self.nodes_and_codes[ctx.getText()]['true']
        next_ = self.nodes_and_codes[ctx.getText()]['next']
        self.nodes_and_codes[ctx.getText()] = {
            'code': to_set,
            'false': false,
            'true': true,
            'next': next_
        }
        # Node and type
        self.nodes_and_types[ctx.getText()] = self.BOOL
    
    """
        _Author_
        Laura
        
        _summary_
        Exit the "LessEq_expr" phase
    """
    def exitLessEq_expr(self, ctx: testParser.LessEq_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()
        # the current code of the node
        this_code = self.nodes_and_codes[ctx.getText()]
        # dd the children's code in case they have something before, then create the if structure and where to exit based on the true and false states
        to_set = self.nodes_and_codes[kid1]['code'] + self.nodes_and_codes[kid2]['code'] + \
                    ['IF ' + self.nodes_and_codes[kid1]['addr'][0] + f' {ctx.LESS_EQ_OP().getText()} ' + self.nodes_and_codes[kid2]['addr'][0] + ' GOTO ' + this_code['true']] + \
                    ['GOTO ' + this_code['false']]
        # Set the state parameters and the code in case it will be used later
        false = self.nodes_and_codes[ctx.getText()]['false']
        true = self.nodes_and_codes[ctx.getText()]['true']
        self.nodes_and_codes[ctx.getText()] = {
            'code': to_set,
            'false': false,
            'true': true,
        }
        #Node and type
        self.nodes_and_types[ctx.getText()] = self.BOOL

    """
        _Author_
        Laura
        
        _summary_
        Exit the "Less_expr" phase
    """
    def exitLess_expr(self, ctx: testParser.Less_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()
        # The current code of the node
        this_code = self.nodes_and_codes[ctx.getText()]
        # Add the children's code in case they have something before, then create the if structure and where to exit based on the true and false states
        to_set = self.nodes_and_codes[kid1]['code'] + self.nodes_and_codes[kid2]['code'] + \
                    ['IF ' + self.nodes_and_codes[kid1]['addr'][0] + f' {ctx.LESS_OP().getText()} ' + self.nodes_and_codes[kid2]['addr'][0] + ' GOTO ' + this_code['true']] + \
                    ['GOTO ' + this_code['false']]
        # Set the state parameters and the code in case it will be used later
        false = self.nodes_and_codes[ctx.getText()]['false']
        true = self.nodes_and_codes[ctx.getText()]['true']
        self.nodes_and_codes[ctx.getText()] = {
            'code': to_set,
            'false': false,
            'true': true,
        }
        # Node and type
        self.nodes_and_types[ctx.getText()] = self.BOOL


    """
        _Author_
        Laura
        
        _summary_
        Exit the "Neg_expr" phase
    """
    def exitNeg_expr(self, ctx: testParser.Neg_exprContext):
        # The type of the child and create the child
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.getChild(1).getText()]
        # The address is defined as a temporary momentary
        addr = self.get_new_temp()
        # The code will be the union between the code of the child, and the structure defined as addres = -addressChils
        code = self.nodes_and_codes[ctx.getChild(1).getText()]['code'] + [addr + ' = ' + '-' + self.nodes_and_codes[ctx.getChild(1).getText()]['addr'][0]]
        self.temp_rt(self.nodes_and_codes[ctx.getChild(1).getText()]['addr'])
        #  add node with code
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }

    """
        _Author_
        Laura
        
        _summary_
        Exit the "Add_expr" phase
    """
    def exitAdd_expr(self, ctx: testParser.Add_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()

        # Intermediate code is created based on the code of both children, and the new structure with temporary variables
        addr = self.get_new_temp()
        code = self.nodes_and_codes[kid1]['code'] + \
            self.nodes_and_codes[kid2]['code'] + \
            [addr + ' = ' + self.nodes_and_codes[kid1]['addr'][0] + ' ' + ctx.getChild(1).getText() + ' ' + self.nodes_and_codes[kid2]['addr'][0]]

        self.temp_rt(self.nodes_and_codes[kid2]['addr'])
        self.temp_rt(self.nodes_and_codes[kid1]['addr'])
        #Add node with code
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }
        # Define the type as an integer
        self.nodes_and_types[ctx.getText()] = self.INT


    """
        _Author_
        Laura
        
        _summary_
        Exit the "Sub_expr" phase
    """
    def exitSub_expr(self, ctx: testParser.Sub_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()

        # Intermediate code is created based on the code of both children, and the new structure with temporary variables
        addr = self.get_new_temp()
        code = self.nodes_and_codes[kid1]['code'] + \
            self.nodes_and_codes[kid2]['code'] + \
            [addr + ' = ' + self.nodes_and_codes[kid1]['addr'][0] + ' ' + ctx.getChild(1).getText() + ' ' + self.nodes_and_codes[kid2]['addr'][0]]

        self.temp_rt(self.nodes_and_codes[kid2]['addr'])
        self.temp_rt(self.nodes_and_codes[kid1]['addr'])

        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }
        # Define the type as an integer
        self.nodes_and_types[ctx.getText()] = self.INT


    """
        _Author_
        Laura
        
        _summary_
        Exit the "Div_expr" phase
    """
    def exitDiv_expr(self, ctx: testParser.Div_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()

        # Intermediate code is created based on the code of both children, and the new structure with temporary variables
        addr = self.get_new_temp()
        code = self.nodes_and_codes[kid1]['code'] + \
            self.nodes_and_codes[kid2]['code'] + \
            [addr + ' = ' + self.nodes_and_codes[kid1]['addr'][0] + ' ' + ctx.getChild(1).getText() + ' ' + self.nodes_and_codes[kid2]['addr'][0]]

        self.temp_rt(self.nodes_and_codes[kid2]['addr'])
        self.temp_rt(self.nodes_and_codes[kid1]['addr'])
        # Add node with code
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }
        # Define the type as an integer
        self.nodes_and_types[ctx.getText()] = self.INT


    """
        _Author_
        Laura
        
        _summary_
        Exit the "Mul_expr" phase
    """
    def exitMul_expr(self, ctx: testParser.Mul_exprContext):
        kid1 = ctx.getChild(0).getText()
        kid2 = ctx.getChild(2).getText()

        # Intermediate code is created based on the code of both children, and the new structure with temporary variables
        addr = self.get_new_temp()
        code = self.nodes_and_codes[kid1]['code'] + \
            self.nodes_and_codes[kid2]['code'] + \
            [addr + ' = ' + self.nodes_and_codes[kid1]['addr'][0] + ' ' + ctx.getChild(1).getText() + ' ' + self.nodes_and_codes[kid2]['addr'][0]]

        self.temp_rt(self.nodes_and_codes[kid2]['addr'])
        self.temp_rt(self.nodes_and_codes[kid1]['addr'])
        # Add node with code
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }
        # Define the type as an integer
        self.nodes_and_types[ctx.getText()] = self.INT


    """
        _Author_
        Laura
        
        _summary_
        Exit the "Void_expr" phase
    """
    def exitVoid_expr(self, ctx: testParser.Void_exprContext):
        kid1 = ctx.getChild(1).getText()
        # Define the type as a boolean
        self.nodes_and_types[ctx.getText()] = self.BOOL

        # Intermediate code is created based on the code of both children and a structure to check if it is void
        addr = self.get_new_temp()
        code = self.nodes_and_codes[kid1]['code'] + \
            [addr + ' = is_void ' + self.nodes_and_codes[kid1]['addr'][0]]
        self.temp_rt(self.nodes_and_codes[kid1]['addr'])
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, True),
            'code': code
        }


    """
        _Author_
        Laura
        
        _summary_
        Exit the "BR_expr" phase
    """
    def exitBr_expr(self, ctx: testParser.Br_exprContext):
        hijos_tipo = []
        # Get types of all children
        for i in ctx.children:
            if not isinstance(i, TerminalNode):
                if i.getText() == 'self':
                    hijos_tipo.append(self.nodes_and_types[i.getText()+self.method_table.search(self.current_scope.scope_name)['parent']])
                else:
                    hijos_tipo.append(self.nodes_and_types[i.getText()])

        addr = ''
        code = []
        # Obtain the code of all the children
        exprs = ctx.expr()
        for i in range(len(exprs)):
            code += self.nodes_and_codes[exprs[i].getText()]['code']

            if 'next' in self.nodes_and_codes[exprs[i].getText()].keys():
                code += [self.nodes_and_codes[exprs[i].getText()]['next']]
            else:
                pass

        # Add the code of all the children, leaving the address empty
        self.nodes_and_codes[ctx.getText()] = {
            'addr': (addr, False),
            'code': code
            }

        # Define its type as equal to the last of the children
        self.nodes_and_types[ctx.getText()] = hijos_tipo[-1]
        
    
    """
        _Author_
        Oliver
        
        _summary_
        Entry the "Class_expr" phase
    """
    def enterClass_method(self, ctx: testParser.Class_methodContext):
        method_name = ctx.var_id()[0].getText()
        parameters = []

        tipo = ctx.return_type().var_type().getText()
        is_type = self.type_table.search(tipo)
        class_off = self.current_scope.getSize() 

        # Obtain parameters and types of the parameters
        hijos = ctx.getChildCount()
        for i in range(hijos):
            if isinstance(ctx.getChild(i), testParser.Var_typeContext):
                par_type = ctx.getChild(i).getText()
                is_type = self.type_table.search(par_type)
                if is_type != None:
                    par_id = ctx.getChild(i - 2).getText()
                    parameters.append({"type":par_type, "id":par_id})                     

        # Enter the methods table
        parent = ctx.parentCtx
        parent_name = parent.var_type()[0].getText()
        self.method_table.add_method(tipo, method_name, parameters, parent_name)
        # Update class table
        self.class_table.search(parent_name)['methods'].append(method_name)
        # Put the new method on the stack
        self.scope_push(method_name)
        # Add each parameter as a symbol to the scope
        for par in parameters:
            par_type = self.type_table.search(par['type'])
            size = par_type['size']
            off = class_off+self.current_scope.this_off
            self.current_scope.add_symb(par['type'], par['id'], size, off, True)

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Exit_expr" phase
    """
    def exitClass_method(self, ctx: testParser.Class_methodContext):
        method = ctx.var_id()[0].getText()
        # Define three-way structure for the method
        enter = f'DEF {method}'
        exit_ = f'EXIT DEF {method}'

        #Obtain the children code
        expr = self.nodes_and_codes[ctx.expr().getText()]

        # Create the code as the combination of the input, the child code and the output
        code = [enter] + ['\t' + x for x in expr['code']] + [exit_]

        # Check if anything comes back
        if ctx.return_type().getText().lower() != "void":
            this_addr = ''
            # Check if it is an instance of Br_expr
            if isinstance(ctx.expr(), testParser.Br_exprContext):
                kidos = []
                # Obtain the address of the last child to return
                for kid in  ctx.expr().expr():
                    kidos.append(kid.getText())
                this_addr = self.nodes_and_codes[kidos[-1]]['addr'][0]
            # Obtain the address of the son
            else:
                this_addr = self.nodes_and_codes[ctx.expr().getText()]['addr'][0]
            # Change the return of the method
            temp = code[-1]
            code[-1] = '\treturn '+ this_addr
            code.append(temp)

        hijos = ctx.getChildCount()
        all_code = []
        # Obtain the code of each parameter
        for i in range(hijos):
            if isinstance(ctx.getChild(i), testParser.Var_typeContext):
                id = ctx.getChild(i-2).getText()
                type_ = ctx.getChild(i).getText()

                tg = self.getTop(id)
                all_code += [tg + ' = alocar '+str(self.type_table.search(type_)["size"])+" <"+type_+">"]
                self
        # Add the parameter code at the beginning
        code = all_code + code

        # Register at the scope and leave
        self.scope_register.append(self.current_scope)
        copy_vars = self.current_scope
        self.scope_pop()
        # Add new symbols
        self.current_scope.symbol_table += copy_vars.symbol_table

        # Add node, types and code
        self.nodes_and_codes[ctx.getText()] = {'code':code}
        self.nodes_and_types[ctx.getText()] = self.VOID

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Class" phase
    """
    def exitClass(self, ctx: testParser.ClassContext):
        this_class = ctx.var_type()[0].getText()
        # Configure the correct size of the scope
        size_scope = self.current_scope.getSize()
        self.type_table.search(this_class)['size'] = size_scope
 
        # Of type void
        self.nodes_and_types[ctx.getText()] = self.VOID
        # Add to the scopes registry
        self.scope_register.append(self.current_scope)
        # out of scope
        self.scope_pop()

        gen_code = []
        # For each child within the class the code is added, the code for the class is defined by its name two points and the code of all the children
        for ft in ctx.feature():
            if ft.getText() in self.nodes_and_codes.keys():
                gen_code += self.nodes_and_codes[ft.getText()]['code']
        
        # The node and codes are added
        self.nodes_and_codes[ctx.getText()] = {'code': [this_class +':']+ gen_code}
     
    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Program" phase
    """
    def exitProgram(self, ctx: testParser.ProgramContext):
        self.current_scope.print_table()
        gen_code = []
        # The code of all the classes is obtained and put together
        for cl in ctx.class_():
            if cl.getText() in self.nodes_and_codes.keys():
                gen_code += self.nodes_and_codes[cl.getText()]['code']
        
        # For use in the interface
        self.code_generated = gen_code.copy()

    """
        _Author_
        Oliver
        
        _summary_
        Entry the "Class_attribute" phase
    """
    def enterClass_attribute(self, ctx: testParser.Class_attributeContext):
        type = ctx.var_type().getText()
        id = ctx.var_id().getText()

        is_type = self.type_table.search(type)
        
        # Configure and add current scope
        size = is_type["size"]
        offset = self.current_scope.this_off
        self.current_scope.add_symb(type, id, size, offset, False)

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Class_attribute" phase
    """
    def exitClass_attribute(self, ctx: testParser.Class_attributeContext):
        # Define the node as void type
        self.nodes_and_types[ctx.getText()] = self.VOID
        # Check if it is assignment
        if "<-" in ctx.getText():
            #Define the type as the same as the assignment
            type2 = self.nodes_and_types[ctx.expr().getText()]
            self.nodes_and_types[ctx.var_id().getText()] = type2

            # obtain the son's code
            id = ctx.var_id().getText()
            E = self.nodes_and_codes[ctx.expr().getText()]

            optional = []
            # Obtain registration and previous code if there was
            if id in self.nodes_and_codes.keys():
                topget = self.nodes_and_codes[id]['addr'][0]
                optional = self.nodes_and_codes[id]['code']
            else:
                topget = self.getTop(id)
            
            # Define the code as the sum of the child's code, plus the previous one if there is one, the output record and those that are being assigned
            code = E['code'] + optional + [topget + ' = ' + E['addr'][0]]
            self.temp_rt(E['addr'])
            # Add code and node
            self.nodes_and_codes[ctx.getText()] = {
                'code': code,
                'addr': (topget, False)
            }

        # If it is not an assignment
        else:
            # The type of the node will be the same as the type of the variable
            self.nodes_and_types[ctx.var_id().getText()] = ctx.var_type().getText()
            
            id = ctx.var_id().getText()
            type_ = ctx.var_type().getText()

            optional = []
            # If there is a previous code and record, obtain it
            if id in self.nodes_and_codes.keys():
                topget = self.nodes_and_codes[id]['addr'][0]
                optional = self.nodes_and_codes[id]['code']
            # Registration is obtained
            else:
                topget = self.getTop(id)
                
            # The code is established as a memory allocation and the type of data it is referring to
            code = optional + [topget + " = alocar "+str(self.type_table.search(type_)["size"])+" <"+type_+">"]
            #Add code and node
            self.nodes_and_codes[ctx.getText()] = {
                'code': code,
                'addr': (topget, False)
            }
        
        # Obtain record for identifier
        tget = self.getTop(ctx.var_id().getText())
        code = {
            'addr': (tget, False),
            'code': []
        }

        #Obtain node for identifier
        self.nodes_and_codes[ctx.var_id().getText()] = code

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "New_expr" phase
    """
    def exitNew_expr(self, ctx: testParser.New_exprContext):
        type = ctx.var_type().getText()
        self.nodes_and_types[ctx.getText()] = type

        # Obtain register to use with a configured offset
        tg =  self.getTop(id = ctx, offset_required = self.current_scope.getSize() + self.scopes[-1].getSize())
        
        # Established as a memory allocation and the type of data it is referring to.
        code = {
            'addr': (tg, False),
            'code': [tg + " = alocar "+str(self.type_table.search(type)["size"])+" <"+type+">"]
        }
        # Identifier node is added
        self.nodes_and_codes[ctx.getText()] = code

    """
        _Author_
        Oliver
        
        _summary_
        Enter to the "Loop_expr" phase
    """
    def enterLoop_expr(self, ctx: testParser.Loop_exprContext):
        # Get names for the while states
        b, s, tr, fa = self.statement_labels('while')

        # Define the names obtained for each phase of the general while, the condition expression and the action expression
        self.nodes_and_codes[ctx.getText()] = {
            'begin': b,
            'next': s,
            'true': tr,
            'false': fa
        }
        self.nodes_and_codes[ctx.expr()[0].getText()] = {
            'true': tr,
            'false': s,
            'next': s
        }
        self.nodes_and_codes[ctx.expr()[1].getText()] = {
            'next': b
        }

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Loop_expr" phase
    """
    def exitLoop_expr(self, ctx: testParser.Loop_exprContext):
        # Define the type as Object
        self.nodes_and_types[ctx.getText()] = self.OBJECT

        # Define next and previous states depending on whether it is denied or not.
        if 'not' in ctx.expr()[0].getText():
            siguiente = self.nodes_and_codes[ctx.expr()[0].getText()]['true']
            anterior = self.nodes_and_codes[ctx.expr()[0].getText()]['false']
        else:
            siguiente = self.nodes_and_codes[ctx.expr()[0].getText()]['false']
            anterior = self.nodes_and_codes[ctx.expr()[0].getText()]['true']

        #The code is defined as follows:
        #Code set as start, condition expression code, next state, action expression code,
        #code that indicates the return to the beginning
        code = [self.nodes_and_codes[ctx.getText()]['begin']] + ['\t' + x for x in self.nodes_and_codes[ctx.expr()[0].getText()]['code']] + \
            [anterior] + ['\t' + x for x in self.nodes_and_codes[ctx.expr()[1].getText()]['code']] + \
            ['\tGOTO ' + self.nodes_and_codes[ctx.getText()]['begin']]

        # Add code and node, next is added to know where to exit when the condition is met
        self.nodes_and_codes[ctx.getText()] = {
            'code': code,
            'next': siguiente
        }

    """
        _Author_
        Oliver
        
        _summary_
        Entry the "Conditional_expr" phase
    """
    def enterConditional_expr(self, ctx: testParser.Conditional_exprContext):
        # Get labels
        s, tr, fa = self.statement_labels('if')

        #Configure labels for the general if and for the conditional expression
        self.nodes_and_codes[ctx.getText()] = {
            'next': s,
            'true': tr,
            'false': fa
        }
        self.nodes_and_codes[ctx.expr()[0].getText()] = {
            'next': s,
            'true': tr,
            'false': fa,
        }

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Conditional_expr" phase
    """
    def exitConditional_expr(self, ctx: testParser.Conditional_exprContext):

        if_type_son1 = self.nodes_and_types[ctx.expr()[1].getText()]

        # Configure the type as that of the child
        self.nodes_and_types[ctx.getText()] = if_type_son1

        #The code is defined as follows:
        #Code of the condition expression, code for jump if true, code if true,
        #code for jump to output, jump code if false, code if false
        code = []
        sig = self.nodes_and_codes[ctx.getText()]["next"]
        code = self.nodes_and_codes[ctx.expr()[0].getText()]['code'] + [self.nodes_and_codes[ctx.getText()]['true']] + \
                ['\t' + x for x in self.nodes_and_codes[ctx.expr()[1].getText()]['code']] + ['\tGOTO ' + self.nodes_and_codes[ctx.getText()]['next']] + \
                [self.nodes_and_codes[ctx.getText()]['false']] + ['\t' + x for x in self.nodes_and_codes[ctx.expr()[-1].getText()]['code']]

        #Add code and node, next is added to know where to exit when the condition is met
        self.nodes_and_codes[ctx.getText()] = {
            'code': code,
            'next': sig
        }      

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Assign_expr" phase
    """
    def exitAssign_expr(self, ctx: testParser.Assign_exprContext):

        left = ctx.var_id().getText()
        right = ctx.expr().getText()

        # Define node and its type Void
        self.nodes_and_types[ctx.getText()] = self.VOID

        # Get code of what we want to assign
        exr = self.nodes_and_codes[right]
        opt = []

        # If the left child has a record and code, they are obtained, otherwise a record is generated
        if left in self.nodes_and_codes.keys():
            tg = self.nodes_and_codes[left]['addr'][0]
            opt = self.nodes_and_codes[left]['code']
        else:
            tg = self.getTop(left)

        # The code for the assignment is generated with the previous code and a simple assignment
        code = exr['code'] + opt + [tg + ' = '+ exr['addr'][0]]
        self.temp_rt(exr['addr'])
        # Add node with code and registration
        self.nodes_and_codes[ctx.getText()] = {'code': code,'addr' : (tg, False)}

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Method_call" phase
    """
    def exitMethod_call(self, ctx: testParser.Method_callContext):
        method_name = ctx.var_id().getText()
        parameters = []

        # Parameters are obtained
        for ch in ctx.children:
            if isinstance(ch, testParser.ExprContext):
                parameters.append(ch)

        # Set its data type to the same as the method
        method_detail = self.method_table.search(method_name)
        self.nodes_and_types[ctx.getText()] = method_detail["type"]

        # Define the beginning of the code as a method call
        if method_detail["type"] not in ("Object", "IO", "Main"):
            addr = self.get_new_temp()
            code = f'{addr} = CALL {method_name}, '
        else:
            addr = "R"
            code = f'CALL {method_name}, '

        # If it does not have parameters, a 0 is added to the end of the string and the nodop is added with the code, with generic R registration
        if len(parameters) == 0:
            code += str(0)
            self.nodes_and_codes[ctx.getText()] = {
                'code': [code],
                'addr': (addr,False)
            }
            return
        
        #If it has parameters, the parameter code is obtained for each one
        #a line is added indicating what will be a parameter and its registration
        par_code = []
        all_code = []
        for i in range(len(parameters)):
            par = self.nodes_and_codes[parameters[i].getText()]['addr'][0]

            self.temp_rt(self.nodes_and_codes[parameters[i].getText()]['addr'])

            all_code += self.nodes_and_codes[parameters[i].getText()]['code']
            par_code += [f'PARAM {par}']

        # General code is generalized as the concatenation of the children's code plus the method call structure, with generic R registration.
        code += str(len(parameters))
        self.nodes_and_codes[ctx.getText()] = {
            'code': all_code + par_code + [code],
            'addr': (addr, True)
        }

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Expr_expr" phase
    """
    def exitExpr_expr(self, ctx: testParser.Expr_exprContext):
        tipo_hijo = self.nodes_and_types[ctx.expr()[0].getText()]

        var_id = ctx.var_id().getText()
        
        kid_scope = self.current_scope
        for i in self.scope_register:
            if i.scope_name == tipo_hijo:
                kid_scope = i

        kid_class = self.class_table.search(tipo_hijo) 

        # Verify that the child is an identifier
        if kid_scope.search(var_id) != None:
            #Define the type of the child as the same as that of the identifier
            self.nodes_and_types[ctx.getText()] = self.nodes_and_types[var_id]

            # If the child var_id has a record with offset, the offset is obtained
            if "[" in self.nodes_and_codes[var_id]['addr'][0]:
                specific = self.nodes_and_codes[var_id]['addr'][0]
                spe_no = int(specific.split("[")[1].split(']')[0])
            else:
                spe_no = 0

            # If the child expr has offset, offset is obtained
            if "[" in self.nodes_and_codes[ctx.expr()[0].getText()]['addr'][0]:
                gen_off = self.nodes_and_codes[ctx.expr()[0].getText()]['addr'][0]
                gen_no = int(gen_off.split("[")[1].split(']')[0])
            else:
                gen_no = 0

            # The code of the expr child is obtained
            ant_code = self.nodes_and_codes[ctx.expr()[0].getText()]['code']

            # The code and address are generated based on the offsets found and the previous code
            code = {
                'addr' : (f'R[{spe_no+gen_no}]', False),
                'code' : ant_code + []
            }
            # The node and its code are generated
            self.nodes_and_codes[ctx.getText()] = code

        # Verify that it is a call and a method
        elif var_id in kid_class['methods']:
            method_name = var_id
            parameters = []

            #Get parameters
            for ch in ctx.children:
                if isinstance(ch, testParser.ExprContext):
                    parameters.append(ch)
            parameters.pop(0)

            method_detail = self.method_table.search(method_name)

            # Set its data type to the same as the method                          
            self.nodes_and_types[ctx.getText()] = method_detail["type"]

            # Define the beginning of the code as a method call
            code = f'CALL {method_name}, '

            # If it does not have parameters, a 0 is added to the end of the string and the nodop is added with the code, with generic R registration
            if len(parameters) == 0:
                
                code += str(0)
                gen_off = self.nodes_and_codes[ctx.expr()[0].getText()]['code']
                aadr = self.nodes_and_codes[ctx.expr()[0].getText()]['addr'][0]
                self.nodes_and_codes[ctx.getText()] = {
                    'code': gen_off + [code],
                    'addr': (aadr,False)
                }
                return

            #If it has parameters, the parameter code is obtained for each one
             #a line is added indicating what will be a parameter and its registration
            par_code = []
            all_code = []
            for i in range(len(parameters)):
                par = self.nodes_and_codes[parameters[i].getText()]['addr'][0]

                self.temp_rt(self.nodes_and_codes[parameters[i].getText()]['addr'])

                all_code += self.nodes_and_codes[parameters[i].getText()]['code']
                par_code += [f'PARAM {par}']

           #General code is generalized as the concatenation of the children's code plus the method call structure, with generic R registration
            code += str(len(parameters))
            gen_off = self.nodes_and_codes[ctx.expr()[0].getText()]['code']
            aadr = self.nodes_and_codes[ctx.expr()[0].getText()]['addr'][0]
            self.nodes_and_codes[ctx.getText()] = {
                'code': gen_off + all_code + par_code + [code],
                'addr': (aadr, False)
            }

    """
        _Author_
        Oliver
        
        _summary_
        Enter to the "Let_expr" phase
    """
    def enterLet_expr(self, ctx: testParser.Let_exprContext):
        # Get number of children
        hijos = ctx.getChildCount()
        for i in range(hijos):
            #check if the children are parameters
            if isinstance(ctx.getChild(i), testParser.Var_typeContext):
                type = ctx.getChild(i).getText()
                id = ctx.getChild(i-2).getText()

                #Check that they are not in the current scope
                if self.current_scope.search(id) == None:
                    is_type = self.type_table.search(type)
                     
                    size = is_type["size"]
                    offset = self.current_scope.this_off
                    # Add to the scope
                    self.current_scope.add_symb(type, id, size, offset, False)
                    # Add type
                    self.nodes_and_types[id] = type

                    # Exit the scope, get offset of the parent scope, return to the stack and return to the current scope
                    this_scope = self.current_scope
                    self.scope_pop()
                    class_off = self.current_scope.this_off
                    reset = self.current_scope
                    self.scopes.append(reset)
                    self.current_scope = this_scope

                    #Define the record that will use the parameter
                    tget = self.getTop(id, class_off+offset)
                    code = {
                        'addr': (tget, False),
                        'code': []
                    }
                    #The code and node are added
                    self.nodes_and_codes[id] = code

    """
        _Author_
        Oliver
        
        _summary_
        Exit the "Let_expr" phase
    """
    def exitLet_expr(self, ctx: testParser.Let_exprContext):
        # Define code and type as the same as the action child
        self.nodes_and_types[ctx.getText()] = self.nodes_and_types[ctx.expr()[-1].getText()]
        self.nodes_and_codes[ctx.getText()] = self.nodes_and_codes[ctx.expr()[-1].getText()]

        # Obtain number of children parameters
        hijos = ctx.getChildCount()
        all_code = []
        for i in range(hijos):
            if isinstance(ctx.getChild(i), testParser.Var_typeContext):
                id = ctx.getChild(i-2).getText()
                assign = ctx.getChild(i+1).getText()

                # Obtain code from the children if it is an assignment
                if "<-" in assign:
                
                    code = self.nodes_and_codes[ctx.getChild(i+2).getText()]
                    new_code = code['code'] + [self.nodes_and_codes[id]['addr'][0] + ' = '+ code['addr'][0]] 

                    self.nodes_and_codes[id]['code'] = new_code
                    all_code += self.nodes_and_codes[id]['code']

        # Registration and code of the last child is obtained
        code = self.nodes_and_codes[ctx.expr()[-1].getText()]['code']
        atrr = self.nodes_and_codes[ctx.expr()[-1].getText()]['addr']
        
        # The code is generated as the combination of the code of the parameters and the action to be performed
        self.nodes_and_codes[ctx.getText()] = {
            'code': all_code + code,
            'addr': atrr
        }
        

