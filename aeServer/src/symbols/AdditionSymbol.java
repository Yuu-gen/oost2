package symbols;

import operators.Addition;
import operators.BinaryOperator;
import basic.TextConstants;
import facade.ParserException;

public class AdditionSymbol implements OperatorSymbol {
	private static AdditionSymbol theInstance;
	
	private AdditionSymbol(){
		super();
	}
	public static AdditionSymbol getTheInstance(){
		if (theInstance==null) theInstance = new AdditionSymbol();
		return theInstance;
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);	
	}
	
	public String toString(){
		return TextConstants.ADD.toString();
	}
	public BinaryOperator getOperator() {
		return Addition.getTheInstance();
	}
}
