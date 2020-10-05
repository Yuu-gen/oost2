package scanner;

import java.util.HashMap;
import java.util.Map;

import symbols.AdditionSymbol;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.DivisionSymbol;
import symbols.MultiplicationSymbol;
import symbols.SubtractionSymbol;
import symbols.Token;
import basic.TextConstants;
/**
 * Singleton to define valid operator symbols
 */
public class SymbolTable {
	private static SymbolTable instance = new SymbolTable();
	private Map<Character, Token> symbols; 
	
	private SymbolTable(){this.fillSymbolMap();}
	
	public static SymbolTable getInstance(){return instance;}

	public boolean exists(Character key){return this.symbols.containsKey(key);}
	public Token get(Character key){return this.symbols.get(key);}
	
	private void fillSymbolMap(){
		this.symbols = new HashMap<Character, Token>();
		this.symbols.put(TextConstants.BRACKETOPEN, BracketOpen.getTheInstance());
		this.symbols.put(TextConstants.BRACKETCLOSE, BracketClose.getTheInstance());
		this.symbols.put(TextConstants.ADD, AdditionSymbol.getTheInstance());
		this.symbols.put(TextConstants.SUB, SubtractionSymbol.getTheInstance());
		this.symbols.put(TextConstants.MULTIPLY, MultiplicationSymbol.getTheInstance());
		this.symbols.put(TextConstants.DIV, DivisionSymbol.getTheInstance());
	}
}
