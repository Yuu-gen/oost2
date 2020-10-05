package scanner.stateSelection;

import basic.TextConstants;
import scanner.BracketState;
import scanner.Scanner;
import scanner.State;

class BracketTester extends StateSelectionLink {
	public BracketTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return TextConstants.isBracket(c);}
	public State myState(Scanner scanner) {return new BracketState(scanner);}
}

