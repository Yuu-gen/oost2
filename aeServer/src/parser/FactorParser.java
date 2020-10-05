package parser;

import java.util.List;
import expressions.Factor;
import facade.ParserException;
import symbols.*;
/**
 * Responsible for parsing expressions of shape "(E)" or "n\in Nat"
 */
class FactorParser{
	public FactorParser() {
		super();
	}
	public Factor toExpression(List<Token> symbolList) throws ParserException{
		FactorAlternativeDecider fad = new FactorAlternativeDecider(this, symbolList);
		symbolList.get(0).accept(fad);
		return fad.getResult();
	}	
}
