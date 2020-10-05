package parser;

import java.util.List;

import expressions.Expression;
import facade.ParserException;
import symbols.Token;
/**
 * The common interface of hidden parser and its proxy
 */
public interface ExpressionParserInterface {
	public Expression toExpression(List<Token> tokenList) throws ParserException;
}
