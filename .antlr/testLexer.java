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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, LINE_COMMENT=15, BOOL=16, 
		INT=17, STRING=18, IO=19, OBJECT=20, SELF_TYPE=21, NEW=22, CLASS_RESERVED=23, 
		INHERITS_RESERVED=24, IF_RESERVED=25, THEN_RESERVED=26, ELSE_RESERVED=27, 
		FI_RESERVED=28, LET_RESERVED=29, IN_RESERVED=30, WHILE_RESERVED=31, CASE=32, 
		OF=33, ESAC=34, ISVOID=35, NOT=36, COMMA=37, DOT=38, COLON=39, SEMI=40, 
		ASSIGN=41, ARROW=42, LPAREN=43, RPAREN=44, LBRACE=45, RBRACE=46, COMMENT=47, 
		ID=48, INT_CONST=49, STR_CONST=50, ErrorChar=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "WS", "LINE_COMMENT", "BOOL", "INT", 
			"STRING", "IO", "OBJECT", "SELF_TYPE", "NEW", "CLASS_RESERVED", "INHERITS_RESERVED", 
			"IF_RESERVED", "THEN_RESERVED", "ELSE_RESERVED", "FI_RESERVED", "LET_RESERVED", 
			"IN_RESERVED", "WHILE_RESERVED", "CASE", "OF", "ESAC", "ISVOID", "NOT", 
			"COMMA", "DOT", "COLON", "SEMI", "ASSIGN", "ARROW", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "COMMENT", "ID", "INT_CONST", "STR_CONST", "ErrorChar"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'='", "'@'", "'/'", "'<'", "'<='", "'~'", 
			"'loop'", "'pool'", "'true'", "'false'", null, null, "'Bool'", "'Int'", 
			"'String'", "'IO'", "'Object'", "'SELF_TYPE'", null, null, null, null, 
			null, null, null, null, null, null, "'case'", "'of'", "'esac'", "'isvoid'", 
			"'not'", "','", "'.'", "':'", "';'", "'<-'", "'=>'", "'('", "')'", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "LINE_COMMENT", "BOOL", "INT", "STRING", "IO", "OBJECT", 
			"SELF_TYPE", "NEW", "CLASS_RESERVED", "INHERITS_RESERVED", "IF_RESERVED", 
			"THEN_RESERVED", "ELSE_RESERVED", "FI_RESERVED", "LET_RESERVED", "IN_RESERVED", 
			"WHILE_RESERVED", "CASE", "OF", "ESAC", "ISVOID", "NOT", "COMMA", "DOT", 
			"COLON", "SEMI", "ASSIGN", "ARROW", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"COMMENT", "ID", "INT_CONST", "STR_CONST", "ErrorChar"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u0182\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\6\17\u0093\n\17\r\17\16\17"+
		"\u0094\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0"+
		"\13\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00d0\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u00dc\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00ee\n\31\3\32\3\32"+
		"\3\32\3\32\5\32\u00f4\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u00fe\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0108\n\34\3"+
		"\35\3\35\3\35\3\35\5\35\u010e\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0116\n\36\3\37\3\37\3\37\3\37\5\37\u011c\n\37\3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \5 \u0128\n \3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+"+
		"\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\7\60\u015c\n\60\f\60\16\60"+
		"\u015f\13\60\3\60\5\60\u0162\n\60\3\60\3\60\5\60\u0166\n\60\3\60\3\60"+
		"\3\61\3\61\7\61\u016c\n\61\f\61\16\61\u016f\13\61\3\62\6\62\u0172\n\62"+
		"\r\62\16\62\u0173\3\63\3\63\3\63\3\63\7\63\u017a\n\63\f\63\16\63\u017d"+
		"\13\63\3\63\3\63\3\64\3\64\4\u009e\u015d\2\65\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\65\3\2\b\5\2\13\f\17\17\"\"\4\2C\\c|\6"+
		"\2\62;C\\aac|\3\2\62;\4\2$$^^\6\2\f\f\17\17$$^^\2\u0194\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2\2\13"+
		"q\3\2\2\2\rs\3\2\2\2\17u\3\2\2\2\21w\3\2\2\2\23z\3\2\2\2\25|\3\2\2\2\27"+
		"\u0081\3\2\2\2\31\u0086\3\2\2\2\33\u008b\3\2\2\2\35\u0092\3\2\2\2\37\u0098"+
		"\3\2\2\2!\u00a5\3\2\2\2#\u00aa\3\2\2\2%\u00ae\3\2\2\2\'\u00b5\3\2\2\2"+
		")\u00b8\3\2\2\2+\u00bf\3\2\2\2-\u00cf\3\2\2\2/\u00db\3\2\2\2\61\u00ed"+
		"\3\2\2\2\63\u00f3\3\2\2\2\65\u00fd\3\2\2\2\67\u0107\3\2\2\29\u010d\3\2"+
		"\2\2;\u0115\3\2\2\2=\u011b\3\2\2\2?\u0127\3\2\2\2A\u0129\3\2\2\2C\u012e"+
		"\3\2\2\2E\u0131\3\2\2\2G\u0136\3\2\2\2I\u013d\3\2\2\2K\u0141\3\2\2\2M"+
		"\u0143\3\2\2\2O\u0145\3\2\2\2Q\u0147\3\2\2\2S\u0149\3\2\2\2U\u014c\3\2"+
		"\2\2W\u014f\3\2\2\2Y\u0151\3\2\2\2[\u0153\3\2\2\2]\u0155\3\2\2\2_\u0157"+
		"\3\2\2\2a\u0169\3\2\2\2c\u0171\3\2\2\2e\u0175\3\2\2\2g\u0180\3\2\2\2i"+
		"j\7-\2\2j\4\3\2\2\2kl\7/\2\2l\6\3\2\2\2mn\7,\2\2n\b\3\2\2\2op\7?\2\2p"+
		"\n\3\2\2\2qr\7B\2\2r\f\3\2\2\2st\7\61\2\2t\16\3\2\2\2uv\7>\2\2v\20\3\2"+
		"\2\2wx\7>\2\2xy\7?\2\2y\22\3\2\2\2z{\7\u0080\2\2{\24\3\2\2\2|}\7n\2\2"+
		"}~\7q\2\2~\177\7q\2\2\177\u0080\7r\2\2\u0080\26\3\2\2\2\u0081\u0082\7"+
		"r\2\2\u0082\u0083\7q\2\2\u0083\u0084\7q\2\2\u0084\u0085\7n\2\2\u0085\30"+
		"\3\2\2\2\u0086\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089"+
		"\u008a\7g\2\2\u008a\32\3\2\2\2\u008b\u008c\7h\2\2\u008c\u008d\7c\2\2\u008d"+
		"\u008e\7n\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\34\3\2\2\2\u0091"+
		"\u0093\t\2\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\b\17\2\2\u0097"+
		"\36\3\2\2\2\u0098\u0099\7\61\2\2\u0099\u009a\7\61\2\2\u009a\u009e\3\2"+
		"\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\b\20\2\2\u00a4"+
		" \3\2\2\2\u00a5\u00a6\7D\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7q\2\2\u00a8"+
		"\u00a9\7n\2\2\u00a9\"\3\2\2\2\u00aa\u00ab\7K\2\2\u00ab\u00ac\7p\2\2\u00ac"+
		"\u00ad\7v\2\2\u00ad$\3\2\2\2\u00ae\u00af\7U\2\2\u00af\u00b0\7v\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7i\2\2"+
		"\u00b4&\3\2\2\2\u00b5\u00b6\7K\2\2\u00b6\u00b7\7Q\2\2\u00b7(\3\2\2\2\u00b8"+
		"\u00b9\7Q\2\2\u00b9\u00ba\7d\2\2\u00ba\u00bb\7l\2\2\u00bb\u00bc\7g\2\2"+
		"\u00bc\u00bd\7e\2\2\u00bd\u00be\7v\2\2\u00be*\3\2\2\2\u00bf\u00c0\7U\2"+
		"\2\u00c0\u00c1\7G\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3\7H\2\2\u00c3\u00c4"+
		"\7a\2\2\u00c4\u00c5\7V\2\2\u00c5\u00c6\7[\2\2\u00c6\u00c7\7R\2\2\u00c7"+
		"\u00c8\7G\2\2\u00c8,\3\2\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00d0\7y\2\2\u00cc\u00cd\7P\2\2\u00cd\u00ce\7G\2\2\u00ce\u00d0\7Y\2\2"+
		"\u00cf\u00c9\3\2\2\2\u00cf\u00cc\3\2\2\2\u00d0.\3\2\2\2\u00d1\u00d2\7"+
		"e\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7u\2\2\u00d5\u00dc"+
		"\7u\2\2\u00d6\u00d7\7E\2\2\u00d7\u00d8\7N\2\2\u00d8\u00d9\7C\2\2\u00d9"+
		"\u00da\7U\2\2\u00da\u00dc\7U\2\2\u00db\u00d1\3\2\2\2\u00db\u00d6\3\2\2"+
		"\2\u00dc\60\3\2\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7p\2\2\u00df\u00e0"+
		"\7j\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7v\2\2\u00e4\u00ee\7u\2\2\u00e5\u00e6\7K\2\2\u00e6\u00e7\7P\2\2"+
		"\u00e7\u00e8\7J\2\2\u00e8\u00e9\7G\2\2\u00e9\u00ea\7T\2\2\u00ea\u00eb"+
		"\7K\2\2\u00eb\u00ec\7V\2\2\u00ec\u00ee\7U\2\2\u00ed\u00dd\3\2\2\2\u00ed"+
		"\u00e5\3\2\2\2\u00ee\62\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f4\7h\2\2"+
		"\u00f1\u00f2\7K\2\2\u00f2\u00f4\7H\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7j\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8\u00fe\7p\2\2\u00f9\u00fa\7V\2\2\u00fa\u00fb\7J\2\2"+
		"\u00fb\u00fc\7G\2\2\u00fc\u00fe\7P\2\2\u00fd\u00f5\3\2\2\2\u00fd\u00f9"+
		"\3\2\2\2\u00fe\66\3\2\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7n\2\2\u0101"+
		"\u0102\7u\2\2\u0102\u0108\7g\2\2\u0103\u0104\7G\2\2\u0104\u0105\7N\2\2"+
		"\u0105\u0106\7U\2\2\u0106\u0108\7G\2\2\u0107\u00ff\3\2\2\2\u0107\u0103"+
		"\3\2\2\2\u01088\3\2\2\2\u0109\u010a\7h\2\2\u010a\u010e\7k\2\2\u010b\u010c"+
		"\7H\2\2\u010c\u010e\7K\2\2\u010d\u0109\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		":\3\2\2\2\u010f\u0110\7n\2\2\u0110\u0111\7g\2\2\u0111\u0116\7v\2\2\u0112"+
		"\u0113\7N\2\2\u0113\u0114\7G\2\2\u0114\u0116\7V\2\2\u0115\u010f\3\2\2"+
		"\2\u0115\u0112\3\2\2\2\u0116<\3\2\2\2\u0117\u0118\7k\2\2\u0118\u011c\7"+
		"p\2\2\u0119\u011a\7K\2\2\u011a\u011c\7P\2\2\u011b\u0117\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c>\3\2\2\2\u011d\u011e\7y\2\2\u011e\u011f\7j\2\2\u011f"+
		"\u0120\7k\2\2\u0120\u0121\7n\2\2\u0121\u0128\7g\2\2\u0122\u0123\7Y\2\2"+
		"\u0123\u0124\7J\2\2\u0124\u0125\7K\2\2\u0125\u0126\7N\2\2\u0126\u0128"+
		"\7G\2\2\u0127\u011d\3\2\2\2\u0127\u0122\3\2\2\2\u0128@\3\2\2\2\u0129\u012a"+
		"\7e\2\2\u012a\u012b\7c\2\2\u012b\u012c\7u\2\2\u012c\u012d\7g\2\2\u012d"+
		"B\3\2\2\2\u012e\u012f\7q\2\2\u012f\u0130\7h\2\2\u0130D\3\2\2\2\u0131\u0132"+
		"\7g\2\2\u0132\u0133\7u\2\2\u0133\u0134\7c\2\2\u0134\u0135\7e\2\2\u0135"+
		"F\3\2\2\2\u0136\u0137\7k\2\2\u0137\u0138\7u\2\2\u0138\u0139\7x\2\2\u0139"+
		"\u013a\7q\2\2\u013a\u013b\7k\2\2\u013b\u013c\7f\2\2\u013cH\3\2\2\2\u013d"+
		"\u013e\7p\2\2\u013e\u013f\7q\2\2\u013f\u0140\7v\2\2\u0140J\3\2\2\2\u0141"+
		"\u0142\7.\2\2\u0142L\3\2\2\2\u0143\u0144\7\60\2\2\u0144N\3\2\2\2\u0145"+
		"\u0146\7<\2\2\u0146P\3\2\2\2\u0147\u0148\7=\2\2\u0148R\3\2\2\2\u0149\u014a"+
		"\7>\2\2\u014a\u014b\7/\2\2\u014bT\3\2\2\2\u014c\u014d\7?\2\2\u014d\u014e"+
		"\7@\2\2\u014eV\3\2\2\2\u014f\u0150\7*\2\2\u0150X\3\2\2\2\u0151\u0152\7"+
		"+\2\2\u0152Z\3\2\2\2\u0153\u0154\7}\2\2\u0154\\\3\2\2\2\u0155\u0156\7"+
		"\177\2\2\u0156^\3\2\2\2\u0157\u0158\7/\2\2\u0158\u0159\7/\2\2\u0159\u015d"+
		"\3\2\2\2\u015a\u015c\13\2\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2\2\2"+
		"\u015d\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0165\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u0160\u0162\7\17\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2"+
		"\u0162\u0163\3\2\2\2\u0163\u0166\7\f\2\2\u0164\u0166\7\2\2\3\u0165\u0161"+
		"\3\2\2\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b\60\2\2"+
		"\u0168`\3\2\2\2\u0169\u016d\t\3\2\2\u016a\u016c\t\4\2\2\u016b\u016a\3"+
		"\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"b\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0172\t\5\2\2\u0171\u0170\3\2\2\2"+
		"\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174d\3"+
		"\2\2\2\u0175\u017b\7$\2\2\u0176\u0177\7^\2\2\u0177\u017a\t\6\2\2\u0178"+
		"\u017a\n\7\2\2\u0179\u0176\3\2\2\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2"+
		"\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u017f\7$\2\2\u017ff\3\2\2\2\u0180\u0181\13\2\2\2"+
		"\u0181h\3\2\2\2\26\2\u0094\u009e\u00cf\u00db\u00ed\u00f3\u00fd\u0107\u010d"+
		"\u0115\u011b\u0127\u015d\u0161\u0165\u016d\u0173\u0179\u017b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}