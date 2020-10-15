package expressions;

import symbols.NaturalNumber;
/**
 * Part of visitor pattern in order to distinguish different types of Expressions
 */
public interface ExpressionVisitor<T> {
	public T handle(Sum s);
	public T handle(Product p);
	public T handle(BracketExpression be);
	public T handle(NaturalNumber c);
}
