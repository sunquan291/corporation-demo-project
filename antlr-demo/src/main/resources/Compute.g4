grammar Compute;

express : express (PLUS|SUB|MUL|DIV)* NUMBER| NUMBER;
NUMBER : [0]|[1-9]+[0-9]*;
PLUS : '+';
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
WS : [ \t\n\r]+ -> skip ;
