package facade;

import basic.Future;
import basic.Pipeline;
import basic.PipelineImplementierung;
import expressions.Expression;
import parser.ExpressionParserInterface;
import parser.ExpressionParserProxy;
import parser.ParserThread;
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

	public Expression checkSyntax(String input) throws ParserException, InterruptedException {
		Pipeline<Token> resultPipe = new PipelineImplementierung<>("tokens", 10, "    ");
		ScannerThread s = new ScannerThread(resultPipe, input);
		s.start();
		//ParserThread p = new ParserThread(resultPipe);
//		Future<Expression> result = new Future<Expression>();
//		Expression expression = new ExpressionParserProxy().toExpression(resultPipe);
//		result.setContents(expression);
		//return result.receiveContents();
		return new ExpressionParserProxy().toExpression(resultPipe);
		//p.start();
		//return p.getResult();
		// return ep.toExpression(s.toTokenSequence(input)); //irgendwie Pipeline
		// übergeben
	}

	public Integer evaluate(String input) throws CalculationException, ParserException, InterruptedException {
		return this.checkSyntax(input).evaluate();
	}
}
