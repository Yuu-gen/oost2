package airplaneWithConditionedSynchronisationTemplate;

import java.lang.Thread.State;
/**
 * encapsulates standard Thread behavior to reduce 
 * redundant code.
 * @author Y
 *
 */
public abstract class RunnableAdapter implements Runnable {
	private Thread whereIRunIn;
	public RunnableAdapter(){
		super();
	}
	public void start(){
		this.whereIRunIn = new Thread(this);
		this.whereIRunIn.start();
	}
	public void interrupt(){
		this.whereIRunIn.interrupt();
	}
	public boolean isInterrupted(){
		return this.whereIRunIn.isInterrupted();
	}
	public State getState() {
		return this.whereIRunIn.getState();
	}
}
