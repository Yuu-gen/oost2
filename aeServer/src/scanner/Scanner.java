package scanner;
import java.util.ArrayList;
import java.util.List;

import symbols.EndSymbol;
import symbols.Token;
import basic.Pipeline;
import basic.PipelineImplementierung;
import basic.TextConstants;
/**
 * The main entry point for lexical analysis of string expressions
 */
public class Scanner {
	private State state;				// State Pattern
	private String currentExpression;	// Input 	(reduced during scanning)
	private Pipeline<Token> currentResult;	// Output 	(grows during scanning) 
	public Scanner(Pipeline result) {
		super();
		this.currentExpression = TextConstants.EMPTYWORD;	
		this.currentResult = result;
		this.state = new SelectionState(this); // Start State
	}
/**
 * EFFECTS: Transformation of input string expr into sequence of symbols 
 */
	public void toTokenSequence(String expr){ 
		this.currentExpression = expr;					 
		while(this.currentExpression.length()>0) 
			this.state.scan(this.currentExpression.charAt(0));
		this.state.onTermination();
		try {
			this.currentResult.push(new EndSymbol());
		} catch (InterruptedException e) {
			System.out.println("Interrupted while adding endsymbol");
		}
		//return this.currentResult; 
	}
/**	
 * EFFECTS: 	Deletion of first character of this.currentExpression
 * REQUIRES:	currentExpression.length>0
 */
	void skip(){
		this.currentExpression = this.currentExpression.substring(1);
	}
	void addSymbol(Token s){
		try {
			this.currentResult.push(s);
		} catch (InterruptedException e) {
			System.out.println("Scanning was interrupted");
			//Eventuell besseres Handling einfügen
		}
	}
	void setState(State newState){
		this.state = newState;
	}
}
