package nfaWordChecking.nfaModel;

import java.util.HashSet;
import java.util.Set;

import nfaWordChecking.objectSpaces.ObjectSpace;
import nfaWordChecking.supervisorsWorkersCommands.Supervisor;

/**
 * Represents a model of an NFA, is able to check which words this automaton can
 * accept.
 *
 */
public class NFA {

	private AutomatonState startState;
	private Set<AutomatonState> states;
	private Set<Transition> transitions;

	public NFA(AutomatonState start, Set<AutomatonState> states, Set<Transition> transitions) {
		super();
		this.startState = start;
		this.states = states;
		this.transitions = transitions;
	}

	public AutomatonState getStartState() {
		return startState;
	}

	public Set<AutomatonState> getStates() {
		return states;
	}

	public Set<Transition> getTransitions() {
		return transitions;
	}

	public Set<AutomatonState> getTargetStates(AutomatonState z, char input) {
		Set<AutomatonState> targetStates = new HashSet<AutomatonState>();
		for (Transition t : this.transitions) {
			if (t.getSource().equals(z) && t.getInput() == input) {
				targetStates.add(t.getTarget());
			}
		}
		return targetStates;
	}

	/**
	 * Checks if word is in the automatons language
	 * 
	 * @param word
	 * @return
	 * @throws InterruptedException
	 */
	public boolean check(String word) throws InterruptedException {
		Supervisor commandant = new Supervisor(this, word, new ObjectSpace());
		commandant.start();
		return commandant.getFinalresult().receiveContents();
	}

	public boolean isTerminalState(AutomatonState state) {
		return state.isTerminal();
	}

}
