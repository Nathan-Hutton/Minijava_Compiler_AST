package edu.westminstercollege.cmpt355.minijava;

import edu.westminstercollege.cmpt355.minijava.node.*;
import jas.Var;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Compiler {

    // Commented out until we have our AST nodes defined...
    private SymbolTable symbols = new SymbolTable(SymbolTable.Level.Class);
    private PrintWriter out;
    private final ClassNode classNode;
    private final String className;

    public Compiler(ClassNode classNode, String className) {
        this.classNode = classNode;
        this.className = className;
        symbols.setCompilingClassName(className);
    }

    public void compile(Path outputDir) throws IOException, SyntaxException {
        Path asmFilePath = outputDir.resolve(className + ".j");
        try (var out = new PrintWriter(Files.newBufferedWriter(asmFilePath))) {
            this.out = out;
            resolveSymbols(this.classNode, symbols);
            this.classNode.typecheck(symbols);

            out.printf(".class public %s\n", className);
            out.printf(".super java/lang/Object\n");
            out.println();
            out.println(".field private static in Ljava/util/Scanner;");
            out.println();
            out.printf("""
                    .method static <clinit>()V
                    .limit stack 3
                    .limit locals 0
                    new java/util/Scanner
                    dup
                    getstatic java/lang/System/in Ljava/io/InputStream;
                    invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V
                    putstatic %s/in Ljava/util/Scanner;
                    return
                    .end method
                    
                    """, className);
            out.printf(".method public static main([Ljava/lang/String;)V\n");
            out.printf(".limit stack 100\n");
            out.printf(".limit locals %d\n", symbols.getVariableCount()); // + 1 because of args
            out.println();

            classNode.generateCode(out, symbols);

            // Generate code for program here 🙂
            // Generate code for each statement of the program
//            for(Statement statement : block.statements())
//                generateCode(statement);

            // program.statements().forEach(this::generateCode);

            out.printf("return\n");
            out.printf(".end method\n");
        }
    }

    // Make sure that all symbols (in this case, names of variables) make sense,
    // i.e. we should not be using the value of a variable before we have assigned
    // to it (Eval does not have declarations).
    private void resolveSymbols(Node node, SymbolTable symbols) throws SyntaxException{
        switch(node){
            case FieldDefinition(ParserRuleContext ctx, TypeNode type, String name, Optional<Expression> expr) -> {
                if (symbols.findField(new ClassType(className), name).isPresent()) {
                    System.out.println(1);
                    throw new SyntaxException(node, String.format("%s already exists", name));
                }
                symbols.registerField(type.type(), name);

                for (Node child : node.children())
                    resolveSymbols(child, symbols);
            }
            case MethodDefinition(ParserRuleContext ctx, TypeNode returnType, String name, List<Parameter> parameters, Block block, SymbolTable symbolTable) -> {
                List<Type> paramTypes = new ArrayList<>();
                for(Parameter p : parameters)
                    paramTypes.add(p.type().type());

                symbols.registerMethod(name, paramTypes, returnType.type());
                symbolTable.setParent(symbols);

                for (Node child : node.children())
                    resolveSymbols(child, symbolTable);
            }
            case MainMethod(ParserRuleContext ctx, Block block, SymbolTable symbolTable) -> {
                symbols.registerMethod("Main", List.of(), VoidType.Instance);
                symbolTable.setParent(symbols);

                for (Node child : node.children())
                    resolveSymbols(child, symbolTable);
            }
            case Parameter(ParserRuleContext ctx, TypeNode type, String name) -> {
                symbols.registerVariable(type.type(), name);
                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
            case Block(ParserRuleContext ctx, List<Statement> statements, SymbolTable symbolTable) -> {
                symbolTable.setParent(symbols);

                for (var child : node.children())
                    resolveSymbols(child, symbolTable);
            }
            case VarDeclarations(ParserRuleContext ctx, TypeNode type, List<DeclarationItem> declarations) -> {
                for (var child : node.children()) {
                    resolveSymbols(child, symbols);
                    if (child instanceof VarDeclaration)
                        symbols.registerVariable(type.type(), ((VarDeclaration) child).name());
                    if (child instanceof VarDeclarationInit)
                        symbols.registerVariable(type.type(), ((VarDeclarationInit) child).name());
                }
            }
            case VarDeclaration(ParserRuleContext ctx, String name) -> {
                if (symbols.findVariable(name).isPresent())
                    if (!(symbols.findVariable(name).orElseThrow().isField()))
                        throw new SyntaxException(node, String.format("%s already exists", name));

                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
            case VarDeclarationInit(ParserRuleContext ctx, String name, Expression expression) -> {
                if (symbols.findVariable(name).isPresent())
                    if (!(symbols.findVariable(name).orElseThrow().isField()))
                        throw new SyntaxException(node, String.format("%s already exists", name));

                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
            case VariableAccess(ParserRuleContext ctx, String name) -> {
                if (symbols.findVariable(name).isPresent())
                    return;
                if (symbols.findJavaClass(name).isEmpty())
                    throw new SyntaxException(node, String.format("Variable used before declaration: %s", name));

                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
            case Assignment(ParserRuleContext ctx, Expression variable, Expression c)  -> {
                if (!(variable instanceof VariableAccess))
                    throw new SyntaxException(node, "Left hand side of the assignment is not a variable");

                String name = ((VariableAccess) variable).name();
                if (symbols.findVariable(name).isEmpty())
                    // No variable found
                    throw new SyntaxException(node, String.format("Variable has not been declared: %s", name));

                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
            default -> {
                for (var child : node.children())
                    resolveSymbols(child, symbols);
            }
        }

    }
}
