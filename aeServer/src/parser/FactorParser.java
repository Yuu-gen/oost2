package parser;

import java.util.List;

import basic.Pipeline;
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
	public Factor toExpression(Pipeline<Token> symbolPipe) throws ParserException{
		FactorAlternativeDecider fad = new FactorAlternativeDecider(this, symbolPipe);
		try {
			symbolPipe.peek().accept(fad);
		}catch (InterruptedException e) {
			System.out.println("AAAAAHHHHHH");
		}
		return fad.getResult();
	}	
}
