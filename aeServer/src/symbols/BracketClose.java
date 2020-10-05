package symbols;

import basic.TextConstants;
import facade.ParserException;

public class BracketClose implements Token {
	
/**
 * Singleton-Entwurfsmuster: Einzige Instanz 
 */	
	private static BracketClose theInstance;
	
	private BracketClose(){
		super();
	}
/**
 * Gibt DIE einzige Instanz zurück
 */	
	public static BracketClose getTheInstance(){
		if (theInstance==null) theInstance = new BracketClose();
		return theInstance;
	}

	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}
	
	public String toString(){
		return TextConstants.BRACKETCLOSE.toString();
	}

}
