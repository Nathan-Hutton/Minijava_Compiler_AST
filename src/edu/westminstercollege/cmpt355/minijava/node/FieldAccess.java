package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.text.html.Option;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public record FieldAccess(ParserRuleContext ctx, Expression expr, String fieldName) implements Expression {
    @Override
    public String getNodeDescription() {
        return String.format("FieldAccess: %s", fieldName);
    }

    @Override
    public List<? extends Node> children() {
        return List.of(expr);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);

        if (expr.getType(symbols) instanceof PrimitiveType)
            throw new SyntaxException(this, String.format("Primitive types cannot access fields: %s", expr));
        if (symbols.findField((ClassType) expr.getType(symbols), fieldName).isEmpty())
            throw new SyntaxException(this, String.format("%s class does not have a %s field", expr.getType(symbols), fieldName));
    }
    @Override
    public Type getType(SymbolTable symbols) {
        Type expr_type = expr.getType(symbols);

        if (expr_type instanceof ClassType class_type) {
            Optional<Field> field = symbols.findField(class_type, fieldName);
            if (field.isPresent()) {
                return field.get().type();
            }
        }
        return null;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        expr.generateCode(out, symbols);

        Type field_type = getType(symbols);
        Type expr_type = expr.getType(symbols);

        String source_class_name = symbols.findJavaClass(expr.getType(symbols).toString()).orElseThrow().getName();

        if (expr_type instanceof StaticType) {
            generateCodeStatic(out, symbols, field_type, source_class_name);
            return;
        }

        generateCodeNonstatic(out, symbols, field_type, source_class_name);
    }
    public void generateCodeStatic(PrintWriter out, SymbolTable symbols, Type field_type, String source_class_name)
    {
        if (field_type == PrimitiveType.Int)
            out.printf("getstatic %s/%s %s\n", source_class_name, fieldName, "I");
        else if (field_type == PrimitiveType.Double)
            out.printf("getstatic %s/%s %s\n", source_class_name, fieldName, "D");
        else if (field_type == PrimitiveType.Boolean)
            out.printf("getstatic %s/%s %s\n", source_class_name, fieldName, "Z");
        else if (field_type instanceof ClassType classType) {
            out.printf("getstatic %s/%s L%s;\n", source_class_name, fieldName, classType.toString().replace('.', '/'));
        }
    }
    public void generateCodeNonstatic(PrintWriter out, SymbolTable symbols, Type field_type, String source_class_name)
    {
        if (field_type == PrimitiveType.Int)
            out.printf("getfield %s/%s %s\n", source_class_name, fieldName, "I");
        else if (field_type == PrimitiveType.Double)
            out.printf("getfield %s/%s %s\n", source_class_name, fieldName, "D");
        else if (field_type == PrimitiveType.Boolean)
            out.printf("getfield %s/%s %s\n", source_class_name, fieldName, "Z");
        else if (field_type instanceof ClassType classType)
            out.printf("getfield %s/%s L%s;\n", source_class_name, fieldName, classType.toString().replace('.', '/'));
    }
}
