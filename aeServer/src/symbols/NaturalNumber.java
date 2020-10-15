package symbols;

import expressions.ExpressionVisitor;
import expressions.Factor;
import facade.ParserException;
/**
 * Class invariant: value >= 0
 */
public class NaturalNumber implements Token, Factor {
	private Integer value;

	public NaturalNumber(Integer value) {
		super();
		this.value = value;
		assert this.value >= 0 : "Card ist negativ";
	}

	public Integer getValue() {
		return value;
	}
	public boolean equals(Object o){
		return 
			o instanceof NaturalNumber
		&&	((NaturalNumber)o).getValue().equals(this.getValue());
	}

	public Integer evaluate() {
		return this.value;
	}
	
	public String toString(){
		return this.value.toString();
	}
	
	public void accept(SymbolVisitor sv) throws ParserException {
		sv.handle(this);
	}

	public <T> T accept(ExpressionVisitor <T> ev) {
		return ev.handle(this);
	}	
}
