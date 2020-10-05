package expressions;

import facade.CalculationException;
import operators.BinaryOperator;
/**
 * A sum is a term of the form a + b or a - b
 */
public class Sum implements BinaryTerm, Expression{
	private Summand arg1;
	private Expression arg2;
	private BinaryOperator op;
	public Sum(Summand arg1, Expression arg2, BinaryOperator op) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.op = op;
	}	
	public Expression getArg1() {
		return arg1;
	}
	public Expression getArg2() {
		return arg2;
	}
	public BinaryOperator getOp() {
		return op;
	}
	public Integer evaluate() throws CalculationException{
		return this.op.calculate(this.arg1.evaluate(), this.arg2.evaluate());
	}
	public void accept(ExpressionVisitor ev) {
		ev.handle(this);
	}	
}
