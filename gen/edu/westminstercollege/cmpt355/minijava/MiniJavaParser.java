// Generated from java-escape by ANTLR 4.11.1
package edu.westminstercollege.cmpt355.minijava;

import edu.westminstercollege.cmpt355.minijava.node.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, RESERVED_WORD=21, WHITESPACE=22, INT=23, 
		DOUBLE=24, BOOLEAN=25, STRING=26, NAME=27, LINE_COMMENT=28, BLOCK_COMMENT=29;
	public static final int
		RULE_goal = 0, RULE_methodBody = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_variableDeclarationItem = 4, RULE_expression = 5, RULE_type = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"goal", "methodBody", "statement", "variableDeclaration", "variableDeclarationItem", 
			"expression", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "','", "'='", "'_print'", "'('", "')'", "'++'", 
			"'--'", "'+'", "'-'", "'.'", "'new'", "'*'", "'/'", "'%'", "'int'", "'double'", 
			"'boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "RESERVED_WORD", 
			"WHITESPACE", "INT", "DOUBLE", "BOOLEAN", "STRING", "NAME", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GoalContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_goal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			methodBody();
			setState(15);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public Block n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 261906118L) != 0) {
				{
				{
				setState(17);
				((MethodBodyContext)_localctx).statement = statement();
				((MethodBodyContext)_localctx).stmts.add(((MethodBodyContext)_localctx).statement);
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}

			        var statements = new ArrayList<Statement>();
			        for (var stmt : ((MethodBodyContext)_localctx).stmts)
			            statements.add(stmt.n);

			        ((MethodBodyContext)_localctx).n =  new Block(_localctx, statements);
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public VariableDeclarationContext variableDeclaration;
		public ExpressionContext expression;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(T__0);

				        ((StatementContext)_localctx).n =  new EmptyStatement(_localctx);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__1);
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 261906118L) != 0) {
					{
					{
					setState(28);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stmts.add(((StatementContext)_localctx).statement);
					}
					}
					setState(33);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(34);
				match(T__2);

				        var statements = new ArrayList<Statement>();
				        for (var stmt : ((StatementContext)_localctx).stmts)
				            statements.add(stmt.n);

				        ((StatementContext)_localctx).n =  new Block(_localctx, statements);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				((StatementContext)_localctx).variableDeclaration = variableDeclaration();

				        ((StatementContext)_localctx).n =  ((StatementContext)_localctx).variableDeclaration.n;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				((StatementContext)_localctx).expression = expression(0);
				setState(40);
				match(T__0);

				        ((StatementContext)_localctx).n =  new ExpressionStatement(_localctx, ((StatementContext)_localctx).expression.n);
				    
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VarDeclarations n;
		public TypeContext type;
		public VariableDeclarationItemContext variableDeclarationItem;
		public List<VariableDeclarationItemContext> decs = new ArrayList<VariableDeclarationItemContext>();
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableDeclarationItemContext> variableDeclarationItem() {
			return getRuleContexts(VariableDeclarationItemContext.class);
		}
		public VariableDeclarationItemContext variableDeclarationItem(int i) {
			return getRuleContext(VariableDeclarationItemContext.class,i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((VariableDeclarationContext)_localctx).type = type();
			setState(46);
			((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
			((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(47);
				match(T__3);
				setState(48);
				((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
				((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__0);

			        var declarations = new ArrayList<DeclarationItem>();
			        for (var dec : ((VariableDeclarationContext)_localctx).decs)
			            declarations.add(dec.n);

			        ((VariableDeclarationContext)_localctx).n =  new VarDeclarations(_localctx, ((VariableDeclarationContext)_localctx).type.n, declarations);
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationItemContext extends ParserRuleContext {
		public DeclarationItem n;
		public Token NAME;
		public ExpressionContext expression;
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationItem; }
	}

	public final VariableDeclarationItemContext variableDeclarationItem() throws RecognitionException {
		VariableDeclarationItemContext _localctx = new VariableDeclarationItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclarationItem);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclaration(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);
				setState(60);
				match(T__4);
				setState(61);
				((VariableDeclarationItemContext)_localctx).expression = expression(0);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclarationInit(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null), ((VariableDeclarationItemContext)_localctx).expression.n);
				    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression n;
		public ExpressionContext expr;
		public ExpressionContext e;
		public ExpressionContext l;
		public ExpressionContext expression;
		public List<ExpressionContext> exprs = new ArrayList<ExpressionContext>();
		public Token INT;
		public Token DOUBLE;
		public Token BOOLEAN;
		public Token STRING;
		public Token NAME;
		public Token op;
		public TypeContext type;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniJavaParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(67);
				match(T__5);
				setState(68);
				match(T__6);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 260071104L) != 0) {
					{
					setState(69);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(70);
						match(T__3);
						setState(71);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(76);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(79);
				match(T__7);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new Print(_localctx, expressions);
				    
				}
				break;
			case 2:
				{
				setState(81);
				((ExpressionContext)_localctx).INT = match(INT);

				        ((ExpressionContext)_localctx).n =  new IntLiteral(_localctx, Integer.parseInt((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)));
				    
				}
				break;
			case 3:
				{
				setState(83);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);

				        ((ExpressionContext)_localctx).n =  new DoubleLiteral(_localctx, Double.parseDouble((((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null)));
				    
				}
				break;
			case 4:
				{
				setState(85);
				((ExpressionContext)_localctx).BOOLEAN = match(BOOLEAN);

				        ((ExpressionContext)_localctx).n =  new BooleanLiteral(_localctx, Boolean.parseBoolean((((ExpressionContext)_localctx).BOOLEAN!=null?((ExpressionContext)_localctx).BOOLEAN.getText():null)));
				    
				}
				break;
			case 5:
				{
				setState(87);
				((ExpressionContext)_localctx).STRING = match(STRING);

				        ((ExpressionContext)_localctx).n =  new StringLiteral(_localctx, (((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null));
				    
				}
				break;
			case 6:
				{
				setState(89);
				((ExpressionContext)_localctx).NAME = match(NAME);

				        ((ExpressionContext)_localctx).n =  new VariableAccess(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 7:
				{
				setState(91);
				match(T__6);
				setState(92);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(93);
				match(T__7);

				        ((ExpressionContext)_localctx).n =  ((ExpressionContext)_localctx).expression.n;
				    
				}
				break;
			case 8:
				{
				setState(96);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7680L) != 0) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				((ExpressionContext)_localctx).expression = expression(8);

				        if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("++") || (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("--"))
				            ((ExpressionContext)_localctx).n =  new PreIncrement(_localctx, new VariableAccess(_localctx, (((ExpressionContext)_localctx).expression!=null?_input.getText(((ExpressionContext)_localctx).expression.start,((ExpressionContext)_localctx).expression.stop):null)), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
				        else if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("-"))
				            ((ExpressionContext)_localctx).n =  new Negate(_localctx, ((ExpressionContext)_localctx).expression.n);
				        else if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+"))
				            ((ExpressionContext)_localctx).n =  ((ExpressionContext)_localctx).expression.n;
				    
				}
				break;
			case 9:
				{
				setState(100);
				match(T__6);
				setState(101);
				((ExpressionContext)_localctx).type = type();
				setState(102);
				match(T__7);
				setState(103);
				((ExpressionContext)_localctx).expression = expression(7);

				        ((ExpressionContext)_localctx).n =  new Cast(_localctx, ((ExpressionContext)_localctx).type.n, ((ExpressionContext)_localctx).expression.n);
				    
				}
				break;
			case 10:
				{
				setState(106);
				match(T__13);
				setState(107);
				((ExpressionContext)_localctx).NAME = match(NAME);
				setState(108);
				match(T__6);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 260071104L) != 0) {
					{
					setState(109);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(110);
						match(T__3);
						setState(111);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(119);
				match(T__7);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new ConstructorCall(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(124);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(125);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(4);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(129);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(3);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(134);
						match(T__4);
						setState(135);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(1);

						                  ((ExpressionContext)_localctx).n =  new Assignment(_localctx, ((ExpressionContext)_localctx).l.n, ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(139);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}

						                  ((ExpressionContext)_localctx).n =  new PostIncrement(_localctx, new VariableAccess(_localctx, (((ExpressionContext)_localctx).expr!=null?_input.getText(((ExpressionContext)_localctx).expr.start,((ExpressionContext)_localctx).expr.stop):null)), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(142);
						match(T__12);
						setState(143);
						((ExpressionContext)_localctx).NAME = match(NAME);

						                      ((ExpressionContext)_localctx).n =  new FieldAccess(_localctx, ((ExpressionContext)_localctx).e.n, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
						                  
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(146);
						match(T__12);
						setState(147);
						((ExpressionContext)_localctx).NAME = match(NAME);
						setState(148);
						match(T__6);
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 260071104L) != 0) {
							{
							setState(149);
							((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
							((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
							setState(154);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__3) {
								{
								{
								setState(150);
								match(T__3);
								setState(151);
								((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
								}
								}
								setState(156);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(159);
						match(T__7);

						                  var expressions = new ArrayList<Expression>();
						                  for (var expr : ((ExpressionContext)_localctx).exprs)
						                      expressions.add(expr.n);

						                  ((ExpressionContext)_localctx).n =  new MethodCall(_localctx, ((ExpressionContext)_localctx).e.n, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
						              
						}
						break;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeNode n;
		public Token NAME;
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__17);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Int);
				    
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(T__18);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Double);
				    
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(T__19);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Boolean);
				    
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				((TypeContext)_localctx).NAME = match(NAME);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, new ClassType((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null)));
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00b1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001\u0013\b\u0001\n\u0001\f\u0001\u0016"+
		"\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u001e\b\u0002\n\u0002\f\u0002!\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002,\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u00032\b\u0003\n\u0003\f\u00035\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005I\b\u0005\n\u0005\f\u0005L\t\u0005\u0003\u0005N\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005q\b\u0005\n\u0005\f\u0005t\t"+
		"\u0005\u0003\u0005v\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005z\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0099\b\u0005\n\u0005\f\u0005\u009c\t\u0005\u0003\u0005\u009e\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00a2\b\u0005\n\u0005\f\u0005\u00a5"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00af\b\u0006\u0001\u0006\u0000"+
		"\u0001\n\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0004\u0001\u0000\t"+
		"\f\u0001\u0000\u000f\u0011\u0001\u0000\u000b\f\u0001\u0000\t\n\u00c8\u0000"+
		"\u000e\u0001\u0000\u0000\u0000\u0002\u0014\u0001\u0000\u0000\u0000\u0004"+
		"+\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b@\u0001\u0000"+
		"\u0000\u0000\ny\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000\u0000\u0000"+
		"\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0010\u0005\u0000\u0000\u0001"+
		"\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0013\u0003\u0004\u0002\u0000"+
		"\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0016\u0001\u0000\u0000\u0000"+
		"\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000"+
		"\u0015\u0017\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0006\u0001\uffff\uffff\u0000\u0018\u0003\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0005\u0001\u0000\u0000\u001a,\u0006\u0002\uffff\uffff"+
		"\u0000\u001b\u001f\u0005\u0002\u0000\u0000\u001c\u001e\u0003\u0004\u0002"+
		"\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000"+
		"\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \""+
		"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0003"+
		"\u0000\u0000#,\u0006\u0002\uffff\uffff\u0000$%\u0003\u0006\u0003\u0000"+
		"%&\u0006\u0002\uffff\uffff\u0000&,\u0001\u0000\u0000\u0000\'(\u0003\n"+
		"\u0005\u0000()\u0005\u0001\u0000\u0000)*\u0006\u0002\uffff\uffff\u0000"+
		"*,\u0001\u0000\u0000\u0000+\u0019\u0001\u0000\u0000\u0000+\u001b\u0001"+
		"\u0000\u0000\u0000+$\u0001\u0000\u0000\u0000+\'\u0001\u0000\u0000\u0000"+
		",\u0005\u0001\u0000\u0000\u0000-.\u0003\f\u0006\u0000.3\u0003\b\u0004"+
		"\u0000/0\u0005\u0004\u0000\u000002\u0003\b\u0004\u00001/\u0001\u0000\u0000"+
		"\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005"+
		"\u0001\u0000\u000078\u0006\u0003\uffff\uffff\u00008\u0007\u0001\u0000"+
		"\u0000\u00009:\u0005\u001b\u0000\u0000:A\u0006\u0004\uffff\uffff\u0000"+
		";<\u0005\u001b\u0000\u0000<=\u0005\u0005\u0000\u0000=>\u0003\n\u0005\u0000"+
		">?\u0006\u0004\uffff\uffff\u0000?A\u0001\u0000\u0000\u0000@9\u0001\u0000"+
		"\u0000\u0000@;\u0001\u0000\u0000\u0000A\t\u0001\u0000\u0000\u0000BC\u0006"+
		"\u0005\uffff\uffff\u0000CD\u0005\u0006\u0000\u0000DM\u0005\u0007\u0000"+
		"\u0000EJ\u0003\n\u0005\u0000FG\u0005\u0004\u0000\u0000GI\u0003\n\u0005"+
		"\u0000HF\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001"+
		"\u0000\u0000\u0000ME\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OP\u0005\b\u0000\u0000Pz\u0006\u0005\uffff\uffff"+
		"\u0000QR\u0005\u0017\u0000\u0000Rz\u0006\u0005\uffff\uffff\u0000ST\u0005"+
		"\u0018\u0000\u0000Tz\u0006\u0005\uffff\uffff\u0000UV\u0005\u0019\u0000"+
		"\u0000Vz\u0006\u0005\uffff\uffff\u0000WX\u0005\u001a\u0000\u0000Xz\u0006"+
		"\u0005\uffff\uffff\u0000YZ\u0005\u001b\u0000\u0000Zz\u0006\u0005\uffff"+
		"\uffff\u0000[\\\u0005\u0007\u0000\u0000\\]\u0003\n\u0005\u0000]^\u0005"+
		"\b\u0000\u0000^_\u0006\u0005\uffff\uffff\u0000_z\u0001\u0000\u0000\u0000"+
		"`a\u0007\u0000\u0000\u0000ab\u0003\n\u0005\bbc\u0006\u0005\uffff\uffff"+
		"\u0000cz\u0001\u0000\u0000\u0000de\u0005\u0007\u0000\u0000ef\u0003\f\u0006"+
		"\u0000fg\u0005\b\u0000\u0000gh\u0003\n\u0005\u0007hi\u0006\u0005\uffff"+
		"\uffff\u0000iz\u0001\u0000\u0000\u0000jk\u0005\u000e\u0000\u0000kl\u0005"+
		"\u001b\u0000\u0000lu\u0005\u0007\u0000\u0000mr\u0003\n\u0005\u0000no\u0005"+
		"\u0004\u0000\u0000oq\u0003\n\u0005\u0000pn\u0001\u0000\u0000\u0000qt\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000um\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0005\b\u0000"+
		"\u0000xz\u0006\u0005\uffff\uffff\u0000yB\u0001\u0000\u0000\u0000yQ\u0001"+
		"\u0000\u0000\u0000yS\u0001\u0000\u0000\u0000yU\u0001\u0000\u0000\u0000"+
		"yW\u0001\u0000\u0000\u0000yY\u0001\u0000\u0000\u0000y[\u0001\u0000\u0000"+
		"\u0000y`\u0001\u0000\u0000\u0000yd\u0001\u0000\u0000\u0000yj\u0001\u0000"+
		"\u0000\u0000z\u00a3\u0001\u0000\u0000\u0000{|\n\u0003\u0000\u0000|}\u0007"+
		"\u0001\u0000\u0000}~\u0003\n\u0005\u0004~\u007f\u0006\u0005\uffff\uffff"+
		"\u0000\u007f\u00a2\u0001\u0000\u0000\u0000\u0080\u0081\n\u0002\u0000\u0000"+
		"\u0081\u0082\u0007\u0002\u0000\u0000\u0082\u0083\u0003\n\u0005\u0003\u0083"+
		"\u0084\u0006\u0005\uffff\uffff\u0000\u0084\u00a2\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\n\u0001\u0000\u0000\u0086\u0087\u0005\u0005\u0000\u0000\u0087"+
		"\u0088\u0003\n\u0005\u0001\u0088\u0089\u0006\u0005\uffff\uffff\u0000\u0089"+
		"\u00a2\u0001\u0000\u0000\u0000\u008a\u008b\n\t\u0000\u0000\u008b\u008c"+
		"\u0007\u0003\u0000\u0000\u008c\u00a2\u0006\u0005\uffff\uffff\u0000\u008d"+
		"\u008e\n\u0006\u0000\u0000\u008e\u008f\u0005\r\u0000\u0000\u008f\u0090"+
		"\u0005\u001b\u0000\u0000\u0090\u00a2\u0006\u0005\uffff\uffff\u0000\u0091"+
		"\u0092\n\u0005\u0000\u0000\u0092\u0093\u0005\r\u0000\u0000\u0093\u0094"+
		"\u0005\u001b\u0000\u0000\u0094\u009d\u0005\u0007\u0000\u0000\u0095\u009a"+
		"\u0003\n\u0005\u0000\u0096\u0097\u0005\u0004\u0000\u0000\u0097\u0099\u0003"+
		"\n\u0005\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000"+
		"\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009d\u0095\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\b\u0000"+
		"\u0000\u00a0\u00a2\u0006\u0005\uffff\uffff\u0000\u00a1{\u0001\u0000\u0000"+
		"\u0000\u00a1\u0080\u0001\u0000\u0000\u0000\u00a1\u0085\u0001\u0000\u0000"+
		"\u0000\u00a1\u008a\u0001\u0000\u0000\u0000\u00a1\u008d\u0001\u0000\u0000"+
		"\u0000\u00a1\u0091\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u000b\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0005\u0012\u0000\u0000\u00a7\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00a8\u00a9\u0005\u0013\u0000\u0000\u00a9\u00af\u0006\u0006"+
		"\uffff\uffff\u0000\u00aa\u00ab\u0005\u0014\u0000\u0000\u00ab\u00af\u0006"+
		"\u0006\uffff\uffff\u0000\u00ac\u00ad\u0005\u001b\u0000\u0000\u00ad\u00af"+
		"\u0006\u0006\uffff\uffff\u0000\u00ae\u00a6\u0001\u0000\u0000\u0000\u00ae"+
		"\u00a8\u0001\u0000\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00af\r\u0001\u0000\u0000\u0000\u000f\u0014"+
		"\u001f+3@JMruy\u009a\u009d\u00a1\u00a3\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}