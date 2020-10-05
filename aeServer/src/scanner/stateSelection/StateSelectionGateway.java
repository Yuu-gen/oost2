package scanner.stateSelection;
import scanner.Scanner;
import scanner.State;

public class StateSelectionGateway implements StateSelector{
	private StateSelectionLink first;
	public StateSelectionGateway() {
/**
 * Creation of chain - can be varied here!		
 */
		this.first = new WhiteSpaceTester(new DigitTester(new BracketTester(new OperatorTester(new StateSelectionEnding()))));
	}
	public State selectStateFor(Character c, Scanner scanner) {
		return this.first.selectStateFor(c, scanner);
	}
}
