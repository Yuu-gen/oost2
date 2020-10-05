package scanner;
/**
 * Processing Whitespace
 */
public class WhitespaceState extends State{
	public WhitespaceState(Scanner myScanner) {
		super(myScanner);
	}
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.getMyScanner().setState(new SelectionState(this.getMyScanner()));
	}
	public void onTermination() {
		return;
	}
}
