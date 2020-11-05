package readerWriterVorlage;

import baseClasses.Semaphor;

public class AccessManagerVorlage {
	// 3 Semaphoren:
	private Semaphor readerQueue; // Wartende Leser
	private Semaphor writerQueue; // Wartende Schreiber
	private Semaphor mutex; // Schutz für Aktionen auf Zählvariablen dieses Objektes !!
	private int activeReaders = 0; // Anzahl Aktive Leser
	private int waitingReaders = 0; // Anzahl Wartende Leser
	private int waitingWriters = 0; // Anzahl Wartende Schreiber
	private int activeWriters = 0; // Anzahl Aktive Schreiber

	private Resource resource;

	public AccessManagerVorlage() {
		this.readerQueue = new Semaphor(0);
		this.writerQueue = new Semaphor(0);
		this.mutex = new Semaphor(1);
		this.resource = new Resource();
	}

	public Resource startWriting() throws InterruptedException {
		
		
		while (activeWriters > 0 || activeReaders > 0 || waitingReaders > 0) {
			this.mutex.down();
			this.waitingWriters++;
			this.mutex.up();
			this.writerQueue.down(); // wirkliches warten
			this.mutex.down();
			this.waitingWriters--;
			this.mutex.up();
		}
		this.mutex.down();
		this.activeWriters++;
		this.checkResourceAccess();
		this.mutex.up();
		
		return this.resource;
	}

	public Resource startReading() throws InterruptedException {
		
		this.checkResourceAccess();
		while (waitingWriters > 0 ||activeWriters > 0) { //
			this.mutex.down();
			this.waitingReaders++;
			this.mutex.up();
			this.readerQueue.down();
			this.mutex.down();
			this.waitingReaders--;
			this.mutex.up();
		}
		
		this.mutex.down();
		this.activeReaders++;
		this.checkResourceAccess();
		this.mutex.up();
		return this.resource;
	}

	public void stopWriting() throws InterruptedException {
		this.mutex.down();
		this.activeWriters--;
		this.printNumbers();
		this.checkResourceAccess();
		
		this.mutex.up();
		
		if(checkForWaitingReaders()) {
			this.readerQueue.up();
		}else {
			this.writerQueue.up();
		}
		
	}

	public void stopReading() throws InterruptedException {
		this.mutex.down();
		this.activeReaders--;
		this.printNumbers();
		this.checkResourceAccess();
		this.mutex.up();
		if(checkForWaitingReaders()) {
			this.readerQueue.up();
		}else {
			this.writerQueue.up();
		}
		
	}
	/**
	 * True, if there are waiting readers in queue
	 * @return
	 * @throws InterruptedException
	 */
	private boolean checkForWaitingReaders() throws InterruptedException {
		this.mutex.down();
		if(this.waitingReaders>0) {
			this.mutex.up();
			return true;
		}
		this.mutex.up();
		return false;
	}
	
	
// ===============================================================
// ============== Protokollierer =================================
// ===============================================================	
	/**
	 * Überprüfung, ob die Anforderungen erfüllt sind
	 */
	private void checkResourceAccess() {
		if (this.activeWriters > 1 || (this.activeWriters == 1 && this.activeReaders > 0
				|| this.waitingReaders + this.activeReaders > Main.noOfReaders
				|| this.waitingWriters + this.activeWriters > Main.noOfWriters
				|| this.waitingReaders + this.activeReaders < 0 || this.waitingWriters + this.activeWriters < 0)) {
			System.out.println("Fataler Fehler, ");
			this.printNumbers();
		}
	}

	/**
	 * Testing traces
	 */
	private void printNumbers() {
		System.out.print("Wartende Schreiber = " + this.waitingWriters);
		System.out.print(", Aktive Schreiber = " + this.activeWriters);
		System.out.print(", Wartende Leser = " + this.waitingReaders);
		System.out.println(", Aktive Leser = " + this.activeReaders);
	}
}
