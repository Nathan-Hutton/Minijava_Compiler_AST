package edu.westminstercollege.cmpt355.minijava.node;
import edu.westminstercollege.cmpt355.minijava.*;

public sealed interface Expression extends Node
    permits IntLiteral, DoubleLiteral, BooleanLiteral, StringLiteral, VariableAccess,
    Assignment, BinaryOp, Negate, PreIncrement, PostIncrement, Cast, Print, FieldAccess,
    MethodCall, ConstructorClass {
    Type getType(SymbolTable symbols);
}
