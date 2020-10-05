package parser;

import java.util.List;

import basic.TextConstants;
import expressions.Factor;
import expressions.Product;
import expressions.Summand;
import facade.ParserException;
import symbols.DivisionSymbol;
import symbols.EndSymbol;
import symbols.MultiplicationSymbol;
import symbols.OperatorSymbol;
import symbols.Token;
/**
 * Decides whether in an expression an operator * or / is used and creates the term accordingly
 */
class SummandAlternativeDecider extends SymbolVisitorAdapterNothingAsDefault {
	private SummandParser myParser;   // Reference used for auxiliary methods (e.g. skipSymbolList())
	private List<Token> currentList; // The symbol stream
	private Summand result;           // The computed result
/**	
 * @param arg1 = First argument of summand (must already be computed)
 */
	public SummandAlternativeDecider(SummandParser myParser, List<Token> currentList, Factor arg1){
		this.myParser = myParser;
		this.currentList = currentList;
		this.result = arg1;			 
	}
	public Summand getResult() {
		return this.result;
	}
	@Override
	public String errorIntro() {
		return TextConstants.EXPECTED+TextConstants.multOperators()+TextConstants.FOUND;
	}
	public void handle(MultiplicationSymbol m) throws ParserException {
		this.createTerm(m);
	}
	public void handle(DivisionSymbol d) throws ParserException {
		this.createTerm(d);
	}
	public void handle(EndSymbol es) throws ParserException {//Nothing: Parsing finishes
	}
	private void createTerm(OperatorSymbol op) throws ParserException{
		this.currentList.remove(0);
		this.result = new Product((Factor)this.result, new SummandParser().toExpression(this.currentList), op.getOperator());
	}
}
