package basic;

import java.util.ArrayList;
import java.util.List;

public class PipelineImplementierung<T> implements Pipeline<T> {
	private List<T> data;
	private Semaphor freeSpace; // Kontrolliert, wie viele Plätze frei sind 
	private Semaphor usedSpace; // Kontrolliert, wie viele Plätze belegt sind
	private Semaphor mutex;     // Kontrolliert konkurrierenden Zugriff auf data
	private String name;
	private String indentForPrintout; // Nur für Simulation
	public PipelineImplementierung(String name, Integer capacity, String indentForPrintout){
		this.data = new ArrayList<>();
		this.freeSpace = new Semaphor(capacity);
		this.usedSpace = new Semaphor(0);
		this.mutex = new Semaphor(1);
		this.name = name;
		this.indentForPrintout = indentForPrintout;
 	}
	public void push(T x) throws InterruptedException {
		this.freeSpace.down(); // Achtung: Diese Reihenfolge einhalten, 
		try{
			this.mutex.down();   // sonst verschachtelte Monitore -> Deadlock!
			this.data.add(0,x); //  Für schönere Visualisierung
			this.printData();
			this.usedSpace.up();
			this.mutex.up();
		}catch(InterruptedException ie) {
			this.freeSpace.up();
			throw ie;
		}
	}
	public T remove() throws InterruptedException {
		this.usedSpace.down();
		try {
			this.mutex.down();
			T object = this.data.remove(this.data.size()-1); // Für schönere Visualisierung
			this.printData();
			this.freeSpace.up();
			this.mutex.up();
			return object;
		}catch(InterruptedException ie) {
			this.usedSpace.up();
			throw ie;
		}
	}
	
// ================== For testing ===================== 	
	private void printData(){
		System.out.println(this.indentForPrintout + this.data);
	}
	public String consistencyCheck() throws InterruptedException{
		this.mutex.down();
		String result = "freeSpace = " + this.freeSpace.getCount() + "\n";
		result+="usedSpace = " + this.usedSpace.getCount() + "\n";
		result+="data-size = " + this.data.size();
		this.mutex.up();
		return result;
	}
}
