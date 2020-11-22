package parser;

import java.util.List;

import basic.Pipeline;
import basic.TextConstants;
import expressions.BracketExpression;
import expressions.Expression;
import expressions.Factor;
import facade.ParserException;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.Token;
/**
 * Decides whether in a factor "(" or a natuarl number is used and creates the term accordingly
 */
class FactorAlternativeDecider extends SymbolVisitorAdapterErrorAsDefault {
	private FactorParser myParser;  // Reference to parser because of use of auxiliary methods (e.g. skipSymbolList())
	private Pipeline<Token> currentPipe; // The symbol stream 
	private Factor result;			// The computed result

	public FactorAlternativeDecider(FactorParser myParser, Pipeline<Token> currentPipe) {
		super();
		this.myParser = myParser;	
		this.currentPipe = currentPipe; 
		this.result = null; 
	}
	public Factor getResult() {
		return this.result;
	}
	@Override
	public void handle(BracketOpen bc) throws ParserException {
		Expression e = null; //Evtl Optional?
		try {
			this.currentPipe.remove();
		 // Remove "("
			e = new ExpressionParser().toExpression(this.currentPipe);
			this.currentPipe.peek().accept(new BracketCloseEnforcer());
			this.currentPipe.remove();
		} catch (InterruptedException e1) {
			System.out.println("Interrupted in Brackethandling");
		}
		//this.currentPipe.remove(0);// Remove ")"
		this.result = new BracketExpression(e);
	}
	@Override
	public void handle(NaturalNumber c) throws ParserException {
		try {
			this.result = (NaturalNumber)this.currentPipe.remove();
		} catch (InterruptedException e) {
			System.out.println("Interrupted while waiting on a number.");
		}
	} 
	@Override
	public String errorIntro() {
		return TextConstants.EXPECTED + TextConstants.factorStartSymbols() + TextConstants.FOUND;
	}
}
