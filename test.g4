grammar test;

prog : statement* EOF ;

statement
    :   ID '=' expression ';'    
    |   expression ';'            
    ;

expression
    :   '(' expression ')'                
    |   expression op=('+'|'-') expression  
    |   expression op=('*'|'/') expression  
    |   INT                                
    |   ID                                 
    ;

ID : [a-zA-Z_][a-zA-Z_0-9]* ;   
INT : [0-9]+ ;              
WS : [ \t\r\n]+ -> skip ;       
