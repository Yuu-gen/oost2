package scanner;
/**
 * Processing Operators
 */
public class OperatorState extends State { 
	public OperatorState(Scanner myScanner) {
		super(myScanner);
	}
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.addSymbol(c);
		this.endOfProcessing();
	}
	public void onTermination() {
		return;
	}	
	private void addSymbol(Character c){
		this.getMyScanner().addSymbol(SymbolTable.getInstance().get(c));
	}
}
