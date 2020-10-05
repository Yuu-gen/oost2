package scanner.stateSelection;

import scanner.DigitState;
import scanner.Scanner;
import scanner.State;

class DigitTester extends StateSelectionLink {
	public DigitTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return Character.isDigit(c);}
	public State myState(Scanner scanner) {return new DigitState(scanner);}
}
