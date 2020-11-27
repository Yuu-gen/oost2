package nfaWordChecking.nfaModel;
/**
 * Represents a state of an automaton 
 *
 */
public class AutomatonState {
	private final String name;
	private final boolean isTerminal;
	
	public AutomatonState(String name, boolean isTerminal) {
		this.name = name;
		this.isTerminal = isTerminal;
	}

	public String getName() {
		return name;
	}

	public boolean isTerminal() {
		return isTerminal;
	}
	

}
