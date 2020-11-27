package nfaWordChecking.nfaModel;
/**
 * Represents a transition in a NFA using 3-Tuple (Triple) of the transition function 
 * (sourceState, input, targetState)
 */
public class Transition {
	private final char input;
	private final AutomatonState source;
	private final AutomatonState target;
	
	public Transition(AutomatonState source, char input, AutomatonState target) {
		this.source = source;
		this.input = input;
		this.target = target;
	}

	public char getInput() {
		return input;
	}

	public AutomatonState getSource() {
		return source;
	}

	public AutomatonState getTarget() {
		return target;
	}

}
