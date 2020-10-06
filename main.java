import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException{

	// we expect exactly one argument: the name of the input file
	if (args.length!=1) {
	    System.err.println("\n");
	    System.err.println("Simple calculator\n");
	    System.err.println("=================\n\n");
	    System.err.println("Please give as input argument a filename\n");
	    System.exit(-1);
	}
	String filename=args[0];

	// open the input file
	CharStream input = CharStreams.fromFileName(filename);
	    //new ANTLRFileStream (filename); // depricated
	
	// create a lexer/scanner
	implLexer lex = new implLexer(input);
	
	// get the stream of tokens from the scanner
	CommonTokenStream tokens = new CommonTokenStream(lex);
	
	// create a parser
	implParser parser = new implParser(tokens);
	
	// and parse anything from the grammar for "start"
	ParseTree parseTree = parser.start();

	// Construct an interpreter and run it on the parse tree
	Interpreter interpreter = new Interpreter();
	interpreter.visit(parseTree);
    }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<Double> implements implVisitor<Double> {

    static Environment env=new Environment();
    
    public Double visitStart(implParser.StartContext ctx){
		for(implParser.CommandContext c:ctx.cs) visit(c);

		return null;
    };

    public Double visitSingleCommand(implParser.SingleCommandContext ctx){
		return visit(ctx.c);
    }

    public Double visitMultipleCommands(implParser.MultipleCommandsContext ctx){
		for(implParser.CommandContext c:ctx.cs) visit(c);

		return null;
    }
    
    public Double visitAssignment(implParser.AssignmentContext ctx){
 		Double v=visit(ctx.e);
		env.setVariable(ctx.x.getText(),v);

		return null;
    }
    
    public Double visitOutput(implParser.OutputContext ctx){
		Double v=visit(ctx.e);
		System.out.println(v);

		return null;
    }

	// While loop
	//// Checks if the condition is not false, and executes the associated program.
    public Double visitWhileLoop(implParser.WhileLoopContext ctx){
		while(visit(ctx.c) != 0.0){
	  	  visit(ctx.p);
		}

		return null;
    }

	// Branch: if
	//// Checks if the condition is not false, and executes the program. If another branch is parsed (elseif or else), execute that.
 	public Double visitIfStatement(implParser.IfStatementContext ctx){
		if(visit(ctx.c) != 0.0){
			visit(ctx.p);
			return null;
		} else {
			if (ctx.b != null)
				visit(ctx.b);
		}

		return null;
    }
    
    // Branch: elseif
    //// Checks if the condition is not false, and executes the program. If another branch is parsed (elseif or else), execute that.
    //// While identical to the if branch, it was required to split them into two in order to enable the parser to not allow an elseif outside an if branch.
	public Double visitElseIfStatement(implParser.ElseIfStatementContext ctx){
		if(visit(ctx.c) != 0.0){
			visit(ctx.p);
			return null;
		} else {
			if (ctx.b != null)
				visit(ctx.b);
		}

		return null;
    }


	// Branch: else
	//// Executes the program following it.
	//// Due to the design of the syntax analysis, the else branch always follows either an if or an elseif branch.
	public Double visitElseStatement(implParser.ElseStatementContext ctx){
		visit(ctx.p);

		return null;
    }

    public Double visitParenthesis(implParser.ParenthesisContext ctx){
		return visit(ctx.e);
    };

    public Double visitCondParenthesis(implParser.CondParenthesisContext ctx){
		return visit(ctx.c);
    };
    
    public Double visitVariable(implParser.VariableContext ctx){
		return env.getVariable(ctx.x.getText());
    };
    
    // Negative floats
    //// Needs to be handled as expressions when parsing, or its prone to errors.
    //// Subsequently, the standard grammar file has had the FLOAT definition changed, so the optional minus has been removed.
    public Double visitNegative(implParser.NegativeContext ctx){
		if (ctx.op.getText().equals("+"))
			return visit(ctx.e);
		else
			return -visit(ctx.e);
    };
    
    public Double visitAdditionSubtraction(implParser.AdditionSubtractionContext ctx){
		if (ctx.op.getText().equals("+"))
			return visit(ctx.e1) + visit(ctx.e2);
		else
			return visit(ctx.e1) - visit(ctx.e2);
    };

    public Double visitMultiplicationDivision(implParser.MultiplicationDivisionContext ctx){
		if (ctx.op.getText().equals("*"))
			return visit(ctx.e1) * visit(ctx.e2);
		else
			return visit(ctx.e1) / visit(ctx.e2);
    };

    public Double visitConstant(implParser.ConstantContext ctx){
		return Double.parseDouble(ctx.c.getText()); 
    };

	// Logical NOT
	//// ! converts the following expression to a boolean and inverts it.
	//// According to our below definition, NOT here simply checks if the value is 0.0 (false) and returns 1.0 (true) if it is. And the other way around.
	public Double visitLogiNot(implParser.LogiNotContext ctx){
		double c=visit(ctx.c);
		if (c == 0.0)
			return 1.0;
		else
			return 0.0;
	};
	
	// Logical AND
	//// && needs to check both expressions are true.
	//// In case of values, as long as they have a value that isnt 0 (null), they should return 1.0 (true).
	//// While &&'ing two constants in java isn't allowed, we anyways decided to check if the value simply exists instead (c/cpp style).
	public Double visitLogiAnd(implParser.LogiAndContext ctx){
		double c1=visit(ctx.c1);
		double c2=visit(ctx.c2);
		if ((c1 == 1.0) && (c2 == 1.0))
			return 1.0;
		else
			return 0.0;
	};

	// Logical OR
	//// || needs to check if one of the expressions are true, and then return true.
	//// In case of values, as long as one has a value that isnt 0 (null), they should return 1.0 (true).
	//// While ||'ing two constants in java isn't allowed, we anyways decided to check if the value simply exists instead (c/cpp style).
	public Double visitLogiOr(implParser.LogiOrContext ctx) {
		double c1=visit(ctx.c1);
		double c2=visit(ctx.c2);
		if ((c1 == 1.0) || (c2 == 1.0))
			return 1.0;
		else
			return 0.0;
	};
	
	// Various Conditional Operators
	// These are handled seperately to the logical AND and OR, as we need to make sure the order of comparison is correct in our grammar (Thanks top-down ANTLR parsing).
	//// Returns 1.0 if condition is true, and 0.0 if condition is false.
	public Double visitCondOp(implParser.CondOpContext ctx) {
		double e1 = visit(ctx.e1);
		double e2 = visit(ctx.e2);
	
		switch(ctx.op.getText()) {
			case "==":
				if (e1 == e2)
					return 1.0;
				break;
			case "!=":
				if (e1 != e2)
					return 1.0;
				break;
			case "<=":
				if (e1 <= e2)
					return 1.0;
				break;
			case ">=":
				if (e1 >= e2)
					return 1.0;
				break;
			case "<":
				if (e1 < e2)
					return 1.0;
				break;
			case ">":
				if (e1 > e2)
					return 1.0;
				break;
			default:
				return 0.0;
		}
		
		return 0.0;
	};

}

