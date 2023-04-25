package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public record While(ParserRuleContext ctx, Expression condition, Statement body) implements Statement {
    @Override
    public List<? extends Node> children() {
        return List.of(condition, body);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        condition.typecheck(symbols);
        body.typecheck(symbols);

        if (condition.getType(symbols) != PrimitiveType.Boolean)
            throw new SyntaxException(this, String.format("while condition must be boolean: %s", condition));
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        String loopStartLabel = symbols.newLabel("loop_start");
        String loopEndLabel = symbols.newLabel("loop_end");

        out.printf("%s:\n", loopStartLabel);
        condition.generateCode(out, symbols);
        // My condition is boolean, so the top of the stack is either true (1) or false(0)
        // If it's true (1), I should continue executing the body;      [no branch]
        // Uf it's false (0), I should jump to the end of the loop.     [branch]
        out.printf("ifeq %s\n", loopEndLabel);

        body.generateCode(out, symbols);

        // Return to the top of the loop to check the condition again
        out.printf("goto %s\n", loopStartLabel);

        //Point to jump to when the condition fails
        out.printf("%s:\n", loopEndLabel);
    }
}
