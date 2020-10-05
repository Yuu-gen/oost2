package scanner;

import symbols.ErrorToken;
/**
 * Produces an error token, if unknown characters are detected
 */
public class ErrorState extends State {
	public ErrorState(Scanner myScanner) {
		super(myScanner);
	}
	public void scan(Character c) {
		this.getMyScanner().addSymbol(new ErrorToken(c.toString()));
		this.getMyScanner().skip();
		this.endOfProcessing();
	}
	public void onTermination() {
		return;
	}
}
