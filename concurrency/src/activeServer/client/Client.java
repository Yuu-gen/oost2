package activeServer.client;

import activeServer.server.ActiveServer;
import baseClasses.Command;
import baseClasses.Invoker;

public class Client extends Invoker {
	private ActiveServer myServer;
	private String name;
	public Client(ActiveServer server, String name){
		this.myServer = server;
		this.name = name;
	}
	public void run() {
		try {
			while(!this.isInterrupted()){
				Integer argument = (int)(100*Math.random())-50;
				System.out.println(this.getName() + " sendet Kommando für Wurzel aus " + argument);
				this.myServer.getPipeline().push(new SQRTCommand(this, argument));
				}
		}catch(InterruptedException ie) {
			System.out.println(this.name + ": Unterbrechung bei Senden des nächsten Kommandos");
		}
		System.out.println("Kommandoerzeugung beendet");
	}
	public void acceptResult(Command<?> c){
		SQRTCommand sqrtCommand = (SQRTCommand)c;
		try {
			System.out.println(this.resultIntro(sqrtCommand) + ": "+ sqrtCommand.getResult());
		} catch (Exception e) {
			System.out.println(this.resultIntro(sqrtCommand) + ": "+ e.getMessage());
		}
	}

// ======================================================================	
	@Override
	public String getName() {
		return this.name;
	}
//===================== Helper for Console Output ========================	
	private String resultIntro(SQRTCommand c){
		return this.getName() + " empfängt Resultat: Wurzel aus " + c.getArgument();
	}
}
