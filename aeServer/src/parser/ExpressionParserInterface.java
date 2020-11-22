package parser;

import java.util.List;

import basic.Pipeline;
import expressions.Expression;
import facade.ParserException;
import symbols.Token;
/**
 * The common interface of hidden parser and its proxy
 */
public interface ExpressionParserInterface {
	public Expression toExpression(Pipeline<Token> tokenList) throws ParserException;
}
