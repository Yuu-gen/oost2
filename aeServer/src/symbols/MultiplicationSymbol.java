package symbols;

import basic.TextConstants;
import facade.ParserException;
import operators.BinaryOperator;

public class MultiplicationSymbol implements OperatorSymbol{
	private static MultiplicationSymbol theInstance;
	
	private MultiplicationSymbol(){
		super();
	}
	public static MultiplicationSymbol getTheInstance(){
		if (theInstance==null) theInstance = new MultiplicationSymbol();
		return theInstance;
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}

	public BinaryOperator getOperator() {
		return operators.Multiplication.getTheInstance();
	}
	
	public String toString(){
		return TextConstants.MULTIPLY.toString();
	}

}
