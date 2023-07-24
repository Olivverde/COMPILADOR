# Generated from test.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .testParser import testParser
else:
    from testParser import testParser

# This class defines a complete listener for a parse tree produced by testParser.
class testListener(ParseTreeListener):

    # Enter a parse tree produced by testParser#class.
    def enterClass(self, ctx:testParser.ClassContext):
        pass

    # Exit a parse tree produced by testParser#class.
    def exitClass(self, ctx:testParser.ClassContext):
        pass


    # Enter a parse tree produced by testParser#inherits.
    def enterInherits(self, ctx:testParser.InheritsContext):
        pass

    # Exit a parse tree produced by testParser#inherits.
    def exitInherits(self, ctx:testParser.InheritsContext):
        pass


    # Enter a parse tree produced by testParser#type.
    def enterType(self, ctx:testParser.TypeContext):
        pass

    # Exit a parse tree produced by testParser#type.
    def exitType(self, ctx:testParser.TypeContext):
        pass


    # Enter a parse tree produced by testParser#binary_op.
    def enterBinary_op(self, ctx:testParser.Binary_opContext):
        pass

    # Exit a parse tree produced by testParser#binary_op.
    def exitBinary_op(self, ctx:testParser.Binary_opContext):
        pass


    # Enter a parse tree produced by testParser#unary_op.
    def enterUnary_op(self, ctx:testParser.Unary_opContext):
        pass

    # Exit a parse tree produced by testParser#unary_op.
    def exitUnary_op(self, ctx:testParser.Unary_opContext):
        pass


    # Enter a parse tree produced by testParser#program.
    def enterProgram(self, ctx:testParser.ProgramContext):
        pass

    # Exit a parse tree produced by testParser#program.
    def exitProgram(self, ctx:testParser.ProgramContext):
        pass


    # Enter a parse tree produced by testParser#clas_list.
    def enterClas_list(self, ctx:testParser.Clas_listContext):
        pass

    # Exit a parse tree produced by testParser#clas_list.
    def exitClas_list(self, ctx:testParser.Clas_listContext):
        pass


    # Enter a parse tree produced by testParser#listOfFeature.
    def enterFeature_list(self, ctx:testParser.Feature_listContext):
        pass

    # Exit a parse tree produced by testParser#listOfFeature.
    def exitFeature_list(self, ctx:testParser.Feature_listContext):
        pass


    # Enter a parse tree produced by testParser#feature.
    def enterFeature(self, ctx:testParser.FeatureContext):
        pass

    # Exit a parse tree produced by testParser#feature.
    def exitFeature(self, ctx:testParser.FeatureContext):
        pass


    # Enter a parse tree produced by testParser#attributesDef.
    def enterAttribute_definition(self, ctx:testParser.Attribute_definitionContext):
        pass

    # Exit a parse tree produced by testParser#attributesDef.
    def exitAttribute_definition(self, ctx:testParser.Attribute_definitionContext):
        pass


    # Enter a parse tree produced by testParser#method_definition.
    def enterMethod_definition(self, ctx:testParser.Method_definitionContext):
        pass

    # Exit a parse tree produced by testParser#method_definition.
    def exitMethod_definition(self, ctx:testParser.Method_definitionContext):
        pass


    # Enter a parse tree produced by testParser#let_declaration.
    def enterLet_declaration(self, ctx:testParser.Let_declarationContext):
        pass

    # Exit a parse tree produced by testParser#let_declaration.
    def exitLet_declaration(self, ctx:testParser.Let_declarationContext):
        pass


    # Enter a parse tree produced by testParser#let_binding.
    def enterLet_binding(self, ctx:testParser.Let_bindingContext):
        pass

    # Exit a parse tree produced by testParser#let_binding.
    def exitLet_binding(self, ctx:testParser.Let_bindingContext):
        pass


    # Enter a parse tree produced by testParser#ifRule.
    def enterIf_statement(self, ctx:testParser.If_statementContext):
        pass

    # Exit a parse tree produced by testParser#ifRule.
    def exitIf_statement(self, ctx:testParser.If_statementContext):
        pass


    # Enter a parse tree produced by testParser#whileRule.
    def enterWhile_statement(self, ctx:testParser.While_statementContext):
        pass

    # Exit a parse tree produced by testParser#whileRule.
    def exitWhile_statement(self, ctx:testParser.While_statementContext):
        pass


    # Enter a parse tree produced by testParser#block.
    def enterBlock(self, ctx:testParser.BlockContext):
        pass

    # Exit a parse tree produced by testParser#block.
    def exitBlock(self, ctx:testParser.BlockContext):
        pass


    # Enter a parse tree produced by testParser#methodSimple.
    def enterSimple_method_definition(self, ctx:testParser.Simple_method_definitionContext):
        pass

    # Exit a parse tree produced by testParser#methodSimple.
    def exitSimple_method_definition(self, ctx:testParser.Simple_method_definitionContext):
        pass


    # Enter a parse tree produced by testParser#formal.
    def enterFormal(self, ctx:testParser.FormalContext):
        pass

    # Exit a parse tree produced by testParser#formal.
    def exitFormal(self, ctx:testParser.FormalContext):
        pass


    # Enter a parse tree produced by testParser#parameters.
    def enterParameter_list(self, ctx:testParser.Parameter_listContext):
        pass

    # Exit a parse tree produced by testParser#parameters.
    def exitParameter_list(self, ctx:testParser.Parameter_listContext):
        pass


    # Enter a parse tree produced by testParser#expr.
    def enterExpr(self, ctx:testParser.ExprContext):
        pass

    # Exit a parse tree produced by testParser#expr.
    def exitExpr(self, ctx:testParser.ExprContext):
        pass



del testParser