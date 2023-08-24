grammar test;

// Espacios en blanco y saltos de linea se ignoran
WS: [ \t\r\n]+ -> skip;

LINE_COMMENT:
	'//' .*? '\n' -> skip;

BOOL: 'Bool';
INT: 'Int';
STRING: 'String';
IO: 'IO';
OBJECT: 'Object';
SELF_TYPE: 'SELF_TYPE';
NEW: 'new' | 'NEW' ;

CLASS_RESERVED: 'class'|'CLASS';
INHERITS_RESERVED: 'inherits' | 'INHERITS' ;
IF_RESERVED: 'if' | 'IF' ;
THEN_RESERVED: 'then' | 'THEN';
ELSE_RESERVED: 'else' | 'ELSE';
FI_RESERVED: 'fi' | 'FI' ;
LET_RESERVED: 'let' | 'LET' ;
IN_RESERVED: 'in' | 'IN' ;
WHILE_RESERVED: 'while' | 'WHILE' ;

CASE: 'case';
OF: 'of';
ESAC: 'esac';

ISVOID: 'isvoid';
NOT: 'not';

type: ID | INT | STRING | BOOL | OBJECT | SELF_TYPE | IO ;
binary_op: '+' | '-' | '*' | '=' | '@' | '/' | '<' | '<=';
unary_op: '~' | NOT;

COMMA: ',';
DOT: '.';
COLON: ':';
SEMI: ';';
ASSIGN: '<-';
ARROW: '=>';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COMMENT: '--' .*? ('\r'? '\n' | EOF) -> skip;

ID: [a-zA-Z][a-zA-Z0-9_]*;
INT_CONST: [0-9]+;
STR_CONST: '"' ( '\\' [\\"] | ~[\\"\r\n] )* '"';

program: (clas_list)*;

clas_list: CLASS_RESERVED type (INHERITS_RESERVED type)? LBRACE (listOfFeature) RBRACE SEMI;


listOfFeature: feature* ;

formal: ID COLON type;

feature: attributesDef | method_definition;

attributesDef: ID COLON type ('<-' expr)? (LPAREN expr SEMI RPAREN)? SEMI;

methodSimple:
	ID LPAREN parameters? RPAREN SEMI;

method_definition:
	ID LPAREN parameters? RPAREN COLON type LBRACE block RBRACE SEMI;

let_declaration: (LPAREN)? LET_RESERVED let_binding (',' let_binding)* (IN_RESERVED (LBRACE)? (expr|whileRule|ifRule|let_declaration (SEMI)?)* (RBRACE)?)? (RPAREN)? (SEMI)?;
let_binding: ID ':' type ('<-' expr)? (type)?;

ifRule: IF_RESERVED expr (THEN_RESERVED (expr|whileRule|ifRule|let_declaration)*)* (ELSE_RESERVED (expr|whileRule|ifRule|let_declaration))? FI_RESERVED;
whileRule: WHILE_RESERVED (expr|whileRule|ifRule)* 'loop' (LBRACE)?(expr|whileRule|ifRule)*(RBRACE)? 'pool';

block: (LBRACE)? (ifRule* | whileRule* | let_declaration* | expr*) (RBRACE)?;

parameters: formal (COMMA formal)*;

expr:
	ID ASSIGN expr
	| ID '(' expr (COMMA expr)* ')'
	| '{' (expr SEMI)+ '}'
	| STR_CONST
	| INT_CONST
	| NEW type
	| ISVOID expr
	| INT_CONST
	| NOT expr
	| LPAREN expr RPAREN
	| 'true'
	| 'false'
	| expr ('@' type)? DOT ID LPAREN expr (COMMA expr)* RPAREN
	| '~' expr
	| expr ('-' expr)
	| expr ('+' expr)
	| expr ('<' expr)
	| expr '=' expr
	| expr ('*' expr)
	| expr ('/' expr)
	| expr '<=' expr
	| ID
    | '(' expr ')';

ErrorChar : . ;