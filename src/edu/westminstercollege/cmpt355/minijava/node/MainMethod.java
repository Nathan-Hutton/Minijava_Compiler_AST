package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.PrintWriter;
import java.util.List;

public record MainMethod(ParserRuleContext ctx, Block block, SymbolTable symbolTable) implements Node {
    public MainMethod(ParserRuleContext ctx, Block block) {
        this(ctx, block, new SymbolTable(SymbolTable.Level.Method));
    }
    @Override
    public String getNodeDescription() {
        return "main";
    }

    @Override
    public List<? extends Node> children() {
        return List.of(block);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        block.typecheck(symbolTable);
        symbolTable.allocateLocalVariable(1);
    }
    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        // minijava main
        out.println(".method public main()V");
        out.printf(".limit stack 100\n");
        out.printf(".limit locals %d\n", symbolTable.getVariableCount() * 2 + 1); // + 1 because of args
        block.generateCode(out, symbolTable);
        out.println("return");
        out.println(".end method\n");

//        // public static void main(String args[])
//        out.printf(".method public static main([Ljava/lang/String;)V\n");
//        out.printf(".limit stack 100\n");
//        out.printf(".limit locals %d\n", symbolTable.getVariableCount() + 1); // + 1 because of args
//        out.printf("invokestatic %s/main()V\n", symbolTable.getCompilingClassName());
//        out.println("return");
//        out.println(".end method");
    }
}
