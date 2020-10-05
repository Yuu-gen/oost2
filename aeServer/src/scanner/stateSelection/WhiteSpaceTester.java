package scanner.stateSelection;

import scanner.Scanner;
import scanner.State;
import scanner.WhitespaceState;

class WhiteSpaceTester extends StateSelectionLink {
	public WhiteSpaceTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return Character.isWhitespace(c);}
	public State myState(Scanner scanner) {return new WhitespaceState(scanner);}
}
