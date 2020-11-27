package nfaWordChecking.objectSpaces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import baseClasses.Command;
import baseClasses.CommandINVOKER;
import baseClasses.Semaphor;
/**
 * An object space contains tagged tasks
 * Tags are semaphors whose counter indicates the number of 
 * contained entries for this tag in the object space 
 */
public class ObjectSpace {
	private Set<ObjectSpaceEntry> contents;
	private Semaphor mutex;
	public ObjectSpace(){
		this.contents 	= new HashSet<ObjectSpaceEntry>();
		this.mutex 		= new Semaphor(1);			// Lock for this' contents
	}
	public boolean isEmpty() throws InterruptedException {
		this.mutex.down();
		boolean r = this.contents.isEmpty();
		this.mutex.up();
		return r;
	}
	public void put(Semaphor tag, Command task) throws InterruptedException{
		this.mutex.down();
		this.contents.add(new ObjectSpaceEntry(tag, task));
		tag.up();
		this.mutex.up();
	}
/**
 * Remove one randomly chosen command with the given <tag> from the space
 */
	public Command remove(Semaphor tag) throws InterruptedException{
		tag.down();
		this.mutex.down();
		ObjectSpaceEntry grabbed = this.getAllEntriesFor(tag).get(0);
		this.contents.remove(grabbed);
		this.mutex.up();
		return grabbed.getTask();
	}
/**	
 * Reads some entry for <tag> without removing it 
 * @throws InterruptedException 
 */
	public Optional<ObjectSpaceEntry> read(Semaphor tag) throws InterruptedException{
		this.mutex.down();
		List<ObjectSpaceEntry> entries = this.getAllEntriesFor(tag);
		Optional<ObjectSpaceEntry> result = null;
		if(entries.isEmpty()) 	result = Optional.empty();
		else					result = Optional.of(entries.get(0));
		this.mutex.up();
		return result;
	}
// =================== Private part =================================
	private List<ObjectSpaceEntry> getAllEntriesFor(Semaphor tag){
		List<ObjectSpaceEntry> result = new ArrayList<ObjectSpaceEntry>();
		for (ObjectSpaceEntry current : this.contents) if(current.getTag()==tag) result.add(current);
		return result;		
	}
}
