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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ID=19, INT_CONST=20, STR_CONST=21, WS=22, BOOL=23, INT=24, STRING=25, 
		IO=26, OBJECT=27, SELF_TYPE=28, CLASS_RESERVED=29, INHERITS_RESERVED=30, 
		IF_RESERVED=31, THEN_RESERVED=32, ELSE_RESERVED=33, FI_RESERVED=34, LET_RESERVED=35, 
		IN_RESERVED=36, WHILE_RESERVED=37, NEW_RESERVED=38, CASE=39, OF=40, ESAC=41, 
		NEW=42, ISVOID=43, NOT=44, COMMA=45, DOT=46, COLON=47, SEMI=48, ASSIGN=49, 
		ARROW=50, LPAREN=51, RPAREN=52, LBRACE=53, RBRACE=54, LINE_COMMENT=55, 
		COMMENT=56, ErrorChar=57;
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
			"T__17", "ID", "INT_CONST", "STR_CONST", "WS", "BOOL", "INT", "STRING", 
			"IO", "OBJECT", "SELF_TYPE", "CLASS_RESERVED", "INHERITS_RESERVED", "IF_RESERVED", 
			"THEN_RESERVED", "ELSE_RESERVED", "FI_RESERVED", "LET_RESERVED", "IN_RESERVED", 
			"WHILE_RESERVED", "NEW_RESERVED", "CASE", "OF", "ESAC", "NEW", "ISVOID", 
			"NOT", "COMMA", "DOT", "COLON", "SEMI", "ASSIGN", "ARROW", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LINE_COMMENT", "COMMENT", "ErrorChar"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u019e\b\1\4\2\t"+
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
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u00b0\n\24\f\24\16\24\u00b3\13"+
		"\24\3\25\6\25\u00b6\n\25\r\25\16\25\u00b7\3\26\3\26\3\26\3\26\7\26\u00be"+
		"\n\26\f\26\16\26\u00c1\13\26\3\26\3\26\3\27\6\27\u00c6\n\27\r\27\16\27"+
		"\u00c7\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00fa\n\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u010c"+
		"\n\37\3 \3 \3 \3 \5 \u0112\n \3!\3!\3!\3!\3!\3!\3!\3!\5!\u011c\n!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0126\n\"\3#\3#\3#\3#\5#\u012c\n#\3$"+
		"\3$\3$\3$\3$\3$\5$\u0134\n$\3%\3%\3%\3%\5%\u013a\n%\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\5&\u0146\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u014e\n\'\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\38\78\u0186\n8\f8\16"+
		"8\u0189\138\38\38\38\38\39\39\39\39\79\u0193\n9\f9\169\u0196\139\39\3"+
		"9\39\39\39\3:\3:\4\u0187\u0194\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;\3\2\b\4\2C\\c|\6\2\62;C\\aac|\3\2"+
		"\62;\4\2$$^^\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\2\u01ae\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5w\3\2\2\2\7y\3\2\2\2\t{\3\2\2\2\13"+
		"}\3\2\2\2\r\177\3\2\2\2\17\u0081\3\2\2\2\21\u0083\3\2\2\2\23\u0086\3\2"+
		"\2\2\25\u0088\3\2\2\2\27\u008d\3\2\2\2\31\u0092\3\2\2\2\33\u0097\3\2\2"+
		"\2\35\u009c\3\2\2\2\37\u00a2\3\2\2\2!\u00a7\3\2\2\2#\u00a9\3\2\2\2%\u00ab"+
		"\3\2\2\2\'\u00ad\3\2\2\2)\u00b5\3\2\2\2+\u00b9\3\2\2\2-\u00c5\3\2\2\2"+
		"/\u00cb\3\2\2\2\61\u00d0\3\2\2\2\63\u00d4\3\2\2\2\65\u00db\3\2\2\2\67"+
		"\u00de\3\2\2\29\u00e5\3\2\2\2;\u00f9\3\2\2\2=\u010b\3\2\2\2?\u0111\3\2"+
		"\2\2A\u011b\3\2\2\2C\u0125\3\2\2\2E\u012b\3\2\2\2G\u0133\3\2\2\2I\u0139"+
		"\3\2\2\2K\u0145\3\2\2\2M\u014d\3\2\2\2O\u014f\3\2\2\2Q\u0154\3\2\2\2S"+
		"\u0157\3\2\2\2U\u015c\3\2\2\2W\u0160\3\2\2\2Y\u0167\3\2\2\2[\u016b\3\2"+
		"\2\2]\u016d\3\2\2\2_\u016f\3\2\2\2a\u0171\3\2\2\2c\u0173\3\2\2\2e\u0176"+
		"\3\2\2\2g\u0179\3\2\2\2i\u017b\3\2\2\2k\u017d\3\2\2\2m\u017f\3\2\2\2o"+
		"\u0181\3\2\2\2q\u018e\3\2\2\2s\u019c\3\2\2\2uv\7-\2\2v\4\3\2\2\2wx\7/"+
		"\2\2x\6\3\2\2\2yz\7,\2\2z\b\3\2\2\2{|\7?\2\2|\n\3\2\2\2}~\7B\2\2~\f\3"+
		"\2\2\2\177\u0080\7\61\2\2\u0080\16\3\2\2\2\u0081\u0082\7>\2\2\u0082\20"+
		"\3\2\2\2\u0083\u0084\7>\2\2\u0084\u0085\7?\2\2\u0085\22\3\2\2\2\u0086"+
		"\u0087\7\u0080\2\2\u0087\24\3\2\2\2\u0088\u0089\7n\2\2\u0089\u008a\7q"+
		"\2\2\u008a\u008b\7q\2\2\u008b\u008c\7r\2\2\u008c\26\3\2\2\2\u008d\u008e"+
		"\7r\2\2\u008e\u008f\7q\2\2\u008f\u0090\7q\2\2\u0090\u0091\7n\2\2\u0091"+
		"\30\3\2\2\2\u0092\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095"+
		"\u0096\7h\2\2\u0096\32\3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099"+
		"\u009a\7w\2\2\u009a\u009b\7g\2\2\u009b\34\3\2\2\2\u009c\u009d\7h\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\36\3\2\2\2\u00a2\u00a3\7x\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7"+
		"k\2\2\u00a5\u00a6\7f\2\2\u00a6 \3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\"\3\2"+
		"\2\2\u00a9\u00aa\7\'\2\2\u00aa$\3\2\2\2\u00ab\u00ac\7`\2\2\u00ac&\3\2"+
		"\2\2\u00ad\u00b1\t\2\2\2\u00ae\u00b0\t\3\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2(\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b4\u00b6\t\4\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8*\3\2\2\2\u00b9"+
		"\u00bf\7$\2\2\u00ba\u00bb\7^\2\2\u00bb\u00be\t\5\2\2\u00bc\u00be\n\6\2"+
		"\2\u00bd\u00ba\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c3\7$\2\2\u00c3,\3\2\2\2\u00c4\u00c6\t\7\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00ca\b\27\2\2\u00ca.\3\2\2\2\u00cb\u00cc\7D\2\2\u00cc\u00cd"+
		"\7q\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7n\2\2\u00cf\60\3\2\2\2\u00d0\u00d1"+
		"\7K\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3\62\3\2\2\2\u00d4\u00d5"+
		"\7U\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7k\2\2\u00d8"+
		"\u00d9\7p\2\2\u00d9\u00da\7i\2\2\u00da\64\3\2\2\2\u00db\u00dc\7K\2\2\u00dc"+
		"\u00dd\7Q\2\2\u00dd\66\3\2\2\2\u00de\u00df\7Q\2\2\u00df\u00e0\7d\2\2\u00e0"+
		"\u00e1\7l\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7e\2\2\u00e3\u00e4\7v\2\2"+
		"\u00e48\3\2\2\2\u00e5\u00e6\7U\2\2\u00e6\u00e7\7G\2\2\u00e7\u00e8\7N\2"+
		"\2\u00e8\u00e9\7H\2\2\u00e9\u00ea\7a\2\2\u00ea\u00eb\7V\2\2\u00eb\u00ec"+
		"\7[\2\2\u00ec\u00ed\7R\2\2\u00ed\u00ee\7G\2\2\u00ee:\3\2\2\2\u00ef\u00f0"+
		"\7e\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00fa\7u\2\2\u00f4\u00f5\7E\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7C\2\2"+
		"\u00f7\u00f8\7U\2\2\u00f8\u00fa\7U\2\2\u00f9\u00ef\3\2\2\2\u00f9\u00f4"+
		"\3\2\2\2\u00fa<\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe"+
		"\7j\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7v\2\2\u0102\u010c\7u\2\2\u0103\u0104\7K\2\2\u0104\u0105\7P\2\2"+
		"\u0105\u0106\7J\2\2\u0106\u0107\7G\2\2\u0107\u0108\7T\2\2\u0108\u0109"+
		"\7K\2\2\u0109\u010a\7V\2\2\u010a\u010c\7U\2\2\u010b\u00fb\3\2\2\2\u010b"+
		"\u0103\3\2\2\2\u010c>\3\2\2\2\u010d\u010e\7k\2\2\u010e\u0112\7h\2\2\u010f"+
		"\u0110\7K\2\2\u0110\u0112\7H\2\2\u0111\u010d\3\2\2\2\u0111\u010f\3\2\2"+
		"\2\u0112@\3\2\2\2\u0113\u0114\7v\2\2\u0114\u0115\7j\2\2\u0115\u0116\7"+
		"g\2\2\u0116\u011c\7p\2\2\u0117\u0118\7V\2\2\u0118\u0119\7J\2\2\u0119\u011a"+
		"\7G\2\2\u011a\u011c\7P\2\2\u011b\u0113\3\2\2\2\u011b\u0117\3\2\2\2\u011c"+
		"B\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7n\2\2\u011f\u0120\7u\2\2\u0120"+
		"\u0126\7g\2\2\u0121\u0122\7G\2\2\u0122\u0123\7N\2\2\u0123\u0124\7U\2\2"+
		"\u0124\u0126\7G\2\2\u0125\u011d\3\2\2\2\u0125\u0121\3\2\2\2\u0126D\3\2"+
		"\2\2\u0127\u0128\7h\2\2\u0128\u012c\7k\2\2\u0129\u012a\7H\2\2\u012a\u012c"+
		"\7K\2\2\u012b\u0127\3\2\2\2\u012b\u0129\3\2\2\2\u012cF\3\2\2\2\u012d\u012e"+
		"\7n\2\2\u012e\u012f\7g\2\2\u012f\u0134\7v\2\2\u0130\u0131\7N\2\2\u0131"+
		"\u0132\7G\2\2\u0132\u0134\7V\2\2\u0133\u012d\3\2\2\2\u0133\u0130\3\2\2"+
		"\2\u0134H\3\2\2\2\u0135\u0136\7k\2\2\u0136\u013a\7p\2\2\u0137\u0138\7"+
		"K\2\2\u0138\u013a\7P\2\2\u0139\u0135\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"J\3\2\2\2\u013b\u013c\7y\2\2\u013c\u013d\7j\2\2\u013d\u013e\7k\2\2\u013e"+
		"\u013f\7n\2\2\u013f\u0146\7g\2\2\u0140\u0141\7Y\2\2\u0141\u0142\7J\2\2"+
		"\u0142\u0143\7K\2\2\u0143\u0144\7N\2\2\u0144\u0146\7G\2\2\u0145\u013b"+
		"\3\2\2\2\u0145\u0140\3\2\2\2\u0146L\3\2\2\2\u0147\u0148\7p\2\2\u0148\u0149"+
		"\7g\2\2\u0149\u014e\7y\2\2\u014a\u014b\7P\2\2\u014b\u014c\7G\2\2\u014c"+
		"\u014e\7Y\2\2\u014d\u0147\3\2\2\2\u014d\u014a\3\2\2\2\u014eN\3\2\2\2\u014f"+
		"\u0150\7e\2\2\u0150\u0151\7c\2\2\u0151\u0152\7u\2\2\u0152\u0153\7g\2\2"+
		"\u0153P\3\2\2\2\u0154\u0155\7q\2\2\u0155\u0156\7h\2\2\u0156R\3\2\2\2\u0157"+
		"\u0158\7g\2\2\u0158\u0159\7u\2\2\u0159\u015a\7c\2\2\u015a\u015b\7e\2\2"+
		"\u015bT\3\2\2\2\u015c\u015d\7p\2\2\u015d\u015e\7g\2\2\u015e\u015f\7y\2"+
		"\2\u015fV\3\2\2\2\u0160\u0161\7k\2\2\u0161\u0162\7u\2\2\u0162\u0163\7"+
		"x\2\2\u0163\u0164\7q\2\2\u0164\u0165\7k\2\2\u0165\u0166\7f\2\2\u0166X"+
		"\3\2\2\2\u0167\u0168\7p\2\2\u0168\u0169\7q\2\2\u0169\u016a\7v\2\2\u016a"+
		"Z\3\2\2\2\u016b\u016c\7.\2\2\u016c\\\3\2\2\2\u016d\u016e\7\60\2\2\u016e"+
		"^\3\2\2\2\u016f\u0170\7<\2\2\u0170`\3\2\2\2\u0171\u0172\7=\2\2\u0172b"+
		"\3\2\2\2\u0173\u0174\7>\2\2\u0174\u0175\7/\2\2\u0175d\3\2\2\2\u0176\u0177"+
		"\7?\2\2\u0177\u0178\7@\2\2\u0178f\3\2\2\2\u0179\u017a\7*\2\2\u017ah\3"+
		"\2\2\2\u017b\u017c\7+\2\2\u017cj\3\2\2\2\u017d\u017e\7}\2\2\u017el\3\2"+
		"\2\2\u017f\u0180\7\177\2\2\u0180n\3\2\2\2\u0181\u0182\7\61\2\2\u0182\u0183"+
		"\7\61\2\2\u0183\u0187\3\2\2\2\u0184\u0186\13\2\2\2\u0185\u0184\3\2\2\2"+
		"\u0186\u0189\3\2\2\2\u0187\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018a"+
		"\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\7\f\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018d\b8\2\2\u018dp\3\2\2\2\u018e\u018f\7\61\2\2\u018f\u0190\7,\2\2\u0190"+
		"\u0194\3\2\2\2\u0191\u0193\13\2\2\2\u0192\u0191\3\2\2\2\u0193\u0196\3"+
		"\2\2\2\u0194\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0197\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0197\u0198\7,\2\2\u0198\u0199\7\61\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u019b\b9\2\2\u019br\3\2\2\2\u019c\u019d\13\2\2\2\u019dt\3\2"+
		"\2\2\24\2\u00b1\u00b7\u00bd\u00bf\u00c7\u00f9\u010b\u0111\u011b\u0125"+
		"\u012b\u0133\u0139\u0145\u014d\u0187\u0194\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}