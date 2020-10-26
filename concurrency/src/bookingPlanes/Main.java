package bookingPlanes;

public class Main {

	public static void main(String[] args) {
		Airplane plane = new Airplane(757);
		TravelAgency tui = new TravelAgency(plane, 187);
		TravelAgency thomasCook = new TravelAgency(plane, 257);
		
		tui.start();
		thomasCook.start();
		
		try {
			tui.join();
			thomasCook.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(plane.getOccupied());
	}

}
