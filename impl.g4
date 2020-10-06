grammar impl;

/* A small imperative language */

start		:  cs+=command* EOF ;

program		: c=command                 # SingleCommand
			| '{' cs+=command* '}'      # MultipleCommands
			;
	
command		: x=ID '=' e=expr ';'                   # Assignment
			| 'output' e=expr ';'                   # Output
			| 'while' '('c=expr')' p=program        # WhileLoop
			| 'if' '('c=cond')' p=program b=branch? # IfStatement
			;
	
			

cond 		: '!' c=cond 				# LogiNot
			| c1=cond '&&' c2=cond 		# LogiAnd
			| c1=cond '||' c2=cond      # LogiOr
			| e1=expr op=CONDOP e2=expr # CondOp
			| '(' c=cond ')'            # CondParenthesis
			;

expr		: e1=expr op=MULDIV e2=expr # MultiplicationDivision
			| e1=expr op=ADDSUB e2=expr # AdditionSubtraction
			| op=ADDSUB e=expr          # Negative
			| c=FLOAT                   # Constant
			| x=ID                      # Variable			
			| '(' e=expr ')'            # Parenthesis
			;

branch		: 'elseif' '('c=cond')' p=program b=branch? #ElseIfStatement
			| 'else' p=program                          #ElseStatement
			;

MULDIV		: ('*' | '/');
ADDSUB		: ('+' | '-');
CONDOP		: ('==' | '!=' | '<' | '>' | '<=' | '>=');

ID			: ALPHA (ALPHA|NUM)* ;
FLOAT		: NUM+ ('.' NUM+)? ;

ALPHA		: [a-zA-Z_] ;
NUM			: [0-9] ;

WHITESPACE	: [ \n\t\r]+ -> skip;
COMMENT		: '//'~[\n]*  -> skip;
COMMENT2	: '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
