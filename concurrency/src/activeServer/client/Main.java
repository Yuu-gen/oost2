package activeServer.client;

import activeServer.server.ActiveServer;

public class Main {
	public static void main(String[] args) {
		ActiveServer theServer = new ActiveServer();
		Client client1 = new Client(theServer, "***Client1");
		Client client2 = new Client(theServer, "Client2");
//		Client client3 = new Client(theServer, "Client3");
		theServer.start();
		System.out.println("Starte Client-Server-Szenario");
		client1.start(); client2.start();//client3.start();
		try{Thread.sleep(100);}catch(InterruptedException ie){}
		 
		client1.interrupt();
		client2.interrupt();
//		client3.interrupt();
		theServer.interrupt();
	}
}
