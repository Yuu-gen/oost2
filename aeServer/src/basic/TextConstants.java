package basic;
/**
 * Static bucket for texts 
 */
public class TextConstants {
	public static final String SPACE = " ";
	public static final String OR = " or ";
	public static final String EMPTYWORD = "";
	public static final Character BRACKETOPEN = '(';
	public static final Character BRACKETCLOSE = ')';
	public static final Character ADD = '+';
	public static final Character SUB = '-';
	public static final Character MULTIPLY = '*';
	public static final Character DIV = '/';
	public static final String COMMENTSTART = "/*";
	public static final String COMMENTEND = "*/";
	public static final String UNKNOWN = "Error Token";
	public static final String MODEL = "";
	public static final String ENDOFEXPRESSION = "end of input";
	
/* ================= General texts ================= */
	public static final String EXPECTED = "Expected ";
	public static final String FOUND = " but found ";
	public static final String OPERAND = " operand ";
	public static final String TERMINATED = "Termination";
	public static final String EXTRABEHIND = "Found something extra behind valid expression: ";
	public static final String CYCLE = "Cyclic reference detected: ";
	public static final String REGISTRATIONFAILED = "Registration of controller for view failed: ";
	public static final String DIV0 = "Division by zero!";
	public static final String COMMENTNOTCOMPLETED = "Uncompleted comment ";
	public static final String ATPOSITION = "after having parsed the following number of symbols: ";
	public static final String SYNTAXOK = "Syntax OK";
	public static final String OK = "Evaluation performed";
	public static final String TREEROOT = "Syntax Tree";
	public static final String EMPTYTREE = "-- VOID --";
	public static final String NAME = "Name";
	public static final String NEW = "New";
	public static final String EXPRESSION = "Expression";
	public static final String EVALUATE = "Evaluate";
	public static final String CREATETREE ="Check Syntax and Create Tree";
	public static final String NOTEVALUATABLE1 ="Evaluation failed: Expression is unchecked";
	public static final String NOTEVALUATABLE2 ="Evaluation failed: Expression has syntax errors";
	public static final String UNKNOWNVARSYMB ="Unknown Variable Symbol detected: ";
	public static final String somethingExtraBehind = "Something extra behind successfully parsed expression: ";
	public static String addOperators(){
		return "Addition-like Operator";
	}
	
	public static String multOperators(){
		return "Multiplication-like Operator";
	}
	
	public static boolean isBracket(Character c){
		return c.equals(BRACKETOPEN) || c.equals(BRACKETCLOSE);
	}
	
	public static String factorStartSymbols(){
		return BRACKETOPEN + OR + OPERAND;
	}
}
