package baseClasses;
/**
 * Command interface of active server
 */
public abstract class CommandINVOKER<R> implements Command{
	private Invoker theInvoker; 
	private R result;
	private Exception exception;
	public CommandINVOKER(Invoker theInvoker){
		this.theInvoker = theInvoker;
	}
/**
 * Executes this and informs invoker by sending this
 */	
	public void execute(){
		try { result = this.call();
		}catch (Exception e) {this.exception = e;}
		this.theInvoker.acceptResult(this); 	
	}	
/**
 * Calls command. Provides either result or exception.
 */	
	protected abstract R call() throws Exception;
	
	public R getResult() throws Exception{
		if(exception!=null) throw exception;
		return this.result;
	}
}
