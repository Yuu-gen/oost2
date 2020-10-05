package symbols;

import facade.ParserException;

/**
 * Visitable objects according to the logic of Visitor Pattern
 */
public interface Visitable {
	public void accept(SymbolVisitor sv) throws ParserException;
}
