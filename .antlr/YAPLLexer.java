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
public class YAPLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, WS=19, LINE_COMMENT=20, BOOL=21, INT=22, STRING=23, IO=24, OBJECT=25, 
		SELF_TYPE=26, NEW=27, CLASS_RESERVED=28, INHERITS_RESERVED=29, IF_RESERVED=30, 
		THEN_RESERVED=31, ELSE_RESERVED=32, FI_RESERVED=33, LET_RESERVED=34, IN_RESERVED=35, 
		WHILE_RESERVED=36, NEW_RESERVED=37, CASE=38, OF=39, ESAC=40, ISVOID=41, 
		NOT=42, COMMA=43, DOT=44, COLON=45, SEMI=46, ASSIGN=47, ARROW=48, LPAREN=49, 
		RPAREN=50, LBRACE=51, RBRACE=52, COMMENT=53, ID=54, INT_CONST=55, STR_CONST=56, 
		ErrorChar=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "WS", "LINE_COMMENT", "BOOL", "INT", "STRING", "IO", "OBJECT", 
			"SELF_TYPE", "NEW", "CLASS_RESERVED", "INHERITS_RESERVED", "IF_RESERVED", 
			"THEN_RESERVED", "ELSE_RESERVED", "FI_RESERVED", "LET_RESERVED", "IN_RESERVED", 
			"WHILE_RESERVED", "NEW_RESERVED", "CASE", "OF", "ESAC", "ISVOID", "NOT", 
			"COMMA", "DOT", "COLON", "SEMI", "ASSIGN", "ARROW", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "COMMENT", "ID", "INT_CONST", "STR_CONST", "ErrorChar"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'='", "'@'", "'/'", "'<'", "'<='", "'~'", 
			"'loop'", "'pool'", "'self'", "'true'", "'false'", "'void'", "'>'", "'%'", 
			"'^'", null, null, "'Bool'", "'Int'", "'String'", "'IO'", "'Object'", 
			"'SELF_TYPE'", "'new'", null, null, null, null, null, null, null, null, 
			null, null, "'case'", "'of'", "'esac'", "'isvoid'", "'not'", "','", "'.'", 
			"':'", "';'", "'<-'", "'=>'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "WS", "LINE_COMMENT", "BOOL", 
			"INT", "STRING", "IO", "OBJECT", "SELF_TYPE", "NEW", "CLASS_RESERVED", 
			"INHERITS_RESERVED", "IF_RESERVED", "THEN_RESERVED", "ELSE_RESERVED", 
			"FI_RESERVED", "LET_RESERVED", "IN_RESERVED", "WHILE_RESERVED", "NEW_RESERVED", 
			"CASE", "OF", "ESAC", "ISVOID", "NOT", "COMMA", "DOT", "COLON", "SEMI", 
			"ASSIGN", "ARROW", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMENT", 
			"ID", "INT_CONST", "STR_CONST", "ErrorChar"
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


	public YAPLLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u01a2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\6\24\u00af\n\24\r\24\16\24\u00b0\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\7\25\u00b9\n\25\f\25\16\25\u00bc\13\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00f4\n\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0106\n\36\3\37\3\37\3\37\3\37\5\37\u010c\n\37\3 \3 \3 \3 "+
		"\3 \3 \3 \3 \5 \u0116\n \3!\3!\3!\3!\3!\3!\3!\3!\5!\u0120\n!\3\"\3\"\3"+
		"\"\3\"\5\"\u0126\n\"\3#\3#\3#\3#\3#\3#\5#\u012e\n#\3$\3$\3$\3$\5$\u0134"+
		"\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0140\n%\3&\3&\3&\3&\3&\3&\5&\u0148"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u017c\n\66"+
		"\f\66\16\66\u017f\13\66\3\66\5\66\u0182\n\66\3\66\3\66\5\66\u0186\n\66"+
		"\3\66\3\66\3\67\3\67\7\67\u018c\n\67\f\67\16\67\u018f\13\67\38\68\u0192"+
		"\n8\r8\168\u0193\39\39\39\39\79\u019a\n9\f9\169\u019d\139\39\39\3:\3:"+
		"\4\u00ba\u017d\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;\3\2\b\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|"+
		"\3\2\62;\4\2$$^^\6\2\f\f\17\17$$^^\2\u01b4\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\3u\3\2\2\2\5w\3\2\2\2\7y\3\2\2\2\t{\3\2\2\2\13}\3\2\2\2\r\177"+
		"\3\2\2\2\17\u0081\3\2\2\2\21\u0083\3\2\2\2\23\u0086\3\2\2\2\25\u0088\3"+
		"\2\2\2\27\u008d\3\2\2\2\31\u0092\3\2\2\2\33\u0097\3\2\2\2\35\u009c\3\2"+
		"\2\2\37\u00a2\3\2\2\2!\u00a7\3\2\2\2#\u00a9\3\2\2\2%\u00ab\3\2\2\2\'\u00ae"+
		"\3\2\2\2)\u00b4\3\2\2\2+\u00c1\3\2\2\2-\u00c6\3\2\2\2/\u00ca\3\2\2\2\61"+
		"\u00d1\3\2\2\2\63\u00d4\3\2\2\2\65\u00db\3\2\2\2\67\u00e5\3\2\2\29\u00f3"+
		"\3\2\2\2;\u0105\3\2\2\2=\u010b\3\2\2\2?\u0115\3\2\2\2A\u011f\3\2\2\2C"+
		"\u0125\3\2\2\2E\u012d\3\2\2\2G\u0133\3\2\2\2I\u013f\3\2\2\2K\u0147\3\2"+
		"\2\2M\u0149\3\2\2\2O\u014e\3\2\2\2Q\u0151\3\2\2\2S\u0156\3\2\2\2U\u015d"+
		"\3\2\2\2W\u0161\3\2\2\2Y\u0163\3\2\2\2[\u0165\3\2\2\2]\u0167\3\2\2\2_"+
		"\u0169\3\2\2\2a\u016c\3\2\2\2c\u016f\3\2\2\2e\u0171\3\2\2\2g\u0173\3\2"+
		"\2\2i\u0175\3\2\2\2k\u0177\3\2\2\2m\u0189\3\2\2\2o\u0191\3\2\2\2q\u0195"+
		"\3\2\2\2s\u01a0\3\2\2\2uv\7-\2\2v\4\3\2\2\2wx\7/\2\2x\6\3\2\2\2yz\7,\2"+
		"\2z\b\3\2\2\2{|\7?\2\2|\n\3\2\2\2}~\7B\2\2~\f\3\2\2\2\177\u0080\7\61\2"+
		"\2\u0080\16\3\2\2\2\u0081\u0082\7>\2\2\u0082\20\3\2\2\2\u0083\u0084\7"+
		">\2\2\u0084\u0085\7?\2\2\u0085\22\3\2\2\2\u0086\u0087\7\u0080\2\2\u0087"+
		"\24\3\2\2\2\u0088\u0089\7n\2\2\u0089\u008a\7q\2\2\u008a\u008b\7q\2\2\u008b"+
		"\u008c\7r\2\2\u008c\26\3\2\2\2\u008d\u008e\7r\2\2\u008e\u008f\7q\2\2\u008f"+
		"\u0090\7q\2\2\u0090\u0091\7n\2\2\u0091\30\3\2\2\2\u0092\u0093\7u\2\2\u0093"+
		"\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095\u0096\7h\2\2\u0096\32\3\2\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a\7w\2\2\u009a\u009b\7g\2\2"+
		"\u009b\34\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7c\2\2\u009e\u009f\7"+
		"n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\36\3\2\2\2\u00a2\u00a3"+
		"\7x\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7f\2\2\u00a6"+
		" \3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa"+
		"$\3\2\2\2\u00ab\u00ac\7`\2\2\u00ac&\3\2\2\2\u00ad\u00af\t\2\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\24\2\2\u00b3(\3\2\2\2\u00b4\u00b5"+
		"\7\61\2\2\u00b5\u00b6\7\61\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b9\13\2\2"+
		"\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bb\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\f\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\b\25\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7D\2\2"+
		"\u00c2\u00c3\7q\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7n\2\2\u00c5,\3\2\2"+
		"\2\u00c6\u00c7\7K\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7v\2\2\u00c9.\3\2"+
		"\2\2\u00ca\u00cb\7U\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce"+
		"\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7i\2\2\u00d0\60\3\2\2\2\u00d1\u00d2"+
		"\7K\2\2\u00d2\u00d3\7Q\2\2\u00d3\62\3\2\2\2\u00d4\u00d5\7Q\2\2\u00d5\u00d6"+
		"\7d\2\2\u00d6\u00d7\7l\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7e\2\2\u00d9"+
		"\u00da\7v\2\2\u00da\64\3\2\2\2\u00db\u00dc\7U\2\2\u00dc\u00dd\7G\2\2\u00dd"+
		"\u00de\7N\2\2\u00de\u00df\7H\2\2\u00df\u00e0\7a\2\2\u00e0\u00e1\7V\2\2"+
		"\u00e1\u00e2\7[\2\2\u00e2\u00e3\7R\2\2\u00e3\u00e4\7G\2\2\u00e4\66\3\2"+
		"\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7y\2\2\u00e88\3"+
		"\2\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ed\7u\2\2\u00ed\u00f4\7u\2\2\u00ee\u00ef\7E\2\2\u00ef\u00f0\7N\2\2"+
		"\u00f0\u00f1\7C\2\2\u00f1\u00f2\7U\2\2\u00f2\u00f4\7U\2\2\u00f3\u00e9"+
		"\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7"+
		"\7p\2\2\u00f7\u00f8\7j\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7t\2\2\u00fa"+
		"\u00fb\7k\2\2\u00fb\u00fc\7v\2\2\u00fc\u0106\7u\2\2\u00fd\u00fe\7K\2\2"+
		"\u00fe\u00ff\7P\2\2\u00ff\u0100\7J\2\2\u0100\u0101\7G\2\2\u0101\u0102"+
		"\7T\2\2\u0102\u0103\7K\2\2\u0103\u0104\7V\2\2\u0104\u0106\7U\2\2\u0105"+
		"\u00f5\3\2\2\2\u0105\u00fd\3\2\2\2\u0106<\3\2\2\2\u0107\u0108\7k\2\2\u0108"+
		"\u010c\7h\2\2\u0109\u010a\7K\2\2\u010a\u010c\7H\2\2\u010b\u0107\3\2\2"+
		"\2\u010b\u0109\3\2\2\2\u010c>\3\2\2\2\u010d\u010e\7v\2\2\u010e\u010f\7"+
		"j\2\2\u010f\u0110\7g\2\2\u0110\u0116\7p\2\2\u0111\u0112\7V\2\2\u0112\u0113"+
		"\7J\2\2\u0113\u0114\7G\2\2\u0114\u0116\7P\2\2\u0115\u010d\3\2\2\2\u0115"+
		"\u0111\3\2\2\2\u0116@\3\2\2\2\u0117\u0118\7g\2\2\u0118\u0119\7n\2\2\u0119"+
		"\u011a\7u\2\2\u011a\u0120\7g\2\2\u011b\u011c\7G\2\2\u011c\u011d\7N\2\2"+
		"\u011d\u011e\7U\2\2\u011e\u0120\7G\2\2\u011f\u0117\3\2\2\2\u011f\u011b"+
		"\3\2\2\2\u0120B\3\2\2\2\u0121\u0122\7h\2\2\u0122\u0126\7k\2\2\u0123\u0124"+
		"\7H\2\2\u0124\u0126\7K\2\2\u0125\u0121\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"D\3\2\2\2\u0127\u0128\7n\2\2\u0128\u0129\7g\2\2\u0129\u012e\7v\2\2\u012a"+
		"\u012b\7N\2\2\u012b\u012c\7G\2\2\u012c\u012e\7V\2\2\u012d\u0127\3\2\2"+
		"\2\u012d\u012a\3\2\2\2\u012eF\3\2\2\2\u012f\u0130\7k\2\2\u0130\u0134\7"+
		"p\2\2\u0131\u0132\7K\2\2\u0132\u0134\7P\2\2\u0133\u012f\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134H\3\2\2\2\u0135\u0136\7y\2\2\u0136\u0137\7j\2\2\u0137"+
		"\u0138\7k\2\2\u0138\u0139\7n\2\2\u0139\u0140\7g\2\2\u013a\u013b\7Y\2\2"+
		"\u013b\u013c\7J\2\2\u013c\u013d\7K\2\2\u013d\u013e\7N\2\2\u013e\u0140"+
		"\7G\2\2\u013f\u0135\3\2\2\2\u013f\u013a\3\2\2\2\u0140J\3\2\2\2\u0141\u0142"+
		"\7P\2\2\u0142\u0143\7G\2\2\u0143\u0148\7Y\2\2\u0144\u0145\7p\2\2\u0145"+
		"\u0146\7g\2\2\u0146\u0148\7y\2\2\u0147\u0141\3\2\2\2\u0147\u0144\3\2\2"+
		"\2\u0148L\3\2\2\2\u0149\u014a\7e\2\2\u014a\u014b\7c\2\2\u014b\u014c\7"+
		"u\2\2\u014c\u014d\7g\2\2\u014dN\3\2\2\2\u014e\u014f\7q\2\2\u014f\u0150"+
		"\7h\2\2\u0150P\3\2\2\2\u0151\u0152\7g\2\2\u0152\u0153\7u\2\2\u0153\u0154"+
		"\7c\2\2\u0154\u0155\7e\2\2\u0155R\3\2\2\2\u0156\u0157\7k\2\2\u0157\u0158"+
		"\7u\2\2\u0158\u0159\7x\2\2\u0159\u015a\7q\2\2\u015a\u015b\7k\2\2\u015b"+
		"\u015c\7f\2\2\u015cT\3\2\2\2\u015d\u015e\7p\2\2\u015e\u015f\7q\2\2\u015f"+
		"\u0160\7v\2\2\u0160V\3\2\2\2\u0161\u0162\7.\2\2\u0162X\3\2\2\2\u0163\u0164"+
		"\7\60\2\2\u0164Z\3\2\2\2\u0165\u0166\7<\2\2\u0166\\\3\2\2\2\u0167\u0168"+
		"\7=\2\2\u0168^\3\2\2\2\u0169\u016a\7>\2\2\u016a\u016b\7/\2\2\u016b`\3"+
		"\2\2\2\u016c\u016d\7?\2\2\u016d\u016e\7@\2\2\u016eb\3\2\2\2\u016f\u0170"+
		"\7*\2\2\u0170d\3\2\2\2\u0171\u0172\7+\2\2\u0172f\3\2\2\2\u0173\u0174\7"+
		"}\2\2\u0174h\3\2\2\2\u0175\u0176\7\177\2\2\u0176j\3\2\2\2\u0177\u0178"+
		"\7/\2\2\u0178\u0179\7/\2\2\u0179\u017d\3\2\2\2\u017a\u017c\13\2\2\2\u017b"+
		"\u017a\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017e\3\2\2\2\u017d\u017b\3\2"+
		"\2\2\u017e\u0185\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0182\7\17\2\2\u0181"+
		"\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0186\7\f"+
		"\2\2\u0184\u0186\7\2\2\3\u0185\u0181\3\2\2\2\u0185\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u0188\b\66\2\2\u0188l\3\2\2\2\u0189\u018d\t\3\2\2"+
		"\u018a\u018c\t\4\2\2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018en\3\2\2\2\u018f\u018d\3\2\2\2\u0190"+
		"\u0192\t\5\2\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0191\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194p\3\2\2\2\u0195\u019b\7$\2\2\u0196\u0197"+
		"\7^\2\2\u0197\u019a\t\6\2\2\u0198\u019a\n\7\2\2\u0199\u0196\3\2\2\2\u0199"+
		"\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2"+
		"\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u019f\7$\2\2\u019f"+
		"r\3\2\2\2\u01a0\u01a1\13\2\2\2\u01a1t\3\2\2\2\26\2\u00b0\u00ba\u00f3\u0105"+
		"\u010b\u0115\u011f\u0125\u012d\u0133\u013f\u0147\u017d\u0181\u0185\u018d"+
		"\u0193\u0199\u019b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}