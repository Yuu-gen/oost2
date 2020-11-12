package baseClasses;

import java.util.Optional;

import baseClasses.Semaphor;
public class Future<T> {
	private Semaphor signal;
	private Optional<T> contents;
	public Future() {
		this.signal = new Semaphor(0);
		this.contents = Optional.empty();
	}
	public T receiveContents() throws InterruptedException {
		while(!this.contents.isPresent()) this.signal.down();
		return this.contents.get();
	}
	public void setContents(T contents) {
		this.contents = Optional.of(contents);
		this.signal.up();
	}
}
