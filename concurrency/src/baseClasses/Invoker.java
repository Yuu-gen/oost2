package baseClasses;

public abstract class Invoker extends RunnableAdapter{
	public abstract void acceptResult(CommandINVOKER<?> command);	
	public abstract String getName();
}
