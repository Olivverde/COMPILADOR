// Generated from c:\Users\laury\Documents\UVG\Compis\LAB0\LAB0-Compiladores\test.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, ELSE=2, FI=3, IF=4, IN=5, INHERITS=6, ISVOID=7, LOOP=8, POOL=9, 
		THEN=10, WHILE=11, NEW=12, NOT=13, LET=14, TRUE=15, FALSE=16, BOOL=17, 
		INT=18, STRING=19, VOID=20, SELF=21, SELF_TYPE=22, SEMICOLON=23, COLON=24, 
		LBRACE=25, RBRACE=26, LBRACKET=27, RBRACKET=28, LPAR=29, RPAR=30, COMMA=31, 
		QUOTES=32, APOSTROPHE=33, ADD=34, SUB=35, MULTIPLY=36, DIVIDE=37, NEGATION=38, 
		LESS_OP=39, LESS_EQ_OP=40, EQUAL_OP=41, DOT=42, AT=43, ASIGN=44, TYPE_ID=45, 
		VAR_NAME=46, INTEGER=47, DIGIT=48, STRING_LIT=49, BOOL_LIT=50, COMMENT=51, 
		COMMENT_2=52, COMMENT_3=53, NEWLINE=54, WS=55, ERR_TOKEN=56;
	public static final int
		RULE_program = 0, RULE_class_prod = 1, RULE_feature = 2, RULE_expr = 3, 
		RULE_var_type = 4, RULE_var_id = 5, RULE_return_type = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class_prod", "feature", "expr", "var_type", "var_id", "return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'true'", "'false'", "'Bool'", "'Int'", "'String'", 
			"'void'", "'self'", "'SELF_TYPE'", "';'", "':'", "'{'", "'}'", "'['", 
			"']'", "'('", "')'", "','", "'\"'", "'''", "'+'", "'-'", "'*'", "'/'", 
			"'~'", "'<'", "'<='", "'='", "'.'", "'@'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "ISVOID", "LOOP", 
			"POOL", "THEN", "WHILE", "NEW", "NOT", "LET", "TRUE", "FALSE", "BOOL", 
			"INT", "STRING", "VOID", "SELF", "SELF_TYPE", "SEMICOLON", "COLON", "LBRACE", 
			"RBRACE", "LBRACKET", "RBRACKET", "LPAR", "RPAR", "COMMA", "QUOTES", 
			"APOSTROPHE", "ADD", "SUB", "MULTIPLY", "DIVIDE", "NEGATION", "LESS_OP", 
			"LESS_EQ_OP", "EQUAL_OP", "DOT", "AT", "ASIGN", "TYPE_ID", "VAR_NAME", 
			"INTEGER", "DIGIT", "STRING_LIT", "BOOL_LIT", "COMMENT", "COMMENT_2", 
			"COMMENT_3", "NEWLINE", "WS", "ERR_TOKEN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public testParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<Class_prodContext> class_prod() {
			return getRuleContexts(Class_prodContext.class);
		}
		public Class_prodContext class_prod(int i) {
			return getRuleContext(Class_prodContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(testParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(testParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				class_prod();
				setState(15);
				match(SEMICOLON);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_prodContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(testParser.CLASS, 0); }
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public TerminalNode INHERITS() { return getToken(testParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public Class_prodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_prod; }
	}

	public final Class_prodContext class_prod() throws RecognitionException {
		Class_prodContext _localctx = new Class_prodContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_prod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(CLASS);
			setState(22);
			var_type();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(23);
				match(INHERITS);
				setState(24);
				var_type();
				}
			}

			setState(27);
			match(LBRACE);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SELF || _la==VAR_NAME) {
				{
				{
				setState(28);
				feature();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Class_methodContext extends FeatureContext {
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(testParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(testParser.RPAR, 0); }
		public List<TerminalNode> COLON() { return getTokens(testParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(testParser.COLON, i);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(testParser.SEMICOLON, 0); }
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public Class_methodContext(FeatureContext ctx) { copyFrom(ctx); }
	}
	public static class Class_attributeContext extends FeatureContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public TerminalNode COLON() { return getToken(testParser.COLON, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(testParser.SEMICOLON, 0); }
		public TerminalNode ASIGN() { return getToken(testParser.ASIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Class_attributeContext(FeatureContext ctx) { copyFrom(ctx); }
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new Class_methodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				var_id();
				setState(37);
				match(LPAR);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SELF || _la==VAR_NAME) {
					{
					setState(38);
					var_id();
					setState(39);
					match(COLON);
					setState(40);
					var_type();
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(41);
						match(COMMA);
						setState(42);
						var_id();
						setState(43);
						match(COLON);
						setState(44);
						var_type();
						}
						}
						setState(50);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(53);
				match(RPAR);
				setState(54);
				match(COLON);
				setState(55);
				return_type();
				setState(56);
				match(LBRACE);
				setState(57);
				expr(0);
				setState(58);
				match(RBRACE);
				setState(59);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new Class_attributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				var_id();
				setState(62);
				match(COLON);
				setState(63);
				var_type();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIGN) {
					{
					setState(64);
					match(ASIGN);
					setState(65);
					expr(0);
					}
				}

				setState(68);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Neg_exprContext extends ExprContext {
		public TerminalNode NEGATION() { return getToken(testParser.NEGATION, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Neg_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Int_exprContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(testParser.INTEGER, 0); }
		public Int_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Par_exprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(testParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(testParser.RPAR, 0); }
		public Par_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class True_exprContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(testParser.TRUE, 0); }
		public True_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Add_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(testParser.ADD, 0); }
		public Add_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Assign_exprContext extends ExprContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public TerminalNode ASIGN() { return getToken(testParser.ASIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class New_exprContext extends ExprContext {
		public TerminalNode NEW() { return getToken(testParser.NEW, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public New_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(testParser.DOT, 0); }
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(testParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(testParser.RPAR, 0); }
		public TerminalNode AT() { return getToken(testParser.AT, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public Expr_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Let_exprContext extends ExprContext {
		public TerminalNode LET() { return getToken(testParser.LET, 0); }
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(testParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(testParser.COLON, i);
		}
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public TerminalNode IN() { return getToken(testParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ASIGN() { return getTokens(testParser.ASIGN); }
		public TerminalNode ASIGN(int i) {
			return getToken(testParser.ASIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public Let_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Div_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVIDE() { return getToken(testParser.DIVIDE, 0); }
		public Div_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LessEq_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS_EQ_OP() { return getToken(testParser.LESS_EQ_OP, 0); }
		public LessEq_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Void_exprContext extends ExprContext {
		public TerminalNode ISVOID() { return getToken(testParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Void_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Method_callContext extends ExprContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(testParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(testParser.RPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public Method_callContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Conditional_exprContext extends ExprContext {
		public TerminalNode IF() { return getToken(testParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(testParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(testParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(testParser.FI, 0); }
		public Conditional_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Loop_exprContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(testParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(testParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(testParser.POOL, 0); }
		public Loop_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Not_exprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(testParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Not_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class String_exprContext extends ExprContext {
		public TerminalNode STRING_LIT() { return getToken(testParser.STRING_LIT, 0); }
		public String_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Br_exprContext extends ExprContext {
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(testParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(testParser.SEMICOLON, i);
		}
		public Br_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class False_exprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(testParser.FALSE, 0); }
		public False_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Sub_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(testParser.SUB, 0); }
		public Sub_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Less_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS_OP() { return getToken(testParser.LESS_OP, 0); }
		public Less_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Var_exprContext extends ExprContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Var_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Eq_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL_OP() { return getToken(testParser.EQUAL_OP, 0); }
		public Eq_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Mul_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(testParser.MULTIPLY, 0); }
		public Mul_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new Assign_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(73);
				var_id();
				setState(74);
				match(ASIGN);
				setState(75);
				expr(24);
				}
				break;
			case 2:
				{
				_localctx = new Method_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				var_id();
				setState(78);
				match(LPAR);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LET) | (1L << TRUE) | (1L << FALSE) | (1L << SELF) | (1L << LBRACE) | (1L << LPAR) | (1L << NEGATION) | (1L << VAR_NAME) | (1L << INTEGER) | (1L << STRING_LIT))) != 0)) {
					{
					setState(79);
					expr(0);
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(80);
						match(COMMA);
						setState(81);
						expr(0);
						}
						}
						setState(86);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(89);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new Conditional_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(IF);
				setState(92);
				expr(0);
				setState(93);
				match(THEN);
				setState(94);
				expr(0);
				setState(95);
				match(ELSE);
				setState(96);
				expr(0);
				setState(97);
				match(FI);
				}
				break;
			case 4:
				{
				_localctx = new Loop_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(WHILE);
				setState(100);
				expr(0);
				setState(101);
				match(LOOP);
				setState(102);
				expr(0);
				setState(103);
				match(POOL);
				}
				break;
			case 5:
				{
				_localctx = new Br_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(LBRACE);
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(106);
					expr(0);
					setState(107);
					match(SEMICOLON);
					}
					}
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LET) | (1L << TRUE) | (1L << FALSE) | (1L << SELF) | (1L << LBRACE) | (1L << LPAR) | (1L << NEGATION) | (1L << VAR_NAME) | (1L << INTEGER) | (1L << STRING_LIT))) != 0) );
				setState(113);
				match(RBRACE);
				}
				break;
			case 6:
				{
				_localctx = new Let_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(LET);
				setState(116);
				var_id();
				setState(117);
				match(COLON);
				setState(118);
				var_type();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIGN) {
					{
					setState(119);
					match(ASIGN);
					setState(120);
					expr(0);
					}
				}

				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(123);
					match(COMMA);
					setState(124);
					var_id();
					setState(125);
					match(COLON);
					setState(126);
					var_type();
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASIGN) {
						{
						setState(127);
						match(ASIGN);
						setState(128);
						expr(0);
						}
					}

					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(IN);
				setState(137);
				expr(18);
				}
				break;
			case 7:
				{
				_localctx = new New_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(NEW);
				setState(140);
				var_type();
				}
				break;
			case 8:
				{
				_localctx = new Void_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(ISVOID);
				setState(142);
				expr(16);
				}
				break;
			case 9:
				{
				_localctx = new Neg_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(NEGATION);
				setState(144);
				expr(11);
				}
				break;
			case 10:
				{
				_localctx = new Not_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(NOT);
				setState(146);
				expr(7);
				}
				break;
			case 11:
				{
				_localctx = new Par_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(LPAR);
				setState(148);
				expr(0);
				setState(149);
				match(RPAR);
				}
				break;
			case 12:
				{
				_localctx = new Var_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				var_id();
				}
				break;
			case 13:
				{
				_localctx = new Int_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(INTEGER);
				}
				break;
			case 14:
				{
				_localctx = new String_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(STRING_LIT);
				}
				break;
			case 15:
				{
				_localctx = new True_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(TRUE);
				}
				break;
			case 16:
				{
				_localctx = new False_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Add_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(159);
						match(ADD);
						setState(160);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new Sub_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(162);
						match(SUB);
						setState(163);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new Mul_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(165);
						match(MULTIPLY);
						setState(166);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new Div_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(168);
						match(DIVIDE);
						setState(169);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new Less_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(171);
						match(LESS_OP);
						setState(172);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new LessEq_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(174);
						match(LESS_EQ_OP);
						setState(175);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new Eq_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(177);
						match(EQUAL_OP);
						setState(178);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new Expr_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(180);
							match(AT);
							setState(181);
							var_type();
							}
						}

						setState(184);
						match(DOT);
						setState(185);
						var_id();
						setState(186);
						match(LPAR);
						setState(195);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LET) | (1L << TRUE) | (1L << FALSE) | (1L << SELF) | (1L << LBRACE) | (1L << LPAR) | (1L << NEGATION) | (1L << VAR_NAME) | (1L << INTEGER) | (1L << STRING_LIT))) != 0)) {
							{
							setState(187);
							expr(0);
							setState(192);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(188);
								match(COMMA);
								setState(189);
								expr(0);
								}
								}
								setState(194);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(197);
						match(RPAR);
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(testParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(testParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public TerminalNode TYPE_ID() { return getToken(testParser.TYPE_ID, 0); }
		public TerminalNode VOID() { return getToken(testParser.VOID, 0); }
		public TerminalNode SELF_TYPE() { return getToken(testParser.SELF_TYPE, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << SELF_TYPE) | (1L << TYPE_ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_idContext extends ParserRuleContext {
		public TerminalNode VAR_NAME() { return getToken(testParser.VAR_NAME, 0); }
		public TerminalNode SELF() { return getToken(testParser.SELF, 0); }
		public Var_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_id; }
	}

	public final Var_idContext var_id() throws RecognitionException {
		Var_idContext _localctx = new Var_idContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==SELF || _la==VAR_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			var_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u00d5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\6\2\24\n\2"+
		"\r\2\16\2\25\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4"+
		"\64\13\4\5\4\66\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4E\n\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5U\n\5\f\5\16\5X\13\5\5\5Z\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5p\n\5\r\5\16\5q\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5|\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0084\n"+
		"\5\7\5\u0086\n\5\f\5\16\5\u0089\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009f\n\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u00b9\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00c1\n\5\f"+
		"\5\16\5\u00c4\13\5\5\5\u00c6\n\5\3\5\3\5\7\5\u00ca\n\5\f\5\16\5\u00cd"+
		"\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\2\3\b\t\2\4\6\b\n\f\16\2\4\5\2\23\26"+
		"\30\30//\4\2\27\27\60\60\2\u00f4\2\23\3\2\2\2\4\27\3\2\2\2\6H\3\2\2\2"+
		"\b\u009e\3\2\2\2\n\u00ce\3\2\2\2\f\u00d0\3\2\2\2\16\u00d2\3\2\2\2\20\21"+
		"\5\4\3\2\21\22\7\31\2\2\22\24\3\2\2\2\23\20\3\2\2\2\24\25\3\2\2\2\25\23"+
		"\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\30\7\3\2\2\30\33\5\n\6\2\31\32"+
		"\7\b\2\2\32\34\5\n\6\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35!\7"+
		"\33\2\2\36 \5\6\4\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$"+
		"\3\2\2\2#!\3\2\2\2$%\7\34\2\2%\5\3\2\2\2&\'\5\f\7\2\'\65\7\37\2\2()\5"+
		"\f\7\2)*\7\32\2\2*\62\5\n\6\2+,\7!\2\2,-\5\f\7\2-.\7\32\2\2./\5\n\6\2"+
		"/\61\3\2\2\2\60+\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\66\3\2\2\2\64\62\3\2\2\2\65(\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678"+
		"\7 \2\289\7\32\2\29:\5\16\b\2:;\7\33\2\2;<\5\b\5\2<=\7\34\2\2=>\7\31\2"+
		"\2>I\3\2\2\2?@\5\f\7\2@A\7\32\2\2AD\5\n\6\2BC\7.\2\2CE\5\b\5\2DB\3\2\2"+
		"\2DE\3\2\2\2EF\3\2\2\2FG\7\31\2\2GI\3\2\2\2H&\3\2\2\2H?\3\2\2\2I\7\3\2"+
		"\2\2JK\b\5\1\2KL\5\f\7\2LM\7.\2\2MN\5\b\5\32N\u009f\3\2\2\2OP\5\f\7\2"+
		"PY\7\37\2\2QV\5\b\5\2RS\7!\2\2SU\5\b\5\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2YQ\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7 \2\2"+
		"\\\u009f\3\2\2\2]^\7\6\2\2^_\5\b\5\2_`\7\f\2\2`a\5\b\5\2ab\7\4\2\2bc\5"+
		"\b\5\2cd\7\5\2\2d\u009f\3\2\2\2ef\7\r\2\2fg\5\b\5\2gh\7\n\2\2hi\5\b\5"+
		"\2ij\7\13\2\2j\u009f\3\2\2\2ko\7\33\2\2lm\5\b\5\2mn\7\31\2\2np\3\2\2\2"+
		"ol\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\34\2\2t\u009f\3"+
		"\2\2\2uv\7\20\2\2vw\5\f\7\2wx\7\32\2\2x{\5\n\6\2yz\7.\2\2z|\5\b\5\2{y"+
		"\3\2\2\2{|\3\2\2\2|\u0087\3\2\2\2}~\7!\2\2~\177\5\f\7\2\177\u0080\7\32"+
		"\2\2\u0080\u0083\5\n\6\2\u0081\u0082\7.\2\2\u0082\u0084\5\b\5\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085}\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\7\2\2\u008b\u008c\5\b\5\24"+
		"\u008c\u009f\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u009f\5\n\6\2\u008f\u0090"+
		"\7\t\2\2\u0090\u009f\5\b\5\22\u0091\u0092\7(\2\2\u0092\u009f\5\b\5\r\u0093"+
		"\u0094\7\17\2\2\u0094\u009f\5\b\5\t\u0095\u0096\7\37\2\2\u0096\u0097\5"+
		"\b\5\2\u0097\u0098\7 \2\2\u0098\u009f\3\2\2\2\u0099\u009f\5\f\7\2\u009a"+
		"\u009f\7\61\2\2\u009b\u009f\7\63\2\2\u009c\u009f\7\21\2\2\u009d\u009f"+
		"\7\22\2\2\u009eJ\3\2\2\2\u009eO\3\2\2\2\u009e]\3\2\2\2\u009ee\3\2\2\2"+
		"\u009ek\3\2\2\2\u009eu\3\2\2\2\u009e\u008d\3\2\2\2\u009e\u008f\3\2\2\2"+
		"\u009e\u0091\3\2\2\2\u009e\u0093\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0099"+
		"\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00cb\3\2\2\2\u00a0\u00a1\f\21\2\2\u00a1\u00a2\7"+
		"$\2\2\u00a2\u00ca\5\b\5\22\u00a3\u00a4\f\20\2\2\u00a4\u00a5\7%\2\2\u00a5"+
		"\u00ca\5\b\5\21\u00a6\u00a7\f\17\2\2\u00a7\u00a8\7&\2\2\u00a8\u00ca\5"+
		"\b\5\20\u00a9\u00aa\f\16\2\2\u00aa\u00ab\7\'\2\2\u00ab\u00ca\5\b\5\17"+
		"\u00ac\u00ad\f\f\2\2\u00ad\u00ae\7)\2\2\u00ae\u00ca\5\b\5\r\u00af\u00b0"+
		"\f\13\2\2\u00b0\u00b1\7*\2\2\u00b1\u00ca\5\b\5\f\u00b2\u00b3\f\n\2\2\u00b3"+
		"\u00b4\7+\2\2\u00b4\u00ca\5\b\5\13\u00b5\u00b8\f\31\2\2\u00b6\u00b7\7"+
		"-\2\2\u00b7\u00b9\5\n\6\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\7,\2\2\u00bb\u00bc\5\f\7\2\u00bc\u00c5\7\37"+
		"\2\2\u00bd\u00c2\5\b\5\2\u00be\u00bf\7!\2\2\u00bf\u00c1\5\b\5\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\7 \2\2\u00c8\u00ca\3\2"+
		"\2\2\u00c9\u00a0\3\2\2\2\u00c9\u00a3\3\2\2\2\u00c9\u00a6\3\2\2\2\u00c9"+
		"\u00a9\3\2\2\2\u00c9\u00ac\3\2\2\2\u00c9\u00af\3\2\2\2\u00c9\u00b2\3\2"+
		"\2\2\u00c9\u00b5\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\t\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\t\2\2\2"+
		"\u00cf\13\3\2\2\2\u00d0\u00d1\t\3\2\2\u00d1\r\3\2\2\2\u00d2\u00d3\5\n"+
		"\6\2\u00d3\17\3\2\2\2\25\25\33!\62\65DHVYq{\u0083\u0087\u009e\u00b8\u00c2"+
		"\u00c5\u00c9\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}