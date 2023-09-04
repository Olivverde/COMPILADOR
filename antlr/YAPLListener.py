# Generated from antlr\YAPL.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .YAPLParser import YAPLParser
else:
    from YAPLParser import YAPLParser

# This class defines a complete listener for a parse tree produced by YAPLParser.
class YAPLListener(ParseTreeListener):

    # Enter a parse tree produced by YAPLParser#program.
    def enterProgram(self, ctx:YAPLParser.ProgramContext):
        pass

    # Exit a parse tree produced by YAPLParser#program.
    def exitProgram(self, ctx:YAPLParser.ProgramContext):
        pass


    # Enter a parse tree produced by YAPLParser#class.
    def enterClass(self, ctx:YAPLParser.ClassContext):
        pass

    # Exit a parse tree produced by YAPLParser#class.
    def exitClass(self, ctx:YAPLParser.ClassContext):
        pass


    # Enter a parse tree produced by YAPLParser#class_method.
    def enterClass_method(self, ctx:YAPLParser.Class_methodContext):
        pass

    # Exit a parse tree produced by YAPLParser#class_method.
    def exitClass_method(self, ctx:YAPLParser.Class_methodContext):
        pass


    # Enter a parse tree produced by YAPLParser#class_attribute.
    def enterClass_attribute(self, ctx:YAPLParser.Class_attributeContext):
        pass

    # Exit a parse tree produced by YAPLParser#class_attribute.
    def exitClass_attribute(self, ctx:YAPLParser.Class_attributeContext):
        pass


    # Enter a parse tree produced by YAPLParser#neg_expr.
    def enterNeg_expr(self, ctx:YAPLParser.Neg_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#neg_expr.
    def exitNeg_expr(self, ctx:YAPLParser.Neg_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#int_expr.
    def enterInt_expr(self, ctx:YAPLParser.Int_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#int_expr.
    def exitInt_expr(self, ctx:YAPLParser.Int_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#par_expr.
    def enterPar_expr(self, ctx:YAPLParser.Par_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#par_expr.
    def exitPar_expr(self, ctx:YAPLParser.Par_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#true_expr.
    def enterTrue_expr(self, ctx:YAPLParser.True_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#true_expr.
    def exitTrue_expr(self, ctx:YAPLParser.True_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#add_expr.
    def enterAdd_expr(self, ctx:YAPLParser.Add_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#add_expr.
    def exitAdd_expr(self, ctx:YAPLParser.Add_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#assign_expr.
    def enterAssign_expr(self, ctx:YAPLParser.Assign_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#assign_expr.
    def exitAssign_expr(self, ctx:YAPLParser.Assign_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#new_expr.
    def enterNew_expr(self, ctx:YAPLParser.New_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#new_expr.
    def exitNew_expr(self, ctx:YAPLParser.New_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#expr_expr.
    def enterExpr_expr(self, ctx:YAPLParser.Expr_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#expr_expr.
    def exitExpr_expr(self, ctx:YAPLParser.Expr_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#let_expr.
    def enterLet_expr(self, ctx:YAPLParser.Let_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#let_expr.
    def exitLet_expr(self, ctx:YAPLParser.Let_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#div_expr.
    def enterDiv_expr(self, ctx:YAPLParser.Div_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#div_expr.
    def exitDiv_expr(self, ctx:YAPLParser.Div_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#lessEq_expr.
    def enterLessEq_expr(self, ctx:YAPLParser.LessEq_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#lessEq_expr.
    def exitLessEq_expr(self, ctx:YAPLParser.LessEq_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#void_expr.
    def enterVoid_expr(self, ctx:YAPLParser.Void_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#void_expr.
    def exitVoid_expr(self, ctx:YAPLParser.Void_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#method_call.
    def entermethod_call(self, ctx:YAPLParser.method_callContext):
        pass

    # Exit a parse tree produced by YAPLParser#method_call.
    def exitmethod_call(self, ctx:YAPLParser.method_callContext):
        pass


    # Enter a parse tree produced by YAPLParser#conditional_expr.
    def enterConditional_expr(self, ctx:YAPLParser.Conditional_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#conditional_expr.
    def exitConditional_expr(self, ctx:YAPLParser.Conditional_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#loop_expr.
    def enterLoop_expr(self, ctx:YAPLParser.Loop_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#loop_expr.
    def exitLoop_expr(self, ctx:YAPLParser.Loop_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#not_expr.
    def enterNot_expr(self, ctx:YAPLParser.Not_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#not_expr.
    def exitNot_expr(self, ctx:YAPLParser.Not_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#string_expr.
    def enterString_expr(self, ctx:YAPLParser.String_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#string_expr.
    def exitString_expr(self, ctx:YAPLParser.String_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#br_expr.
    def enterBr_expr(self, ctx:YAPLParser.Br_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#br_expr.
    def exitBr_expr(self, ctx:YAPLParser.Br_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#false_expr.
    def enterFalse_expr(self, ctx:YAPLParser.False_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#false_expr.
    def exitFalse_expr(self, ctx:YAPLParser.False_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#sub_expr.
    def enterSub_expr(self, ctx:YAPLParser.Sub_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#sub_expr.
    def exitSub_expr(self, ctx:YAPLParser.Sub_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#less_expr.
    def enterLess_expr(self, ctx:YAPLParser.Less_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#less_expr.
    def exitLess_expr(self, ctx:YAPLParser.Less_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#var_expr.
    def enterVar_expr(self, ctx:YAPLParser.Var_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#var_expr.
    def exitVar_expr(self, ctx:YAPLParser.Var_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#eq_expr.
    def enterEq_expr(self, ctx:YAPLParser.Eq_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#eq_expr.
    def exitEq_expr(self, ctx:YAPLParser.Eq_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#mul_expr.
    def enterMul_expr(self, ctx:YAPLParser.Mul_exprContext):
        pass

    # Exit a parse tree produced by YAPLParser#mul_expr.
    def exitMul_expr(self, ctx:YAPLParser.Mul_exprContext):
        pass


    # Enter a parse tree produced by YAPLParser#var_type.
    def enterVar_type(self, ctx:YAPLParser.Var_typeContext):
        pass

    # Exit a parse tree produced by YAPLParser#var_type.
    def exitVar_type(self, ctx:YAPLParser.Var_typeContext):
        pass


    # Enter a parse tree produced by YAPLParser#var_id.
    def enterVar_id(self, ctx:YAPLParser.Var_idContext):
        pass

    # Exit a parse tree produced by YAPLParser#var_id.
    def exitVar_id(self, ctx:YAPLParser.Var_idContext):
        pass


    # Enter a parse tree produced by YAPLParser#return_type.
    def enterReturn_type(self, ctx:YAPLParser.Return_typeContext):
        pass

    # Exit a parse tree produced by YAPLParser#return_type.
    def exitReturn_type(self, ctx:YAPLParser.Return_typeContext):
        pass



del YAPLParser