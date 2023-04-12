grammar MiniJava;

@parser::header {
import edu.westminstercollege.cmpt355.minijava.node.*;
import edu.westminstercollege.cmpt355.minijava.Type;
import java.util.Optional;
}

goal
returns [ClassNode n]
    : classNode EOF {
        $n = $classNode.n;
    }
    ;

classNode
returns [ClassNode n]
    : (importz+=imports)* (fields+=fieldDefinition)* (methods+=methodDefinition)* EOF {
        var importStmts = new ArrayList<Import>();
        var fieldDefs = new ArrayList<FieldDefinition>();
        var methodDefs = new ArrayList<MethodDefinition>();

        for (var imp : $importz)
            importStmts.add(imp.n);
        for (var field : $fields)
            fieldDefs.add(field.n);
        for (var method : $methods)
            methodDefs.add(method.n);

        $n = new ClassNode($ctx, importStmts, fieldDefs, methodDefs);
    }
    ;

block
returns [Block n]
    : (stmts+=statement*) {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block($ctx, statements);
    }
    ;

statement
returns [Statement n]
    : ';' {
        $n = new EmptyStatement($ctx);
    }
    | '{' (stmts+=statement)* '}' {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block($ctx, statements);
    }
    | variableDeclaration {
        $n = $variableDeclaration.n;
    }
    | 'return' ';' {
        $n = new Return($ctx, Optional.empty());
    }
    | 'return' e=expression ';' {
        $n = new Return($ctx, Optional.of($e.n));
    }
    | expression ';' {
        $n = new ExpressionStatement($ctx, $expression.n);
    }
    ;

imports
returns [Import n]
    : 'import' names+=NAME ('.' names+=NAME)* '.' '*' ';' {
        StringBuilder nameString = new StringBuilder();
        nameString.append($names.get(0).getText());
        $names.remove(0);

        for (var name : $names) {
            nameString.append(".");
            nameString.append(name.getText());
        }

        $n = new PackageImport($ctx, nameString.toString());
    }
    | 'import' names+=NAME ('.' names+=NAME)* ';' {
        StringBuilder nameString = new StringBuilder();
        nameString.append($names.get(0).getText());
        $names.remove(0);

        for (var name : $names) {
            nameString.append(".");
            nameString.append(name.getText());
        }

        $n = new ClassImport($ctx, nameString.toString());
    }
;

fieldDefinition
returns [FieldDefinition n]
    : type NAME ('=' expr=expression)? ';' {
        $n = new FieldDefinition($ctx, $type.n, $NAME.text, Optional.of($expr.n));
    }
    ;

methodDefinition
returns [MethodDefinition n]
    : type methodName=NAME '(' (params+=parameter (',' params+=parameter)*)? ')' '{' block '}' {
        List<Parameter> paramNodes = new ArrayList<>();
        for (var p : $params)
            paramNodes.add(p.n);

        $n = new MethodDefinition($ctx, $type.n, $methodName.text, paramNodes, $block.n);
    }
    ;

mainMethod
returns [MainMethod n]
    : 'main' '(' ')' '{' block '}'
    ;

// type followed by a comma-separated list of "items", each being just a name or a name = value.
variableDeclaration
returns [VarDeclarations n]
    : type decs+=variableDeclarationItem (',' decs+=variableDeclarationItem)* ';' {
        var declarations = new ArrayList<DeclarationItem>();
        for (var dec : $decs)
            declarations.add(dec.n);

        $n = new VarDeclarations($ctx, $type.n, declarations);
    }
    ;

variableDeclarationItem
returns [DeclarationItem n]
    : NAME {
        $n = new VarDeclaration($ctx, $NAME.text);
    }
    | NAME '=' expression {
        $n = new VarDeclarationInit($ctx, $NAME.text, $expression.n);
    }
    ;

parameter
returns [Parameter n]
    : type NAME {
        $n = new Parameter($ctx, $type.n, $NAME.text);
    }
    ;

expression
returns [Expression n]
    : '_print' '(' (exprs+=expression (',' exprs+=expression)*)? ')' {
        var expressions = new ArrayList<Expression>();
        for (var expr : $exprs)
            expressions.add(expr.n);

        $n = new Print($ctx, expressions);
    }
    | INT {
        $n = new IntLiteral($ctx, Integer.parseInt($INT.text));
    }
    | DOUBLE {
        $n = new DoubleLiteral($ctx, Double.parseDouble($DOUBLE.text));
    }
    | BOOLEAN {
        $n = new BooleanLiteral($ctx, Boolean.parseBoolean($BOOLEAN.text));
    }
    | STRING {
        $n = new StringLiteral($ctx, $STRING.text);
    }
    | NAME {
        $n = new VariableAccess($ctx, $NAME.text);
    }
    | 'this' {
        $n = new This($ctx);
    }
    | '(' expression ')' {
        $n = $expression.n;
    }
    | expr=expression op=('++' | '--') {
        $n = new PostIncrement($ctx, new VariableAccess($ctx, $expr.text), $op.text);
    }
    | op=('++' | '--' | '+' | '-') expression {
        if ($op.text.equals("++") || $op.text.equals("--"))
            $n = new PreIncrement($ctx, new VariableAccess($ctx, $expression.text), $op.text);
        else if ($op.text.equals("-"))
            $n = new Negate($ctx, $expression.n);
        else if ($op.text.equals("+"))
            $n = $expression.n;
    }
    | e=expression '.' NAME {
            $n = new FieldAccess($ctx, $e.n, $NAME.text);
        }
    | e=expression '.' NAME '(' (exprs+=expression (',' exprs+=expression)*)? ')' {
        var expressions = new ArrayList<Expression>();
        for (var expr : $exprs)
            expressions.add(expr.n);

        $n = new MethodCall($ctx, $e.n, $NAME.text, expressions);
    }
    | 'new' NAME '(' (exprs+=expression (',' exprs+=expression)*)? ')' {
        var expressions = new ArrayList<Expression>();
        for (var expr : $exprs)
            expressions.add(expr.n);

        $n = new ConstructorCall($ctx, $NAME.text, expressions);
    }
    | '(' type ')' expression {
        $n = new Cast($ctx, $type.n, $expression.n);
    }
    | l=expression op=('*' | '/' | '%') r=expression {
        $n = new BinaryOp($ctx, $l.n, $op.text, $r.n);
    }
    | l=expression op=('+' | '-') r=expression {
        $n = new BinaryOp($ctx, $l.n, $op.text, $r.n);
    }
    | <assoc=right> l=expression '=' r=expression {
        $n = new Assignment($ctx, $l.n, $r.n);
    }
    ;

type
returns [TypeNode n]
    : 'int' {
        $n = new TypeNode($ctx, PrimitiveType.Int);
    }
    | 'double' {
        $n = new TypeNode($ctx, PrimitiveType.Double);
    }
    | 'boolean' {
        $n = new TypeNode($ctx, PrimitiveType.Boolean);
    }
    | 'void' {
        $n = new TypeNode($ctx, VoidType.Instance);
    }
    | NAME {
        $n = new TypeNode($ctx, new ClassType($NAME.text));
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