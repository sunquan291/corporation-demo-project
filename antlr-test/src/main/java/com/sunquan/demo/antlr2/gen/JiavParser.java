// Generated from E:/sunquan-project/antlr-test/src/main/resources\Jiav.g4 by ANTLR 4.6
package com.sunquan.demo.antlr2.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JiavParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, PLUS=2, SUB=3, MUL=4, DIV=5, WS=6;
	public static final int
		RULE_expres = 0;
	public static final String[] ruleNames = {
		"expres"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'p'", "'s'", "'m'", "'d'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "PLUS", "SUB", "MUL", "DIV", "WS"
	};
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
	public String getGrammarFileName() { return "Jiav.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JiavParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpresContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(JiavParser.NUMBER, 0); }
		public ExpresContext expres() {
			return getRuleContext(ExpresContext.class,0);
		}
		public List<TerminalNode> PLUS() { return getTokens(JiavParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(JiavParser.PLUS, i);
		}
		public List<TerminalNode> SUB() { return getTokens(JiavParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(JiavParser.SUB, i);
		}
		public List<TerminalNode> MUL() { return getTokens(JiavParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(JiavParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(JiavParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(JiavParser.DIV, i);
		}
		public ExpresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expres; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JiavListener ) ((JiavListener)listener).enterExpres(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JiavListener ) ((JiavListener)listener).exitExpres(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JiavVisitor ) return ((JiavVisitor<? extends T>)visitor).visitExpres(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresContext expres() throws RecognitionException {
		return expres(0);
	}

	private ExpresContext expres(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresContext _localctx = new ExpresContext(_ctx, _parentState);
		ExpresContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expres, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(3);
			match(NUMBER);
			}
			_ctx.stop = _input.LT(-1);
			setState(15);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpresContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expres);
					setState(5);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(9);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << SUB) | (1L << MUL) | (1L << DIV))) != 0)) {
						{
						{
						setState(6);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << SUB) | (1L << MUL) | (1L << DIV))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(11);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(12);
					match(NUMBER);
					}
					} 
				}
				setState(17);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		case 0:
			return expres_sempred((ExpresContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expres_sempred(ExpresContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\25\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\7\2\20\n\2\f\2\16\2\23"+
		"\13\2\3\2\2\3\2\3\2\2\3\3\2\4\7\25\2\4\3\2\2\2\4\5\b\2\1\2\5\6\7\3\2\2"+
		"\6\21\3\2\2\2\7\13\f\4\2\2\b\n\t\2\2\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3"+
		"\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2\2\2\16\20\7\3\2\2\17\7\3\2\2"+
		"\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\21\3\2\2"+
		"\2\4\13\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}