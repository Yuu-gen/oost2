package bookingPlanes;

public class Main {

	public static void main(String[] args) {
		Airplane plane = new Airplane(757);
		TravelAgency Tui = new TravelAgency(plane, 187);
		TravelAgency ThomasCook = new TravelAgency(plane, 257);
		
		Tui.start();
		ThomasCook.start();
		
		try {
			Tui.join();
			ThomasCook.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(plane.getOccupied());
	}

}
