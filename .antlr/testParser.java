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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ID=19, INT_CONST=20, STR_CONST=21, WS=22, BOOL=23, INT=24, STRING=25, 
		IO=26, OBJECT=27, SELF_TYPE=28, CLASS_RESERVED=29, INHERITS_RESERVED=30, 
		IF_RESERVED=31, THEN_RESERVED=32, ELSE_RESERVED=33, FI_RESERVED=34, LET_RESERVED=35, 
		IN_RESERVED=36, WHILE_RESERVED=37, NEW_RESERVED=38, CASE=39, OF=40, ESAC=41, 
		NEW=42, ISVOID=43, NOT=44, COMMA=45, DOT=46, COLON=47, SEMI=48, ASSIGN=49, 
		ARROW=50, LPAREN=51, RPAREN=52, LBRACE=53, RBRACE=54, LINE_COMMENT=55, 
		COMMENT=56, ErrorChar=57;
	public static final int
		RULE_type = 0, RULE_binary_op = 1, RULE_unary_op = 2, RULE_program = 3, 
		RULE_clas_list = 4, RULE_listOfFeature = 5, RULE_formal = 6, RULE_feature = 7, 
		RULE_attributesDef = 8, RULE_methodSimple = 9, RULE_method_definition = 10, 
		RULE_let_declaration = 11, RULE_let_binding = 12, RULE_ifRule = 13, RULE_whileRule = 14, 
		RULE_block = 15, RULE_parameters = 16, RULE_expr = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"type", "binary_op", "unary_op", "program", "clas_list", "listOfFeature", 
			"formal", "feature", "attributesDef", "methodSimple", "method_definition", 
			"let_declaration", "let_binding", "ifRule", "whileRule", "block", "parameters", 
			"expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'='", "'@'", "'/'", "'<'", "'<='", "'~'", 
			"'loop'", "'pool'", "'self'", "'true'", "'false'", "'void'", "'>'", "'%'", 
			"'^'", null, null, null, null, "'Bool'", "'Int'", "'String'", "'IO'", 
			"'Object'", "'SELF_TYPE'", null, null, null, null, null, null, null, 
			null, null, null, "'case'", "'of'", "'esac'", "'new'", "'isvoid'", "'not'", 
			"','", "'.'", "':'", "';'", "'<-'", "'=>'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "ID", "INT_CONST", "STR_CONST", 
			"WS", "BOOL", "INT", "STRING", "IO", "OBJECT", "SELF_TYPE", "CLASS_RESERVED", 
			"INHERITS_RESERVED", "IF_RESERVED", "THEN_RESERVED", "ELSE_RESERVED", 
			"FI_RESERVED", "LET_RESERVED", "IN_RESERVED", "WHILE_RESERVED", "NEW_RESERVED", 
			"CASE", "OF", "ESAC", "NEW", "ISVOID", "NOT", "COMMA", "DOT", "COLON", 
			"SEMI", "ASSIGN", "ARROW", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LINE_COMMENT", 
			"COMMENT", "ErrorChar"
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode INT() { return getToken(testParser.INT, 0); }
		public TerminalNode STRING() { return getToken(testParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(testParser.BOOL, 0); }
		public TerminalNode OBJECT() { return getToken(testParser.OBJECT, 0); }
		public TerminalNode SELF_TYPE() { return getToken(testParser.SELF_TYPE, 0); }
		public TerminalNode IO() { return getToken(testParser.IO, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << IO) | (1L << OBJECT) | (1L << SELF_TYPE))) != 0)) ) {
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

	public static class Binary_opContext extends ParserRuleContext {
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_binary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
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

	public static class Unary_opContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(testParser.NOT, 0); }
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==NOT) ) {
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

	public static class ProgramContext extends ParserRuleContext {
		public List<Clas_listContext> clas_list() {
			return getRuleContexts(Clas_listContext.class);
		}
		public Clas_listContext clas_list(int i) {
			return getRuleContext(Clas_listContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				clas_list();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS_RESERVED );
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

	public static class Clas_listContext extends ParserRuleContext {
		public TerminalNode CLASS_RESERVED() { return getToken(testParser.CLASS_RESERVED, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public TerminalNode SEMI() { return getToken(testParser.SEMI, 0); }
		public ListOfFeatureContext listOfFeature() {
			return getRuleContext(ListOfFeatureContext.class,0);
		}
		public TerminalNode INHERITS_RESERVED() { return getToken(testParser.INHERITS_RESERVED, 0); }
		public Clas_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clas_list; }
	}

	public final Clas_listContext clas_list() throws RecognitionException {
		Clas_listContext _localctx = new Clas_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_clas_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(CLASS_RESERVED);
			setState(48);
			type();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS_RESERVED) {
				{
				setState(49);
				match(INHERITS_RESERVED);
				setState(50);
				type();
				}
			}

			setState(53);
			match(LBRACE);
			{
			setState(54);
			listOfFeature();
			}
			setState(55);
			match(RBRACE);
			setState(56);
			match(SEMI);
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

	public static class ListOfFeatureContext extends ParserRuleContext {
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public ListOfFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOfFeature; }
	}

	public final ListOfFeatureContext listOfFeature() throws RecognitionException {
		ListOfFeatureContext _localctx = new ListOfFeatureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listOfFeature);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(58);
					feature();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(64);
					formal();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FormalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode COLON() { return getToken(testParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(ID);
			setState(73);
			match(COLON);
			setState(74);
			type();
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
		public AttributesDefContext attributesDef() {
			return getRuleContext(AttributesDefContext.class,0);
		}
		public Method_definitionContext method_definition() {
			return getRuleContext(Method_definitionContext.class,0);
		}
		public MethodSimpleContext methodSimple() {
			return getRuleContext(MethodSimpleContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_feature);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				attributesDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				method_definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				methodSimple();
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

	public static class AttributesDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode COLON() { return getToken(testParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(testParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(testParser.SEMI, i);
		}
		public TerminalNode ASSIGN() { return getToken(testParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(testParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(testParser.RPAREN, 0); }
		public AttributesDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributesDef; }
	}

	public final AttributesDefContext attributesDef() throws RecognitionException {
		AttributesDefContext _localctx = new AttributesDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attributesDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ID);
			setState(82);
			match(COLON);
			setState(83);
			type();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(84);
				match(ASSIGN);
				setState(85);
				expr(0);
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(88);
				match(LPAREN);
				setState(89);
				expr(0);
				setState(90);
				match(SEMI);
				setState(91);
				match(RPAREN);
				}
			}

			setState(95);
			match(SEMI);
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

	public static class MethodSimpleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(testParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(testParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(testParser.SEMI, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public MethodSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSimple; }
	}

	public final MethodSimpleContext methodSimple() throws RecognitionException {
		MethodSimpleContext _localctx = new MethodSimpleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ID);
			setState(98);
			match(LPAREN);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(99);
				parameters();
				}
			}

			setState(102);
			match(RPAREN);
			setState(103);
			match(SEMI);
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

	public static class Method_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(testParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(testParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(testParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public List<TerminalNode> SEMI() { return getTokens(testParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(testParser.SEMI, i);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Method_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_definition; }
	}

	public final Method_definitionContext method_definition() throws RecognitionException {
		Method_definitionContext _localctx = new Method_definitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_method_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ID);
			setState(106);
			match(LPAREN);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(107);
				parameters();
				}
			}

			setState(110);
			match(RPAREN);
			setState(111);
			match(COLON);
			setState(112);
			type();
			setState(113);
			match(LBRACE);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << IF_RESERVED) | (1L << LET_RESERVED) | (1L << WHILE_RESERVED) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << SEMI) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
				{
				{
				setState(114);
				block();
				setState(115);
				match(SEMI);
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(RBRACE);
			setState(123);
			match(SEMI);
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

	public static class Let_declarationContext extends ParserRuleContext {
		public TerminalNode LET_RESERVED() { return getToken(testParser.LET_RESERVED, 0); }
		public List<Let_bindingContext> let_binding() {
			return getRuleContexts(Let_bindingContext.class);
		}
		public Let_bindingContext let_binding(int i) {
			return getRuleContext(Let_bindingContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public TerminalNode IN_RESERVED() { return getToken(testParser.IN_RESERVED, 0); }
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(testParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(testParser.SEMI, i);
		}
		public Let_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_declaration; }
	}

	public final Let_declarationContext let_declaration() throws RecognitionException {
		Let_declarationContext _localctx = new Let_declarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_let_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(LET_RESERVED);
			setState(126);
			let_binding();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(127);
				match(COMMA);
				setState(128);
				let_binding();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN_RESERVED) {
				{
				setState(134);
				match(IN_RESERVED);
				setState(135);
				match(LBRACE);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
					{
					{
					setState(136);
					expr(0);
					setState(137);
					match(SEMI);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(RBRACE);
				}
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

	public static class Let_bindingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode COLON() { return getToken(testParser.COLON, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(testParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Let_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_binding; }
	}

	public final Let_bindingContext let_binding() throws RecognitionException {
		Let_bindingContext _localctx = new Let_bindingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_let_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(ID);
			setState(148);
			match(COLON);
			setState(149);
			type();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(150);
				match(ASSIGN);
				setState(151);
				expr(0);
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << IO) | (1L << OBJECT) | (1L << SELF_TYPE))) != 0)) {
				{
				setState(154);
				type();
				}
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

	public static class IfRuleContext extends ParserRuleContext {
		public TerminalNode IF_RESERVED() { return getToken(testParser.IF_RESERVED, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FI_RESERVED() { return getToken(testParser.FI_RESERVED, 0); }
		public List<TerminalNode> THEN_RESERVED() { return getTokens(testParser.THEN_RESERVED); }
		public TerminalNode THEN_RESERVED(int i) {
			return getToken(testParser.THEN_RESERVED, i);
		}
		public TerminalNode ELSE_RESERVED() { return getToken(testParser.ELSE_RESERVED, 0); }
		public List<WhileRuleContext> whileRule() {
			return getRuleContexts(WhileRuleContext.class);
		}
		public WhileRuleContext whileRule(int i) {
			return getRuleContext(WhileRuleContext.class,i);
		}
		public List<IfRuleContext> ifRule() {
			return getRuleContexts(IfRuleContext.class);
		}
		public IfRuleContext ifRule(int i) {
			return getRuleContext(IfRuleContext.class,i);
		}
		public IfRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifRule; }
	}

	public final IfRuleContext ifRule() throws RecognitionException {
		IfRuleContext _localctx = new IfRuleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(IF_RESERVED);
			setState(158);
			expr(0);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==THEN_RESERVED) {
				{
				{
				setState(159);
				match(THEN_RESERVED);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << IF_RESERVED) | (1L << WHILE_RESERVED) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
					{
					setState(163);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
					case T__12:
					case T__13:
					case T__14:
					case ID:
					case INT_CONST:
					case STR_CONST:
					case NEW:
					case ISVOID:
					case NOT:
					case LPAREN:
					case LBRACE:
						{
						setState(160);
						expr(0);
						}
						break;
					case WHILE_RESERVED:
						{
						setState(161);
						whileRule();
						}
						break;
					case IF_RESERVED:
						{
						setState(162);
						ifRule();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_RESERVED) {
				{
				setState(173);
				match(ELSE_RESERVED);
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case ID:
				case INT_CONST:
				case STR_CONST:
				case NEW:
				case ISVOID:
				case NOT:
				case LPAREN:
				case LBRACE:
					{
					setState(174);
					expr(0);
					}
					break;
				case WHILE_RESERVED:
					{
					setState(175);
					whileRule();
					}
					break;
				case IF_RESERVED:
					{
					setState(176);
					ifRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(181);
			match(FI_RESERVED);
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

	public static class WhileRuleContext extends ParserRuleContext {
		public TerminalNode WHILE_RESERVED() { return getToken(testParser.WHILE_RESERVED, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<WhileRuleContext> whileRule() {
			return getRuleContexts(WhileRuleContext.class);
		}
		public WhileRuleContext whileRule(int i) {
			return getRuleContext(WhileRuleContext.class,i);
		}
		public List<IfRuleContext> ifRule() {
			return getRuleContexts(IfRuleContext.class);
		}
		public IfRuleContext ifRule(int i) {
			return getRuleContext(IfRuleContext.class,i);
		}
		public WhileRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileRule; }
	}

	public final WhileRuleContext whileRule() throws RecognitionException {
		WhileRuleContext _localctx = new WhileRuleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(WHILE_RESERVED);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << IF_RESERVED) | (1L << WHILE_RESERVED) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case ID:
				case INT_CONST:
				case STR_CONST:
				case NEW:
				case ISVOID:
				case NOT:
				case LPAREN:
				case LBRACE:
					{
					setState(184);
					expr(0);
					}
					break;
				case WHILE_RESERVED:
					{
					setState(185);
					whileRule();
					}
					break;
				case IF_RESERVED:
					{
					setState(186);
					ifRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(T__9);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << IF_RESERVED) | (1L << WHILE_RESERVED) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
				{
				setState(196);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case ID:
				case INT_CONST:
				case STR_CONST:
				case NEW:
				case ISVOID:
				case NOT:
				case LPAREN:
				case LBRACE:
					{
					setState(193);
					expr(0);
					}
					break;
				case WHILE_RESERVED:
					{
					setState(194);
					whileRule();
					}
					break;
				case IF_RESERVED:
					{
					setState(195);
					ifRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(T__10);
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

	public static class BlockContext extends ParserRuleContext {
		public List<IfRuleContext> ifRule() {
			return getRuleContexts(IfRuleContext.class);
		}
		public IfRuleContext ifRule(int i) {
			return getRuleContext(IfRuleContext.class,i);
		}
		public List<WhileRuleContext> whileRule() {
			return getRuleContexts(WhileRuleContext.class);
		}
		public WhileRuleContext whileRule(int i) {
			return getRuleContext(WhileRuleContext.class,i);
		}
		public List<Let_declarationContext> let_declaration() {
			return getRuleContexts(Let_declarationContext.class);
		}
		public Let_declarationContext let_declaration(int i) {
			return getRuleContext(Let_declarationContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IF_RESERVED) {
					{
					{
					setState(203);
					ifRule();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHILE_RESERVED) {
					{
					{
					setState(209);
					whileRule();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LET_RESERVED) {
					{
					{
					setState(215);
					let_declaration();
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
					{
					{
					setState(221);
					expr(0);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParametersContext extends ParserRuleContext {
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(testParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(testParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			formal();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				formal();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(testParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(testParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(testParser.RPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(testParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(testParser.RBRACE, 0); }
		public TerminalNode STR_CONST() { return getToken(testParser.STR_CONST, 0); }
		public TerminalNode INT_CONST() { return getToken(testParser.INT_CONST, 0); }
		public TerminalNode NEW() { return getToken(testParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ISVOID() { return getToken(testParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(testParser.NOT, 0); }
		public TerminalNode DOT() { return getToken(testParser.DOT, 0); }
		public List<TerminalNode> SEMI() { return getTokens(testParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(testParser.SEMI, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(238);
				match(ID);
				setState(239);
				match(ASSIGN);
				setState(240);
				expr(38);
				}
				break;
			case 2:
				{
				setState(241);
				match(ID);
				setState(242);
				match(LPAREN);
				setState(243);
				expr(0);
				setState(244);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(246);
				match(ID);
				setState(247);
				match(LPAREN);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(248);
					parameters();
					}
				}

				setState(251);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(252);
				match(LBRACE);
				setState(253);
				expr(0);
				setState(254);
				match(RBRACE);
				}
				break;
			case 5:
				{
				setState(256);
				match(STR_CONST);
				}
				break;
			case 6:
				{
				setState(257);
				match(ID);
				setState(258);
				match(LPAREN);
				setState(259);
				match(STR_CONST);
				setState(260);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(261);
				match(LPAREN);
				setState(262);
				match(STR_CONST);
				setState(263);
				match(RPAREN);
				}
				break;
			case 8:
				{
				setState(264);
				match(INT_CONST);
				}
				break;
			case 9:
				{
				setState(265);
				match(NEW);
				setState(266);
				match(ID);
				}
				break;
			case 10:
				{
				setState(267);
				match(NEW);
				setState(268);
				type();
				}
				break;
			case 11:
				{
				setState(269);
				match(ISVOID);
				setState(270);
				expr(28);
				}
				break;
			case 12:
				{
				setState(271);
				match(INT_CONST);
				}
				break;
			case 13:
				{
				setState(272);
				match(STR_CONST);
				}
				break;
			case 14:
				{
				setState(273);
				match(NOT);
				setState(274);
				expr(25);
				}
				break;
			case 15:
				{
				setState(275);
				match(LPAREN);
				setState(277); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(276);
						expr(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(279); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(281);
				match(RPAREN);
				}
				break;
			case 16:
				{
				setState(283);
				match(ISVOID);
				setState(284);
				expr(23);
				}
				break;
			case 17:
				{
				setState(285);
				match(T__11);
				}
				break;
			case 18:
				{
				setState(286);
				match(T__12);
				}
				break;
			case 19:
				{
				setState(287);
				match(T__13);
				}
				break;
			case 20:
				{
				setState(288);
				match(T__14);
				}
				break;
			case 21:
				{
				setState(289);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(398);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(293);
						match(DOT);
						setState(294);
						match(ID);
						setState(295);
						match(ASSIGN);
						setState(296);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(298);
						match(T__3);
						setState(299);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(300);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(301);
						match(T__17);
						setState(302);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(304);
						match(T__7);
						setState(305);
						expr(3);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(307);
						match(DOT);
						setState(308);
						match(ID);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(310);
						match(DOT);
						setState(311);
						match(ID);
						setState(312);
						match(LPAREN);
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << NEW) | (1L << ISVOID) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE))) != 0)) {
							{
							setState(313);
							expr(0);
							}
						}

						setState(316);
						match(RPAREN);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(317);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(318);
						match(T__4);
						setState(319);
						type();
						setState(320);
						match(DOT);
						setState(321);
						match(ID);
						setState(322);
						match(LPAREN);
						setState(323);
						expr(0);
						setState(328);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==SEMI) {
							{
							{
							setState(324);
							match(SEMI);
							setState(325);
							expr(0);
							}
							}
							setState(330);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(331);
						match(RPAREN);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(333);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(334);
						match(T__8);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(335);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(338); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(336);
								match(T__1);
								setState(337);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(340); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(342);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(345); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(343);
								match(T__0);
								setState(344);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(347); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(349);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(352); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(350);
								match(T__6);
								setState(351);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(354); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(359); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(357);
								match(T__15);
								setState(358);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(361); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(363);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(366); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(364);
								match(T__0);
								setState(365);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(368); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(370);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(373); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(371);
								match(T__1);
								setState(372);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(375); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(377);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(380); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(378);
								match(T__2);
								setState(379);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(382); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 16:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(384);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(387); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(385);
								match(T__5);
								setState(386);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(389); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 17:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(391);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(394); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(392);
								match(T__16);
								setState(393);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(396); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		case 8:
			return precpred(_ctx, 13);
		case 9:
			return precpred(_ctx, 12);
		case 10:
			return precpred(_ctx, 11);
		case 11:
			return precpred(_ctx, 10);
		case 12:
			return precpred(_ctx, 8);
		case 13:
			return precpred(_ctx, 7);
		case 14:
			return precpred(_ctx, 6);
		case 15:
			return precpred(_ctx, 5);
		case 16:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0196\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\6\5.\n\5\r\5\16\5/\3\6\3\6\3\6"+
		"\3\6\5\6\66\n\6\3\6\3\6\3\6\3\6\3\6\3\7\7\7>\n\7\f\7\16\7A\13\7\3\7\7"+
		"\7D\n\7\f\7\16\7G\13\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\tR\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\5\nY\n\n\3\n\3\n\3\n\3\n\3\n\5\n`\n\n\3\n\3\n\3\13"+
		"\3\13\3\13\5\13g\n\13\3\13\3\13\3\13\3\f\3\f\3\f\5\fo\n\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\fx\n\f\f\f\16\f{\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7"+
		"\r\u0084\n\r\f\r\16\r\u0087\13\r\3\r\3\r\3\r\3\r\3\r\7\r\u008e\n\r\f\r"+
		"\16\r\u0091\13\r\3\r\5\r\u0094\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u009b"+
		"\n\16\3\16\5\16\u009e\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00a6\n"+
		"\17\f\17\16\17\u00a9\13\17\7\17\u00ab\n\17\f\17\16\17\u00ae\13\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00b4\n\17\5\17\u00b6\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\7\20\u00be\n\20\f\20\16\20\u00c1\13\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00c7\n\20\f\20\16\20\u00ca\13\20\3\20\3\20\3\21\7\21\u00cf\n\21\f"+
		"\21\16\21\u00d2\13\21\3\21\7\21\u00d5\n\21\f\21\16\21\u00d8\13\21\3\21"+
		"\7\21\u00db\n\21\f\21\16\21\u00de\13\21\3\21\7\21\u00e1\n\21\f\21\16\21"+
		"\u00e4\13\21\5\21\u00e6\n\21\3\22\3\22\3\22\7\22\u00eb\n\22\f\22\16\22"+
		"\u00ee\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u00fc\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\6\23\u0118\n\23\r\23\16\23\u0119\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u0125\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u013d\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u0149\n\23\f\23\16\23\u014c\13\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\6\23\u0155\n\23\r\23\16\23\u0156\3\23\3\23\3\23\6\23\u015c\n\23"+
		"\r\23\16\23\u015d\3\23\3\23\3\23\6\23\u0163\n\23\r\23\16\23\u0164\3\23"+
		"\3\23\3\23\6\23\u016a\n\23\r\23\16\23\u016b\3\23\3\23\3\23\6\23\u0171"+
		"\n\23\r\23\16\23\u0172\3\23\3\23\3\23\6\23\u0178\n\23\r\23\16\23\u0179"+
		"\3\23\3\23\3\23\6\23\u017f\n\23\r\23\16\23\u0180\3\23\3\23\3\23\6\23\u0186"+
		"\n\23\r\23\16\23\u0187\3\23\3\23\3\23\6\23\u018d\n\23\r\23\16\23\u018e"+
		"\7\23\u0191\n\23\f\23\16\23\u0194\13\23\3\23\3\u0119\3$\24\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$\2\5\4\2\25\25\31\36\3\2\3\n\4\2\13\13"+
		"..\2\u01db\2&\3\2\2\2\4(\3\2\2\2\6*\3\2\2\2\b-\3\2\2\2\n\61\3\2\2\2\f"+
		"H\3\2\2\2\16J\3\2\2\2\20Q\3\2\2\2\22S\3\2\2\2\24c\3\2\2\2\26k\3\2\2\2"+
		"\30\177\3\2\2\2\32\u0095\3\2\2\2\34\u009f\3\2\2\2\36\u00b9\3\2\2\2 \u00e5"+
		"\3\2\2\2\"\u00e7\3\2\2\2$\u0124\3\2\2\2&\'\t\2\2\2\'\3\3\2\2\2()\t\3\2"+
		"\2)\5\3\2\2\2*+\t\4\2\2+\7\3\2\2\2,.\5\n\6\2-,\3\2\2\2./\3\2\2\2/-\3\2"+
		"\2\2/\60\3\2\2\2\60\t\3\2\2\2\61\62\7\37\2\2\62\65\5\2\2\2\63\64\7 \2"+
		"\2\64\66\5\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\67\2"+
		"\289\5\f\7\29:\78\2\2:;\7\62\2\2;\13\3\2\2\2<>\5\20\t\2=<\3\2\2\2>A\3"+
		"\2\2\2?=\3\2\2\2?@\3\2\2\2@I\3\2\2\2A?\3\2\2\2BD\5\16\b\2CB\3\2\2\2DG"+
		"\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3\2\2\2H?\3\2\2\2HE\3\2\2\2I"+
		"\r\3\2\2\2JK\7\25\2\2KL\7\61\2\2LM\5\2\2\2M\17\3\2\2\2NR\5\22\n\2OR\5"+
		"\26\f\2PR\5\24\13\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\21\3\2\2\2ST\7\25\2"+
		"\2TU\7\61\2\2UX\5\2\2\2VW\7\63\2\2WY\5$\23\2XV\3\2\2\2XY\3\2\2\2Y_\3\2"+
		"\2\2Z[\7\65\2\2[\\\5$\23\2\\]\7\62\2\2]^\7\66\2\2^`\3\2\2\2_Z\3\2\2\2"+
		"_`\3\2\2\2`a\3\2\2\2ab\7\62\2\2b\23\3\2\2\2cd\7\25\2\2df\7\65\2\2eg\5"+
		"\"\22\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\66\2\2ij\7\62\2\2j\25\3\2\2"+
		"\2kl\7\25\2\2ln\7\65\2\2mo\5\"\22\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7"+
		"\66\2\2qr\7\61\2\2rs\5\2\2\2sy\7\67\2\2tu\5 \21\2uv\7\62\2\2vx\3\2\2\2"+
		"wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\78\2\2"+
		"}~\7\62\2\2~\27\3\2\2\2\177\u0080\7%\2\2\u0080\u0085\5\32\16\2\u0081\u0082"+
		"\7/\2\2\u0082\u0084\5\32\16\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0093\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0089\7&\2\2\u0089\u008f\7\67\2\2\u008a\u008b\5$\23\2\u008b"+
		"\u008c\7\62\2\2\u008c\u008e\3\2\2\2\u008d\u008a\3\2\2\2\u008e\u0091\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\78\2\2\u0093\u0088\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\31\3\2\2\2\u0095\u0096\7\25\2\2\u0096\u0097\7\61\2\2\u0097"+
		"\u009a\5\2\2\2\u0098\u0099\7\63\2\2\u0099\u009b\5$\23\2\u009a\u0098\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009e\5\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\33\3\2\2\2\u009f\u00a0\7!\2\2"+
		"\u00a0\u00ac\5$\23\2\u00a1\u00a7\7\"\2\2\u00a2\u00a6\5$\23\2\u00a3\u00a6"+
		"\5\36\20\2\u00a4\u00a6\5\34\17\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2"+
		"\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a1\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b5\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b3\7#\2\2\u00b0\u00b4\5$\23\2\u00b1"+
		"\u00b4\5\36\20\2\u00b2\u00b4\5\34\17\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8\35\3\2\2\2"+
		"\u00b9\u00bf\7\'\2\2\u00ba\u00be\5$\23\2\u00bb\u00be\5\36\20\2\u00bc\u00be"+
		"\5\34\17\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c8\7\f\2\2\u00c3\u00c7\5$\23\2\u00c4"+
		"\u00c7\5\36\20\2\u00c5\u00c7\5\34\17\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\r"+
		"\2\2\u00cc\37\3\2\2\2\u00cd\u00cf\5\34\17\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00e6\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d5\5\36\20\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e6\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00db\5\30\r\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e6\3\2"+
		"\2\2\u00de\u00dc\3\2\2\2\u00df\u00e1\5$\23\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00d0\3\2\2\2\u00e5\u00d6\3\2\2\2\u00e5"+
		"\u00dc\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6!\3\2\2\2\u00e7\u00ec\5\16\b\2"+
		"\u00e8\u00e9\7/\2\2\u00e9\u00eb\5\16\b\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed#\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\b\23\1\2\u00f0\u00f1\7\25\2\2\u00f1\u00f2\7"+
		"\63\2\2\u00f2\u0125\5$\23(\u00f3\u00f4\7\25\2\2\u00f4\u00f5\7\65\2\2\u00f5"+
		"\u00f6\5$\23\2\u00f6\u00f7\7\66\2\2\u00f7\u0125\3\2\2\2\u00f8\u00f9\7"+
		"\25\2\2\u00f9\u00fb\7\65\2\2\u00fa\u00fc\5\"\22\2\u00fb\u00fa\3\2\2\2"+
		"\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0125\7\66\2\2\u00fe\u00ff"+
		"\7\67\2\2\u00ff\u0100\5$\23\2\u0100\u0101\78\2\2\u0101\u0125\3\2\2\2\u0102"+
		"\u0125\7\27\2\2\u0103\u0104\7\25\2\2\u0104\u0105\7\65\2\2\u0105\u0106"+
		"\7\27\2\2\u0106\u0125\7\66\2\2\u0107\u0108\7\65\2\2\u0108\u0109\7\27\2"+
		"\2\u0109\u0125\7\66\2\2\u010a\u0125\7\26\2\2\u010b\u010c\7,\2\2\u010c"+
		"\u0125\7\25\2\2\u010d\u010e\7,\2\2\u010e\u0125\5\2\2\2\u010f\u0110\7-"+
		"\2\2\u0110\u0125\5$\23\36\u0111\u0125\7\26\2\2\u0112\u0125\7\27\2\2\u0113"+
		"\u0114\7.\2\2\u0114\u0125\5$\23\33\u0115\u0117\7\65\2\2\u0116\u0118\5"+
		"$\23\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\66\2\2\u011c\u0125\3"+
		"\2\2\2\u011d\u011e\7-\2\2\u011e\u0125\5$\23\31\u011f\u0125\7\16\2\2\u0120"+
		"\u0125\7\17\2\2\u0121\u0125\7\20\2\2\u0122\u0125\7\21\2\2\u0123\u0125"+
		"\7\25\2\2\u0124\u00ef\3\2\2\2\u0124\u00f3\3\2\2\2\u0124\u00f8\3\2\2\2"+
		"\u0124\u00fe\3\2\2\2\u0124\u0102\3\2\2\2\u0124\u0103\3\2\2\2\u0124\u0107"+
		"\3\2\2\2\u0124\u010a\3\2\2\2\u0124\u010b\3\2\2\2\u0124\u010d\3\2\2\2\u0124"+
		"\u010f\3\2\2\2\u0124\u0111\3\2\2\2\u0124\u0112\3\2\2\2\u0124\u0113\3\2"+
		"\2\2\u0124\u0115\3\2\2\2\u0124\u011d\3\2\2\2\u0124\u011f\3\2\2\2\u0124"+
		"\u0120\3\2\2\2\u0124\u0121\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2"+
		"\2\2\u0125\u0192\3\2\2\2\u0126\u0127\f\22\2\2\u0127\u0128\7\60\2\2\u0128"+
		"\u0129\7\25\2\2\u0129\u012a\7\63\2\2\u012a\u0191\5$\23\23\u012b\u012c"+
		"\f\13\2\2\u012c\u012d\7\6\2\2\u012d\u0191\5$\23\f\u012e\u012f\f\5\2\2"+
		"\u012f\u0130\7\24\2\2\u0130\u0191\5$\23\6\u0131\u0132\f\4\2\2\u0132\u0133"+
		"\7\n\2\2\u0133\u0191\5$\23\5\u0134\u0135\f\24\2\2\u0135\u0136\7\60\2\2"+
		"\u0136\u0191\7\25\2\2\u0137\u0138\f\23\2\2\u0138\u0139\7\60\2\2\u0139"+
		"\u013a\7\25\2\2\u013a\u013c\7\65\2\2\u013b\u013d\5$\23\2\u013c\u013b\3"+
		"\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0191\7\66\2\2\u013f"+
		"\u0140\f\21\2\2\u0140\u0141\7\7\2\2\u0141\u0142\5\2\2\2\u0142\u0143\7"+
		"\60\2\2\u0143\u0144\7\25\2\2\u0144\u0145\7\65\2\2\u0145\u014a\5$\23\2"+
		"\u0146\u0147\7\62\2\2\u0147\u0149\5$\23\2\u0148\u0146\3\2\2\2\u0149\u014c"+
		"\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014d\u014e\7\66\2\2\u014e\u0191\3\2\2\2\u014f\u0150\f"+
		"\20\2\2\u0150\u0191\7\13\2\2\u0151\u0154\f\17\2\2\u0152\u0153\7\4\2\2"+
		"\u0153\u0155\5$\23\2\u0154\u0152\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0191\3\2\2\2\u0158\u015b\f\16\2\2"+
		"\u0159\u015a\7\3\2\2\u015a\u015c\5$\23\2\u015b\u0159\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0191\3\2\2\2\u015f"+
		"\u0162\f\r\2\2\u0160\u0161\7\t\2\2\u0161\u0163\5$\23\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0191\3\2\2\2\u0166\u0169\f\f\2\2\u0167\u0168\7\22\2\2\u0168\u016a\5"+
		"$\23\2\u0169\u0167\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u0191\3\2\2\2\u016d\u0170\f\n\2\2\u016e\u016f\7\3"+
		"\2\2\u016f\u0171\5$\23\2\u0170\u016e\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0191\3\2\2\2\u0174\u0177\f\t"+
		"\2\2\u0175\u0176\7\4\2\2\u0176\u0178\5$\23\2\u0177\u0175\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0191\3\2"+
		"\2\2\u017b\u017e\f\b\2\2\u017c\u017d\7\5\2\2\u017d\u017f\5$\23\2\u017e"+
		"\u017c\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u0191\3\2\2\2\u0182\u0185\f\7\2\2\u0183\u0184\7\b\2\2\u0184"+
		"\u0186\5$\23\2\u0185\u0183\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2"+
		"\2\2\u0187\u0188\3\2\2\2\u0188\u0191\3\2\2\2\u0189\u018c\f\6\2\2\u018a"+
		"\u018b\7\23\2\2\u018b\u018d\5$\23\2\u018c\u018a\3\2\2\2\u018d\u018e\3"+
		"\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190"+
		"\u0126\3\2\2\2\u0190\u012b\3\2\2\2\u0190\u012e\3\2\2\2\u0190\u0131\3\2"+
		"\2\2\u0190\u0134\3\2\2\2\u0190\u0137\3\2\2\2\u0190\u013f\3\2\2\2\u0190"+
		"\u014f\3\2\2\2\u0190\u0151\3\2\2\2\u0190\u0158\3\2\2\2\u0190\u015f\3\2"+
		"\2\2\u0190\u0166\3\2\2\2\u0190\u016d\3\2\2\2\u0190\u0174\3\2\2\2\u0190"+
		"\u017b\3\2\2\2\u0190\u0182\3\2\2\2\u0190\u0189\3\2\2\2\u0191\u0194\3\2"+
		"\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193%\3\2\2\2\u0194\u0192"+
		"\3\2\2\2\61/\65?EHQX_fny\u0085\u008f\u0093\u009a\u009d\u00a5\u00a7\u00ac"+
		"\u00b3\u00b5\u00bd\u00bf\u00c6\u00c8\u00d0\u00d6\u00dc\u00e2\u00e5\u00ec"+
		"\u00fb\u0119\u0124\u013c\u014a\u0156\u015d\u0164\u016b\u0172\u0179\u0180"+
		"\u0187\u018e\u0190\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}