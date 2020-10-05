package expressions;

import operators.BinaryOperator;
/**
 * Any binary term, such as a + b, e * z, etc
 */
public interface BinaryTerm extends Expression{
	public Expression getArg1();
	public Expression getArg2();
	public BinaryOperator getOp();
}
