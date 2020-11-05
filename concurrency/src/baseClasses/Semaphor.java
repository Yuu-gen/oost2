package baseClasses;
/**
 * Klassische Semaphore nach Dijkstra: Realisierung von Wartebereichen und Sperren
 */
public class Semaphor {
	private Integer count;
	public Semaphor(Integer count) {
		super();
		this.count = count;
	} 
	public synchronized void up() {
		this.count++;
		this.notify();
	}
	public synchronized void down() throws InterruptedException {
		while(this.count==0) this.wait();
		count--;
	}
}
