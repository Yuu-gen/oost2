package baseClasses;
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
	/**
	 * "looks" at the first element of the Pipeline without taking it out.
	 * Shouldn't be used if there's more than one receiver using the pipeline
	 * @return
	 * @throws InterruptedException
	 */
	public T get() throws InterruptedException;
}
