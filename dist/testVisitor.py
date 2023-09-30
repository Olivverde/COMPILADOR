# Generated from antlr\YAPL.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .testParser import testParser
else:
    from testParser import testParser

# This class defines a complete generic visitor for a parse tree produced by testParser.

class testVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by testParser#program.
    def visitProgram(self, ctx:testParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#class.
    def visitClass(self, ctx:testParser.ClassContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#class_method.
    def visitClass_method(self, ctx:testParser.Class_methodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#class_attribute.
    def visitClass_attribute(self, ctx:testParser.Class_attributeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#neg_expr.
    def visitNeg_expr(self, ctx:testParser.Neg_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#int_expr.
    def visitInt_expr(self, ctx:testParser.Int_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#par_expr.
    def visitPar_expr(self, ctx:testParser.Par_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#true_expr.
    def visitTrue_expr(self, ctx:testParser.True_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#add_expr.
    def visitAdd_expr(self, ctx:testParser.Add_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#assign_expr.
    def visitAssign_expr(self, ctx:testParser.Assign_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#new_expr.
    def visitNew_expr(self, ctx:testParser.New_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#expr_expr.
    def visitExpr_expr(self, ctx:testParser.Expr_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#let_expr.
    def visitLet_expr(self, ctx:testParser.Let_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#div_expr.
    def visitDiv_expr(self, ctx:testParser.Div_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#lessEq_expr.
    def visitLessEq_expr(self, ctx:testParser.LessEq_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#void_expr.
    def visitVoid_expr(self, ctx:testParser.Void_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#method_call.
    def visitMethod_call(self, ctx:testParser.Method_callContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#conditional_expr.
    def visitConditional_expr(self, ctx:testParser.Conditional_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#loop_expr.
    def visitLoop_expr(self, ctx:testParser.Loop_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#not_expr.
    def visitNot_expr(self, ctx:testParser.Not_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#string_expr.
    def visitString_expr(self, ctx:testParser.String_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#br_expr.
    def visitBr_expr(self, ctx:testParser.Br_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#false_expr.
    def visitFalse_expr(self, ctx:testParser.False_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#sub_expr.
    def visitSub_expr(self, ctx:testParser.Sub_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#less_expr.
    def visitLess_expr(self, ctx:testParser.Less_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#var_expr.
    def visitVar_expr(self, ctx:testParser.Var_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#eq_expr.
    def visitEq_expr(self, ctx:testParser.Eq_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#mul_expr.
    def visitMul_expr(self, ctx:testParser.Mul_exprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#var_type.
    def visitVar_type(self, ctx:testParser.Var_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#var_id.
    def visitVar_id(self, ctx:testParser.Var_idContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by testParser#return_type.
    def visitReturn_type(self, ctx:testParser.Return_typeContext):
        return self.visitChildren(ctx)



del testParser