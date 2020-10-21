package bookingPlanes;

import java.util.Random;

public class Airplane{
	private Integer occupied; // number of occupied seats
	private Integer capacity; // number of seats that can be occupied
	
	public Airplane(Integer capacity) {
		this.occupied = 0;
		this.capacity = capacity;
	}

	/** 
	 * Books one seat of the airplane
	 * @param n
	 * @throws Exception
	 */
	public void book(Integer n) throws Exception {
		Integer temp = this.occupied;
		
		if(new Random().nextInt()%n == 0)
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(this.occupied < this.capacity) 
			this.occupied = temp + 1;
		//else
			//throw new Exception("Airplane is full");
	}
	
	public Integer getCapacity() {
		return this.capacity;
	}
	
	public Integer getOccupied() {
		return this.occupied;
	}
}
