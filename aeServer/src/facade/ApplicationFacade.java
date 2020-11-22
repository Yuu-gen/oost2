package facade;

import basic.Pipeline;
import basic.PipelineImplementierung;
import expressions.Expression;
import parser.ExpressionParserInterface;
import parser.ExpressionParserProxy;
import scanner.Scanner;
import scanner.ScannerThread;
import symbols.Token;
/**
 * Fassade in die Applikationslogik (Model) für arithmetische Ausdrücke
 */
public class ApplicationFacade {
	private String input;
	public ApplicationFacade() {
		this.input = "";
	}
	public Expression checkSyntax(String input) throws ParserException {
		Pipeline<Token> resultPipe = new PipelineImplementierung<>("tokens", 10, "    ");
		ScannerThread s = new ScannerThread(resultPipe, input);
		ExpressionParserInterface ep = new ExpressionParserProxy();
		//return ep.toExpression(s.toTokenSequence(input)); //irgendwie Pipeline übergeben
	}
	public Integer evaluate(String input) throws CalculationException, ParserException {
		return this.checkSyntax(input).evaluate();
	}
}
