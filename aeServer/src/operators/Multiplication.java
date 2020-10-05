package operators;

import symbols.MultiplicationSymbol;
/**
 * The one and only multiplication operator as a singleton
 */
public class Multiplication extends BinaryOperator {
	private static Multiplication theInstance = new Multiplication();
	private Multiplication(){
		super(MultiplicationSymbol.getTheInstance());
	}
	
	public static Multiplication getTheInstance(){
		return theInstance;
	}

	public Integer calculate(Integer arg1, Integer arg2){
		return arg1 * arg2;
	}

}
