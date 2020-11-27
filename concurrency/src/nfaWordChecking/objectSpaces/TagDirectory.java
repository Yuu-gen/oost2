package nfaWordChecking.objectSpaces;

import java.util.HashMap;
import java.util.Map;

import baseClasses.Semaphor;

public class TagDirectory {
	public static Semaphor tagForTasks;
	public static Semaphor tagForResults;
	public static Semaphor tagForStopCommand;
	private static Map<Semaphor, String> namesOfTags = new HashMap<Semaphor, String>();
	
	static{initialize();}
	public static void initialize(){
		tagForTasks 	= new Semaphor(0);
		tagForResults 	= new Semaphor(0);
		tagForStopCommand 	= new Semaphor(0);
		namesOfTags.put(tagForTasks, "TASK");
		namesOfTags.put(tagForResults, "RESULT");
		namesOfTags.put(tagForStopCommand, "STOP");
	}
	public static String getName(Semaphor tag){return namesOfTags.get(tag);}
}
