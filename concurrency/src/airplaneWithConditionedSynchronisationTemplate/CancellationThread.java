package airplaneWithConditionedSynchronisationTemplate;
import java.util.List;

public class CancellationThread extends BookingThread {
	public CancellationThread(List<Airplane> planes, String name){
		super(planes, name);
	}
/**	
 * Cancels one seat on a randomly chosen plane
 */
	public void action() throws InterruptedException{
		if(this.getPlanes().size()==0) return;
		this.getPlanes().get(this.getRandomPlaneNumber()).cancel();
	}
}
