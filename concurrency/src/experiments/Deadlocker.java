package experiments;

public class Deadlocker {
	private final String description;
	public Deadlocker(String descr) {
		this.description = descr;
	}
	//Deadlock auch ohne synchronized beim getter
	public synchronized String getDescription() {
		return this.description;
	}
	
	public synchronized void lock(Deadlocker locker) {
		System.out.format("%s: Ich blockiere %s!%n",
				this.description, locker.getDescription());
		locker.lock2(this);
	}
	public synchronized void lock2(Deadlocker locker) {
		System.out.format("%s blockiert mich %s!%n",
				locker.getDescription(), this.description);
	}
}
