package parser;

import java.util.List;

import basic.Pipeline;
import expressions.Expression;
import expressions.Summand;
import facade.ParserException;
import symbols.*;
/**
 * Hidden part of parser (used by proxy and visitors only)
 */
class ExpressionParser implements ExpressionParserInterface{ // Paketsichtbarkeit
	public ExpressionParser(){
		super();
	}
	public Expression toExpression(Pipeline<Token> tokenPipe) throws ParserException{
		Summand s = new SummandParser().toExpression(tokenPipe);
		ExpressionAlternativeDecider ead = new ExpressionAlternativeDecider(this, tokenPipe, s);
		try {
			tokenPipe.remove().accept(ead);
		} catch (InterruptedException e) {
			System.out.println("Whatever.");
		}
		return ead.getResult();
	}
}
