package parser;

import java.util.List;

import basic.Pipeline;
import basic.TextConstants;
import expressions.Expression;
import facade.ParserException;
import symbols.EndSymbol;
import symbols.Token;
/**
 * A proxy for an expression parser - enabling preprocessing
 */
public class ExpressionParserProxy implements ExpressionParserInterface{
	public Expression toExpression(Pipeline<Token> tokenPipe) throws ParserException{
//		try {
//			tokenPipe.push(new EndSymbol()); //WTF
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //END SYMBOLIS PROVIDED BY SCANNER!...
		ExpressionParserInterface ep = new ExpressionParser();
		Expression exp = ep.toExpression(tokenPipe);
		//if(tokenPipe.getCount() > 1) throw new ParserException(TextConstants.somethingExtraBehind + tokenList.toString());
		return exp;
	}
}
