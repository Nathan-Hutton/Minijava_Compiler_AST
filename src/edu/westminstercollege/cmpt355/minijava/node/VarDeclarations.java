package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import edu.westminstercollege.cmpt355.minijava.Variable;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.plaf.nimbus.State;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public record VarDeclarations(ParserRuleContext ctx, TypeNode type, List<DeclarationItem> declarations) implements Statement {
    @Override
    public List<? extends Node> children() {
        List<Node> children = new ArrayList<>();
        children.add(type);
        children.addAll(declarations);
        return children;
    }

    @Override
    public void generateCode(PrintWriter out, SymbolTable symbols) {
        for (DeclarationItem declaration : declarations)
            declaration.generateCode(out, symbols);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (DeclarationItem item : declarations) {
            item.typecheck(symbols);

            // Item has no assignment
            if (!(item instanceof VarDeclarationInit)) {
                Variable v = symbols.findVariable(item.name()).orElseThrow();
                v.setType(type.type());

                if (type.type() == PrimitiveType.Double)
                    v.setIndex(symbols.allocateLocalVariable(2));
                else
                    v.setIndex(symbols.allocateLocalVariable(1));

                continue;
            }

            Expression expression = ((VarDeclarationInit) item).expression();

            if (type.type() == PrimitiveType.Double) {
                if (expression.getType(symbols) == PrimitiveType.Int || expression.getType(symbols) == PrimitiveType.Double) {
                    Variable v = symbols.findVariable(item.name()).orElseThrow();
                    v.setType(type.type());
                    v.setIndex(symbols.allocateLocalVariable(2));
                    continue;
                }
            }

            if (!type.type().equals((expression.getType(symbols))))
                throw new SyntaxException(this, String.format("%s is not of type %s", expression, type.type()));

            Variable v = symbols.findVariable(item.name()).orElseThrow();
            v.setType(type.type());
            v.setIndex(symbols.allocateLocalVariable(1));
        }
    }
}
