grammar impl;

/* A small imperative language */

start       :  cs+=command* EOF ;

program     : c=command                 # SingleCommand
            | '{' cs+=command* '}'      # MultipleCommands
            ;
    
command     : id=ID '[' e1=expr ']' '=' e2=expr ';'                     # ArrayAssignment
            | x=ID '=' e=expr ';'                                       # Assignment
            | 'output' e=expr ';'                                       # Output
            | 'while' '('c=cond')' p=program                            # WhileLoop
            | 'for' '(' c1=command  c2=cond ';' c3=command')' p=program # ForLoop
            | 'if' '('c=cond')' p=program b=branch?                     # IfStatement
            ;
    
            

cond        : '!' c=cond                # LogiNot
            | c1=cond '&&' c2=cond      # LogiAnd
            | c1=cond '||' c2=cond      # LogiOr
            | e1=expr op=CONDOP e2=expr # CondOp
            | '(' c=cond ')'            # CondParenthesis
            ;

expr        : op=ADDSUB e=expr          # Negative
			| e1=expr op=MULDIV e2=expr # MultiplicationDivision
            | e1=expr op=ADDSUB e2=expr # AdditionSubtraction
            | c=FLOAT                   # Constant
            | id=ID '[' e=expr ']'      # ArrayVariable
            | x=ID                      # Variable
            | '(' e=expr ')'            # Parenthesis
            ;

branch      : 'elseif' '('c=cond')' p=program b=branch? #ElseIfStatement
            | 'else' p=program                          #ElseStatement
            ;


MULDIV      : ('*' | '/');
ADDSUB      : ('+' | '-');
CONDOP      : ('==' | '!=' | '<' | '>' | '<=' | '>=');

ID          : ALPHA (ALPHA|NUM)* ;

FLOAT       : NUM+ ('.' NUM+)? ;

ALPHA       : [a-zA-Z_] ;
NUM         : [0-9] ;

WHITESPACE  : [ \n\t\r]+ -> skip;
COMMENT     : '//'~[\n]*  -> skip;
COMMENT2    : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
