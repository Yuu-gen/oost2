package nfaWordChecking.objectSpaces;

import baseClasses.Command;
import baseClasses.CommandINVOKER;
import baseClasses.Semaphor;

public class ObjectSpaceEntry {
	private Semaphor tag; 
	private Command task;
	public ObjectSpaceEntry(Semaphor tag, Command task2) {
		super();
		this.tag = tag;
		this.task = task2;
	}
	Semaphor getTag() {
		return tag;
	}
	Command getTask() {
		return task;
	}
	public String toString(){
		return "(" + tag + "," + task + ")";
	}
	
}
