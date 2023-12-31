// Generated from c:\Users\laury\Documents\UVG\Compis\LAB0\LAB0-Compiladores\test.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "ISVOID", "LOOP", "POOL", 
			"THEN", "WHILE", "NEW", "NOT", "LET", "TRUE", "FALSE", "BOOL", "INT", 
			"STRING", "VOID", "SELF", "SELF_TYPE", "SEMICOLON", "COLON", "LBRACE", 
			"RBRACE", "LBRACKET", "RBRACKET", "LPAR", "RPAR", "COMMA", "QUOTES", 
			"APOSTROPHE", "ADD", "SUB", "MULTIPLY", "DIVIDE", "NEGATION", "LESS_OP", 
			"LESS_EQ_OP", "EQUAL_OP", "DOT", "AT", "ASIGN", "TYPE_ID", "VAR_NAME", 
			"INTEGER", "DIGIT", "STRING_LIT", "BOOL_LIT", "COMMENT", "COMMENT_2", 
			"COMMENT_3", "NEWLINE", "WS", "ERR_TOKEN"
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


	public testLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u01bb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2~\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0088\n"+
		"\3\3\4\3\4\3\4\3\4\5\4\u008e\n\4\3\5\3\5\3\5\3\5\5\5\u0094\n\5\3\6\3\6"+
		"\3\6\3\6\5\6\u009a\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00ac\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00ba\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c4\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ce\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00d8\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00e4\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ec\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00f4\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fc"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3"+
		".\7.\u015d\n.\f.\16.\u0160\13.\3/\3/\7/\u0164\n/\f/\16/\u0167\13/\3\60"+
		"\6\60\u016a\n\60\r\60\16\60\u016b\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0174"+
		"\n\62\f\62\16\62\u0177\13\62\3\62\3\62\3\63\3\63\5\63\u017d\n\63\3\64"+
		"\3\64\3\64\3\64\7\64\u0183\n\64\f\64\16\64\u0186\13\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\7\65\u0190\n\65\f\65\16\65\u0193\13\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u019e\n\66\f\66\16\66\u01a1"+
		"\13\66\3\66\3\66\3\66\3\66\3\66\3\67\5\67\u01a9\n\67\3\67\3\67\6\67\u01ad"+
		"\n\67\r\67\16\67\u01ae\3\67\3\67\38\68\u01b4\n8\r8\168\u01b5\38\38\39"+
		"\39\5\u0184\u0191\u019f\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m8o9q:\3\2\t\3\2C\\\6\2\62;C\\aac|\4\2C\\c|\3\2"+
		"\62;\n\2$$))^^ddhhppttvv\6\2\f\f\17\17$$^^\5\2\n\f\16\17\"\"\2\u01d5\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\3}\3\2\2\2\5\u0087\3\2\2\2\7\u008d\3\2\2\2\t\u0093"+
		"\3\2\2\2\13\u0099\3\2\2\2\r\u00ab\3\2\2\2\17\u00b9\3\2\2\2\21\u00c3\3"+
		"\2\2\2\23\u00cd\3\2\2\2\25\u00d7\3\2\2\2\27\u00e3\3\2\2\2\31\u00eb\3\2"+
		"\2\2\33\u00f3\3\2\2\2\35\u00fb\3\2\2\2\37\u00fd\3\2\2\2!\u0102\3\2\2\2"+
		"#\u0108\3\2\2\2%\u010d\3\2\2\2\'\u0111\3\2\2\2)\u0118\3\2\2\2+\u011d\3"+
		"\2\2\2-\u0122\3\2\2\2/\u012c\3\2\2\2\61\u012e\3\2\2\2\63\u0130\3\2\2\2"+
		"\65\u0132\3\2\2\2\67\u0134\3\2\2\29\u0136\3\2\2\2;\u0138\3\2\2\2=\u013a"+
		"\3\2\2\2?\u013c\3\2\2\2A\u013e\3\2\2\2C\u0140\3\2\2\2E\u0142\3\2\2\2G"+
		"\u0144\3\2\2\2I\u0146\3\2\2\2K\u0148\3\2\2\2M\u014a\3\2\2\2O\u014c\3\2"+
		"\2\2Q\u014e\3\2\2\2S\u0151\3\2\2\2U\u0153\3\2\2\2W\u0155\3\2\2\2Y\u0157"+
		"\3\2\2\2[\u015a\3\2\2\2]\u0161\3\2\2\2_\u0169\3\2\2\2a\u016d\3\2\2\2c"+
		"\u016f\3\2\2\2e\u017c\3\2\2\2g\u017e\3\2\2\2i\u018b\3\2\2\2k\u0199\3\2"+
		"\2\2m\u01ac\3\2\2\2o\u01b3\3\2\2\2q\u01b9\3\2\2\2st\7e\2\2tu\7n\2\2uv"+
		"\7c\2\2vw\7u\2\2w~\7u\2\2xy\7E\2\2yz\7N\2\2z{\7C\2\2{|\7U\2\2|~\7U\2\2"+
		"}s\3\2\2\2}x\3\2\2\2~\4\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081"+
		"\u0082\7u\2\2\u0082\u0088\7g\2\2\u0083\u0084\7G\2\2\u0084\u0085\7N\2\2"+
		"\u0085\u0086\7U\2\2\u0086\u0088\7G\2\2\u0087\177\3\2\2\2\u0087\u0083\3"+
		"\2\2\2\u0088\6\3\2\2\2\u0089\u008a\7h\2\2\u008a\u008e\7k\2\2\u008b\u008c"+
		"\7H\2\2\u008c\u008e\7K\2\2\u008d\u0089\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\b\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0094\7h\2\2\u0091\u0092\7K\2\2\u0092"+
		"\u0094\7H\2\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094\n\3\2\2\2"+
		"\u0095\u0096\7k\2\2\u0096\u009a\7p\2\2\u0097\u0098\7K\2\2\u0098\u009a"+
		"\7P\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\f\3\2\2\2\u009b"+
		"\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009e\7j\2\2\u009e\u009f\7g\2\2"+
		"\u009f\u00a0\7t\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7v\2\2\u00a2\u00ac"+
		"\7u\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5\7P\2\2\u00a5\u00a6\7J\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7K\2\2\u00a9\u00aa\7V\2\2"+
		"\u00aa\u00ac\7U\2\2\u00ab\u009b\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ac\16\3"+
		"\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7x\2\2\u00b0"+
		"\u00b1\7q\2\2\u00b1\u00b2\7k\2\2\u00b2\u00ba\7f\2\2\u00b3\u00b4\7K\2\2"+
		"\u00b4\u00b5\7U\2\2\u00b5\u00b6\7X\2\2\u00b6\u00b7\7Q\2\2\u00b7\u00b8"+
		"\7K\2\2\u00b8\u00ba\7F\2\2\u00b9\u00ad\3\2\2\2\u00b9\u00b3\3\2\2\2\u00ba"+
		"\20\3\2\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7q\2\2\u00be"+
		"\u00c4\7r\2\2\u00bf\u00c0\7N\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7Q\2\2"+
		"\u00c2\u00c4\7R\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\22\3"+
		"\2\2\2\u00c5\u00c6\7r\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7q\2\2\u00c8"+
		"\u00ce\7n\2\2\u00c9\u00ca\7R\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7Q\2\2"+
		"\u00cc\u00ce\7N\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce\24\3"+
		"\2\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7j\2\2\u00d1\u00d2\7g\2\2\u00d2"+
		"\u00d8\7p\2\2\u00d3\u00d4\7V\2\2\u00d4\u00d5\7J\2\2\u00d5\u00d6\7G\2\2"+
		"\u00d6\u00d8\7P\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\26\3"+
		"\2\2\2\u00d9\u00da\7y\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7k\2\2\u00dc"+
		"\u00dd\7n\2\2\u00dd\u00e4\7g\2\2\u00de\u00df\7Y\2\2\u00df\u00e0\7J\2\2"+
		"\u00e0\u00e1\7K\2\2\u00e1\u00e2\7N\2\2\u00e2\u00e4\7G\2\2\u00e3\u00d9"+
		"\3\2\2\2\u00e3\u00de\3\2\2\2\u00e4\30\3\2\2\2\u00e5\u00e6\7p\2\2\u00e6"+
		"\u00e7\7g\2\2\u00e7\u00ec\7y\2\2\u00e8\u00e9\7P\2\2\u00e9\u00ea\7G\2\2"+
		"\u00ea\u00ec\7Y\2\2\u00eb\u00e5\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\32\3"+
		"\2\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f4\7v\2\2\u00f0"+
		"\u00f1\7P\2\2\u00f1\u00f2\7Q\2\2\u00f2\u00f4\7V\2\2\u00f3\u00ed\3\2\2"+
		"\2\u00f3\u00f0\3\2\2\2\u00f4\34\3\2\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00fc\7v\2\2\u00f8\u00f9\7N\2\2\u00f9\u00fa\7G\2\2\u00fa"+
		"\u00fc\7V\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fc\36\3\2\2\2"+
		"\u00fd\u00fe\7v\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7w\2\2\u0100\u0101"+
		"\7g\2\2\u0101 \3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104\7c\2\2\u0104\u0105"+
		"\7n\2\2\u0105\u0106\7u\2\2\u0106\u0107\7g\2\2\u0107\"\3\2\2\2\u0108\u0109"+
		"\7D\2\2\u0109\u010a\7q\2\2\u010a\u010b\7q\2\2\u010b\u010c\7n\2\2\u010c"+
		"$\3\2\2\2\u010d\u010e\7K\2\2\u010e\u010f\7p\2\2\u010f\u0110\7v\2\2\u0110"+
		"&\3\2\2\2\u0111\u0112\7U\2\2\u0112\u0113\7v\2\2\u0113\u0114\7t\2\2\u0114"+
		"\u0115\7k\2\2\u0115\u0116\7p\2\2\u0116\u0117\7i\2\2\u0117(\3\2\2\2\u0118"+
		"\u0119\7x\2\2\u0119\u011a\7q\2\2\u011a\u011b\7k\2\2\u011b\u011c\7f\2\2"+
		"\u011c*\3\2\2\2\u011d\u011e\7u\2\2\u011e\u011f\7g\2\2\u011f\u0120\7n\2"+
		"\2\u0120\u0121\7h\2\2\u0121,\3\2\2\2\u0122\u0123\7U\2\2\u0123\u0124\7"+
		"G\2\2\u0124\u0125\7N\2\2\u0125\u0126\7H\2\2\u0126\u0127\7a\2\2\u0127\u0128"+
		"\7V\2\2\u0128\u0129\7[\2\2\u0129\u012a\7R\2\2\u012a\u012b\7G\2\2\u012b"+
		".\3\2\2\2\u012c\u012d\7=\2\2\u012d\60\3\2\2\2\u012e\u012f\7<\2\2\u012f"+
		"\62\3\2\2\2\u0130\u0131\7}\2\2\u0131\64\3\2\2\2\u0132\u0133\7\177\2\2"+
		"\u0133\66\3\2\2\2\u0134\u0135\7]\2\2\u01358\3\2\2\2\u0136\u0137\7_\2\2"+
		"\u0137:\3\2\2\2\u0138\u0139\7*\2\2\u0139<\3\2\2\2\u013a\u013b\7+\2\2\u013b"+
		">\3\2\2\2\u013c\u013d\7.\2\2\u013d@\3\2\2\2\u013e\u013f\7$\2\2\u013fB"+
		"\3\2\2\2\u0140\u0141\7)\2\2\u0141D\3\2\2\2\u0142\u0143\7-\2\2\u0143F\3"+
		"\2\2\2\u0144\u0145\7/\2\2\u0145H\3\2\2\2\u0146\u0147\7,\2\2\u0147J\3\2"+
		"\2\2\u0148\u0149\7\61\2\2\u0149L\3\2\2\2\u014a\u014b\7\u0080\2\2\u014b"+
		"N\3\2\2\2\u014c\u014d\7>\2\2\u014dP\3\2\2\2\u014e\u014f\7>\2\2\u014f\u0150"+
		"\7?\2\2\u0150R\3\2\2\2\u0151\u0152\7?\2\2\u0152T\3\2\2\2\u0153\u0154\7"+
		"\60\2\2\u0154V\3\2\2\2\u0155\u0156\7B\2\2\u0156X\3\2\2\2\u0157\u0158\7"+
		">\2\2\u0158\u0159\7/\2\2\u0159Z\3\2\2\2\u015a\u015e\t\2\2\2\u015b\u015d"+
		"\t\3\2\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\\\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0165\t\4\2\2"+
		"\u0162\u0164\t\3\2\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166^\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u016a\t\5\2\2\u0169\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c`\3\2\2\2\u016d\u016e\t\5\2\2\u016eb\3\2"+
		"\2\2\u016f\u0175\7$\2\2\u0170\u0171\7^\2\2\u0171\u0174\t\6\2\2\u0172\u0174"+
		"\n\7\2\2\u0173\u0170\3\2\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0178\u0179\7$\2\2\u0179d\3\2\2\2\u017a\u017d\5\37\20\2\u017b\u017d"+
		"\5!\21\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017df\3\2\2\2\u017e"+
		"\u017f\7/\2\2\u017f\u0180\7/\2\2\u0180\u0184\3\2\2\2\u0181\u0183\13\2"+
		"\2\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0185\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u0188\7\f"+
		"\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\64\2\2\u018ah\3\2\2\2\u018b\u018c"+
		"\7*\2\2\u018c\u018d\7,\2\2\u018d\u0191\3\2\2\2\u018e\u0190\13\2\2\2\u018f"+
		"\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u0192\3\2\2\2\u0191\u018f\3\2"+
		"\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\7,\2\2\u0195"+
		"\u0196\7+\2\2\u0196\u0197\3\2\2\2\u0197\u0198\b\65\2\2\u0198j\3\2\2\2"+
		"\u0199\u019a\7\60\2\2\u019a\u019b\7\60\2\2\u019b\u019f\3\2\2\2\u019c\u019e"+
		"\13\2\2\2\u019d\u019c\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u01a0\3\2\2\2"+
		"\u019f\u019d\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3"+
		"\7\60\2\2\u01a3\u01a4\7\60\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\b\66\2"+
		"\2\u01a6l\3\2\2\2\u01a7\u01a9\7\17\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\7\f\2\2\u01ab\u01ad\7\17\2\2"+
		"\u01ac\u01a8\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ac"+
		"\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\b\67\2\2"+
		"\u01b1n\3\2\2\2\u01b2\u01b4\t\b\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b5\3"+
		"\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b8\b8\2\2\u01b8p\3\2\2\2\u01b9\u01ba\13\2\2\2\u01bar\3\2\2\2\36\2"+
		"}\u0087\u008d\u0093\u0099\u00ab\u00b9\u00c3\u00cd\u00d7\u00e3\u00eb\u00f3"+
		"\u00fb\u015e\u0165\u016b\u0173\u0175\u017c\u0184\u0191\u019f\u01a8\u01ac"+
		"\u01ae\u01b5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}