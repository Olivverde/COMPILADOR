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


    # Enter a parse tree produced by testParser#statement.
    def enterStatement(self, ctx:testParser.StatementContext):
        pass

    # Exit a parse tree produced by testParser#statement.
    def exitStatement(self, ctx:testParser.StatementContext):
        pass


    # Enter a parse tree produced by testParser#expression.
    def enterExpression(self, ctx:testParser.ExpressionContext):
        pass

    # Exit a parse tree produced by testParser#expression.
    def exitExpression(self, ctx:testParser.ExpressionContext):
        pass



del testParser