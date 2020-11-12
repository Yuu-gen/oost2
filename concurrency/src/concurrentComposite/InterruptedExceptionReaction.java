package concurrentComposite;
/**
 * A special Exception for this scenario
 */
public class InterruptedExceptionReaction {
	private Component component;
	public InterruptedExceptionReaction(Component component){
		this.component = component;
	}
	public String toString(){
		return "Unexpected Interrupt when calculating " + this.component.toString();
	}
}
