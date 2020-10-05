package parser;

import java.util.List;

import expressions.Factor;
import expressions.Summand;
import facade.ParserException;
import symbols.*;
/**
 * Responsible for parsing expressions of shape "F*S", "F/S", or "F"
 */
class SummandParser{
	public SummandParser(){
		super();
	}
	public Summand toExpression(List<Token> symbolList) throws ParserException{
		Factor arg1 = new FactorParser().toExpression(symbolList);
		SummandAlternativeDecider sad = new SummandAlternativeDecider(this, symbolList, arg1);
		symbolList.get(0).accept(sad);
		return sad.getResult();
	}	
}
