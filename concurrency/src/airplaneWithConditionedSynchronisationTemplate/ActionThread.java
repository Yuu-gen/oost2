package airplaneWithConditionedSynchronisationTemplate;

import java.util.List;
/**
 * A travel agency that frequently alternates actions on planes 
 */
public abstract class ActionThread extends RunnableAdapter{
	private List<Airplane> planes;
	private String name;  
	public ActionThread(List<Airplane> planes, String name){
		this.planes = planes;
		this.name = name;
	}
	
	public void run() {
		try{
			while(!this.isInterrupted())this.action();
		}catch(InterruptedException ie){
			System.out.println(name + ": Beendet");
		}
	}
/**
 * Any recurring action in a thread 
 */	
	public abstract void action() throws InterruptedException;
	public List<Airplane> getPlanes(){
		return this.planes;
	}
	public String toString(){
		return this.name;
	}
/**
 * Returns a randomly chosen index from the plane list
 */	
	protected int getRandomPlaneNumber(){
		return (int)(Math.random() * this.getPlanes().size());
	}
}
