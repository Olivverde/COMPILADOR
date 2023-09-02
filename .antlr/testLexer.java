// Generated from c:\Users\olive\OneDrive\Escritorio\UVG\SEM10\Compiladores\COMPILADOR\test.g4 by ANTLR 4.9.2
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
		COMMENT_2=52, NEWLINE=53, WS=54, ERR_TOKEN=55;
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
			"NEWLINE", "WS", "ERR_TOKEN"
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
			"NEWLINE", "WS", "ERR_TOKEN"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u01ab\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2|\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0086\n\3\3\4"+
		"\3\4\3\4\3\4\5\4\u008c\n\4\3\5\3\5\3\5\3\5\5\5\u0092\n\5\3\6\3\6\3\6\3"+
		"\6\5\6\u0098\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u00aa\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00b8\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c2\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00cc\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00d6\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e2"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ea\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00f2\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fa\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\7.\u015b"+
		"\n.\f.\16.\u015e\13.\3/\3/\7/\u0162\n/\f/\16/\u0165\13/\3\60\6\60\u0168"+
		"\n\60\r\60\16\60\u0169\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0172\n\62\f"+
		"\62\16\62\u0175\13\62\3\62\3\62\3\63\3\63\5\63\u017b\n\63\3\64\3\64\3"+
		"\64\3\64\7\64\u0181\n\64\f\64\16\64\u0184\13\64\3\64\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\7\65\u018e\n\65\f\65\16\65\u0191\13\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\66\5\66\u0199\n\66\3\66\3\66\6\66\u019d\n\66\r\66\16\66"+
		"\u019e\3\66\3\66\3\67\6\67\u01a4\n\67\r\67\16\67\u01a5\3\67\3\67\38\3"+
		"8\4\u0182\u018f\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9\3\2\t\3\2C\\\6\2\62;C\\aac|\4\2C\\c|\3\2\62;\n\2"+
		"$$))^^ddhhppttvv\6\2\f\f\17\17$$^^\5\2\n\f\16\17\"\"\2\u01c4\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\3{\3\2\2\2\5\u0085\3\2\2\2\7\u008b\3\2\2\2\t\u0091\3\2\2\2\13\u0097"+
		"\3\2\2\2\r\u00a9\3\2\2\2\17\u00b7\3\2\2\2\21\u00c1\3\2\2\2\23\u00cb\3"+
		"\2\2\2\25\u00d5\3\2\2\2\27\u00e1\3\2\2\2\31\u00e9\3\2\2\2\33\u00f1\3\2"+
		"\2\2\35\u00f9\3\2\2\2\37\u00fb\3\2\2\2!\u0100\3\2\2\2#\u0106\3\2\2\2%"+
		"\u010b\3\2\2\2\'\u010f\3\2\2\2)\u0116\3\2\2\2+\u011b\3\2\2\2-\u0120\3"+
		"\2\2\2/\u012a\3\2\2\2\61\u012c\3\2\2\2\63\u012e\3\2\2\2\65\u0130\3\2\2"+
		"\2\67\u0132\3\2\2\29\u0134\3\2\2\2;\u0136\3\2\2\2=\u0138\3\2\2\2?\u013a"+
		"\3\2\2\2A\u013c\3\2\2\2C\u013e\3\2\2\2E\u0140\3\2\2\2G\u0142\3\2\2\2I"+
		"\u0144\3\2\2\2K\u0146\3\2\2\2M\u0148\3\2\2\2O\u014a\3\2\2\2Q\u014c\3\2"+
		"\2\2S\u014f\3\2\2\2U\u0151\3\2\2\2W\u0153\3\2\2\2Y\u0155\3\2\2\2[\u0158"+
		"\3\2\2\2]\u015f\3\2\2\2_\u0167\3\2\2\2a\u016b\3\2\2\2c\u016d\3\2\2\2e"+
		"\u017a\3\2\2\2g\u017c\3\2\2\2i\u0189\3\2\2\2k\u019c\3\2\2\2m\u01a3\3\2"+
		"\2\2o\u01a9\3\2\2\2qr\7e\2\2rs\7n\2\2st\7c\2\2tu\7u\2\2u|\7u\2\2vw\7E"+
		"\2\2wx\7N\2\2xy\7C\2\2yz\7U\2\2z|\7U\2\2{q\3\2\2\2{v\3\2\2\2|\4\3\2\2"+
		"\2}~\7g\2\2~\177\7n\2\2\177\u0080\7u\2\2\u0080\u0086\7g\2\2\u0081\u0082"+
		"\7G\2\2\u0082\u0083\7N\2\2\u0083\u0084\7U\2\2\u0084\u0086\7G\2\2\u0085"+
		"}\3\2\2\2\u0085\u0081\3\2\2\2\u0086\6\3\2\2\2\u0087\u0088\7h\2\2\u0088"+
		"\u008c\7k\2\2\u0089\u008a\7H\2\2\u008a\u008c\7K\2\2\u008b\u0087\3\2\2"+
		"\2\u008b\u0089\3\2\2\2\u008c\b\3\2\2\2\u008d\u008e\7k\2\2\u008e\u0092"+
		"\7h\2\2\u008f\u0090\7K\2\2\u0090\u0092\7H\2\2\u0091\u008d\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\n\3\2\2\2\u0093\u0094\7k\2\2\u0094\u0098\7p\2\2\u0095"+
		"\u0096\7K\2\2\u0096\u0098\7P\2\2\u0097\u0093\3\2\2\2\u0097\u0095\3\2\2"+
		"\2\u0098\f\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b\u009c\7"+
		"j\2\2\u009c\u009d\7g\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f\u00a0"+
		"\7v\2\2\u00a0\u00aa\7u\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3\7P\2\2\u00a3"+
		"\u00a4\7J\2\2\u00a4\u00a5\7G\2\2\u00a5\u00a6\7T\2\2\u00a6\u00a7\7K\2\2"+
		"\u00a7\u00a8\7V\2\2\u00a8\u00aa\7U\2\2\u00a9\u0099\3\2\2\2\u00a9\u00a1"+
		"\3\2\2\2\u00aa\16\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7u\2\2\u00ad"+
		"\u00ae\7x\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7k\2\2\u00b0\u00b8\7f\2\2"+
		"\u00b1\u00b2\7K\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4\7X\2\2\u00b4\u00b5"+
		"\7Q\2\2\u00b5\u00b6\7K\2\2\u00b6\u00b8\7F\2\2\u00b7\u00ab\3\2\2\2\u00b7"+
		"\u00b1\3\2\2\2\u00b8\20\3\2\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7q\2\2"+
		"\u00bb\u00bc\7q\2\2\u00bc\u00c2\7r\2\2\u00bd\u00be\7N\2\2\u00be\u00bf"+
		"\7Q\2\2\u00bf\u00c0\7Q\2\2\u00c0\u00c2\7R\2\2\u00c1\u00b9\3\2\2\2\u00c1"+
		"\u00bd\3\2\2\2\u00c2\22\3\2\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7q\2\2"+
		"\u00c5\u00c6\7q\2\2\u00c6\u00cc\7n\2\2\u00c7\u00c8\7R\2\2\u00c8\u00c9"+
		"\7Q\2\2\u00c9\u00ca\7Q\2\2\u00ca\u00cc\7N\2\2\u00cb\u00c3\3\2\2\2\u00cb"+
		"\u00c7\3\2\2\2\u00cc\24\3\2\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7j\2\2"+
		"\u00cf\u00d0\7g\2\2\u00d0\u00d6\7p\2\2\u00d1\u00d2\7V\2\2\u00d2\u00d3"+
		"\7J\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d6\7P\2\2\u00d5\u00cd\3\2\2\2\u00d5"+
		"\u00d1\3\2\2\2\u00d6\26\3\2\2\2\u00d7\u00d8\7y\2\2\u00d8\u00d9\7j\2\2"+
		"\u00d9\u00da\7k\2\2\u00da\u00db\7n\2\2\u00db\u00e2\7g\2\2\u00dc\u00dd"+
		"\7Y\2\2\u00dd\u00de\7J\2\2\u00de\u00df\7K\2\2\u00df\u00e0\7N\2\2\u00e0"+
		"\u00e2\7G\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\30\3\2\2\2"+
		"\u00e3\u00e4\7p\2\2\u00e4\u00e5\7g\2\2\u00e5\u00ea\7y\2\2\u00e6\u00e7"+
		"\7P\2\2\u00e7\u00e8\7G\2\2\u00e8\u00ea\7Y\2\2\u00e9\u00e3\3\2\2\2\u00e9"+
		"\u00e6\3\2\2\2\u00ea\32\3\2\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7q\2\2"+
		"\u00ed\u00f2\7v\2\2\u00ee\u00ef\7P\2\2\u00ef\u00f0\7Q\2\2\u00f0\u00f2"+
		"\7V\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\34\3\2\2\2\u00f3"+
		"\u00f4\7n\2\2\u00f4\u00f5\7g\2\2\u00f5\u00fa\7v\2\2\u00f6\u00f7\7N\2\2"+
		"\u00f7\u00f8\7G\2\2\u00f8\u00fa\7V\2\2\u00f9\u00f3\3\2\2\2\u00f9\u00f6"+
		"\3\2\2\2\u00fa\36\3\2\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7w\2\2\u00fe\u00ff\7g\2\2\u00ff \3\2\2\2\u0100\u0101\7h\2\2\u0101"+
		"\u0102\7c\2\2\u0102\u0103\7n\2\2\u0103\u0104\7u\2\2\u0104\u0105\7g\2\2"+
		"\u0105\"\3\2\2\2\u0106\u0107\7D\2\2\u0107\u0108\7q\2\2\u0108\u0109\7q"+
		"\2\2\u0109\u010a\7n\2\2\u010a$\3\2\2\2\u010b\u010c\7K\2\2\u010c\u010d"+
		"\7p\2\2\u010d\u010e\7v\2\2\u010e&\3\2\2\2\u010f\u0110\7U\2\2\u0110\u0111"+
		"\7v\2\2\u0111\u0112\7t\2\2\u0112\u0113\7k\2\2\u0113\u0114\7p\2\2\u0114"+
		"\u0115\7i\2\2\u0115(\3\2\2\2\u0116\u0117\7x\2\2\u0117\u0118\7q\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7f\2\2\u011a*\3\2\2\2\u011b\u011c\7u\2\2\u011c"+
		"\u011d\7g\2\2\u011d\u011e\7n\2\2\u011e\u011f\7h\2\2\u011f,\3\2\2\2\u0120"+
		"\u0121\7U\2\2\u0121\u0122\7G\2\2\u0122\u0123\7N\2\2\u0123\u0124\7H\2\2"+
		"\u0124\u0125\7a\2\2\u0125\u0126\7V\2\2\u0126\u0127\7[\2\2\u0127\u0128"+
		"\7R\2\2\u0128\u0129\7G\2\2\u0129.\3\2\2\2\u012a\u012b\7=\2\2\u012b\60"+
		"\3\2\2\2\u012c\u012d\7<\2\2\u012d\62\3\2\2\2\u012e\u012f\7}\2\2\u012f"+
		"\64\3\2\2\2\u0130\u0131\7\177\2\2\u0131\66\3\2\2\2\u0132\u0133\7]\2\2"+
		"\u01338\3\2\2\2\u0134\u0135\7_\2\2\u0135:\3\2\2\2\u0136\u0137\7*\2\2\u0137"+
		"<\3\2\2\2\u0138\u0139\7+\2\2\u0139>\3\2\2\2\u013a\u013b\7.\2\2\u013b@"+
		"\3\2\2\2\u013c\u013d\7$\2\2\u013dB\3\2\2\2\u013e\u013f\7)\2\2\u013fD\3"+
		"\2\2\2\u0140\u0141\7-\2\2\u0141F\3\2\2\2\u0142\u0143\7/\2\2\u0143H\3\2"+
		"\2\2\u0144\u0145\7,\2\2\u0145J\3\2\2\2\u0146\u0147\7\61\2\2\u0147L\3\2"+
		"\2\2\u0148\u0149\7\u0080\2\2\u0149N\3\2\2\2\u014a\u014b\7>\2\2\u014bP"+
		"\3\2\2\2\u014c\u014d\7>\2\2\u014d\u014e\7?\2\2\u014eR\3\2\2\2\u014f\u0150"+
		"\7?\2\2\u0150T\3\2\2\2\u0151\u0152\7\60\2\2\u0152V\3\2\2\2\u0153\u0154"+
		"\7B\2\2\u0154X\3\2\2\2\u0155\u0156\7>\2\2\u0156\u0157\7/\2\2\u0157Z\3"+
		"\2\2\2\u0158\u015c\t\2\2\2\u0159\u015b\t\3\2\2\u015a\u0159\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\\\3\2\2\2"+
		"\u015e\u015c\3\2\2\2\u015f\u0163\t\4\2\2\u0160\u0162\t\3\2\2\u0161\u0160"+
		"\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"^\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0168\t\5\2\2\u0167\u0166\3\2\2\2"+
		"\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a`\3"+
		"\2\2\2\u016b\u016c\t\5\2\2\u016cb\3\2\2\2\u016d\u0173\7$\2\2\u016e\u016f"+
		"\7^\2\2\u016f\u0172\t\6\2\2\u0170\u0172\n\7\2\2\u0171\u016e\3\2\2\2\u0171"+
		"\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7$\2\2\u0177"+
		"d\3\2\2\2\u0178\u017b\5\37\20\2\u0179\u017b\5!\21\2\u017a\u0178\3\2\2"+
		"\2\u017a\u0179\3\2\2\2\u017bf\3\2\2\2\u017c\u017d\7/\2\2\u017d\u017e\7"+
		"/\2\2\u017e\u0182\3\2\2\2\u017f\u0181\13\2\2\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0184\3\2\2\2\u0182\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0185\3\2"+
		"\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7\f\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\b\64\2\2\u0188h\3\2\2\2\u0189\u018a\7\60\2\2\u018a\u018b\7\60\2"+
		"\2\u018b\u018f\3\2\2\2\u018c\u018e\13\2\2\2\u018d\u018c\3\2\2\2\u018e"+
		"\u0191\3\2\2\2\u018f\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0192\3\2"+
		"\2\2\u0191\u018f\3\2\2\2\u0192\u0193\7\60\2\2\u0193\u0194\7\60\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0196\b\65\2\2\u0196j\3\2\2\2\u0197\u0199\7\17\2"+
		"\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019d"+
		"\7\f\2\2\u019b\u019d\7\17\2\2\u019c\u0198\3\2\2\2\u019c\u019b\3\2\2\2"+
		"\u019d\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0"+
		"\3\2\2\2\u01a0\u01a1\b\66\2\2\u01a1l\3\2\2\2\u01a2\u01a4\t\b\2\2\u01a3"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\b\67\2\2\u01a8n\3\2\2\2\u01a9\u01aa"+
		"\13\2\2\2\u01aap\3\2\2\2\35\2{\u0085\u008b\u0091\u0097\u00a9\u00b7\u00c1"+
		"\u00cb\u00d5\u00e1\u00e9\u00f1\u00f9\u015c\u0163\u0169\u0171\u0173\u017a"+
		"\u0182\u018f\u0198\u019c\u019e\u01a5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}