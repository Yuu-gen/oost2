package scanner.stateSelection;

import scanner.ErrorState;
import scanner.Scanner;
import scanner.State;
/**
 * Chain Ending!
 */
class StateSelectionEnding implements StateSelector {
	public State selectStateFor(Character c, Scanner scanner) {
		return new ErrorState(scanner);
	}
}
