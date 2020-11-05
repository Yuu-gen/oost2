package readerWriterVorlage;
public class Writer extends MyRun {
	private static int writeActions = 0;
	public Writer(AccessManagerVorlage accessManager, String name) {
		super(accessManager, name);
	}
	public Resource startAction() throws InterruptedException{
		return this.getAccessManager().startWriting();
	}
	public void stopAction() throws InterruptedException{
		this.getAccessManager().stopWriting();
	}
	public void action(Resource r){
		int newValue = (int)(Math.random()*100);
		r.set(newValue);
		writeActions++;
		System.out.println(this.toString() + ": Schreibt " + newValue + ".");
	}
	public static int getWriteActions(){
		return writeActions;
	}
}
