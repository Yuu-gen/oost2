package experiments;

public class Main {

	public static void main(String[] args) {
		Deadlocker d1 = new Deadlocker("D1");
		Deadlocker d2 = new Deadlocker("D2");
		new Thread(() -> d1.lock(d2)).start();
		new Thread(() -> d2.lock(d1)).start();

		System.out.println("Deadlock...");

	}
}
