package scanner.stateSelection;

import scanner.OperatorState;
import scanner.Scanner;
import scanner.State;
import scanner.SymbolTable;

class OperatorTester extends StateSelectionLink {
	public OperatorTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return SymbolTable.getInstance().exists(c);}
	public State myState(Scanner scanner) 	{return new OperatorState(scanner);}
}
