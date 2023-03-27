package edu.westminstercollege.cmpt355.minijava;

import edu.westminstercollege.cmpt355.minijava.node.*;
import jas.Var;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Compiler {

    // Commented out until we have our AST nodes defined...
    private SymbolTable symbols = new SymbolTable();
    private PrintWriter out;
    private final Block block;
    private final String className;

    public Compiler(Block block, String className) {
        this.block = block;
        this.className = className;
        symbols.allocateLocalVariable(1);
    }

    public void compile(Path outputDir) throws IOException, SyntaxException {
        Path asmFilePath = outputDir.resolve(className + ".j");
        try (var out = new PrintWriter(Files.newBufferedWriter(asmFilePath))) {
            this.out = out;
            resolveSymbols(block);
            this.block.typecheck(symbols);

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

            block.generateCode(out, symbols);

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
    private void resolveSymbols(Block block) throws SyntaxException {
        AST.postOrder(block, node -> {
            switch (node) {
                case VarDeclaration(ParserRuleContext ctx, String name) -> {
                    if (symbols.findVariable(name).isPresent())
                        throw new SyntaxException(node, String.format("%s already exists", name));
                    else
                        symbols.registerVariable(name);
                }
                case VarDeclarationInit(ParserRuleContext ctx, String name, Expression expression) -> {
                    if (symbols.findVariable(name).isPresent())
                        throw new SyntaxException(node, String.format("%s already exists", name));
                    else
                        symbols.registerVariable(name);
                }
                case VariableAccess(ParserRuleContext ctx, String name) -> {
                    if (symbols.findVariable(name).isEmpty())
                        // No variable found
                        throw new SyntaxException(node, String.format("Variable used before declaration: %s", name));
                }
                case Assignment(ParserRuleContext ctx, Expression variable, Expression c)  -> {
                    if (!(variable instanceof VariableAccess)) {
                        throw new SyntaxException(node, "Left hand side of the assignment is not a variable");
                    }
                    String name = ((VariableAccess) variable).name();
                    if (symbols.findVariable(name).isEmpty())
                        // No variable found
                        throw new SyntaxException(node, String.format("Variable has not been declared: %s", name));
                }
                default -> {}
            }
        });
    }

//    private void generateCode(Statement statement) {
//        switch (statement) {
//            case Print(List<PrintArgument> args) -> {
//                // Print each argument individually (using generateCode(PrintArgument))
//                // then do a println
//                for (var arg : args)
//                    generateCode(arg);
//                //aggs.forEach(this::generateCode);
//                out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
//                out.println("invokevirtual java/io/PrintStream/println()V");
//            }
//            case Assignment(String varName, Expression value) -> {
//                Variable var = symbols.findVariable(varName).get();
//                generateCode(value); // get the value to be assigned on top of the stack
//                out.printf("dstore %d\n", var.getIndex());
//            }
//            // Don't need default since we've handled all the cases in the sealed interface
//        }
//    }
//
//    private void generateCode(PrintArgument argument) {
//        switch (argument) {
//            case Expression e ->  {
//                out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
//                generateCode(e);
//                out.println("invokevirtual java/io/PrintStream/println(D)V");
//            }
//            case StringArgument(String text) -> {
//                out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
//                out.printf("ldc %s\n", text);
//                out.println("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
//            }
//            default ->
//                    throw new RuntimeException(String.format("Unimplemented: %s", argument.getNodeDescription()));
//        }
//    }
//
//    private void generateCode(Expression expr) {
//        switch (expr) {
//            case Literal(String text) -> {
//                out.printf("ldc2_w %f\n", Double.parseDouble(text));
//            }
//            case Add(Expression left, Expression right) -> {
//                generateCode(left);
//                generateCode(right);
//                out.println("dadd");
//            }
//            case Subtract(Expression left, Expression right) -> {
//                generateCode(left);
//                generateCode(right);
//                out.println("dsub");
//            }
//            case Multiply(Expression left, Expression right) -> {
//                generateCode(left);
//                generateCode(right);
//                out.println("dmul");
//            }
//            case Divide(Expression left, Expression right) -> {
//                generateCode(left);
//                generateCode(right);
//                out.println("ddiv");
//            }
//            case Power(Expression left, Expression right) -> {
//                generateCode(left);
//                generateCode(right);
//                out.println("invokestatic java/lang/Math/pow(DD)D");
//            }
//            case SquareRoot(Expression child) -> {
//                generateCode(child);
//                out.println("invokestatic java/lang/Math/sqrt(D)D");
//            }
//            case Negate(Expression child) -> {
//                generateCode(child);
//                out.println("dneg");
//            }
//            case VariableAccess(String variableName) -> {
//                Variable v = symbols.findVariable(variableName).get();
//                out.printf("dload %d\n", v.getIndex());
//            }
//            case Input(List<PrintArgument> args) -> {
//                // Print out the arguments
//                for (var arg : args)
//                    generateCode(arg);
//
//                // Read a double value from the user
//                // Load the value of "in" (the static Scanner variable)
//                out.printf("getstatic %s/in Ljava/util/Scanner;\n", className);
//                // Call the nextDouble() method
//                out.println("invokevirtual java/util/Scanner/nextDouble()D");
//            }
//            default ->
//                    throw new RuntimeException(String.format("Unimplemented: %s", expr.getNodeDescription()));
//        }
//    }

    //
}
