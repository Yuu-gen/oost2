package basic;
/**
 * Speichermedium zur Verwaltung von auszutauschenden Daten
 * T = Typisierung der Daten
 */
public interface Pipeline<T> {
/**	
 * Fügt dem Puffer ein Objekt vom Typ T hinzu. Prozess wartet, wenn Puffer voll ist
 */
	public void push(T x) throws InterruptedException;
/**
 * Versucht, dem Puffer ein Element zu entnehmen (FIFO-Prinzip) und wartet auf leerem Puffer
 */
	public T remove() throws InterruptedException;
}
