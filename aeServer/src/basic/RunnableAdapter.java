package basic;
public abstract class RunnableAdapter implements Runnable {
	private Thread whereIRunIn;
	private int priority;
	public RunnableAdapter(){
		super();
	}
	public void start(){
		this.start(5);
	}
/**	
 * @param priority enables to start this runnable with a java-priority 
 * REQUIRES 0 < priority < 11
 */
	public void start(int priority){
		this.whereIRunIn = new Thread(this);
		this.whereIRunIn.setPriority(priority);
		this.whereIRunIn.start();
	}
/**	
 * A random delay between 0 and milliseconds
 */
	public void delay(int millis){
		try{Thread.sleep((long)(Math.random()*millis));}catch(InterruptedException e){this.interrupt();}
	}
	public Thread getWhereIRunIn() {
		return whereIRunIn;
	}
	public void interrupt(){
		this.whereIRunIn.interrupt();
	}
	public void clearInterrupt(){
		if(this.isInterrupted())Thread.interrupted();
	}
	public boolean isInterrupted(){
		return this.getWhereIRunIn().isInterrupted();
	}
	public int getPriority(){
		return this.whereIRunIn.getPriority();
	}
}
