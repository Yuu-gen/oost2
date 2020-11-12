package concurrentComposite;

public abstract class Component{
	private String name;
	public Component(String name){
		this.name = name;
	}
/**	
 * We trace results to make calculation sequences transparent
 */
	public Integer calculateSize() throws InterruptedException{
		Thread.sleep((int)(Math.random()*5)); // Some random delay
		Integer result = this.doCalculateSize();
		System.out.println("Determined size of " + this.toString());
		return result;
	}
	public abstract Integer doCalculateSize() throws InterruptedException;
	public String toString(){
		return this.name;
	}
}
