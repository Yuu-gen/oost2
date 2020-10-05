package facade;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import basic.TextConstants;
import expressions.BinaryTerm;
import expressions.BracketExpression;
import expressions.Expression;
import expressions.ExpressionVisitor;
import expressions.Product;
import expressions.Sum;
import symbols.NaturalNumber;
/**
 * Responsible for creating the tree model from an expression object
 * Visits expression objects 
 */
public class TreeModelCreator implements ExpressionVisitor{
	private DefaultMutableTreeNode cursor;
	private DefaultTreeModel theTreeModel;
	public TreeModelCreator() {
		super(); 
		this.cursor = new DefaultMutableTreeNode(TextConstants.TREEROOT);
		this.theTreeModel = null;
	}
	public DefaultTreeModel create(Expression e){
		this.theTreeModel = new DefaultTreeModel(this.cursor);
		e.accept(this); 
		return this.theTreeModel;
	}
	public void handle(Sum s) {
		this.doHandle(s);
	}
	public void handle(Product p) {
		this.doHandle(p);
	}	
	public void handle(BracketExpression be) {
		this.setCursorText(be);
		DefaultMutableTreeNode arg = new DefaultMutableTreeNode("");
		this.cursor.add(new DefaultMutableTreeNode(be.getBracketOpen()));
		this.cursor.add(arg);
		this.cursor.add(new DefaultMutableTreeNode(be.getBracketClose()));
		this.cursor = arg;
		be.getExpression().accept(this);
	}
	public void handle(NaturalNumber n) {
		this.cursor.setUserObject(n);
	}
/**	
 * Determines a textual representation of the node type in the tree
 */
	private void setCursorText(Expression e){
		this.cursor.setUserObject(e.getClass().getSimpleName());
	}
/**	
 * Common handling of binary terms
 */
	private void doHandle(BinaryTerm bt){
		this.setCursorText(bt);
		DefaultMutableTreeNode arg1 = new DefaultMutableTreeNode("");
		DefaultMutableTreeNode arg2 = new DefaultMutableTreeNode("");
		this.cursor.add(arg1);
		this.cursor.add(new DefaultMutableTreeNode(bt.getOp()));
		this.cursor.add(arg2);
		
// Depth first traversal (could be made concurrent):		
		this.cursor = arg1;
		bt.getArg1().accept(this);
		this.cursor = arg2;
		bt.getArg2().accept(this);
	}
}
