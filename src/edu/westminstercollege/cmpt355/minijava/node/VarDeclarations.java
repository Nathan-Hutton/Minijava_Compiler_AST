package edu.westminstercollege.cmpt355.minijava.node;

import edu.westminstercollege.cmpt355.minijava.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava.SymbolTable;
import edu.westminstercollege.cmpt355.minijava.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.plaf.nimbus.State;
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
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (DeclarationItem item : declarations) {
            item.typecheck(symbols);

            if (!(item instanceof VarDeclarationInit)) {
                symbols.findVariable(item.name()).orElseThrow().setType(type.type());
                continue;
            }

            Expression expression = ((VarDeclarationInit) item).expression();

            if (type.type() == PrimitiveType.Double) {
                if (expression.getType(symbols) == PrimitiveType.Int || expression.getType(symbols) == PrimitiveType.Double) {
                    symbols.findVariable(item.name()).orElseThrow().setType(type.type());
                    continue;
                }
            }

            if (!type.type().equals((expression.getType(symbols))))
                throw new SyntaxException(this, String.format("%s is not of type %s", expression, type.type()));

            symbols.findVariable(item.name()).orElseThrow().setType(type.type());

        }
    }
}
