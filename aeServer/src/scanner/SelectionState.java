package scanner;

import scanner.stateSelection.StateSelectionGateway;
/**
 * Responsible for determining the next state
 */
public class SelectionState extends State {
	private StateSelectionGateway stateSelector;
	public SelectionState(Scanner myScanner) {
		super(myScanner);
		this.stateSelector = new StateSelectionGateway();
	}
	public void scan(Character c) {
		Scanner s = this.getMyScanner();
		s.setState(this.stateSelector.selectStateFor(c, s));
	}
	public void onTermination() {
		return;
	}
}
