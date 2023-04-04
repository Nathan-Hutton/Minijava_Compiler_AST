package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record BinaryOp(ParserRuleContext ctx, Expression expr1, String operator, Expression expr2) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expr1, expr2);
    }

    @Override
    public String getNodeDescription() {
        return String.format("BinaryOp: %s", operator);
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        Type left_type = expr1.getType(symbols);
        Type right_type = expr2.getType(symbols);

        // Number adding
        if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Double) {
            expr1.generateCode(out, symbols);
            out.println("i2d");
            expr2.generateCode(out, symbols);
        }
        else if (left_type == PrimitiveType.Double && right_type == PrimitiveType.Int) {
            expr1.generateCode(out, symbols);
            expr2.generateCode(out, symbols);
            out.println("i2d");
        }

        // Concatenation
        else if (left_type.equals(new ClassType("String")) && right_type.equals(new ClassType("String"))) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type.equals(new ClassType("String")) && right_type instanceof ClassType) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("ldc_w \"" + right_type.toString() + "@" + expr2.hashCode() + "\"");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type instanceof ClassType && right_type.equals(new ClassType("String"))) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            out.println("ldc_w \"" + left_type.toString() + "@" + expr1.hashCode() + "\"");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type == PrimitiveType.Int && right_type.equals(new ClassType("String"))) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokestatic java/lang/Integer/toString(I)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type.equals(new ClassType("String")) && right_type == PrimitiveType.Int) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokestatic java/lang/Integer/toString(I)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type == PrimitiveType.Double && right_type.equals(new ClassType("String"))) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokestatic java/lang/Double/toString(D)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type.equals(new ClassType("String")) && right_type == PrimitiveType.Double) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokestatic java/lang/Double/toString(D)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type.equals(new ClassType("String")) && right_type == PrimitiveType.Boolean) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokestatic java/lang/Boolean/toString(Z)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else if (left_type == PrimitiveType.Boolean && right_type.equals(new ClassType("String"))) {
            out.println("new java/lang/StringBuilder");
            out.println("dup");
            out.println("invokespecial java/lang/StringBuilder/<init>()V");
            expr1.generateCode(out, symbols);
            out.println("invokestatic java/lang/Boolean/toString(Z)Ljava/lang/String;");
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            expr2.generateCode(out, symbols);
            out.println("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            out.println("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
            return;
        }
        else {
            expr1.generateCode(out, symbols);
            expr2.generateCode(out, symbols);
        }

        switch (operator) {
            case "+" -> generateCodeAdd(out, left_type, right_type);
            case "-" -> generateCodeSub(out, left_type, right_type);
            case "*" -> generateCodeMul(out, left_type, right_type);
            case "/" -> generateCodeDiv(out, left_type, right_type);
            case "%" -> generateCodeMod(out, left_type, right_type);
        }
    }

    public void generateCodeAdd(PrintWriter out, Type left_type, Type right_type) {
        if (left_type == PrimitiveType.Double && right_type == PrimitiveType.Double)
            out.println("dadd");
        else if (left_type == PrimitiveType.Double && right_type == PrimitiveType.Int)
            out.println("dadd");
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Double)
            out.println("dadd");
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Int)
            out.println("iadd");

    }
    public void generateCodeSub(PrintWriter out, Type left_type, Type right_type) {
        if (left_type == PrimitiveType.Double || right_type == PrimitiveType.Double)
            out.println("dsub");
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Int)
            out.println("isub");
    }
    public void generateCodeMul(PrintWriter out, Type left_type, Type right_type) {
        if (left_type == PrimitiveType.Double || right_type == PrimitiveType.Double)
            out.println("dmul");
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Int)
            out.println("imul");
    }
    public void generateCodeDiv(PrintWriter out, Type left_type, Type right_type) {
        if (left_type == PrimitiveType.Double || right_type == PrimitiveType.Double)
            out.println("ddiv");
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Int)
            out.println("idiv");
    }
    public void generateCodeMod(PrintWriter out, Type left_type, Type right_type) {
        if (left_type == PrimitiveType.Double || right_type == PrimitiveType.Double) {
            out.println("drem");
        }
        else if (left_type == PrimitiveType.Int && right_type == PrimitiveType.Int) {
            out.println("irem");
        }
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr1.typecheck(symbols);
        expr2.typecheck(symbols);

        Type leftType = expr1.getType(symbols);
        Type rightType = expr2.getType(symbols);

        // Doing stuff with numbers
        if ((leftType == PrimitiveType.Int || leftType == PrimitiveType.Double ) && (rightType == PrimitiveType.Int ||
                rightType == PrimitiveType.Double))
            return;

        if (!operator.equals("+"))
            throw new SyntaxException(this, String.format("Can't use %s with %s and %s", operator, leftType, rightType));

        // Adding numbers with numbers, strings with strings, and numbers with strings
        if (leftType.equals(new ClassType("String")) || rightType.equals(new ClassType("String")))
            return;

        throw new SyntaxException(this, String.format("Can't use %s with %s and %s", operator, leftType, rightType));
    }

    @Override
    public Type getType(SymbolTable symbols) {
        Type leftType = expr1.getType(symbols);
        Type rightType = expr2.getType(symbols);

        if (leftType.equals(new ClassType("String")) || rightType.equals(new ClassType("String")))
            return new ClassType("String");

        if (leftType.equals(PrimitiveType.Double) || rightType.equals(PrimitiveType.Double))
            return PrimitiveType.Double;

        if (operator.equals("*") || operator.equals("/"))
            if (leftType.equals(PrimitiveType.Int) && rightType.equals(PrimitiveType.Int))
                return PrimitiveType.Int;
            else
                return PrimitiveType.Double;

        if (operator.equals("+"))
            if (leftType.equals(new ClassType("String")) && (rightType == PrimitiveType.Int ||
                    rightType.equals(new ClassType("String")) || rightType.equals(PrimitiveType.Double)))
                return new ClassType("String");

            else if (rightType.equals(new ClassType("String")) && (leftType == PrimitiveType.Int ||
                    leftType.equals(new ClassType("String")) || leftType.equals(PrimitiveType.Double)))
                return new ClassType("String");

        return PrimitiveType.Int;
    }
}