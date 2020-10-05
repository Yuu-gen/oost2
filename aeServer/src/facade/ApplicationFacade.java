package facade;

import expressions.Expression;
import parser.ExpressionParserInterface;
import parser.ExpressionParserProxy;
import scanner.Scanner;
/**
 * Fassade in die Applikationslogik (Model) für arithmetische Ausdrücke
 */
public class ApplicationFacade {
	private String input;
	public ApplicationFacade() {
		this.input = "";
	}
	public Expression checkSyntax(String input) throws ParserException {
		Scanner s = new Scanner();
		ExpressionParserInterface ep = new ExpressionParserProxy();
		return ep.toExpression(s.toTokenSequence(input));
	}
	public Integer evaluate(String input) throws CalculationException, ParserException {
		return this.checkSyntax(input).evaluate();
	}
}
