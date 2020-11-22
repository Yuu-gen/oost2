package parser;

import java.util.List;

import basic.Pipeline;
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
	public Summand toExpression(Pipeline<Token> symbolPipe) throws ParserException{
		Factor arg1 = new FactorParser().toExpression(symbolPipe);
		SummandAlternativeDecider sad = new SummandAlternativeDecider(this, symbolPipe, arg1);
		try {
			symbolPipe.peek().accept(sad);
		} catch (InterruptedException e) {
			System.out.println("Interrupted while SUMMANDING");
		}
		return sad.getResult();
	}	
}
