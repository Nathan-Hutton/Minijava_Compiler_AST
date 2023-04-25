package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record RelationalOp(ParserRuleContext ctx, Expression left, Expression right, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(left, right);
    }

    @Override
    public String getNodeDescription() {
        return String.format("RelationalOp[op=%s]", op);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        // <, <=, >, >= : numeric only, mixed types (int/double) allowed
        //      maybe later: allow with strings
        // ==, != : any (non-void) types, both must be i same "category"
        //          (numeric, boolean, or object)
        left.typecheck(symbols);
        right.typecheck(symbols);

        var leftType = left.getType(symbols);
        var rightType = right.getType(symbols);

        boolean bothNumeric = isNumeric(leftType) && isNumeric(rightType);
        boolean bothBoolean = leftType == PrimitiveType.Boolean && rightType == PrimitiveType.Boolean;
        boolean bothObjects = leftType instanceof ClassType && rightType instanceof ClassType;
        SyntaxException ex = new SyntaxException(this, String.format("Incompatible types: %s %s %s", leftType, op, rightType));

        if (List.of("<", "<=", ">", ">=").contains(op)) {
            if (!bothNumeric)
                 throw ex;
        } else if (!(bothNumeric || bothBoolean || bothObjects))
            throw ex;
    }
    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        var leftType = left.getType(symbols);
        var rightType = right.getType(symbols);

        boolean bothNumeric = isNumeric(leftType) && isNumeric(rightType);
        boolean bothBoolean = leftType == PrimitiveType.Boolean && rightType == PrimitiveType.Boolean;
        boolean bothObjects = leftType instanceof ClassType && rightType instanceof ClassType;

        // Possibilities:
        //      </> <=/>= / ==/ != (ints)        if_icmp<op>
        //      </> <=/>= / ==/ !=(doubles)      dcmpg
        //      ==/!= (booleans)                 if_icmp<op>
        //      ==/!= (objects)                  if_acmp<op>
        // Goal: end up with 0 (false) or 1 (true) on the stack

        String instrOp = switch (op) {
            case "==" -> "eq";
            case "!=" -> "ne";
            case "<"  -> "lt";
            case ">"  -> "gt";
            case ">="  -> "ge";
            case "<="  -> "le";
            default -> throw new RuntimeException("Internal compiler error");
        };

        String trueLabel = symbols.newLabel("trueCase");
        String endLabel = symbols.newLabel("falseCase");

        if (leftType == PrimitiveType.Int && rightType == PrimitiveType.Int) {
            /*  if (!(left op right))
                    iconst_0 // push false
                    goto end

                else
                trueCase:
                    iconst_1 // push true

                end:
            */
            left.generateCode(out, symbols);
            right.generateCode(out, symbols);
            out.printf("if_icmp%s %s\n", instrOp, trueLabel);

            // false case
            out.println("iconst_0");
            out.printf("goto %s\n", endLabel);

            // true case
            out.printf("%s:\n", trueLabel);
            out.println("iconst_1");

            out.printf("%s:\n", endLabel);
        } else
            throw new RuntimeException("Unimplemented");
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return PrimitiveType.Boolean;
    }

    private boolean isNumeric(Type type) {
        return (type == PrimitiveType.Int || type == PrimitiveType.Double);
    }
}
