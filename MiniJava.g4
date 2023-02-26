grammar MiniJava;

@parser::header {
import edu.westminstercollege.cmpt355.minijava.node.*;
}

goal
    : methodBody EOF
    ;

methodBody
returns [Block n]
    : (stmts+=statement*) {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block(statements);
    }
    ;

statement
returns [Statement n]
    : ';' {
        $n = new EmptyStatement();
    }
    | '{' (stmts+=statement)* '}' {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block(statements);
    }
    | variableDeclaration {
        $n = $variableDeclaration.n;
    }
    | expression ';' {
        $n = new ExpressionStatement($expression.n);
    }
    ;

// type followed by a comma-separated list of "items", each being just a name or a name = value.
variableDeclaration
returns [VarDeclarations n]
    : type decs+=variableDeclarationItem (',' decs+=variableDeclarationItem)* ';' {
        var declarations = new ArrayList<DeclarationItem>();
        for (var dec : $decs)
            declarations.add(dec.n);

        $n = new VarDeclarations($type.n, declarations);
    }
    ;

variableDeclarationItem
returns [DeclarationItem n]
    : NAME {
        $n = new VarDeclaration($NAME.text);
    }
    | NAME '=' expression {
        $n = new VarDeclarationInit($NAME.text, $expression.n);
    }
    ;

// print()
expression
returns [Expression n]
    : 'print' '(' (exprs+=expression (',' exprs+=expression)*)? ')' {
        var expressions = new ArrayList<Expression>();
        for (var expr : $exprs)
            expressions.add(expr.n);

        $n = new Print(expressions);
    }
    | INT {
        $n = new IntLiteral(Integer.parseInt($INT.text));
    }
    | DOUBLE {
        $n = new DoubleLiteral(Double.parseDouble($DOUBLE.text));
    }
    | BOOLEAN {
        $n = new BooleanLiteral(Boolean.parseBoolean($BOOLEAN.text));
    }
    | STRING {
        $n = new StringLiteral($STRING.text);
    }
    | NAME {
        $n = new VariableAccess($NAME.text);
    }
    | '(' expression ')' {
        $n = $expression.n;
    }
    | NAME op=('++' | '--') {
        $n = new PostIncrement(new VariableAccess($NAME.text), $op.text);
    }
    | op=('++' | '--' | '+' | '-') expression {
        if ($op.text.equals("++") || $op.text.equals("--"))
            $n = new PreIncrement(new VariableAccess($expression.text), $op.text);
        else if ($op.text.equals("-"))
            $n = new Negate($expression.n);
    }
    | '(' type ')' expression {
        $n = new Cast(new TypeNode($type.text), $expression.n);
    }
    | l=expression op=('*' | '/' | '%') r=expression {
        $n = new BinaryOp($l.n, $op.text, $r.n);
    }
    | l=expression op=('+' | '-') r=expression {
        $n = new BinaryOp($l.n, $op.text, $r.n);
    }
    | <assoc=right> names+=NAME '=' exprs+=expression (',' names+=NAME '=' exprs+=expression)* {
        $n = new Assignment(new VariableAccess($NAME.text), $expression.n);
    }
    ;

type
returns [TypeNode n]
    : 'int' {
        $n = new TypeNode("int");
    }
    | 'double' {
        $n = new TypeNode("double");
    }
    | 'boolean' {
        $n = new TypeNode("boolean");
    }
    | NAME {
        $n = new TypeNode($NAME.text);
    }
    ;

RESERVED_WORD
    : 'abstract'   | 'continue'   | 'for'          | 'new'         | 'switch'
    | 'assert'     | 'default'    | 'if'           | 'package'     | 'synchronized'
    | 'boolean'    | 'do'         | 'goto'         | 'private'     | 'this'
    | 'break'      | 'double'     | 'implements'   | 'protected'   | 'throw'
    | 'byte'       | 'else'       | 'import'       | 'public'      | 'throws'
    | 'case'       | 'enum'       | 'instanceof'   | 'return'      | 'transient'
    | 'catch'      | 'extends'    | 'int'          | 'short'       | 'try'
    | 'char'       | 'final'      | 'interface'    | 'static'      | 'void'
    | 'class'      | 'finally'    | 'long'         | 'strictfp'    | 'volatile'
    | 'const'      | 'float'      | 'native'       | 'super'       | 'while'
    | '_'
    ;

WHITESPACE
    : [ \n\r\t]+ -> skip
    ;

// fragment: doesn't generate tokens, but can be used in other lexer rules
fragment DIGITS
    : [0-9]+
    ;

fragment FIXED_POINT
    : [0-9]+ '.' [0-9]*
    | [0-9]* '.' [0-9]+
    ;

INT
    : DIGITS
    ;

DOUBLE
    :  FIXED_POINT
    | FIXED_POINT [Ee] [+-]? INT
    | DIGITS [Ee] [+-]? DIGITS
    ;

BOOLEAN
    : 'true'
    | 'false'
    ;

STRING
    : '"' .*? '"'
    ;

// letters, numbers, dollar signs '$', underscores '_', but not starting with a digit
NAME
    : [a-zA-Z_$] [a-zA-Z_$0-9]*
    ;

LINE_COMMENT
    : '//' .*? ('\n' | EOF) -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/'         -> skip
    ;