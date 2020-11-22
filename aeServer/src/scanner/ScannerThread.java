package scanner;

import basic.Pipeline;
import basic.RunnableAdapter;
import symbols.Token;

public class ScannerThread extends RunnableAdapter {
	Scanner scanner;
	String input;
	public ScannerThread(Pipeline<Token> result, String input) {
		super();
		this.scanner = new Scanner(result);
		this.input = input;
	}
	@Override
	public void run() {
		this.scanner.toTokenSequence(input);
	}


}
