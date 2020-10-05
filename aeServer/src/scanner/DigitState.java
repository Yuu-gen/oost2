package scanner;
import symbols.NaturalNumber;
/**
 * Digit Processing 
 */
public class DigitState extends State {
    private Integer collectedDigits;
	public DigitState(Scanner myScanner){
		super(myScanner);
		this.collectedDigits = 0;
	}
	public void scan(Character c) {
		if(Character.isDigit(c)){
			this.collectedDigits = 	this.collectedDigits * 10 + Integer.parseInt(c.toString());
			this.getMyScanner().skip();
		}else{
			this.addSymbol();
			this.endOfProcessing();
		}
	}
	public void onTermination() {
		this.addSymbol();
	}
	private void addSymbol(){
		this.getMyScanner().addSymbol(new NaturalNumber(this.collectedDigits));
	}
}
