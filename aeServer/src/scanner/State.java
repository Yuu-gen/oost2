package scanner;
/** 
 * Scanner state pattern
 */
public abstract class State {
	private Scanner myScanner;
	public State(Scanner myScanner) {
		super();
		this.myScanner = myScanner;
	}

/**
 * May add symbol to current Scanner result depending on <c>, 
 * May erase <c> in input string 
 * May change state    
 */
	public abstract void scan(Character c);
/**
 * Final actions if the input string has completely been traversed
 */
	public abstract void onTermination();
	
// =================================================================
// ================ Auxiliary operations for subclasses ============
// =================================================================	
	protected void endOfProcessing(){
		this.getMyScanner().setState(new SelectionState(this.getMyScanner()));
	}
	protected Scanner getMyScanner(){
		return this.myScanner;
	}
}
