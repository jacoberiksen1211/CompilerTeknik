grammar impl;

/* A small imperative language */

start       :  cs+=command* EOF ;

program     : c=command                      # SingleCommand
	        | '{' cs+=command* '}'           # MultipleCommands
	        ;
	
command     : x=ID '=' e=expr ';'	         # Assignment
	        | 'output' e=expr ';'            # Output
            | 'while' '('c=condition')' p=program  # WhileLoop
			| 'if' '('c=condition')' p=program b=branch? # IfStatement
	        ;
	
expr	    : e1=expr op=MULDIV e2=expr # MultiplicationDivision
		    | e1=expr op=ADDSUB e2=expr # AdditionSubtraction
		    | c=FLOAT     	      # Constant
		    | x=ID		      # Variable
		    | '(' e=expr ')'      # Parenthesis
		    ;

branch		: 'elseif' '('c=condition')' p=program b=branch? #ElseIfStatement
			| 'else' p=program #ElseStatement
			;


condition   : e1=expr '!=' e2=expr # Unequal
			| e1=expr '==' e2=expr # Equal
			| e1=expr '&&' e2=expr # And
			| e1=expr '||' e2=expr # Or
	        ;  

MULDIV      :	('*' | '/');
ADDSUB      :	('+' | '-');

ID          : ALPHA (ALPHA|NUM)* ;
FLOAT       : '-'? NUM+ ('.' NUM+)? ;

ALPHA       : [a-zA-Z_ÆØÅæøå] ;
NUM         : [0-9] ;

WHITESPACE  : [ \n\t\r]+ -> skip;
COMMENT     : '//'~[\n]*  -> skip;
COMMENT2    : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
