package activeServer.server;

import baseClasses.Command;
import baseClasses.Pipeline;
import baseClasses.PipelineImplementierung;
import baseClasses.RunnableAdapter;

public class ActiveServer extends RunnableAdapter {
	private Pipeline<Command<?>> myPipe;
	public ActiveServer(){
		this.myPipe = new PipelineImplementierung<Command<?>>("Server-Pipe", 4, "   ");
	}
	public void run() {
		try {
			while (!this.isInterrupted()) this.myPipe.get().execute();
		} catch (InterruptedException e) {
			System.out.println("Server-Interrupt beim Warten auf neue Kommandos");
		}
		System.out.println("Server Stop");
	}
	
	public Pipeline<Command<?>> getPipeline(){
		return this.myPipe;
	}
}
