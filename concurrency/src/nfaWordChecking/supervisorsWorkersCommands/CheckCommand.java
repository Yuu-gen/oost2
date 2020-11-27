package nfaWordChecking.supervisorsWorkersCommands;

import java.util.ArrayList;
import java.util.List;

import baseClasses.Command;
import nfaWordChecking.nfaModel.AutomatonState;
import nfaWordChecking.nfaModel.NFA;

public class CheckCommand implements Command {
	private NFA nfa;
	private AutomatonState currentState;
	private String remainingInput;
	private List<CheckCommand> results;
	public CheckCommand(NFA nfa, AutomatonState currentState, String remainingInput) {
		super();
		this.nfa = nfa;
		this.currentState = currentState;
		this.remainingInput = remainingInput;
		this.results = new ArrayList<>();
	}
	//should be used in a command-Interface
	public void execute() {
		if(remainingInput.isEmpty()) return;
		for(AutomatonState nextState: nfa.getTargetStates(currentState, remainingInput.charAt(0))) {
			this.results.add(this.transition(nextState));
		}
	}
	public AutomatonState getCurrentState() {
		return this.currentState;
	}
	public String getRemainingInput() {
		return remainingInput;
	}
	public List<CheckCommand> getResults() {
		return results;
	}
	
	private CheckCommand transition(AutomatonState nextState) {
		return new CheckCommand(nfa, nextState, remainingInput.substring(1));
	}
	
}
