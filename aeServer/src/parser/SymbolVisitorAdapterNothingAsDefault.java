package parser;

import facade.ParserException;
import symbols.AdditionSymbol;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.DivisionSymbol;
import symbols.EndSymbol;
import symbols.ErrorToken;
import symbols.MultiplicationSymbol;
import symbols.SubtractionSymbol;
import symbols.SymbolVisitor;
/**
 * The default behavior here is to ignore syntax errors everywhere!
 */
abstract class SymbolVisitorAdapterNothingAsDefault implements SymbolVisitor {
	public void handle(AdditionSymbol a) throws ParserException{}
	public void handle(BracketOpen bo)throws ParserException{}
	public void handle(BracketClose bc)throws ParserException{}
	public void handle(NaturalNumber c)throws ParserException{}
	public void handle(MultiplicationSymbol m)throws ParserException{}
	public void handle(EndSymbol es)throws ParserException{}
	public void handle(ErrorToken es)throws ParserException{}
	public void handle(SubtractionSymbol ss)throws ParserException{}
	public void handle(DivisionSymbol ds)throws ParserException{}
	
	public abstract String errorIntro();
}
