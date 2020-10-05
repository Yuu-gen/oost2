package symbols;

import basic.TextConstants;
import facade.ParserException;
import operators.BinaryOperator;
import operators.Division;

public class DivisionSymbol implements OperatorSymbol{
	private static DivisionSymbol theInstance;
	
	private DivisionSymbol(){
		super();
	}
	public static DivisionSymbol getTheInstance(){
		if (theInstance==null) theInstance = new DivisionSymbol();
		return theInstance;
	}

	public String toString(){
		return TextConstants.DIV.toString();
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
		
	}
	public BinaryOperator getOperator() {
		return Division.getTheInstance();
	}

}
