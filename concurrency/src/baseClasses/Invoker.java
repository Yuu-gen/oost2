package baseClasses;

public abstract class Invoker extends RunnableAdapter{
	public abstract void acceptResult(Command<?> command);	
	public abstract String getName();
}
