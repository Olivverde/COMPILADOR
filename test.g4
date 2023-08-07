// referencia para archivo: https://github.com/antlr/website-antlr4/tree/gh-pages/papers/ALL-star
grammar test;

ID: [a-zA-Z][a-zA-Z0-9_]*;
INT_CONST: [0-9]+;
STR_CONST: '"' ( '\\' [\\"] | ~[\\"\r\n] )* '"';

// Espacios en blanco y saltos de linea se ignoran
WS: [ \t\r\n]+ -> skip;

BOOL: 'Bool';
INT: 'Int';
STRING: 'String';
IO: 'IO';
OBJECT: 'Object';
SELF_TYPE: 'SELF_TYPE';

CLASS_RESERVED: 'class' | 'CLASS' ;
INHERITS_RESERVED: 'inherits' | 'INHERITS' ;
IF_RESERVED: 'if' | 'IF' ;
THEN_RESERVED: 'then' | 'THEN';
ELSE_RESERVED: 'else' | 'ELSE';
FI_RESERVED: 'fi' | 'FI' ;
LET_RESERVED: 'let' | 'LET' ;
IN_RESERVED: 'in' | 'IN' ;
WHILE_RESERVED: 'while' | 'WHILE' ;
NEW_RESERVED : 'new' | 'NEW' ;

CASE: 'case';
OF: 'of';
ESAC: 'esac';
NEW: 'new';
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
LINE_COMMENT:
	'//' .*? '\n' -> skip;
COMMENT: '/*' .*? '*/' -> skip;


program: clas_list+;

clas_list:
	CLASS_RESERVED type (INHERITS_RESERVED type)? LBRACE (listOfFeature) RBRACE SEMI;

listOfFeature: feature* | formal*;

formal: ID COLON type;

feature: attributesDef | method_definition | methodSimple;

attributesDef: ID COLON type ('<-' expr)? (LPAREN expr SEMI RPAREN)? SEMI;

methodSimple:
	ID LPAREN parameters? RPAREN SEMI;

method_definition:
	ID LPAREN parameters? RPAREN COLON type LBRACE (block SEMI)*  RBRACE SEMI;

let_declaration: LET_RESERVED let_binding (',' let_binding)* (IN_RESERVED LBRACE (expr SEMI)* RBRACE)?;
let_binding: ID ':' type ('<-' expr)? (type)?;

ifRule: IF_RESERVED expr (THEN_RESERVED (expr|whileRule|ifRule)*)* (ELSE_RESERVED (expr|whileRule|ifRule))? FI_RESERVED;
whileRule: WHILE_RESERVED (expr|whileRule|ifRule)* 'loop' (expr|whileRule|ifRule)* 'pool';

block: ifRule* | whileRule* | let_declaration* | expr*;

parameters: formal (COMMA formal)*;

expr:
	ID ASSIGN expr
	| ID '(' expr ')'
	| ID '(' parameters? ')'
	| '{' expr '}'
	| STR_CONST
	| ID '(' STR_CONST ')'
	| '(' STR_CONST ')'
	| INT_CONST
	| NEW ID
	| NEW type
	| ISVOID expr
	| INT_CONST
	| STR_CONST
	| NOT expr
	| LPAREN expr+? RPAREN
	| ISVOID expr
	| 'self'
	| 'true'
	| 'false'
	| 'void'
	| expr DOT ID
	| expr DOT ID LPAREN expr? RPAREN
	| expr DOT ID ASSIGN expr
	| expr '@' type DOT ID LPAREN expr (SEMI expr)* RPAREN
	| expr '~'
	| expr ('-' expr)+
	| expr ('+' expr)+
	| expr ('<' expr)+
	| expr ('>' expr)+
	| expr '=' expr
	| expr ('+' expr)+
	| expr ('-' expr)+
	| expr ('*' expr)+
	| expr ('/' expr)+
	| expr ('%' expr)+
	| expr '^' expr
	| expr '<=' expr
	| ID;

ErrorChar : . ;
