package nfaWordChecking.supervisorsWorkersCommands;

import baseClasses.Command;
import baseClasses.RunnableAdapter;
import nfaWordChecking.objectSpaces.ObjectSpace;
import nfaWordChecking.objectSpaces.TagDirectory;

public class Worker extends RunnableAdapter {
	private ObjectSpace objectSpace;
	public Worker(ObjectSpace objectSpace) {
		super();
		this.objectSpace= objectSpace;
	}

	@Override
	public void run() {
		try {
			while(!this.isInterrupted()) {
				Command currentCommand = this.objectSpace.remove(TagDirectory.tagForTasks); //entnehmen
				currentCommand.execute(); //bearbeiten
				this.objectSpace.put(TagDirectory.tagForResults, currentCommand); //zurücklegen
			}
		}catch(InterruptedException ie) {
			this.interrupt();
		}
		
	}

}
