package activeServer.client;

import baseClasses.Invoker;
import baseClasses.Command;

public class SQRTCommand extends Command<Double>{
	private Integer argument; 
	public SQRTCommand(Invoker invoker, Integer argument){
		super(invoker);
		this.argument = argument;
	}
/**
 * Request for calculation of square root
 * @throws NotAValidArgumentException 
 * @throws InterruptedDuringComputationException 
 */
	public Double call() throws NotAValidArgumentException{
		if (this.argument<0) throw new NotAValidArgumentException(" Ergebnis ist undefiniert!");
		return Math.sqrt((double)this.argument);
	}
	public Integer getArgument() {
		return this.argument;
	}
}
