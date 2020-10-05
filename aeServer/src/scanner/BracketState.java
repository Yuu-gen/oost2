package scanner;

import basic.TextConstants;
import symbols.BracketClose;
import symbols.BracketOpen;
/**
 * Processing brackets: A bracket is always a single character
 */
public class BracketState extends State {
	public BracketState(Scanner myScanner) {
		super(myScanner);
	}
	public void scan(Character c) {
		Scanner s = this.getMyScanner();
		if(c.equals(TextConstants.BRACKETOPEN)) 	s.addSymbol(BracketOpen.getTheInstance());
		if(c.equals(TextConstants.BRACKETCLOSE)) 	s.addSymbol(BracketClose.getTheInstance());
		s.skip();
		this.endOfProcessing();
	}
	public void onTermination() {
		return;
	}
}
