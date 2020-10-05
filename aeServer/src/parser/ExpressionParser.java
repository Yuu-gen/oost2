package parser;

import java.util.List;

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
	public Expression toExpression(List<Token> tokenList) throws ParserException{
		Summand s = new SummandParser().toExpression(tokenList);
		ExpressionAlternativeDecider ead = new ExpressionAlternativeDecider(this, tokenList, s);
		tokenList.get(0).accept(ead);
		return ead.getResult();
	}
}
