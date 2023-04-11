// Generated from java-escape by ANTLR 4.11.1
package edu.westminstercollege.cmpt355.minijava;

import edu.westminstercollege.cmpt355.minijava.node.*;
import edu.westminstercollege.cmpt355.minijava.Type;
import java.util.Optional;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, RESERVED_WORD=24, 
		WHITESPACE=25, INT=26, DOUBLE=27, BOOLEAN=28, STRING=29, NAME=30, LINE_COMMENT=31, 
		BLOCK_COMMENT=32;
	public static final int
		RULE_goal = 0, RULE_classNode = 1, RULE_block = 2, RULE_method = 3, RULE_statement = 4, 
		RULE_imports = 5, RULE_fieldDefinition = 6, RULE_variableDeclaration = 7, 
		RULE_variableDeclarationItem = 8, RULE_parameter = 9, RULE_expression = 10, 
		RULE_type = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"goal", "classNode", "block", "method", "statement", "imports", "fieldDefinition", 
			"variableDeclaration", "variableDeclarationItem", "parameter", "expression", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "';'", "'{'", "'}'", "'return'", "'import'", 
			"'.'", "'*'", "'='", "'_print'", "'this'", "'++'", "'--'", "'+'", "'-'", 
			"'new'", "'/'", "'%'", "'int'", "'double'", "'boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"RESERVED_WORD", "WHITESPACE", "INT", "DOUBLE", "BOOLEAN", "STRING", 
			"NAME", "LINE_COMMENT", "BLOCK_COMMENT"
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
		public ClassNode n;
		public ClassNodeContext classNode;
		public ClassNodeContext classNode() {
			return getRuleContext(ClassNodeContext.class,0);
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
			setState(24);
			((GoalContext)_localctx).classNode = classNode();
			setState(25);
			match(EOF);

			        ((GoalContext)_localctx).n =  ((GoalContext)_localctx).classNode.n;
			    
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
	public static class ClassNodeContext extends ParserRuleContext {
		public ClassNode n;
		public ImportsContext imports;
		public List<ImportsContext> importz = new ArrayList<ImportsContext>();
		public FieldDefinitionContext fieldDefinition;
		public List<FieldDefinitionContext> fields = new ArrayList<FieldDefinitionContext>();
		public MethodContext method;
		public List<MethodContext> methods = new ArrayList<MethodContext>();
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public List<FieldDefinitionContext> fieldDefinition() {
			return getRuleContexts(FieldDefinitionContext.class);
		}
		public FieldDefinitionContext fieldDefinition(int i) {
			return getRuleContext(FieldDefinitionContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classNode; }
	}

	public final ClassNodeContext classNode() throws RecognitionException {
		ClassNodeContext _localctx = new ClassNodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classNode);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(28);
				((ClassNodeContext)_localctx).imports = imports();
				((ClassNodeContext)_localctx).importz.add(((ClassNodeContext)_localctx).imports);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					((ClassNodeContext)_localctx).fieldDefinition = fieldDefinition();
					((ClassNodeContext)_localctx).fields.add(((ClassNodeContext)_localctx).fieldDefinition);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1088421888L) != 0) {
				{
				{
				setState(40);
				((ClassNodeContext)_localctx).method = method();
				((ClassNodeContext)_localctx).methods.add(((ClassNodeContext)_localctx).method);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);

			        var importStmts = new ArrayList<Import>();
			        var fieldDefs = new ArrayList<FieldDefinition>();
			        var methodDefs = new ArrayList<MethodDefinition>();

			        for (var imp : ((ClassNodeContext)_localctx).importz)
			            importStmts.add(imp.n);
			        for (var field : ((ClassNodeContext)_localctx).fields)
			            fieldDefs.add(field.n);
			        for (var method : ((ClassNodeContext)_localctx).methods)
			            methodDefs.add(method.n);

			        ((ClassNodeContext)_localctx).n =  new ClassNode(_localctx, importStmts, fieldDefs, methodDefs);
			    
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
	public static class BlockContext extends ParserRuleContext {
		public Block n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					((BlockContext)_localctx).statement = statement();
					((BlockContext)_localctx).stmts.add(((BlockContext)_localctx).statement);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}

			        var statements = new ArrayList<Statement>();
			        for (var stmt : ((BlockContext)_localctx).stmts)
			            statements.add(stmt.n);

			        ((BlockContext)_localctx).n =  new Block(_localctx, statements);
			    
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
	public static class MethodContext extends ParserRuleContext {
		public MethodDefinition n;
		public TypeContext type;
		public Token NAME;
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public List<ParameterContext> param = new ArrayList<ParameterContext>();
		public BlockContext block;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((MethodContext)_localctx).type = type();
			setState(58);
			((MethodContext)_localctx).NAME = match(NAME);
			setState(59);
			match(T__0);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1088421888L) != 0) {
				{
				setState(60);
				((MethodContext)_localctx).parameter = parameter();
				((MethodContext)_localctx).params.add(((MethodContext)_localctx).parameter);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(61);
					match(T__1);
					setState(62);
					((MethodContext)_localctx).parameter = parameter();
					((MethodContext)_localctx).param.add(((MethodContext)_localctx).parameter);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(70);
			match(T__2);
			setState(71);
			((MethodContext)_localctx).block = block();

			        var arguments = new ArrayList<Parameter>();
			        for (var p : ((MethodContext)_localctx).params)
			            arguments.add(p.n);

			        ((MethodContext)_localctx).n =  new MethodDefinition(_localctx, ((MethodContext)_localctx).type.n, (((MethodContext)_localctx).NAME!=null?((MethodContext)_localctx).NAME.getText():null), arguments, ((MethodContext)_localctx).block.n);
			    
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
		public ExpressionContext e;
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
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__3);

				        ((StatementContext)_localctx).n =  new EmptyStatement(_localctx);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__4);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2095575218L) != 0) {
					{
					{
					setState(77);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stmts.add(((StatementContext)_localctx).statement);
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(T__5);

				        var statements = new ArrayList<Statement>();
				        for (var stmt : ((StatementContext)_localctx).stmts)
				            statements.add(stmt.n);

				        ((StatementContext)_localctx).n =  new Block(_localctx, statements);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				((StatementContext)_localctx).variableDeclaration = variableDeclaration();

				        ((StatementContext)_localctx).n =  ((StatementContext)_localctx).variableDeclaration.n;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				match(T__6);
				setState(89);
				match(T__3);

				        ((StatementContext)_localctx).n =  new Return(_localctx, Optional.empty());
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				match(T__6);
				setState(92);
				((StatementContext)_localctx).e = expression(0);
				setState(93);
				match(T__3);

				        ((StatementContext)_localctx).n =  new Return(_localctx, Optional.of(((StatementContext)_localctx).e.n));
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				((StatementContext)_localctx).expression = expression(0);
				setState(97);
				match(T__3);

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
	public static class ImportsContext extends ParserRuleContext {
		public Import n;
		public Token NAME;
		public List<Token> names = new ArrayList<Token>();
		public List<TerminalNode> NAME() { return getTokens(MiniJavaParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MiniJavaParser.NAME, i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_imports);
		int _la;
		try {
			int _alt;
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(T__7);
				setState(103);
				((ImportsContext)_localctx).NAME = match(NAME);
				((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(104);
						match(T__8);
						setState(105);
						((ImportsContext)_localctx).NAME = match(NAME);
						((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(111);
				match(T__8);
				setState(112);
				match(T__9);
				setState(113);
				match(T__3);

				        StringBuilder nameString = new StringBuilder();
				        nameString.append(((ImportsContext)_localctx).names.get(0));
				        ((ImportsContext)_localctx).names.remove(0);

				        for (var name : ((ImportsContext)_localctx).names) {
				            nameString.append(name.getText());
				        }

				        ((ImportsContext)_localctx).n =  new PackageImport(_localctx, nameString.toString());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(T__7);
				setState(116);
				((ImportsContext)_localctx).NAME = match(NAME);
				((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(117);
					match(T__8);
					setState(118);
					((ImportsContext)_localctx).NAME = match(NAME);
					((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(T__3);

				        StringBuilder nameString = new StringBuilder();
				        nameString.append(((ImportsContext)_localctx).names.get(0));
				        ((ImportsContext)_localctx).names.remove(0);

				        for (var name : ((ImportsContext)_localctx).names) {
				            nameString.append(name.getText());
				        }

				        ((ImportsContext)_localctx).n =  new ClassImport(_localctx, nameString.toString());
				    
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
	public static class FieldDefinitionContext extends ParserRuleContext {
		public FieldDefinition n;
		public TypeContext type;
		public Token NAME;
		public ExpressionContext expr;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinition; }
	}

	public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
		FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((FieldDefinitionContext)_localctx).type = type();
			setState(129);
			((FieldDefinitionContext)_localctx).NAME = match(NAME);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(130);
				match(T__10);
				setState(131);
				((FieldDefinitionContext)_localctx).expr = expression(0);
				}
			}

			setState(134);
			match(T__3);

			        ((FieldDefinitionContext)_localctx).n =  new FieldDefinition(_localctx, ((FieldDefinitionContext)_localctx).type.n, (((FieldDefinitionContext)_localctx).NAME!=null?((FieldDefinitionContext)_localctx).NAME.getText():null), Optional.of(((FieldDefinitionContext)_localctx).expr.n));
			    
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
		enterRule(_localctx, 14, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((VariableDeclarationContext)_localctx).type = type();
			setState(138);
			((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
			((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(139);
				match(T__1);
				setState(140);
				((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
				((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(T__3);

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
		enterRule(_localctx, 16, RULE_variableDeclarationItem);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclaration(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);
				setState(152);
				match(T__10);
				setState(153);
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
	public static class ParameterContext extends ParserRuleContext {
		public Parameter n;
		public TypeContext type;
		public Token NAME;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((ParameterContext)_localctx).type = type();
			setState(159);
			((ParameterContext)_localctx).NAME = match(NAME);

			        ((ParameterContext)_localctx).n =  new Parameter(_localctx, ((ParameterContext)_localctx).type.n, (((ParameterContext)_localctx).NAME!=null?((ParameterContext)_localctx).NAME.getText():null));
			    
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(163);
				match(T__11);
				setState(164);
				match(T__0);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2080894978L) != 0) {
					{
					setState(165);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(166);
						match(T__1);
						setState(167);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(172);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(175);
				match(T__2);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new Print(_localctx, expressions);
				    
				}
				break;
			case 2:
				{
				setState(177);
				((ExpressionContext)_localctx).INT = match(INT);

				        ((ExpressionContext)_localctx).n =  new IntLiteral(_localctx, Integer.parseInt((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)));
				    
				}
				break;
			case 3:
				{
				setState(179);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);

				        ((ExpressionContext)_localctx).n =  new DoubleLiteral(_localctx, Double.parseDouble((((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null)));
				    
				}
				break;
			case 4:
				{
				setState(181);
				((ExpressionContext)_localctx).BOOLEAN = match(BOOLEAN);

				        ((ExpressionContext)_localctx).n =  new BooleanLiteral(_localctx, Boolean.parseBoolean((((ExpressionContext)_localctx).BOOLEAN!=null?((ExpressionContext)_localctx).BOOLEAN.getText():null)));
				    
				}
				break;
			case 5:
				{
				setState(183);
				((ExpressionContext)_localctx).STRING = match(STRING);

				        ((ExpressionContext)_localctx).n =  new StringLiteral(_localctx, (((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null));
				    
				}
				break;
			case 6:
				{
				setState(185);
				((ExpressionContext)_localctx).NAME = match(NAME);

				        ((ExpressionContext)_localctx).n =  new VariableAccess(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 7:
				{
				setState(187);
				match(T__12);

				        ((ExpressionContext)_localctx).n =  new This(_localctx);
				    
				}
				break;
			case 8:
				{
				setState(189);
				match(T__0);
				setState(190);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(191);
				match(T__2);

				        ((ExpressionContext)_localctx).n =  ((ExpressionContext)_localctx).expression.n;
				    
				}
				break;
			case 9:
				{
				setState(194);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(195);
				((ExpressionContext)_localctx).expression = expression(8);

				        if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("++") || (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("--"))
				            ((ExpressionContext)_localctx).n =  new PreIncrement(_localctx, new VariableAccess(_localctx, (((ExpressionContext)_localctx).expression!=null?_input.getText(((ExpressionContext)_localctx).expression.start,((ExpressionContext)_localctx).expression.stop):null)), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
				        else if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("-"))
				            ((ExpressionContext)_localctx).n =  new Negate(_localctx, ((ExpressionContext)_localctx).expression.n);
				        else if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+"))
				            ((ExpressionContext)_localctx).n =  ((ExpressionContext)_localctx).expression.n;
				    
				}
				break;
			case 10:
				{
				setState(198);
				match(T__17);
				setState(199);
				((ExpressionContext)_localctx).NAME = match(NAME);
				setState(200);
				match(T__0);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2080894978L) != 0) {
					{
					setState(201);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(202);
						match(T__1);
						setState(203);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(211);
				match(T__2);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new ConstructorCall(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
				    
				}
				break;
			case 11:
				{
				setState(213);
				match(T__0);
				setState(214);
				((ExpressionContext)_localctx).type = type();
				setState(215);
				match(T__2);
				setState(216);
				((ExpressionContext)_localctx).expression = expression(4);

				        ((ExpressionContext)_localctx).n =  new Cast(_localctx, ((ExpressionContext)_localctx).type.n, ((ExpressionContext)_localctx).expression.n);
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(222);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1573888L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(4);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(3);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(232);
						match(T__10);
						setState(233);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(1);

						                  ((ExpressionContext)_localctx).n =  new Assignment(_localctx, ((ExpressionContext)_localctx).l.n, ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(237);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
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
						setState(239);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(240);
						match(T__8);
						setState(241);
						((ExpressionContext)_localctx).NAME = match(NAME);

						                      ((ExpressionContext)_localctx).n =  new FieldAccess(_localctx, ((ExpressionContext)_localctx).e.n, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
						                  
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(244);
						match(T__8);
						setState(245);
						((ExpressionContext)_localctx).NAME = match(NAME);
						setState(246);
						match(T__0);
						setState(255);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2080894978L) != 0) {
							{
							setState(247);
							((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
							((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
							setState(252);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(248);
								match(T__1);
								setState(249);
								((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
								}
								}
								setState(254);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(257);
						match(T__2);

						                  var expressions = new ArrayList<Expression>();
						                  for (var expr : ((ExpressionContext)_localctx).exprs)
						                      expressions.add(expr.n);

						                  ((ExpressionContext)_localctx).n =  new MethodCall(_localctx, ((ExpressionContext)_localctx).e.n, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
						              
						}
						break;
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__20);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Int);
				    
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(T__21);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Double);
				    
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				match(T__22);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Boolean);
				    
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
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
		case 10:
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
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001e"+
		"\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0001\u0005\u0001$\b\u0001\n\u0001"+
		"\f\u0001\'\t\u0001\u0001\u0001\u0005\u0001*\b\u0001\n\u0001\f\u0001-\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u00023\b"+
		"\u0002\n\u0002\f\u00026\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003@\b"+
		"\u0003\n\u0003\f\u0003C\t\u0003\u0003\u0003E\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004O\b\u0004\n\u0004\f\u0004R\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004e\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005k\b\u0005\n\u0005"+
		"\f\u0005n\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005x\b\u0005\n\u0005"+
		"\f\u0005{\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u007f\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0085\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u008e\b\u0007\n\u0007\f\u0007\u0091\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u009d\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a9\b\n\n\n\f\n\u00ac\t\n"+
		"\u0003\n\u00ae\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cd\b\n\n\n\f\n\u00d0\t\n"+
		"\u0003\n\u00d2\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00dc\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00fb\b\n\n\n\f\n\u00fe"+
		"\t\n\u0003\n\u0100\b\n\u0001\n\u0001\n\u0005\n\u0104\b\n\n\n\f\n\u0107"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0111\b\u000b\u0001\u000b\u0000"+
		"\u0001\u0014\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0004\u0001\u0000\u000e\u0011\u0002\u0000\n\n\u0013\u0014\u0001"+
		"\u0000\u0010\u0011\u0001\u0000\u000e\u000f\u0131\u0000\u0018\u0001\u0000"+
		"\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u00044\u0001\u0000\u0000"+
		"\u0000\u00069\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000\u0000\n~\u0001"+
		"\u0000\u0000\u0000\f\u0080\u0001\u0000\u0000\u0000\u000e\u0089\u0001\u0000"+
		"\u0000\u0000\u0010\u009c\u0001\u0000\u0000\u0000\u0012\u009e\u0001\u0000"+
		"\u0000\u0000\u0014\u00db\u0001\u0000\u0000\u0000\u0016\u0110\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0005\u0000"+
		"\u0000\u0001\u001a\u001b\u0006\u0000\uffff\uffff\u0000\u001b\u0001\u0001"+
		"\u0000\u0000\u0000\u001c\u001e\u0003\n\u0005\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000\u001f \u0001\u0000\u0000\u0000 %\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000\"$\u0003\f\u0006\u0000#\"\u0001\u0000\u0000\u0000"+
		"$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&+\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0003\u0006"+
		"\u0003\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/0\u0006\u0001\uffff"+
		"\uffff\u00000\u0003\u0001\u0000\u0000\u000013\u0003\b\u0004\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000078\u0006\u0002\uffff\uffff\u00008\u0005\u0001\u0000\u0000\u0000"+
		"9:\u0003\u0016\u000b\u0000:;\u0005\u001e\u0000\u0000;D\u0005\u0001\u0000"+
		"\u0000<A\u0003\u0012\t\u0000=>\u0005\u0002\u0000\u0000>@\u0003\u0012\t"+
		"\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000D<\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FG\u0005\u0003\u0000\u0000GH\u0003\u0004\u0002"+
		"\u0000HI\u0006\u0003\uffff\uffff\u0000I\u0007\u0001\u0000\u0000\u0000"+
		"JK\u0005\u0004\u0000\u0000Ke\u0006\u0004\uffff\uffff\u0000LP\u0005\u0005"+
		"\u0000\u0000MO\u0003\b\u0004\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0005\u0006\u0000\u0000"+
		"Te\u0006\u0004\uffff\uffff\u0000UV\u0003\u000e\u0007\u0000VW\u0006\u0004"+
		"\uffff\uffff\u0000We\u0001\u0000\u0000\u0000XY\u0005\u0007\u0000\u0000"+
		"YZ\u0005\u0004\u0000\u0000Ze\u0006\u0004\uffff\uffff\u0000[\\\u0005\u0007"+
		"\u0000\u0000\\]\u0003\u0014\n\u0000]^\u0005\u0004\u0000\u0000^_\u0006"+
		"\u0004\uffff\uffff\u0000_e\u0001\u0000\u0000\u0000`a\u0003\u0014\n\u0000"+
		"ab\u0005\u0004\u0000\u0000bc\u0006\u0004\uffff\uffff\u0000ce\u0001\u0000"+
		"\u0000\u0000dJ\u0001\u0000\u0000\u0000dL\u0001\u0000\u0000\u0000dU\u0001"+
		"\u0000\u0000\u0000dX\u0001\u0000\u0000\u0000d[\u0001\u0000\u0000\u0000"+
		"d`\u0001\u0000\u0000\u0000e\t\u0001\u0000\u0000\u0000fg\u0005\b\u0000"+
		"\u0000gl\u0005\u001e\u0000\u0000hi\u0005\t\u0000\u0000ik\u0005\u001e\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000op\u0005\t\u0000\u0000pq\u0005\n\u0000\u0000qr\u0005"+
		"\u0004\u0000\u0000r\u007f\u0006\u0005\uffff\uffff\u0000st\u0005\b\u0000"+
		"\u0000ty\u0005\u001e\u0000\u0000uv\u0005\t\u0000\u0000vx\u0005\u001e\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0005\u0004\u0000\u0000}\u007f\u0006\u0005\uffff"+
		"\uffff\u0000~f\u0001\u0000\u0000\u0000~s\u0001\u0000\u0000\u0000\u007f"+
		"\u000b\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081"+
		"\u0084\u0005\u001e\u0000\u0000\u0082\u0083\u0005\u000b\u0000\u0000\u0083"+
		"\u0085\u0003\u0014\n\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005\u0004\u0000\u0000\u0087\u0088\u0006\u0006\uffff\uffff\u0000\u0088"+
		"\r\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u0016\u000b\u0000\u008a\u008f"+
		"\u0003\u0010\b\u0000\u008b\u008c\u0005\u0002\u0000\u0000\u008c\u008e\u0003"+
		"\u0010\b\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000"+
		"\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\u0004\u0000\u0000\u0093\u0094\u0006\u0007"+
		"\uffff\uffff\u0000\u0094\u000f\u0001\u0000\u0000\u0000\u0095\u0096\u0005"+
		"\u001e\u0000\u0000\u0096\u009d\u0006\b\uffff\uffff\u0000\u0097\u0098\u0005"+
		"\u001e\u0000\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a\u0003"+
		"\u0014\n\u0000\u009a\u009b\u0006\b\uffff\uffff\u0000\u009b\u009d\u0001"+
		"\u0000\u0000\u0000\u009c\u0095\u0001\u0000\u0000\u0000\u009c\u0097\u0001"+
		"\u0000\u0000\u0000\u009d\u0011\u0001\u0000\u0000\u0000\u009e\u009f\u0003"+
		"\u0016\u000b\u0000\u009f\u00a0\u0005\u001e\u0000\u0000\u00a0\u00a1\u0006"+
		"\t\uffff\uffff\u0000\u00a1\u0013\u0001\u0000\u0000\u0000\u00a2\u00a3\u0006"+
		"\n\uffff\uffff\u0000\u00a3\u00a4\u0005\f\u0000\u0000\u00a4\u00ad\u0005"+
		"\u0001\u0000\u0000\u00a5\u00aa\u0003\u0014\n\u0000\u00a6\u00a7\u0005\u0002"+
		"\u0000\u0000\u00a7\u00a9\u0003\u0014\n\u0000\u00a8\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00a5\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\u0003\u0000\u0000\u00b0\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00b1\u00b2\u0005\u001a\u0000\u0000\u00b2\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00b3\u00b4\u0005\u001b\u0000\u0000\u00b4\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00b5\u00b6\u0005\u001c\u0000\u0000\u00b6\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00b7\u00b8\u0005\u001d\u0000\u0000\u00b8\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00b9\u00ba\u0005\u001e\u0000\u0000\u00ba\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00bb\u00bc\u0005\r\u0000\u0000\u00bc\u00dc\u0006\n\uffff\uffff"+
		"\u0000\u00bd\u00be\u0005\u0001\u0000\u0000\u00be\u00bf\u0003\u0014\n\u0000"+
		"\u00bf\u00c0\u0005\u0003\u0000\u0000\u00c0\u00c1\u0006\n\uffff\uffff\u0000"+
		"\u00c1\u00dc\u0001\u0000\u0000\u0000\u00c2\u00c3\u0007\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0003\u0014\n\b\u00c4\u00c5\u0006\n\uffff\uffff\u0000\u00c5"+
		"\u00dc\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0012\u0000\u0000\u00c7"+
		"\u00c8\u0005\u001e\u0000\u0000\u00c8\u00d1\u0005\u0001\u0000\u0000\u00c9"+
		"\u00ce\u0003\u0014\n\u0000\u00ca\u00cb\u0005\u0002\u0000\u0000\u00cb\u00cd"+
		"\u0003\u0014\n\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00c9\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"\u0003\u0000\u0000\u00d4\u00dc\u0006\n\uffff\uffff\u0000\u00d5\u00d6\u0005"+
		"\u0001\u0000\u0000\u00d6\u00d7\u0003\u0016\u000b\u0000\u00d7\u00d8\u0005"+
		"\u0003\u0000\u0000\u00d8\u00d9\u0003\u0014\n\u0004\u00d9\u00da\u0006\n"+
		"\uffff\uffff\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00a2\u0001"+
		"\u0000\u0000\u0000\u00db\u00b1\u0001\u0000\u0000\u0000\u00db\u00b3\u0001"+
		"\u0000\u0000\u0000\u00db\u00b5\u0001\u0000\u0000\u0000\u00db\u00b7\u0001"+
		"\u0000\u0000\u0000\u00db\u00b9\u0001\u0000\u0000\u0000\u00db\u00bb\u0001"+
		"\u0000\u0000\u0000\u00db\u00bd\u0001\u0000\u0000\u0000\u00db\u00c2\u0001"+
		"\u0000\u0000\u0000\u00db\u00c6\u0001\u0000\u0000\u0000\u00db\u00d5\u0001"+
		"\u0000\u0000\u0000\u00dc\u0105\u0001\u0000\u0000\u0000\u00dd\u00de\n\u0003"+
		"\u0000\u0000\u00de\u00df\u0007\u0001\u0000\u0000\u00df\u00e0\u0003\u0014"+
		"\n\u0004\u00e0\u00e1\u0006\n\uffff\uffff\u0000\u00e1\u0104\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\n\u0002\u0000\u0000\u00e3\u00e4\u0007\u0002\u0000"+
		"\u0000\u00e4\u00e5\u0003\u0014\n\u0003\u00e5\u00e6\u0006\n\uffff\uffff"+
		"\u0000\u00e6\u0104\u0001\u0000\u0000\u0000\u00e7\u00e8\n\u0001\u0000\u0000"+
		"\u00e8\u00e9\u0005\u000b\u0000\u0000\u00e9\u00ea\u0003\u0014\n\u0001\u00ea"+
		"\u00eb\u0006\n\uffff\uffff\u0000\u00eb\u0104\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\n\t\u0000\u0000\u00ed\u00ee\u0007\u0003\u0000\u0000\u00ee\u0104"+
		"\u0006\n\uffff\uffff\u0000\u00ef\u00f0\n\u0007\u0000\u0000\u00f0\u00f1"+
		"\u0005\t\u0000\u0000\u00f1\u00f2\u0005\u001e\u0000\u0000\u00f2\u0104\u0006"+
		"\n\uffff\uffff\u0000\u00f3\u00f4\n\u0006\u0000\u0000\u00f4\u00f5\u0005"+
		"\t\u0000\u0000\u00f5\u00f6\u0005\u001e\u0000\u0000\u00f6\u00ff\u0005\u0001"+
		"\u0000\u0000\u00f7\u00fc\u0003\u0014\n\u0000\u00f8\u00f9\u0005\u0002\u0000"+
		"\u0000\u00f9\u00fb\u0003\u0014\n\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000"+
		"\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u00f7\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0005\u0003\u0000\u0000\u0102\u0104\u0006\n\uffff\uffff\u0000"+
		"\u0103\u00dd\u0001\u0000\u0000\u0000\u0103\u00e2\u0001\u0000\u0000\u0000"+
		"\u0103\u00e7\u0001\u0000\u0000\u0000\u0103\u00ec\u0001\u0000\u0000\u0000"+
		"\u0103\u00ef\u0001\u0000\u0000\u0000\u0103\u00f3\u0001\u0000\u0000\u0000"+
		"\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0015\u0001\u0000\u0000\u0000"+
		"\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0015\u0000\u0000"+
		"\u0109\u0111\u0006\u000b\uffff\uffff\u0000\u010a\u010b\u0005\u0016\u0000"+
		"\u0000\u010b\u0111\u0006\u000b\uffff\uffff\u0000\u010c\u010d\u0005\u0017"+
		"\u0000\u0000\u010d\u0111\u0006\u000b\uffff\uffff\u0000\u010e\u010f\u0005"+
		"\u001e\u0000\u0000\u010f\u0111\u0006\u000b\uffff\uffff\u0000\u0110\u0108"+
		"\u0001\u0000\u0000\u0000\u0110\u010a\u0001\u0000\u0000\u0000\u0110\u010c"+
		"\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0017"+
		"\u0001\u0000\u0000\u0000\u0018\u001f%+4ADPdly~\u0084\u008f\u009c\u00aa"+
		"\u00ad\u00ce\u00d1\u00db\u00fc\u00ff\u0103\u0105\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}