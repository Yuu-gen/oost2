package parser;

import java.util.List;

import basic.TextConstants;
import expressions.Expression;
import facade.ParserException;
import symbols.EndSymbol;
import symbols.Token;
/**
 * A proxy for an expression parser - enabling preprocessing
 */
public class ExpressionParserProxy implements ExpressionParserInterface{
	public Expression toExpression(List<Token> tokenList) throws ParserException{
		tokenList.add(new EndSymbol());
		ExpressionParserInterface ep = new ExpressionParser();
		Expression exp = ep.toExpression(tokenList);
		if(tokenList.size() > 1) throw new ParserException(TextConstants.somethingExtraBehind + tokenList.toString());
		return exp;
	}
}
