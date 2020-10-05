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
import symbols.Token;
import symbols.SymbolVisitor;
/**
 * The default behavior here is to create syntax errors everywhere!
 */
abstract class SymbolVisitorAdapterErrorAsDefault implements SymbolVisitor {
	public void handle(AdditionSymbol a) throws ParserException {exc(a);}
	public void handle(BracketOpen bo) throws ParserException {exc(bo);}
	public void handle(BracketClose bc) throws ParserException {exc(bc);}
	public void handle(NaturalNumber c) throws ParserException {exc(c);}
	public void handle(MultiplicationSymbol m) throws ParserException {exc(m);}
	public void handle(EndSymbol es) throws ParserException {exc(es);}
	public void handle(ErrorToken es) throws ParserException {exc(es);}
	public void handle(SubtractionSymbol ss) throws ParserException {exc(ss);}
	public void handle(DivisionSymbol ds) throws ParserException {exc(ds);}
	
	public abstract String errorIntro();
	private void exc(Token s) throws ParserException{
		throw new ParserException(this.errorIntro()+s.toString());
	}
}
