package parser;
import symbols.*;
import basic.TextConstants;
import facade.ParserException;
/**
 * Tests whether F ends with ")" if F --> (E) was used
 */
class BracketCloseEnforcer extends SymbolVisitorAdapterErrorAsDefault {
	public String errorIntro(){
		return TextConstants.EXPECTED + TextConstants.BRACKETCLOSE + TextConstants.FOUND;
	}
	public void handle(BracketClose bc) throws ParserException {// That is OK
	}
}
