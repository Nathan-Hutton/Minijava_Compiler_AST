package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record FieldDefinition(ParserRuleContext ctx, TypeNode type, String name, Optional<Expression> expr) implements Statement {

    @Override
    public List<? extends Node> children() {
        if (expr.isPresent())
            return List.of(type, expr.orElseThrow());
        return List.of(type);
    }

    @Override
    public String getNodeDescription() {
        return "[FieldDefinition] " + name;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        if (expr.isPresent())
            expr.orElseThrow().typecheck(symbols);

        Optional<Variable> field = symbols.findVariable(name);

        if (field.isEmpty())
            throw new SyntaxException(this, String.format("Compiler tomfoolery occurred with field: %s", name));

        field.orElseThrow().setType(type.type());

        if (type.type() == PrimitiveType.Double) {
            field.orElseThrow().setIndex(2);
            return;
        }

        field.orElseThrow().setIndex(1);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        if (expr.isEmpty())
            return;

        expr.orElseThrow().generateCode(out, symbols);

        if (type.type() == PrimitiveType.Int || type.type() == PrimitiveType.Boolean)
            out.printf("putstatic %s/%s I\n", symbols.getCompilingClassName(), name);
        else if (type.type() == PrimitiveType.Double) {
            if (expr.orElseThrow().getType(symbols) == PrimitiveType.Int)
                out.println("i2d");

            out.printf("putstatic %s/%s D\n", symbols.getCompilingClassName(), name);
        }
        else {
            String class_name = symbols.classFromType(type.type()).orElseThrow().getName().replace('.', '/');
            out.printf("putstatic %s/%s L%s;\n", symbols.getCompilingClassName(), name, class_name);
        }
    }
}
