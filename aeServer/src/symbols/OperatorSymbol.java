package symbols;

import operators.BinaryOperator;

public interface OperatorSymbol extends Token {
	public BinaryOperator getOperator();
}
