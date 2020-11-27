package activeServer.server;

import baseClasses.CommandINVOKER;
import baseClasses.Pipeline;
import baseClasses.PipelineImplementierung;
import baseClasses.RunnableAdapter;

public class ActiveServer extends RunnableAdapter {
	private Pipeline<CommandINVOKER<?>> myPipe;
	public ActiveServer(){
		this.myPipe = new PipelineImplementierung<CommandINVOKER<?>>("Server-Pipe", 4, "   ");
	}
	public void run() {
		try {
			while (!this.isInterrupted()) this.myPipe.get().execute();
		} catch (InterruptedException e) {
			System.out.println("Server-Interrupt beim Warten auf neue Kommandos");
		}
		System.out.println("Server Stop");
	}
	
	public Pipeline<CommandINVOKER<?>> getPipeline(){
		return this.myPipe;
	}
}
