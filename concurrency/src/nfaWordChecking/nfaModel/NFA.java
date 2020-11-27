package nfaWordChecking.nfaModel;

import java.util.Set;
/**
 * Represents a model of an NFA, is able to check which words this automaton can accept.
 *
 */
public class NFA {
	
	private AutomatonState start;
	private Set<AutomatonState> states;
	private Set<Transition> transitions;
	
	public NFA(AutomatonState start, Set<AutomatonState> states, Set<Transition> transitions) {
		super();
		this.start = start;
		this.states = states;
		this.transitions = transitions;
	}

	public AutomatonState getStart() {
		return start;
	}

	public Set<AutomatonState> getStates() {
		return states;
	}


	public Set<Transition> getTransitions() {
		return transitions;
	}
	
	private Set<AutomatonState> getTargetStates(AutomatonState z, char input){
		return null;
	}
	
	public boolean check(String word) {
		return false;
		
	}
	
	

}
