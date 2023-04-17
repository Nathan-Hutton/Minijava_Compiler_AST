package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record PostIncrement(ParserRuleContext ctx, VariableAccess variable, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(variable);
    }

    @Override
    public String getNodeDescription() {
        return String.format("PostIncrement: %s", op);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        variable.generateCode(out, symbols);

        Variable v = symbols.findVariable(variable.name()).orElseThrow();

        if (op.equals("++")) {
            if (variable.getType(symbols) == PrimitiveType.Double) {
                out.println("dup2");
                out.println("dconst_1");
                out.println("dadd");

                if (v.isField())
                    out.printf("putstatic %s/%s D\n", symbols.getCompilingClassName(), variable.name());
                else
                    out.printf("dstore %d\n", symbols.findVariable(variable.name()).orElseThrow().getIndex());

            } else if (variable.getType(symbols) == PrimitiveType.Int) {
                out.println("dup");
                out.println("iconst_1");
                out.println("iadd");

                if (v.isField())
                    out.printf("putstatic %s/%s I\n", symbols.getCompilingClassName(), variable.name());
                else
                    out.printf("istore %d\n", symbols.findVariable(variable.name()).orElseThrow().getIndex());
            }
        }
        else {
            if (variable.getType(symbols) == PrimitiveType.Double) {
                out.println("dup2");
                out.println("dconst_1");
                out.println("dsub");

                if (v.isField())
                    out.printf("putstatic %s/%s D\n", symbols.getCompilingClassName(), variable.name());
                else
                    out.printf("dstore %d\n", symbols.findVariable(variable.name()).orElseThrow().getIndex());

            } else if (variable.getType(symbols) == PrimitiveType.Int) {
                out.println("dup");
                out.println("iconst_1");
                out.println("isub");

                if (v.isField())
                    out.printf("putstatic %s/%s I\n", symbols.getCompilingClassName(), variable.name());
                else
                    out.printf("istore %d\n", symbols.findVariable(variable.name()).orElseThrow().getIndex());
            }
        }
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        variable.typecheck(symbols);

        Type variable_type = variable.getType(symbols);

        if (variable_type != PrimitiveType.Int && variable_type != PrimitiveType.Double)
            throw new SyntaxException(this, String.format("%s is not a numeric value", variable));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return variable.getType(symbols);
    }
}
