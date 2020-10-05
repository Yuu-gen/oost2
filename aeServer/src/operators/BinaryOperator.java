package operators;

import facade.CalculationException;
import symbols.OperatorSymbol;
/**
 * Any binary operator (like +, -, *, /, etc)
 */
public abstract class BinaryOperator{
	private OperatorSymbol theSymbol;
	public BinaryOperator(OperatorSymbol theSymbol){
		this.theSymbol = theSymbol;
	}
	public String toString(){
		return theSymbol.toString();
	}
/**
 * Returns the evaluation of <this>(arg1, arg2)
 */
	public abstract Integer calculate(Integer arg1, Integer arg2) throws CalculationException;
}
