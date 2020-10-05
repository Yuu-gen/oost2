package parser;

import java.util.List;

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
	private List<Token> currentList; // The symbol stream 
	private Factor result;			// The computed result

	public FactorAlternativeDecider(FactorParser myParser, List<Token> currentList) {
		super();
		this.myParser = myParser;	
		this.currentList = currentList; 
		this.result = null; 
	}
	public Factor getResult() {
		return this.result;
	}
	@Override
	public void handle(BracketOpen bc) throws ParserException {
		this.currentList.remove(0); // Remove "("
		Expression e = new ExpressionParser().toExpression(this.currentList);
		this.currentList.get(0).accept(new BracketCloseEnforcer()); 
		this.currentList.remove(0);// Remove ")"
		this.result = new BracketExpression(e);
	}
	@Override
	public void handle(NaturalNumber c) throws ParserException {
		this.result = (NaturalNumber)this.currentList.remove(0);
	}
	@Override
	public String errorIntro() {
		return TextConstants.EXPECTED + TextConstants.factorStartSymbols() + TextConstants.FOUND;
	}
}
