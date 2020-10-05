package symbols;

import operators.BinaryOperator;
import operators.Subtraction;
import basic.TextConstants;
import facade.ParserException;

public class SubtractionSymbol implements OperatorSymbol {
	private static SubtractionSymbol theInstance;
	
	private SubtractionSymbol(){
		super();
	}
	public static SubtractionSymbol getTheInstance(){
		if (theInstance==null) theInstance = new SubtractionSymbol();
		return theInstance;
	}
	public String toString(){
		return TextConstants.SUB.toString();
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}
	public BinaryOperator getOperator() {
		return Subtraction.getTheInstance();
	}
}
