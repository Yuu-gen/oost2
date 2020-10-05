package symbols;
import basic.TextConstants;
import facade.ParserException;
/**
 * Anything not understandable during scanning of input
 */
public class ErrorToken implements Token {
	private String value;

	public ErrorToken(String value) {
		super();
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	public boolean equals(Object o){
		return 	o instanceof ErrorToken
			&&	((ErrorToken)o).getValue().equals(this.getValue());	
	}
	public String toString(){
		return TextConstants.UNKNOWN + ": " + this.getValue();
	}
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);		
	}
}
