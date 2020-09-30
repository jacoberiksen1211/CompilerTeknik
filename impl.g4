grammar impl;

/* A small imperative language */

start       :  cs+=command* EOF ;

program     : c=command               	# SingleCommand
	        | '{' cs+=command* '}'   	# MultipleCommands
	        ;
	
command     : x=ID '=' e=expr ';'	         		# Assignment
	        | 'output' e=expr ';'            		# Output
            | 'while' '('c=expr')' p=program  		# WhileLoop
			| 'if' '('c=expr')' p=program b=branch? # IfStatement
	        ;
	
expr	    : '!' e=expr #LogiNot
			| e1=expr op=MULDIV e2=expr # MultiplicationDivision
		    | e1=expr op=ADDSUB e2=expr # AdditionSubtraction
		    | op=ADDSUB e=expr 	 		# Negative
		    | c=FLOAT     	      		# Constant
		    | x=ID		      			# Variable
		    | e1=expr op=CONDOP e2=expr # CondOp
			| e1=expr '&&' e2=expr 		# LogiAnd
			| e1=expr '||' e2=expr 		# LogiOr
		    | '(' e=expr ')'      		# Parenthesis
		    ;

branch		: 'elseif' '('c=expr')' p=program b=branch? #ElseIfStatement
			| 'else' p=program 							#ElseStatement
			;

MULDIV      : ('*' | '/');
ADDSUB      : ('+' | '-');
CONDOP		: ('==' | '!=' | '<' | '>' | '<=' | '>=');

ID          : ALPHA (ALPHA|NUM)* ;
FLOAT       : NUM+ ('.' NUM+)? ;

ALPHA       : [a-zA-Z_ÆØÅæøå] ;
NUM         : [0-9] ;

WHITESPACE  : [ \n\t\r]+ -> skip;
COMMENT     : '//'~[\n]*  -> skip;
COMMENT2    : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
