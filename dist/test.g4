grammar test;

// Keywords
CLASS           : 'class' | 'CLASS';
ELSE            : 'else' |'ELSE';
FI              : 'fi' |'FI';
IF              : 'if'| 'IF';
IN              : 'in' | 'IN';
INHERITS        : 'inherits' | 'INHERITS';
ISVOID          : 'isvoid' | 'ISVOID';
LOOP            : 'loop' |'LOOP' ;
POOL            : 'pool'| 'POOL' ;
THEN            : 'then' | 'THEN' ;
WHILE           : 'while' | 'WHILE' ;
NEW             : 'new' |'NEW';
NOT             : 'not' |'NOT';
LET             : 'let' |'LET';

TRUE            : 'true';
FALSE           : 'false';
BOOL            : 'Bool';
INT             : 'Int';
STRING          : 'String';
VOID            : 'void';
SELF            : 'self';
SELF_TYPE       : 'SELF_TYPE';


// Helpfull symbols
SEMICOLON       : ';';
COLON           : ':';
LBRACE          : '{';
RBRACE          : '}';
LBRACKET        : '[';
RBRACKET        : ']';
LPAR            : '(';
RPAR            : ')';
COMMA           : ',';
QUOTES          : '"';
APOSTROPHE      : '\'';
ADD             : '+';
SUB             : '-';
MULTIPLY        : '*';
DIVIDE          : '/';
NEGATION        : '~';
LESS_OP         : '<';
LESS_EQ_OP      : '<=';
EQUAL_OP        : '=';
DOT           : '.';
AT              : '@';
ASIGN           : '<-';

// Basic expresions

TYPE_ID         : [A-Z] ([a-zA-Z0-9_])*;
VAR_NAME          : [a-zA-Z] ([a-zA-Z0-9_])*;
INTEGER         : [0-9]+;
DIGIT           : [0-9];
STRING_LIT      : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"'; // obtained from documentation
BOOL_LIT        : TRUE | FALSE;
COMMENT         : '--' .*? '\n' -> skip; // skip comment line starting with --
COMMENT_2   : '(*' .*? '*)' -> skip; // toggle comment (*...*)
COMMENT_3   : '..' .*? '..' -> skip; // skip comment between ..
NEWLINE		    : ('\r'? '\n' | '\r')+ -> skip; // skip new line
WS	    : [ \t\r\n\f\b]+ -> skip; // skip all kind of whitespaces

// Productions

program         : (class_prod SEMICOLON)+;
class_prod           : CLASS var_type (INHERITS var_type)? LBRACE (feature)* RBRACE;
feature         : var_id LPAR (var_id COLON var_type (COMMA var_id COLON var_type)*)? RPAR COLON return_type LBRACE expr RBRACE SEMICOLON            # class_method
                | var_id COLON var_type (ASIGN expr)? SEMICOLON                                                     # class_attribute
                ;

expr            : var_id ASIGN expr                                                                                 # assign_expr
                | expr (AT var_type)? DOT var_id LPAR (expr (COMMA expr)*)? RPAR                                    # expr_expr
                | var_id LPAR (expr (COMMA expr)*)? RPAR                                                            # method_call     
                | IF expr THEN expr ELSE expr FI                                                                    # conditional_expr 
                | WHILE expr LOOP expr POOL                                                                         # loop_expr                           
                | LBRACE (expr SEMICOLON)+ RBRACE                                                                   # br_expr                       
                | LET var_id COLON var_type (ASIGN expr)? (COMMA var_id COLON var_type (ASIGN expr)?)* IN expr      # let_expr
                | NEW var_type                                                                                      # new_expr                           
                | ISVOID expr                                                                                       # void_expr
                | expr ADD expr                                                                                     # add_expr
                | expr SUB expr                                                                                     # sub_expr                                           
                | expr MULTIPLY expr                                                                                # mul_expr                       
                | expr DIVIDE expr                                                                                  # div_expr                      
                | NEGATION expr                                                                                     # neg_expr                                                                                   
                | expr LESS_OP expr                                                                                 # less_expr
                | expr LESS_EQ_OP expr                                                                              # lessEq_expr
                | expr EQUAL_OP expr                                                                                # eq_expr
                | NOT expr                                                                                          # not_expr                                
                | LPAR expr RPAR                                                                                    # par_expr
                | var_id                                                                                            # var_expr                                           
                | INTEGER                                                                                           # int_expr
                | STRING_LIT                                                                                        # string_expr
                | TRUE                                                                                              # true_expr
                | FALSE                                                                                             # false_expr
                ;

var_type        : INT | BOOL | STRING | TYPE_ID | VOID | SELF_TYPE;
var_id          : VAR_NAME | SELF;
return_type     : var_type;

ERR_TOKEN : . ;