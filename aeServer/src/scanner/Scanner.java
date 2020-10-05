package scanner;
import java.util.ArrayList;
import java.util.List;

import symbols.Token;
import basic.TextConstants;
/**
 * The main entry point for lexical analysis of string expressions
 */
public class Scanner {
	private State state;				// State Pattern
	private String currentExpression;	// Input 	(reduced during scanning)
	private List<Token> currentResult;	// Output 	(grows during scanning) 
	public Scanner() {
		super();
		this.currentExpression = TextConstants.EMPTYWORD;	
		this.currentResult = new ArrayList<Token>();
		this.state = new SelectionState(this); // Start State
	}
/**
 * EFFECTS: Transformation of input string expr into sequence of symbols 
 */
	public List<Token> toTokenSequence(String expr){ 
		this.currentExpression = expr;					 
		while(this.currentExpression.length()>0) 
			this.state.scan(this.currentExpression.charAt(0));
		this.state.onTermination();
		return this.currentResult; 
	}
/**	
 * EFFECTS: 	Deletion of first character of this.currentExpression
 * REQUIRES:	currentExpression.length>0
 */
	void skip(){
		this.currentExpression = this.currentExpression.substring(1);
	}
	void addSymbol(Token s){
		this.currentResult.add(s);
	}
	void setState(State newState){
		this.state = newState;
	}
}
