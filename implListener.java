// Generated from impl.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link implParser}.
 */
public interface implListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link implParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(implParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link implParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(implParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleCommand}
	 * labeled alternative in {@link implParser#program}.
	 * @param ctx the parse tree
	 */
	void enterSingleCommand(implParser.SingleCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleCommand}
	 * labeled alternative in {@link implParser#program}.
	 * @param ctx the parse tree
	 */
	void exitSingleCommand(implParser.SingleCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipleCommands}
	 * labeled alternative in {@link implParser#program}.
	 * @param ctx the parse tree
	 */
	void enterMultipleCommands(implParser.MultipleCommandsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipleCommands}
	 * labeled alternative in {@link implParser#program}.
	 * @param ctx the parse tree
	 */
	void exitMultipleCommands(implParser.MultipleCommandsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(implParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAssignment}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(implParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(implParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(implParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Output}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterOutput(implParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Output}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitOutput(implParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(implParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(implParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(implParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(implParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(implParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link implParser#command}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(implParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogiNot}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLogiNot(implParser.LogiNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogiNot}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLogiNot(implParser.LogiNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogiOr}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLogiOr(implParser.LogiOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogiOr}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLogiOr(implParser.LogiOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondOp}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondOp(implParser.CondOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondOp}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondOp(implParser.CondOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondParenthesis(implParser.CondParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondParenthesis(implParser.CondParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogiAnd}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLogiAnd(implParser.LogiAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogiAnd}
	 * labeled alternative in {@link implParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLogiAnd(implParser.LogiAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(implParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(implParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(implParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(implParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegative(implParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegative(implParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionSubtraction}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditionSubtraction(implParser.AdditionSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionSubtraction}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditionSubtraction(implParser.AdditionSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(implParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(implParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVariable}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariable(implParser.ArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVariable}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariable(implParser.ArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationDivision}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationDivision(implParser.MultiplicationDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationDivision}
	 * labeled alternative in {@link implParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationDivision(implParser.MultiplicationDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfStatement}
	 * labeled alternative in {@link implParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(implParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfStatement}
	 * labeled alternative in {@link implParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(implParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseStatement}
	 * labeled alternative in {@link implParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(implParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseStatement}
	 * labeled alternative in {@link implParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(implParser.ElseStatementContext ctx);
}