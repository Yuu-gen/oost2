package nfaWordChecking.supervisorsWorkersCommands;

import java.util.ArrayList;
import java.util.List;

import baseClasses.Future;
import baseClasses.RunnableAdapter;
import nfaWordChecking.nfaModel.NFA;
import nfaWordChecking.objectSpaces.ObjectSpace;
import nfaWordChecking.objectSpaces.TagDirectory;

public class Supervisor extends RunnableAdapter {
	private final Integer numberOfWorkers = 4; // Number of Cores in processor would be a useful gauge;
	private NFA nfa;
	private String input;
	private ObjectSpace objectSpace;
	private List<Worker> workerList;
	private List<CheckCommand> taskBoard;
	private boolean result; //nicht mehr unbedingt benötigt.
	private Future<Boolean> finalresult;

	public Supervisor(NFA nfa, String input, ObjectSpace objectSpace) {
		super();
		this.nfa = nfa;
		this.input = input;
		this.objectSpace = objectSpace;
		this.createWorkers();
		this.taskBoard = new ArrayList<>();
		this.result = false;
		this.finalresult = new Future<Boolean>();
	}
	
	public Future<Boolean> getFinalresult() {
		return finalresult;
	}

	@Override
	public void run() {
		this.startWorkers();
		if (input.isEmpty()) {
			this.result = nfa.isTerminalState(nfa.getStartState());
		} else {
			this.taskBoard.add(new CheckCommand(nfa, nfa.getStartState(), input));
		}

		try {
			while (!taskBoard.isEmpty()) {
				this.processTasks();
			}
			this.interruptWorkers();
			this.finalresult.setContents(result);
		} catch (InterruptedException ie) {
			System.out.println("Supervisor was interrupted doing important calculations.");
			this.interruptWorkers();
		}

	}

	private void processTasks() throws InterruptedException {
		int numOfOpenTasks = taskBoard.size();
		for (CheckCommand checkCommand : taskBoard) {
			this.objectSpace.put(TagDirectory.tagForTasks, checkCommand);
		}
		this.taskBoard.clear();
		for (int i = 0; i < numOfOpenTasks; i++) {
			CheckCommand completedCommand = (CheckCommand) this.objectSpace.remove(TagDirectory.tagForResults);
			for (CheckCommand presentNextCommand : completedCommand.getResults()) {
				if (presentNextCommand.getRemainingInput().isEmpty()
						&& nfa.isTerminalState(presentNextCommand.getCurrentState())) {
					this.interruptWorkers();
					this.taskBoard.clear();
					this.result = true;
					return;
				}
				if (!presentNextCommand.getRemainingInput().isEmpty())
					this.taskBoard.add(presentNextCommand);
			}

		}
	}

	private void createWorkers() {
		this.workerList = new ArrayList<>();
		for (int i = 0; i < numberOfWorkers; i++) {
			this.workerList.add(new Worker(this.objectSpace));
		}
	}

	private void startWorkers() {
		for (Worker w : this.workerList) {
			w.start();
		}
	}

	private void interruptWorkers() {
		for (Worker w : this.workerList) w.interrupt();
	}

	
}
