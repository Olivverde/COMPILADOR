# Generated from antlr\YAPL.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .YAPLParser import YAPLParser
else:
    from YAPLParser import YAPLParser

# This class defines a complete generic visitor for a parse tree produced by YAPLParser.

class YAPLVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by YAPLParser#program.
    def visitProgram(self, ctx:YAPLParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#class.
    def visitClass(self, ctx:YAPLParser.ClassContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#class_method.
    def visitClass_method(self, ctx:YAPLParser.Class_methodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#class_attribute.
    def visitClass_attribute(self, ctx:YAPLParser.Class_attributeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#neg_expr.
    def visitNeg_expr(self, ctx:YAPLParser.Neg_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#int_expr.
    def visitInt_expr(self, ctx:YAPLParser.Int_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#par_expr.
    def visitPar_expr(self, ctx:YAPLParser.Par_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#true_expr.
    def visitTrue_expr(self, ctx:YAPLParser.True_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#add_expr.
    def visitAdd_expr(self, ctx:YAPLParser.Add_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#assign_expr.
    def visitAssign_expr(self, ctx:YAPLParser.Assign_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#new_expr.
    def visitNew_expr(self, ctx:YAPLParser.New_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#expr_expr.
    def visitExpr_expr(self, ctx:YAPLParser.Expr_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#let_expr.
    def visitLet_expr(self, ctx:YAPLParser.Let_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#div_expr.
    def visitDiv_expr(self, ctx:YAPLParser.Div_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#lessEq_expr.
    def visitLessEq_expr(self, ctx:YAPLParser.LessEq_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#void_expr.
    def visitVoid_expr(self, ctx:YAPLParser.Void_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#method_call.
    def visitmethod_call(self, ctx:YAPLParser.method_callContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#conditional_expr.
    def visitConditional_expr(self, ctx:YAPLParser.Conditional_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#loop_expr.
    def visitLoop_expr(self, ctx:YAPLParser.Loop_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#not_expr.
    def visitNot_expr(self, ctx:YAPLParser.Not_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#string_expr.
    def visitString_expr(self, ctx:YAPLParser.String_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#br_expr.
    def visitBr_expr(self, ctx:YAPLParser.Br_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#false_expr.
    def visitFalse_expr(self, ctx:YAPLParser.False_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#sub_expr.
    def visitSub_expr(self, ctx:YAPLParser.Sub_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#less_expr.
    def visitLess_expr(self, ctx:YAPLParser.Less_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#var_expr.
    def visitVar_expr(self, ctx:YAPLParser.Var_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#eq_expr.
    def visitEq_expr(self, ctx:YAPLParser.Eq_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#mul_expr.
    def visitMul_expr(self, ctx:YAPLParser.Mul_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#var_type.
    def visitVar_type(self, ctx:YAPLParser.Var_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#var_id.
    def visitVar_id(self, ctx:YAPLParser.Var_idContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by YAPLParser#return_type.
    def visitReturn_type(self, ctx:YAPLParser.Return_typeContext):
        return self.visitChildren(ctx)



del YAPLParser