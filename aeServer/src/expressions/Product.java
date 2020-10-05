package expressions;

import facade.CalculationException;
import operators.BinaryOperator;
/**
 * A term of type F*S or F/S
 */
public class Product implements Summand, BinaryTerm {
	private Factor arg1;
	private Summand arg2;
	private BinaryOperator op;
	public Product(Factor arg1, Summand arg2, BinaryOperator op) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.op = op;
	}

	public Integer evaluate() throws CalculationException{
		return this.op.calculate(this.arg1.evaluate(), this.arg2.evaluate());
	}
	public void accept(ExpressionVisitor ev) {
		ev.handle(this);
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
}
