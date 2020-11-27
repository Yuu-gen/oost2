package nfaWordChecking.supervisorsWorkersCommands;

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
				CheckCommand currentCommand = (CheckCommand)this.objectSpace.remove(TagDirectory.tagForTasks);
				currentCommand.execute();
				this.objectSpace.put(TagDirectory.tagForResults, currentCommand);
			}
		}catch(InterruptedException ie) {
			this.interrupt();
		}
		
	}

}
