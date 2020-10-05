package expressions;

import facade.CalculationException;

/**
 * The general interface which represents all arithmetic expressions
 */
public interface Expression {
/**	
 * Evaluates this objects
 */
	public Integer evaluate() throws CalculationException;
/**
 * Receives a request from any visitor
 */
	public void accept(ExpressionVisitor ev);
}
