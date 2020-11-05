package readerWriterVorlage;

import java.util.ArrayList;
import java.util.List;


public class Main {
	public static final int noOfReaders = 7; // Starvation ...?
	public static final int noOfWriters = 5;
	public static void main(String[] args) {
		AccessManagerVorlage manager = new AccessManagerVorlage();
		List<MyRun> writers, readers;
		writers = new ArrayList<MyRun>(); readers = new ArrayList<MyRun>();
		
		for(int i=0; i<noOfReaders; i++) readers.add(new Reader(manager, "R" + i));
		for(int j=0; j<noOfWriters; j++) writers.add(new Writer(manager, "W" + j));
		
		for(MyRun current : readers) current.start();
		for(MyRun current : writers) current.start();

// 	Warten
		try{Thread.sleep(2000);}catch(InterruptedException ie){} 
		// TODO: Besser aktiv beenden über Benutzereingabe
//	Beenden
		
		for(MyRun current : writers) current.interrupt();
		for(MyRun current : readers) current.interrupt();
		
		System.out.println(Writer.getWriteActions() + " Schreibaktionen");		
	}
}
