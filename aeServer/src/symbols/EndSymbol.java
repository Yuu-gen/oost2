package symbols;

import basic.TextConstants;
import facade.ParserException;
/**
 * Artificial End Symbol to prevent the parsers from loosing track
 */
public class EndSymbol implements Token {
	public String toString(){
		return TextConstants.ENDOFEXPRESSION;
	}
	
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}

}
