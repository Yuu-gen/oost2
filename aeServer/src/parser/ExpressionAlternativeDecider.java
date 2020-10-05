package parser;

import java.util.List;

import basic.TextConstants;
import expressions.Expression;
import expressions.Sum;
import expressions.Summand;
import facade.ParserException;
import symbols.AdditionSymbol;
import symbols.EndSymbol;
import symbols.OperatorSymbol;
import symbols.SubtractionSymbol;
import symbols.Token;
/**
 * Decides whether in an expression an operator + or - is used and creates the term accordingly
 */
class ExpressionAlternativeDecider extends SymbolVisitorAdapterNothingAsDefault {
	private ExpressionParser myParser; // Reference used for auxiliary methods (e.g. skipSymbolList())
	private List<Token> currentList;  // The symbol stream
	private Expression result;         // The computed result
/**	
 * @param arg1 = First argument of expression (must already be computed)
 */	
	public ExpressionAlternativeDecider(ExpressionParser myParser, List<Token> currentList, Summand arg1){
		this.myParser = myParser;
		this.currentList = currentList;
		this.result = arg1;
	}
	public Expression getResult() {
		return this.result;
	}
	@Override
	public String errorIntro() {
		return TextConstants.EXPECTED+TextConstants.addOperators()+TextConstants.FOUND;
	}
	@Override
	public void handle(AdditionSymbol a) throws ParserException {
		this.createTerm(a);
	}
	@Override
	public void handle(SubtractionSymbol s) throws ParserException {
		this.createTerm(s);
	}
	@Override
	public void handle(EndSymbol es) throws ParserException {// Nothing: Parsing finishes
	}
	private void createTerm(OperatorSymbol op) throws ParserException{
		this.currentList.remove(0);
		this.result = new Sum((Summand)this.result, new ExpressionParser().toExpression(this.currentList), op.getOperator());
	}
}
