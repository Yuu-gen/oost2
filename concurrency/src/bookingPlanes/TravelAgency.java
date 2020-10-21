package bookingPlanes;

public class TravelAgency extends Thread{
	
	private Airplane airplane;
	private Integer n; // number of bookings
	
	public TravelAgency(Airplane airplane, Integer n) {
		this.airplane = airplane;
		this.n = n;
	}
	@Override
	public void run() {
		for(int i = 0; i < this.n; i++) {
			try {
				this.airplane.book(this.n);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
