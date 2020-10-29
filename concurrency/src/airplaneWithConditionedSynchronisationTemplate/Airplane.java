package airplaneWithConditionedSynchronisationTemplate;

/**
 * A monitor with ONE queue of threads that may wait for booking or cancellation
 */
public class Airplane extends Observable {
	private int capacity;
	private int occupied;
	private String name;

	public Airplane(int capacity, String name) {
		this.capacity = capacity;
		this.occupied = 0;
		this.name = name;
	}

	/**
	 * Books a seat, notifies its observers and notifies waiting threads
	 */
	public synchronized void book() throws InterruptedException {
// TODO 1. Muss die vorige Zeile ergänzt werden? Nein?!
		while (this.occupied == this.capacity) {
			this.wait();
		}
		this.occupied++;
		this.fireUpdate(); // Aktualisierung der Oberfläche nach Wert-Änderung
		Thread.sleep((int) (1000 + Math.random() * 500));
		this.notify();
	}

	/**
	 * Cancels a seat, notifies its observers and notifies waiting threads
	 */
	public synchronized void cancel() throws InterruptedException {
// TODO 5. Muss die vorige Zeile ergänzt werden? ja!		
		while(this.occupied == 0) {
			this.wait();
		}
		this.occupied--;
		this.fireUpdate(); // Aktualisierung der Oberfläche nach Wert-Änderung
		Thread.sleep((int) (1000 + Math.random() * 500));
		this.notify();
	}

	public int getOccupied() {
		return this.occupied;
	}

	public String toString() {
		return this.name;
	}
}
