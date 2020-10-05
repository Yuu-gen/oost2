package scanner.stateSelection;

import scanner.Scanner;
import scanner.State;

abstract class StateSelectionLink implements StateSelector{
	private StateSelector successor;
	public StateSelectionLink(StateSelector successor){
		this.successor = successor;
	}
	public abstract boolean myCondition(Character c);
	public abstract State myState(Scanner scanner);

/**	
 * Chain delegation template
 */
	public State selectStateFor(Character c, Scanner scanner) {
		if(myCondition(c)) 	return myState(scanner);
		else				return this.getSuccessor().selectStateFor(c, scanner); 
	}
	public StateSelector getSuccessor() {
		return this.successor;
	}
}
