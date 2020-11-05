package readerWriterVorlage;

public class Reader extends MyRun {
	public Reader(AccessManagerVorlage accessManager, String name) {
		super(accessManager, name);
	}
	public Resource startAction() throws InterruptedException{
		return this.getAccessManager().startReading();
	}
	public void stopAction() throws InterruptedException{
		this.getAccessManager().stopReading();
	}
	public void action(Resource r) {
		System.out.println(this.toString() + ": Liest " + r.get() + ".");
	}
}
