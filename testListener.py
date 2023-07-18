# Generated from test.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .testParser import testParser
else:
    from testParser import testParser

# This class defines a complete listener for a parse tree produced by testParser.
class testListener(ParseTreeListener):

    # Enter a parse tree produced by testParser#prog.
    def enterProg(self, ctx:testParser.ProgContext):
        pass

    # Exit a parse tree produced by testParser#prog.
    def exitProg(self, ctx:testParser.ProgContext):
        pass


    # Enter a parse tree produced by testParser#class.
    def enterClass(self, ctx:testParser.ClassContext):
        pass

    # Exit a parse tree produced by testParser#class.
    def exitClass(self, ctx:testParser.ClassContext):
        pass


    # Enter a parse tree produced by testParser#statement.
    def enterStatement(self, ctx:testParser.StatementContext):
        pass

    # Exit a parse tree produced by testParser#statement.
    def exitStatement(self, ctx:testParser.StatementContext):
        pass


    # Enter a parse tree produced by testParser#formalList.
    def enterFormalList(self, ctx:testParser.FormalListContext):
        pass

    # Exit a parse tree produced by testParser#formalList.
    def exitFormalList(self, ctx:testParser.FormalListContext):
        pass


    # Enter a parse tree produced by testParser#formal.
    def enterFormal(self, ctx:testParser.FormalContext):
        pass

    # Exit a parse tree produced by testParser#formal.
    def exitFormal(self, ctx:testParser.FormalContext):
        pass


    # Enter a parse tree produced by testParser#expr.
    def enterExpr(self, ctx:testParser.ExprContext):
        pass

    # Exit a parse tree produced by testParser#expr.
    def exitExpr(self, ctx:testParser.ExprContext):
        pass


    # Enter a parse tree produced by testParser#assignExpr.
    def enterAssignExpr(self, ctx:testParser.AssignExprContext):
        pass

    # Exit a parse tree produced by testParser#assignExpr.
    def exitAssignExpr(self, ctx:testParser.AssignExprContext):
        pass


    # Enter a parse tree produced by testParser#condExpr.
    def enterCondExpr(self, ctx:testParser.CondExprContext):
        pass

    # Exit a parse tree produced by testParser#condExpr.
    def exitCondExpr(self, ctx:testParser.CondExprContext):
        pass


    # Enter a parse tree produced by testParser#orExpr.
    def enterOrExpr(self, ctx:testParser.OrExprContext):
        pass

    # Exit a parse tree produced by testParser#orExpr.
    def exitOrExpr(self, ctx:testParser.OrExprContext):
        pass


    # Enter a parse tree produced by testParser#andExpr.
    def enterAndExpr(self, ctx:testParser.AndExprContext):
        pass

    # Exit a parse tree produced by testParser#andExpr.
    def exitAndExpr(self, ctx:testParser.AndExprContext):
        pass


    # Enter a parse tree produced by testParser#relExpr.
    def enterRelExpr(self, ctx:testParser.RelExprContext):
        pass

    # Exit a parse tree produced by testParser#relExpr.
    def exitRelExpr(self, ctx:testParser.RelExprContext):
        pass


    # Enter a parse tree produced by testParser#addExpr.
    def enterAddExpr(self, ctx:testParser.AddExprContext):
        pass

    # Exit a parse tree produced by testParser#addExpr.
    def exitAddExpr(self, ctx:testParser.AddExprContext):
        pass


    # Enter a parse tree produced by testParser#multExpr.
    def enterMultExpr(self, ctx:testParser.MultExprContext):
        pass

    # Exit a parse tree produced by testParser#multExpr.
    def exitMultExpr(self, ctx:testParser.MultExprContext):
        pass


    # Enter a parse tree produced by testParser#unaryExpr.
    def enterUnaryExpr(self, ctx:testParser.UnaryExprContext):
        pass

    # Exit a parse tree produced by testParser#unaryExpr.
    def exitUnaryExpr(self, ctx:testParser.UnaryExprContext):
        pass


    # Enter a parse tree produced by testParser#atomExpr.
    def enterAtomExpr(self, ctx:testParser.AtomExprContext):
        pass

    # Exit a parse tree produced by testParser#atomExpr.
    def exitAtomExpr(self, ctx:testParser.AtomExprContext):
        pass


    # Enter a parse tree produced by testParser#letBindingList.
    def enterLetBindingList(self, ctx:testParser.LetBindingListContext):
        pass

    # Exit a parse tree produced by testParser#letBindingList.
    def exitLetBindingList(self, ctx:testParser.LetBindingListContext):
        pass


    # Enter a parse tree produced by testParser#letBinding.
    def enterLetBinding(self, ctx:testParser.LetBindingContext):
        pass

    # Exit a parse tree produced by testParser#letBinding.
    def exitLetBinding(self, ctx:testParser.LetBindingContext):
        pass


    # Enter a parse tree produced by testParser#exprList.
    def enterExprList(self, ctx:testParser.ExprListContext):
        pass

    # Exit a parse tree produced by testParser#exprList.
    def exitExprList(self, ctx:testParser.ExprListContext):
        pass



del testParser