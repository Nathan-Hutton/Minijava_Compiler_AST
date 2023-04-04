package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record Print(ParserRuleContext ctx, List<Expression> expressions) implements Expression {
    @Override
    public List<? extends Node> children() {
        return expressions;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (Expression expr: expressions)
            expr.typecheck(symbols);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        for (Expression expr : expressions) {
            out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
            expr.generateCode(out, symbols);

            Type type = expr.getType(symbols);
            if (type == PrimitiveType.Double)
                out.println("invokevirtual java/io/PrintStream/print(D)V");
            else if (type == PrimitiveType.Int)
                out.println("invokevirtual java/io/PrintStream/print(I)V");
            else if (type == PrimitiveType.Boolean)
                out.println("invokevirtual java/io/PrintStream/print(Z)V");
            else if (type.equals(new ClassType("String")))
                out.println("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
            else if (type instanceof ClassType)
                out.printf("invokevirtual java/io/PrintStream/print(L%s;)V\n", expr.getType(symbols).toString());
        }

        out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
        out.println("invokevirtual java/io/PrintStream/println()V");
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return VoidType.Instance;
    }
}
