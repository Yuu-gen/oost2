package operators;
import facade.CalculationException;
/**
 * The one and only division operator as a singleton
 */
import symbols.DivisionSymbol;
public class Division extends BinaryOperator {
	private static Division theInstance = new Division();
	private Division(){
		super(DivisionSymbol.getTheInstance());
	}
	public static Division getTheInstance(){
		return theInstance;
	}
	public Integer calculate(Integer arg1, Integer arg2) throws CalculationException{
		if(arg2.equals(new Integer(0))) throw new CalculationException("Division by zero");
		return arg1 / arg2;
	}
}
