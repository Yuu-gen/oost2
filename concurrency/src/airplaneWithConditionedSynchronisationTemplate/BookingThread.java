package airplaneWithConditionedSynchronisationTemplate;

import java.util.List;
public class BookingThread extends ActionThread{
	public BookingThread(List<Airplane> planes, String name){
		super(planes, name);
	}
/**	
 * Books one seat on a randomly chosen plane
 */
	public void action() throws InterruptedException{
		if(this.getPlanes().size()==0) return;
		this.getPlanes().get(this.getRandomPlaneNumber()).book();
	}
}
