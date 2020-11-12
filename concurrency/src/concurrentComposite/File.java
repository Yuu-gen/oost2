package concurrentComposite;
public class File extends Component {
	private Integer size;
	public File(Integer size, String name){
		super(name);
		this.size = size;
	}
	public Integer doCalculateSize() throws InterruptedException{
		System.out.println("Retrieving value of " + this.toString());
		// A long running calculation
		Thread.sleep(1000);
		return this.size;		
	}
}
