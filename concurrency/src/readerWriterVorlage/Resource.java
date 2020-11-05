package readerWriterVorlage;

public class Resource {
	private int content = 0; 
	public Resource(){
	}

	public int get(){
		return this.content;
	}
	
	public void set(int content){
		this.content = content;
	}
}
