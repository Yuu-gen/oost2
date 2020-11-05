package readerWriterVorlage;

import baseClasses.RunnableAdapter;

public abstract class MyRun extends RunnableAdapter { 
	private String name; 
	private AccessManagerVorlage accessManager;
	public MyRun(AccessManagerVorlage accessManager, String name){
		this.accessManager 	= accessManager;
		this.name 			= name;
	}
	public AccessManagerVorlage getAccessManager(){
		return this.accessManager;
	}
	public void run(){
		try{
			while(!this.isInterrupted()){
				Resource r = this.startAction();
				this.delay();
				this.action(r);
				this.delay();					
				this.stopAction();
				this.delay();				
			}
		}
		catch(InterruptedException ie){
			System.out.println(this.toString() + ": Interrupt beim Warten.");
			this.interrupt();
		}
		System.out.println(this.toString() + ": Ende.");
	}
	public abstract Resource startAction() throws InterruptedException;
	public abstract void action(Resource r);
	public abstract void stopAction() throws InterruptedException;
	public String toString(){
		return this.name; 
	}
/**
 * A small amount of waiting time to make the effects more transparent
 */
	private void delay() throws InterruptedException{
		Thread.sleep((long)(Math.random()*10));
	}
}
