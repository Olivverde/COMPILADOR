# Generated from test.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .testParser import testParser
else:
    from testParser import testParser

# This class defines a complete listener for a parse tree produced by testParser.
class testListener(ParseTreeListener):

    # Enter a parse tree produced by testParser#program.
    def enterProgram(self, ctx:testParser.ProgramContext):
        pass

    # Exit a parse tree produced by testParser#program.
    def exitProgram(self, ctx:testParser.ProgramContext):
        pass


    # Enter a parse tree produced by testParser#class_prod.
    def enterClass_prod(self, ctx:testParser.Class_prodContext):
        pass

    # Exit a parse tree produced by testParser#class_prod.
    def exitClass_prod(self, ctx:testParser.Class_prodContext):
        pass


    # Enter a parse tree produced by testParser#class_method.
    def enterClass_method(self, ctx:testParser.Class_methodContext):
        pass

    # Exit a parse tree produced by testParser#class_method.
    def exitClass_method(self, ctx:testParser.Class_methodContext):
        pass


    # Enter a parse tree produced by testParser#class_attribute.
    def enterClass_attribute(self, ctx:testParser.Class_attributeContext):
        pass

    # Exit a parse tree produced by testParser#class_attribute.
    def exitClass_attribute(self, ctx:testParser.Class_attributeContext):
        pass


    # Enter a parse tree produced by testParser#neg_expr.
    def enterNeg_expr(self, ctx:testParser.Neg_exprContext):
        pass

    # Exit a parse tree produced by testParser#neg_expr.
    def exitNeg_expr(self, ctx:testParser.Neg_exprContext):
        pass


    # Enter a parse tree produced by testParser#int_expr.
    def enterInt_expr(self, ctx:testParser.Int_exprContext):
        pass

    # Exit a parse tree produced by testParser#int_expr.
    def exitInt_expr(self, ctx:testParser.Int_exprContext):
        pass


    # Enter a parse tree produced by testParser#par_expr.
    def enterPar_expr(self, ctx:testParser.Par_exprContext):
        pass

    # Exit a parse tree produced by testParser#par_expr.
    def exitPar_expr(self, ctx:testParser.Par_exprContext):
        pass


    # Enter a parse tree produced by testParser#true_expr.
    def enterTrue_expr(self, ctx:testParser.True_exprContext):
        pass

    # Exit a parse tree produced by testParser#true_expr.
    def exitTrue_expr(self, ctx:testParser.True_exprContext):
        pass


    # Enter a parse tree produced by testParser#add_expr.
    def enterAdd_expr(self, ctx:testParser.Add_exprContext):
        pass

    # Exit a parse tree produced by testParser#add_expr.
    def exitAdd_expr(self, ctx:testParser.Add_exprContext):
        pass


    # Enter a parse tree produced by testParser#assign_expr.
    def enterAssign_expr(self, ctx:testParser.Assign_exprContext):
        pass

    # Exit a parse tree produced by testParser#assign_expr.
    def exitAssign_expr(self, ctx:testParser.Assign_exprContext):
        pass


    # Enter a parse tree produced by testParser#new_expr.
    def enterNew_expr(self, ctx:testParser.New_exprContext):
        pass

    # Exit a parse tree produced by testParser#new_expr.
    def exitNew_expr(self, ctx:testParser.New_exprContext):
        pass


    # Enter a parse tree produced by testParser#expr_expr.
    def enterExpr_expr(self, ctx:testParser.Expr_exprContext):
        pass

    # Exit a parse tree produced by testParser#expr_expr.
    def exitExpr_expr(self, ctx:testParser.Expr_exprContext):
        pass


    # Enter a parse tree produced by testParser#let_expr.
    def enterLet_expr(self, ctx:testParser.Let_exprContext):
        pass

    # Exit a parse tree produced by testParser#let_expr.
    def exitLet_expr(self, ctx:testParser.Let_exprContext):
        pass


    # Enter a parse tree produced by testParser#div_expr.
    def enterDiv_expr(self, ctx:testParser.Div_exprContext):
        pass

    # Exit a parse tree produced by testParser#div_expr.
    def exitDiv_expr(self, ctx:testParser.Div_exprContext):
        pass


    # Enter a parse tree produced by testParser#lessEq_expr.
    def enterLessEq_expr(self, ctx:testParser.LessEq_exprContext):
        pass

    # Exit a parse tree produced by testParser#lessEq_expr.
    def exitLessEq_expr(self, ctx:testParser.LessEq_exprContext):
        pass


    # Enter a parse tree produced by testParser#void_expr.
    def enterVoid_expr(self, ctx:testParser.Void_exprContext):
        pass

    # Exit a parse tree produced by testParser#void_expr.
    def exitVoid_expr(self, ctx:testParser.Void_exprContext):
        pass


    # Enter a parse tree produced by testParser#method_call.
    def enterMethod_call(self, ctx:testParser.Method_callContext):
        pass

    # Exit a parse tree produced by testParser#method_call.
    def exitMethod_call(self, ctx:testParser.Method_callContext):
        pass


    # Enter a parse tree produced by testParser#conditional_expr.
    def enterConditional_expr(self, ctx:testParser.Conditional_exprContext):
        pass

    # Exit a parse tree produced by testParser#conditional_expr.
    def exitConditional_expr(self, ctx:testParser.Conditional_exprContext):
        pass


    # Enter a parse tree produced by testParser#loop_expr.
    def enterLoop_expr(self, ctx:testParser.Loop_exprContext):
        pass

    # Exit a parse tree produced by testParser#loop_expr.
    def exitLoop_expr(self, ctx:testParser.Loop_exprContext):
        pass


    # Enter a parse tree produced by testParser#not_expr.
    def enterNot_expr(self, ctx:testParser.Not_exprContext):
        pass

    # Exit a parse tree produced by testParser#not_expr.
    def exitNot_expr(self, ctx:testParser.Not_exprContext):
        pass


    # Enter a parse tree produced by testParser#string_expr.
    def enterString_expr(self, ctx:testParser.String_exprContext):
        pass

    # Exit a parse tree produced by testParser#string_expr.
    def exitString_expr(self, ctx:testParser.String_exprContext):
        pass


    # Enter a parse tree produced by testParser#br_expr.
    def enterBr_expr(self, ctx:testParser.Br_exprContext):
        pass

    # Exit a parse tree produced by testParser#br_expr.
    def exitBr_expr(self, ctx:testParser.Br_exprContext):
        pass


    # Enter a parse tree produced by testParser#false_expr.
    def enterFalse_expr(self, ctx:testParser.False_exprContext):
        pass

    # Exit a parse tree produced by testParser#false_expr.
    def exitFalse_expr(self, ctx:testParser.False_exprContext):
        pass


    # Enter a parse tree produced by testParser#sub_expr.
    def enterSub_expr(self, ctx:testParser.Sub_exprContext):
        pass

    # Exit a parse tree produced by testParser#sub_expr.
    def exitSub_expr(self, ctx:testParser.Sub_exprContext):
        pass


    # Enter a parse tree produced by testParser#less_expr.
    def enterLess_expr(self, ctx:testParser.Less_exprContext):
        pass

    # Exit a parse tree produced by testParser#less_expr.
    def exitLess_expr(self, ctx:testParser.Less_exprContext):
        pass


    # Enter a parse tree produced by testParser#var_expr.
    def enterVar_expr(self, ctx:testParser.Var_exprContext):
        pass

    # Exit a parse tree produced by testParser#var_expr.
    def exitVar_expr(self, ctx:testParser.Var_exprContext):
        pass


    # Enter a parse tree produced by testParser#eq_expr.
    def enterEq_expr(self, ctx:testParser.Eq_exprContext):
        pass

    # Exit a parse tree produced by testParser#eq_expr.
    def exitEq_expr(self, ctx:testParser.Eq_exprContext):
        pass


    # Enter a parse tree produced by testParser#mul_expr.
    def enterMul_expr(self, ctx:testParser.Mul_exprContext):
        pass

    # Exit a parse tree produced by testParser#mul_expr.
    def exitMul_expr(self, ctx:testParser.Mul_exprContext):
        pass


    # Enter a parse tree produced by testParser#var_type.
    def enterVar_type(self, ctx:testParser.Var_typeContext):
        pass

    # Exit a parse tree produced by testParser#var_type.
    def exitVar_type(self, ctx:testParser.Var_typeContext):
        pass


    # Enter a parse tree produced by testParser#var_id.
    def enterVar_id(self, ctx:testParser.Var_idContext):
        pass

    # Exit a parse tree produced by testParser#var_id.
    def exitVar_id(self, ctx:testParser.Var_idContext):
        pass


    # Enter a parse tree produced by testParser#return_type.
    def enterReturn_type(self, ctx:testParser.Return_typeContext):
        pass

    # Exit a parse tree produced by testParser#return_type.
    def exitReturn_type(self, ctx:testParser.Return_typeContext):
        pass



del testParser