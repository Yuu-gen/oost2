package parser;

import basic.Future;
import basic.Pipeline;
import basic.RunnableAdapter;
import expressions.Expression;
import facade.ParserException;
import symbols.Token;

public class ParserThread extends RunnableAdapter {
	ExpressionParserInterface ep;
	Pipeline<Token> resultPipe;
	Future<Expression> result;
	public ParserThread(Pipeline<Token> resultPipe) {
		super();
		this.result = new Future<Expression>();
		this.ep = new ExpressionParserProxy();
		this.resultPipe = resultPipe;
	}

	@Override
	public void run() {
		try {
			result.setContents(ep.toExpression(this.resultPipe));
		} catch (ParserException e) {
			System.out.println("INTERRUPTED");
		}

	}
	
	public Expression getResult() throws InterruptedException {
		return this.result.receiveContents();
	}

}
