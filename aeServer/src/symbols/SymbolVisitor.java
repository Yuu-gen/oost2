package symbols;

import facade.ParserException;
/**
 * Object for rendezvous with symbols
 */
public interface SymbolVisitor {
	public void handle(AdditionSymbol a) throws ParserException;
	public void handle(BracketOpen bo) throws ParserException;
	public void handle(BracketClose bc) throws ParserException;
	public void handle(NaturalNumber c) throws ParserException;
	public void handle(MultiplicationSymbol m) throws ParserException;
	public void handle(EndSymbol es) throws ParserException;
	public void handle(ErrorToken es) throws ParserException;
	public void handle(SubtractionSymbol ss) throws ParserException;
	public void handle(DivisionSymbol ds) throws ParserException;
}
