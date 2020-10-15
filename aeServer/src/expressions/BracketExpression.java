package expressions;
import facade.CalculationException;
import symbols.BracketClose;
import symbols.BracketOpen;
/**
 * An expression of type (E)
 */
public class BracketExpression implements Factor {
	private BracketOpen bracketOpen;
	private Expression expression;
	private BracketClose bracketClose;
	public BracketExpression(Expression expression) {
		super();
		this.bracketOpen = BracketOpen.getTheInstance();
		this.expression = expression;
		this.bracketClose = BracketClose.getTheInstance();
	}
	public Integer evaluate() throws CalculationException{
		return this.expression.evaluate();
	}
	public <T> T accept(ExpressionVisitor <T> ev) {
		return ev.handle(this);
	}	
	public BracketClose getBracketClose() {
		return bracketClose;
	}
	public BracketOpen getBracketOpen() {
		return bracketOpen;
	}
	public Expression getExpression() {
		return expression;
	}	
}
