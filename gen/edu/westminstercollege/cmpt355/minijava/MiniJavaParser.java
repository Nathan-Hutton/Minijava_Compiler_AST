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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, RESERVED_WORD=33, WHITESPACE=34, INT=35, DOUBLE=36, BOOLEAN=37, 
		STRING=38, NAME=39, LINE_COMMENT=40, BLOCK_COMMENT=41;
	public static final int
		RULE_goal = 0, RULE_classNode = 1, RULE_methodDefinition = 2, RULE_mainMethod = 3, 
		RULE_block = 4, RULE_statement = 5, RULE_imports = 6, RULE_fieldDefinition = 7, 
		RULE_variableDeclaration = 8, RULE_variableDeclarationItem = 9, RULE_parameter = 10, 
		RULE_expression = 11, RULE_type = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"goal", "classNode", "methodDefinition", "mainMethod", "block", "statement", 
			"imports", "fieldDefinition", "variableDeclaration", "variableDeclarationItem", 
			"parameter", "expression", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "'}'", "'main'", "';'", "'return'", 
			"'while'", "'import'", "'.'", "'*'", "'='", "'_print'", "'this'", "'++'", 
			"'--'", "'+'", "'-'", "'new'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'int'", "'double'", "'boolean'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
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
			setState(26);
			((GoalContext)_localctx).classNode = classNode();
			setState(27);
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
		public MethodDefinitionContext methodDefinition;
		public List<MethodDefinitionContext> methods = new ArrayList<MethodDefinitionContext>();
		public MainMethodContext mainMethod;
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public MainMethodContext mainMethod() {
			return getRuleContext(MainMethodContext.class,0);
		}
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
		public List<MethodDefinitionContext> methodDefinition() {
			return getRuleContexts(MethodDefinitionContext.class);
		}
		public MethodDefinitionContext methodDefinition(int i) {
			return getRuleContext(MethodDefinitionContext.class,i);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(30);
				((ClassNodeContext)_localctx).imports = imports();
				((ClassNodeContext)_localctx).importz.add(((ClassNodeContext)_localctx).imports);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					((ClassNodeContext)_localctx).fieldDefinition = fieldDefinition();
					((ClassNodeContext)_localctx).fields.add(((ClassNodeContext)_localctx).fieldDefinition);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 557808877568L) != 0) {
				{
				{
				setState(42);
				((ClassNodeContext)_localctx).methodDefinition = methodDefinition();
				((ClassNodeContext)_localctx).methods.add(((ClassNodeContext)_localctx).methodDefinition);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(48);
				((ClassNodeContext)_localctx).mainMethod = mainMethod();
				}
			}

			setState(51);
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

			        if (((ClassNodeContext)_localctx).mainMethod != null)
			            ((ClassNodeContext)_localctx).n =  new ClassNode(_localctx, importStmts, fieldDefs, methodDefs, Optional.of(((ClassNodeContext)_localctx).mainMethod.n));
			        else
			            ((ClassNodeContext)_localctx).n =  new ClassNode(_localctx, importStmts, fieldDefs, methodDefs, Optional.empty());
			    
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
	public static class MethodDefinitionContext extends ParserRuleContext {
		public MethodDefinition n;
		public TypeContext type;
		public Token methodName;
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public BlockContext block;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_methodDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((MethodDefinitionContext)_localctx).type = type();
			setState(55);
			((MethodDefinitionContext)_localctx).methodName = match(NAME);
			setState(56);
			match(T__0);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 557808877568L) != 0) {
				{
				setState(57);
				((MethodDefinitionContext)_localctx).parameter = parameter();
				((MethodDefinitionContext)_localctx).params.add(((MethodDefinitionContext)_localctx).parameter);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(58);
					match(T__1);
					setState(59);
					((MethodDefinitionContext)_localctx).parameter = parameter();
					((MethodDefinitionContext)_localctx).params.add(((MethodDefinitionContext)_localctx).parameter);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
			match(T__2);
			setState(68);
			match(T__3);
			setState(69);
			((MethodDefinitionContext)_localctx).block = block();
			setState(70);
			match(T__4);

			        List<Parameter> paramNodes = new ArrayList<>();
			        for (var p : ((MethodDefinitionContext)_localctx).params)
			            paramNodes.add(p.n);

			        ((MethodDefinitionContext)_localctx).n =  new MethodDefinition(_localctx, ((MethodDefinitionContext)_localctx).type.n, (((MethodDefinitionContext)_localctx).methodName!=null?((MethodDefinitionContext)_localctx).methodName.getText():null), paramNodes, ((MethodDefinitionContext)_localctx).block.n);
			    
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
	public static class MainMethodContext extends ParserRuleContext {
		public MainMethod n;
		public BlockContext block;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMethod; }
	}

	public final MainMethodContext mainMethod() throws RecognitionException {
		MainMethodContext _localctx = new MainMethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__5);
			setState(74);
			match(T__0);
			setState(75);
			match(T__2);
			setState(76);
			match(T__3);
			setState(77);
			((MainMethodContext)_localctx).block = block();
			setState(78);
			match(T__4);

			        ((MainMethodContext)_localctx).n =  new MainMethod(_localctx, ((MainMethodContext)_localctx).block.n);
			    
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073207034770L) != 0) {
				{
				{
				setState(81);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).stmts.add(((BlockContext)_localctx).statement);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class StatementContext extends ParserRuleContext {
		public Statement n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public VariableDeclarationContext variableDeclaration;
		public ExpressionContext expression;
		public ExpressionContext e;
		public ExpressionContext cond;
		public StatementContext body;
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
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(T__6);

				        ((StatementContext)_localctx).n =  new EmptyStatement(_localctx);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(T__3);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073207034770L) != 0) {
					{
					{
					setState(92);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stmts.add(((StatementContext)_localctx).statement);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(T__4);

				        var statements = new ArrayList<Statement>();
				        for (var stmt : ((StatementContext)_localctx).stmts)
				            statements.add(stmt.n);

				        ((StatementContext)_localctx).n =  new Block(_localctx, statements);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				((StatementContext)_localctx).variableDeclaration = variableDeclaration();

				        ((StatementContext)_localctx).n =  ((StatementContext)_localctx).variableDeclaration.n;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				((StatementContext)_localctx).expression = expression(0);
				setState(104);
				match(T__6);

				        ((StatementContext)_localctx).n =  new ExpressionStatement(_localctx, ((StatementContext)_localctx).expression.n);
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				match(T__7);
				setState(108);
				match(T__6);

				        ((StatementContext)_localctx).n =  new Return(_localctx, Optional.empty());
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				match(T__7);
				setState(111);
				((StatementContext)_localctx).e = expression(0);
				setState(112);
				match(T__6);

				        ((StatementContext)_localctx).n =  new Return(_localctx, Optional.of(((StatementContext)_localctx).e.n));
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				match(T__8);
				setState(116);
				match(T__0);
				setState(117);
				((StatementContext)_localctx).cond = expression(0);
				setState(118);
				match(T__2);
				setState(119);
				((StatementContext)_localctx).body = statement();

				        ((StatementContext)_localctx).n =  new While(_localctx, ((StatementContext)_localctx).cond.n, ((StatementContext)_localctx).body.n);
				    
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
		enterRule(_localctx, 12, RULE_imports);
		int _la;
		try {
			int _alt;
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__9);
				setState(125);
				((ImportsContext)_localctx).NAME = match(NAME);
				((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(126);
						match(T__10);
						setState(127);
						((ImportsContext)_localctx).NAME = match(NAME);
						((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
						}
						} 
					}
					setState(132);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(133);
				match(T__10);
				setState(134);
				match(T__11);
				setState(135);
				match(T__6);

				        StringBuilder nameString = new StringBuilder();
				        nameString.append(((ImportsContext)_localctx).names.get(0).getText());
				        ((ImportsContext)_localctx).names.remove(0);

				        for (var name : ((ImportsContext)_localctx).names) {
				            nameString.append(".");
				            nameString.append(name.getText());
				        }

				        ((ImportsContext)_localctx).n =  new PackageImport(_localctx, nameString.toString());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__9);
				setState(138);
				((ImportsContext)_localctx).NAME = match(NAME);
				((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(139);
					match(T__10);
					setState(140);
					((ImportsContext)_localctx).NAME = match(NAME);
					((ImportsContext)_localctx).names.add(((ImportsContext)_localctx).NAME);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(T__6);

				        StringBuilder nameString = new StringBuilder();
				        nameString.append(((ImportsContext)_localctx).names.get(0).getText());
				        ((ImportsContext)_localctx).names.remove(0);

				        for (var name : ((ImportsContext)_localctx).names) {
				            nameString.append(".");
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
		enterRule(_localctx, 14, RULE_fieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((FieldDefinitionContext)_localctx).type = type();
			setState(151);
			((FieldDefinitionContext)_localctx).NAME = match(NAME);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(152);
				match(T__12);
				setState(153);
				((FieldDefinitionContext)_localctx).expr = expression(0);
				}
			}

			setState(156);
			match(T__6);

			        if (((FieldDefinitionContext)_localctx).expr != null)
			            ((FieldDefinitionContext)_localctx).n =  new FieldDefinition(_localctx, ((FieldDefinitionContext)_localctx).type.n, (((FieldDefinitionContext)_localctx).NAME!=null?((FieldDefinitionContext)_localctx).NAME.getText():null), Optional.of(((FieldDefinitionContext)_localctx).expr.n));
			        else
			            ((FieldDefinitionContext)_localctx).n =  new FieldDefinition(_localctx, ((FieldDefinitionContext)_localctx).type.n, (((FieldDefinitionContext)_localctx).NAME!=null?((FieldDefinitionContext)_localctx).NAME.getText():null), Optional.empty());
			    
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
		enterRule(_localctx, 16, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((VariableDeclarationContext)_localctx).type = type();
			setState(160);
			((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
			((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(161);
				match(T__1);
				setState(162);
				((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
				((VariableDeclarationContext)_localctx).decs.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			match(T__6);

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
		enterRule(_localctx, 18, RULE_variableDeclarationItem);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclaration(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);
				setState(174);
				match(T__12);
				setState(175);
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
		enterRule(_localctx, 20, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((ParameterContext)_localctx).type = type();
			setState(181);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(185);
				match(T__13);
				setState(186);
				match(T__0);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065153970178L) != 0) {
					{
					setState(187);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(188);
						match(T__1);
						setState(189);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(194);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(197);
				match(T__2);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new Print(_localctx, expressions);
				    
				}
				break;
			case 2:
				{
				setState(199);
				((ExpressionContext)_localctx).INT = match(INT);

				        ((ExpressionContext)_localctx).n =  new IntLiteral(_localctx, Integer.parseInt((((ExpressionContext)_localctx).INT!=null?((ExpressionContext)_localctx).INT.getText():null)));
				    
				}
				break;
			case 3:
				{
				setState(201);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);

				        ((ExpressionContext)_localctx).n =  new DoubleLiteral(_localctx, Double.parseDouble((((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null)));
				    
				}
				break;
			case 4:
				{
				setState(203);
				((ExpressionContext)_localctx).BOOLEAN = match(BOOLEAN);

				        ((ExpressionContext)_localctx).n =  new BooleanLiteral(_localctx, Boolean.parseBoolean((((ExpressionContext)_localctx).BOOLEAN!=null?((ExpressionContext)_localctx).BOOLEAN.getText():null)));
				    
				}
				break;
			case 5:
				{
				setState(205);
				match(T__14);

				        ((ExpressionContext)_localctx).n =  new This(_localctx);
				    
				}
				break;
			case 6:
				{
				setState(207);
				((ExpressionContext)_localctx).STRING = match(STRING);

				        ((ExpressionContext)_localctx).n =  new StringLiteral(_localctx, (((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null));
				    
				}
				break;
			case 7:
				{
				setState(209);
				((ExpressionContext)_localctx).NAME = match(NAME);

				        ((ExpressionContext)_localctx).n =  new VariableAccess(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 8:
				{
				setState(211);
				match(T__0);
				setState(212);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(213);
				match(T__2);

				        ((ExpressionContext)_localctx).n =  ((ExpressionContext)_localctx).expression.n;
				    
				}
				break;
			case 9:
				{
				setState(216);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				((ExpressionContext)_localctx).expression = expression(11);

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
				setState(220);
				((ExpressionContext)_localctx).NAME = match(NAME);
				setState(221);
				match(T__0);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065153970178L) != 0) {
					{
					setState(222);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(223);
						match(T__1);
						setState(224);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(229);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(232);
				match(T__2);

				            var expressions = new ArrayList<Expression>();
				            for (var expr : ((ExpressionContext)_localctx).exprs)
				                expressions.add(expr.n);

				            ((ExpressionContext)_localctx).n =  new MethodCall(_localctx, new This(_localctx), (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
				        
				}
				break;
			case 11:
				{
				setState(234);
				match(T__19);
				setState(235);
				((ExpressionContext)_localctx).NAME = match(NAME);
				setState(236);
				match(T__0);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065153970178L) != 0) {
					{
					setState(237);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(238);
						match(T__1);
						setState(239);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(244);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(247);
				match(T__2);

				        var expressions = new ArrayList<Expression>();
				        for (var expr : ((ExpressionContext)_localctx).exprs)
				            expressions.add(expr.n);

				        ((ExpressionContext)_localctx).n =  new ConstructorCall(_localctx, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null), expressions);
				    
				}
				break;
			case 12:
				{
				setState(249);
				match(T__0);
				setState(250);
				((ExpressionContext)_localctx).type = type();
				setState(251);
				match(T__2);
				setState(252);
				((ExpressionContext)_localctx).expression = expression(6);

				        ((ExpressionContext)_localctx).n =  new Cast(_localctx, ((ExpressionContext)_localctx).type.n, ((ExpressionContext)_localctx).expression.n);
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(258);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 6295552L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(6);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(263);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(5);

						                  ((ExpressionContext)_localctx).n =  new BinaryOp(_localctx, ((ExpressionContext)_localctx).l.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(269);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(4);

						                  ((ExpressionContext)_localctx).n =  new RelationalOp(_localctx, ((ExpressionContext)_localctx).l.n, ((ExpressionContext)_localctx).r.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(273);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(274);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(3);

						                  ((ExpressionContext)_localctx).n =  new RelationalOp(_localctx, ((ExpressionContext)_localctx).l.n, ((ExpressionContext)_localctx).r.n, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(278);
						match(T__12);
						setState(279);
						((ExpressionContext)_localctx).r = ((ExpressionContext)_localctx).expression = expression(1);

						                  ((ExpressionContext)_localctx).n =  new Assignment(_localctx, ((ExpressionContext)_localctx).l.n, ((ExpressionContext)_localctx).r.n);
						              
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(283);
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

						                  ((ExpressionContext)_localctx).n =  new PostIncrement(_localctx, new VariableAccess(_localctx, (((ExpressionContext)_localctx).expr!=null?_input.getText(((ExpressionContext)_localctx).expr.start,((ExpressionContext)_localctx).expr.stop):null)), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(286);
						match(T__10);
						setState(287);
						((ExpressionContext)_localctx).NAME = match(NAME);

						                      ((ExpressionContext)_localctx).n =  new FieldAccess(_localctx, ((ExpressionContext)_localctx).e.n, (((ExpressionContext)_localctx).NAME!=null?((ExpressionContext)_localctx).NAME.getText():null));
						                  
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(290);
						match(T__10);
						setState(291);
						((ExpressionContext)_localctx).NAME = match(NAME);
						setState(292);
						match(T__0);
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065153970178L) != 0) {
							{
							setState(293);
							((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
							((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
							setState(298);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(294);
								match(T__1);
								setState(295);
								((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).exprs.add(((ExpressionContext)_localctx).expression);
								}
								}
								setState(300);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(303);
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
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 24, RULE_type);
		try {
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(T__28);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Int);
				    
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(T__29);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Double);
				    
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				match(T__30);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, PrimitiveType.Boolean);
				    
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				match(T__31);

				        ((TypeContext)_localctx).n =  new TypeNode(_localctx, VoidType.Instance);
				    
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u0143\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001\u0001\u0005\u0001"+
		"&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001\u0001\u0005\u0001,\b\u0001\n"+
		"\u0001\f\u0001/\t\u0001\u0001\u0001\u0003\u00012\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002=\b\u0002\n\u0002\f\u0002@\t\u0002\u0003"+
		"\u0002B\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004S\b"+
		"\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005^\b\u0005\n\u0005\f\u0005a\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005{\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u0081\b\u0006\n\u0006\f\u0006\u0084\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u008e\b\u0006\n\u0006\f\u0006\u0091\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0095\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u009b\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a4\b\b\n\b\f\b\u00a7"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00b3\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00bf\b\u000b\n\u000b\f\u000b\u00c2\t\u000b\u0003\u000b\u00c4\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e2\b\u000b"+
		"\n\u000b\f\u000b\u00e5\t\u000b\u0003\u000b\u00e7\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00f1\b\u000b\n\u000b\f\u000b\u00f4\t\u000b\u0003\u000b"+
		"\u00f6\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0100\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0129\b\u000b\n\u000b\f\u000b\u012c"+
		"\t\u000b\u0003\u000b\u012e\b\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0132\b\u000b\n\u000b\f\u000b\u0135\t\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0141\b\f\u0001"+
		"\f\u0000\u0001\u0016\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0006\u0001\u0000\u0010\u0013\u0002\u0000\f\f"+
		"\u0015\u0016\u0001\u0000\u0012\u0013\u0001\u0000\u0017\u001a\u0001\u0000"+
		"\u001b\u001c\u0001\u0000\u0010\u0011\u0168\u0000\u001a\u0001\u0000\u0000"+
		"\u0000\u0002!\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006"+
		"I\u0001\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\nz\u0001\u0000\u0000"+
		"\u0000\f\u0094\u0001\u0000\u0000\u0000\u000e\u0096\u0001\u0000\u0000\u0000"+
		"\u0010\u009f\u0001\u0000\u0000\u0000\u0012\u00b2\u0001\u0000\u0000\u0000"+
		"\u0014\u00b4\u0001\u0000\u0000\u0000\u0016\u00ff\u0001\u0000\u0000\u0000"+
		"\u0018\u0140\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000"+
		"\u001b\u001c\u0005\u0000\u0000\u0001\u001c\u001d\u0006\u0000\uffff\uffff"+
		"\u0000\u001d\u0001\u0001\u0000\u0000\u0000\u001e \u0003\f\u0006\u0000"+
		"\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\'\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000$&\u0003\u000e\u0007\u0000%$\u0001\u0000"+
		"\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000(-\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		"*,\u0003\u0004\u0002\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.1\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000002\u0003\u0006\u0003\u000010\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"34\u0005\u0000\u0000\u000145\u0006\u0001\uffff\uffff\u00005\u0003\u0001"+
		"\u0000\u0000\u000067\u0003\u0018\f\u000078\u0005\'\u0000\u00008A\u0005"+
		"\u0001\u0000\u00009>\u0003\u0014\n\u0000:;\u0005\u0002\u0000\u0000;=\u0003"+
		"\u0014\n\u0000<:\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000A9\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CD\u0005\u0003\u0000\u0000DE\u0005\u0004"+
		"\u0000\u0000EF\u0003\b\u0004\u0000FG\u0005\u0005\u0000\u0000GH\u0006\u0002"+
		"\uffff\uffff\u0000H\u0005\u0001\u0000\u0000\u0000IJ\u0005\u0006\u0000"+
		"\u0000JK\u0005\u0001\u0000\u0000KL\u0005\u0003\u0000\u0000LM\u0005\u0004"+
		"\u0000\u0000MN\u0003\b\u0004\u0000NO\u0005\u0005\u0000\u0000OP\u0006\u0003"+
		"\uffff\uffff\u0000P\u0007\u0001\u0000\u0000\u0000QS\u0003\n\u0005\u0000"+
		"RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WX\u0006\u0004\uffff\uffff\u0000X\t\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0007\u0000\u0000Z{\u0006\u0005\uffff\uffff\u0000[_\u0005\u0004"+
		"\u0000\u0000\\^\u0003\n\u0005\u0000]\\\u0001\u0000\u0000\u0000^a\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0005\u0000"+
		"\u0000c{\u0006\u0005\uffff\uffff\u0000de\u0003\u0010\b\u0000ef\u0006\u0005"+
		"\uffff\uffff\u0000f{\u0001\u0000\u0000\u0000gh\u0003\u0016\u000b\u0000"+
		"hi\u0005\u0007\u0000\u0000ij\u0006\u0005\uffff\uffff\u0000j{\u0001\u0000"+
		"\u0000\u0000kl\u0005\b\u0000\u0000lm\u0005\u0007\u0000\u0000m{\u0006\u0005"+
		"\uffff\uffff\u0000no\u0005\b\u0000\u0000op\u0003\u0016\u000b\u0000pq\u0005"+
		"\u0007\u0000\u0000qr\u0006\u0005\uffff\uffff\u0000r{\u0001\u0000\u0000"+
		"\u0000st\u0005\t\u0000\u0000tu\u0005\u0001\u0000\u0000uv\u0003\u0016\u000b"+
		"\u0000vw\u0005\u0003\u0000\u0000wx\u0003\n\u0005\u0000xy\u0006\u0005\uffff"+
		"\uffff\u0000y{\u0001\u0000\u0000\u0000zY\u0001\u0000\u0000\u0000z[\u0001"+
		"\u0000\u0000\u0000zd\u0001\u0000\u0000\u0000zg\u0001\u0000\u0000\u0000"+
		"zk\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000\u0000zs\u0001\u0000\u0000"+
		"\u0000{\u000b\u0001\u0000\u0000\u0000|}\u0005\n\u0000\u0000}\u0082\u0005"+
		"\'\u0000\u0000~\u007f\u0005\u000b\u0000\u0000\u007f\u0081\u0005\'\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005\u000b\u0000\u0000\u0086\u0087\u0005\f\u0000\u0000\u0087"+
		"\u0088\u0005\u0007\u0000\u0000\u0088\u0095\u0006\u0006\uffff\uffff\u0000"+
		"\u0089\u008a\u0005\n\u0000\u0000\u008a\u008f\u0005\'\u0000\u0000\u008b"+
		"\u008c\u0005\u000b\u0000\u0000\u008c\u008e\u0005\'\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092"+
		"\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005\u0007\u0000\u0000\u0093\u0095\u0006\u0006\uffff\uffff\u0000\u0094"+
		"|\u0001\u0000\u0000\u0000\u0094\u0089\u0001\u0000\u0000\u0000\u0095\r"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0003\u0018\f\u0000\u0097\u009a\u0005"+
		"\'\u0000\u0000\u0098\u0099\u0005\r\u0000\u0000\u0099\u009b\u0003\u0016"+
		"\u000b\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0007"+
		"\u0000\u0000\u009d\u009e\u0006\u0007\uffff\uffff\u0000\u009e\u000f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0003\u0018\f\u0000\u00a0\u00a5\u0003\u0012"+
		"\t\u0000\u00a1\u00a2\u0005\u0002\u0000\u0000\u00a2\u00a4\u0003\u0012\t"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0005\u0007\u0000\u0000\u00a9\u00aa\u0006\b\uffff\uffff"+
		"\u0000\u00aa\u0011\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\'\u0000\u0000"+
		"\u00ac\u00b3\u0006\t\uffff\uffff\u0000\u00ad\u00ae\u0005\'\u0000\u0000"+
		"\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0003\u0016\u000b\u0000\u00b0"+
		"\u00b1\u0006\t\uffff\uffff\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000\u00b3"+
		"\u0013\u0001\u0000\u0000\u0000\u00b4\u00b5\u0003\u0018\f\u0000\u00b5\u00b6"+
		"\u0005\'\u0000\u0000\u00b6\u00b7\u0006\n\uffff\uffff\u0000\u00b7\u0015"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0006\u000b\uffff\uffff\u0000\u00b9"+
		"\u00ba\u0005\u000e\u0000\u0000\u00ba\u00c3\u0005\u0001\u0000\u0000\u00bb"+
		"\u00c0\u0003\u0016\u000b\u0000\u00bc\u00bd\u0005\u0002\u0000\u0000\u00bd"+
		"\u00bf\u0003\u0016\u000b\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c3\u00bb\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0003\u0000\u0000\u00c6\u0100\u0006\u000b\uffff\uffff\u0000"+
		"\u00c7\u00c8\u0005#\u0000\u0000\u00c8\u0100\u0006\u000b\uffff\uffff\u0000"+
		"\u00c9\u00ca\u0005$\u0000\u0000\u00ca\u0100\u0006\u000b\uffff\uffff\u0000"+
		"\u00cb\u00cc\u0005%\u0000\u0000\u00cc\u0100\u0006\u000b\uffff\uffff\u0000"+
		"\u00cd\u00ce\u0005\u000f\u0000\u0000\u00ce\u0100\u0006\u000b\uffff\uffff"+
		"\u0000\u00cf\u00d0\u0005&\u0000\u0000\u00d0\u0100\u0006\u000b\uffff\uffff"+
		"\u0000\u00d1\u00d2\u0005\'\u0000\u0000\u00d2\u0100\u0006\u000b\uffff\uffff"+
		"\u0000\u00d3\u00d4\u0005\u0001\u0000\u0000\u00d4\u00d5\u0003\u0016\u000b"+
		"\u0000\u00d5\u00d6\u0005\u0003\u0000\u0000\u00d6\u00d7\u0006\u000b\uffff"+
		"\uffff\u0000\u00d7\u0100\u0001\u0000\u0000\u0000\u00d8\u00d9\u0007\u0000"+
		"\u0000\u0000\u00d9\u00da\u0003\u0016\u000b\u000b\u00da\u00db\u0006\u000b"+
		"\uffff\uffff\u0000\u00db\u0100\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\'\u0000\u0000\u00dd\u00e6\u0005\u0001\u0000\u0000\u00de\u00e3\u0003\u0016"+
		"\u000b\u0000\u00df\u00e0\u0005\u0002\u0000\u0000\u00e0\u00e2\u0003\u0016"+
		"\u000b\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e6\u00de\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005\u0003"+
		"\u0000\u0000\u00e9\u0100\u0006\u000b\uffff\uffff\u0000\u00ea\u00eb\u0005"+
		"\u0014\u0000\u0000\u00eb\u00ec\u0005\'\u0000\u0000\u00ec\u00f5\u0005\u0001"+
		"\u0000\u0000\u00ed\u00f2\u0003\u0016\u000b\u0000\u00ee\u00ef\u0005\u0002"+
		"\u0000\u0000\u00ef\u00f1\u0003\u0016\u000b\u0000\u00f0\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0005\u0003\u0000\u0000\u00f8\u0100\u0006\u000b"+
		"\uffff\uffff\u0000\u00f9\u00fa\u0005\u0001\u0000\u0000\u00fa\u00fb\u0003"+
		"\u0018\f\u0000\u00fb\u00fc\u0005\u0003\u0000\u0000\u00fc\u00fd\u0003\u0016"+
		"\u000b\u0006\u00fd\u00fe\u0006\u000b\uffff\uffff\u0000\u00fe\u0100\u0001"+
		"\u0000\u0000\u0000\u00ff\u00b8\u0001\u0000\u0000\u0000\u00ff\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ff\u00c9\u0001\u0000\u0000\u0000\u00ff\u00cb\u0001"+
		"\u0000\u0000\u0000\u00ff\u00cd\u0001\u0000\u0000\u0000\u00ff\u00cf\u0001"+
		"\u0000\u0000\u0000\u00ff\u00d1\u0001\u0000\u0000\u0000\u00ff\u00d3\u0001"+
		"\u0000\u0000\u0000\u00ff\u00d8\u0001\u0000\u0000\u0000\u00ff\u00dc\u0001"+
		"\u0000\u0000\u0000\u00ff\u00ea\u0001\u0000\u0000\u0000\u00ff\u00f9\u0001"+
		"\u0000\u0000\u0000\u0100\u0133\u0001\u0000\u0000\u0000\u0101\u0102\n\u0005"+
		"\u0000\u0000\u0102\u0103\u0007\u0001\u0000\u0000\u0103\u0104\u0003\u0016"+
		"\u000b\u0006\u0104\u0105\u0006\u000b\uffff\uffff\u0000\u0105\u0132\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\n\u0004\u0000\u0000\u0107\u0108\u0007\u0002"+
		"\u0000\u0000\u0108\u0109\u0003\u0016\u000b\u0005\u0109\u010a\u0006\u000b"+
		"\uffff\uffff\u0000\u010a\u0132\u0001\u0000\u0000\u0000\u010b\u010c\n\u0003"+
		"\u0000\u0000\u010c\u010d\u0007\u0003\u0000\u0000\u010d\u010e\u0003\u0016"+
		"\u000b\u0004\u010e\u010f\u0006\u000b\uffff\uffff\u0000\u010f\u0132\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\n\u0002\u0000\u0000\u0111\u0112\u0007\u0004"+
		"\u0000\u0000\u0112\u0113\u0003\u0016\u000b\u0003\u0113\u0114\u0006\u000b"+
		"\uffff\uffff\u0000\u0114\u0132\u0001\u0000\u0000\u0000\u0115\u0116\n\u0001"+
		"\u0000\u0000\u0116\u0117\u0005\r\u0000\u0000\u0117\u0118\u0003\u0016\u000b"+
		"\u0001\u0118\u0119\u0006\u000b\uffff\uffff\u0000\u0119\u0132\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\n\f\u0000\u0000\u011b\u011c\u0007\u0005\u0000"+
		"\u0000\u011c\u0132\u0006\u000b\uffff\uffff\u0000\u011d\u011e\n\n\u0000"+
		"\u0000\u011e\u011f\u0005\u000b\u0000\u0000\u011f\u0120\u0005\'\u0000\u0000"+
		"\u0120\u0132\u0006\u000b\uffff\uffff\u0000\u0121\u0122\n\t\u0000\u0000"+
		"\u0122\u0123\u0005\u000b\u0000\u0000\u0123\u0124\u0005\'\u0000\u0000\u0124"+
		"\u012d\u0005\u0001\u0000\u0000\u0125\u012a\u0003\u0016\u000b\u0000\u0126"+
		"\u0127\u0005\u0002\u0000\u0000\u0127\u0129\u0003\u0016\u000b\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000\u012a"+
		"\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b"+
		"\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d"+
		"\u0125\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u0003\u0000\u0000\u0130"+
		"\u0132\u0006\u000b\uffff\uffff\u0000\u0131\u0101\u0001\u0000\u0000\u0000"+
		"\u0131\u0106\u0001\u0000\u0000\u0000\u0131\u010b\u0001\u0000\u0000\u0000"+
		"\u0131\u0110\u0001\u0000\u0000\u0000\u0131\u0115\u0001\u0000\u0000\u0000"+
		"\u0131\u011a\u0001\u0000\u0000\u0000\u0131\u011d\u0001\u0000\u0000\u0000"+
		"\u0131\u0121\u0001\u0000\u0000\u0000\u0132\u0135\u0001\u0000\u0000\u0000"+
		"\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000"+
		"\u0134\u0017\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000"+
		"\u0136\u0137\u0005\u001d\u0000\u0000\u0137\u0141\u0006\f\uffff\uffff\u0000"+
		"\u0138\u0139\u0005\u001e\u0000\u0000\u0139\u0141\u0006\f\uffff\uffff\u0000"+
		"\u013a\u013b\u0005\u001f\u0000\u0000\u013b\u0141\u0006\f\uffff\uffff\u0000"+
		"\u013c\u013d\u0005 \u0000\u0000\u013d\u0141\u0006\f\uffff\uffff\u0000"+
		"\u013e\u013f\u0005\'\u0000\u0000\u013f\u0141\u0006\f\uffff\uffff\u0000"+
		"\u0140\u0136\u0001\u0000\u0000\u0000\u0140\u0138\u0001\u0000\u0000\u0000"+
		"\u0140\u013a\u0001\u0000\u0000\u0000\u0140\u013c\u0001\u0000\u0000\u0000"+
		"\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0019\u0001\u0000\u0000\u0000"+
		"\u001b!\'-1>AT_z\u0082\u008f\u0094\u009a\u00a5\u00b2\u00c0\u00c3\u00e3"+
		"\u00e6\u00f2\u00f5\u00ff\u012a\u012d\u0131\u0133\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}