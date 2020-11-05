package readerWriterVorlage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static final int noOfReaders = 3; // Starvation ...?
	public static final int noOfWriters = 3;
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
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            while(true) {
//                if (reader.readLine().toLowerCase().startsWith("stop")) {
//                    for(MyRun current : writers) current.interrupt();
//                    for(MyRun current : readers) current.interrupt();
//
//                    System.out.println(Writer.getWriteActions() + " Schreibaktionen");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		for(MyRun current : writers) current.interrupt();
		for(MyRun current : readers) current.interrupt();
		
		System.out.println(Writer.getWriteActions() + " Schreibaktionen");		
	}
}
