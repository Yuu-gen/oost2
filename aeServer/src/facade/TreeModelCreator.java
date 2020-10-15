package facade;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import basic.TextConstants;
import expressions.BinaryTerm;
import expressions.BracketExpression;
import expressions.Expression;
import expressions.ExpressionVisitor;
import expressions.Product;
import expressions.Sum;
import symbols.NaturalNumber;

/**
 * Responsible for creating the tree model from an expression object Visits
 * expression objects
 */
public class TreeModelCreator implements ExpressionVisitor<MutableTreeNode> {
	private DefaultTreeModel theTreeModel;

	public TreeModelCreator() {
		super();
		this.theTreeModel = null;
	}

	public DefaultTreeModel create(Expression e) {
		this.theTreeModel = new DefaultTreeModel(e.accept(this));
		return this.theTreeModel;
	}

	public MutableTreeNode handle(Sum s) {
		return this.doHandle(s);
	}

	public MutableTreeNode handle(Product p) {
		return this.doHandle(p);
	}

	public MutableTreeNode handle(BracketExpression be) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		this.setText(be, node);
		node.add(new DefaultMutableTreeNode(be.getBracketOpen()));
		node.add(be.getExpression().accept(this));
		node.add(new DefaultMutableTreeNode(be.getBracketClose()));
		return node;
	}

	public MutableTreeNode handle(NaturalNumber n) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("");
		node.setUserObject(n);
		return node;
	}

	/**
	 * Determines a textual representation of the node type in the tree
	 */
	private void setText(Expression e, MutableTreeNode node) {
		node.setUserObject(e.getClass().getSimpleName());
	}

	/**
	 * Common handling of binary terms
	 */
	private MutableTreeNode doHandle(BinaryTerm bt) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("");
		this.setText(bt, node);
		// Depth first traversal (could be made concurrent):
		node.add(bt.getArg1().accept(this));
		node.add(new DefaultMutableTreeNode(bt.getOp()));
		node.add(bt.getArg2().accept(this));
		return node;
	}
}
