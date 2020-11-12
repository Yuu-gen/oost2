package concurrentComposite;
import baseClasses.RunnableAdapter;

public class CalculationThread extends RunnableAdapter {
	private Future<Integer> futureResult;
	private Component of;
	
	public CalculationThread(Future<Integer> futureResult, Component of) {
		super();
		this.futureResult = futureResult;
		this.of = of;
	}

	public void run() {
		try {
			this.futureResult.setContents(this.of.calculateSize());
		} catch (InterruptedException e) {
			System.out.println("Interrupt beim Warten");
		}
	}

}
