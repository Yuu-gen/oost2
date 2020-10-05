package scanner.stateSelection;
import scanner.Scanner;
import scanner.State;
/**
 * Encapsulation of state selection in a chain of responsibilities
 */
public interface StateSelector {
/**
 * Depending on <c> return a new state for <scanner> 	
 */
	public State selectStateFor(Character c, Scanner scanner);
}
