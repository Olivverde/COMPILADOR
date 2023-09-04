grammar YAPL;

// Keywords
CLASS           : 'CLASS' | 'class';
ELSE            : 'ELSE' | 'else';
FI              : 'FI' | 'fi';
IF              : 'IF' | 'if';
IN              : 'IN' | 'in';
INHERITS        : 'INHERITS' | 'inherits';
ISVOID          : 'ISVOID' | 'isvoid';
LOOP            : 'LOOP' | 'loop';
POOL            : 'POOL' | 'pool';
THEN            : 'THEN' | 'then';
WHILE           : 'WHILE' | 'while';
NEW             : 'NEW' | 'new';
NOT             : 'NOT' | 'not';
LET             : 'LET' | 'let';

FALSE           : 'false';
TRUE            : 'true';
SELF            : 'self';
SELF_TYPE       : 'SELF_TYPE';
BOOL            : 'Bool';
INT             : 'Int';
STRING          : 'String';
VOID            : 'void';


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
OBJ_ID          : [a-zA-Z] ([a-zA-Z0-9_])*;  // for variable name
INTEGER         : [0-9]+;
DIGIT           : [0-9];
STRING_LIT      : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"'; // obtained from documentation
BOOL_LIT        : TRUE | FALSE;
COMMENT         : '--' .*? '\n' -> skip; // skip comment line starting with --
OTHER_COMMENT   : '..' .*? '..' -> skip; // skip comment between ..
NEWLINE		    : ('\r'? '\n' | '\r')+ -> skip; // skip new line
WHITESPACE	    : [ \t\r\n\f\b]+ -> skip; // skip all kind of whitespaces

// Productions

program         : (class SEMICOLON)+;
class           : CLASS var_type (INHERITS var_type)? LBRACE (feature)* RBRACE;
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
var_id          : OBJ_ID | SELF;
return_type     : var_type;

ERR_TOKEN : . ;