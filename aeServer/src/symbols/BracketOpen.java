package symbols;

import basic.TextConstants;
import facade.ParserException;

public class BracketOpen implements Token {
	private static BracketOpen theInstance = new BracketOpen();
	private BracketOpen(){
		super();
	}
	
	public static BracketOpen getTheInstance(){
		return theInstance;
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}
	public String toString(){
		return TextConstants.BRACKETOPEN.toString();
	}
}
