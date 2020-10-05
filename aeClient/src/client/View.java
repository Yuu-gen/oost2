package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JScrollPane;
/**
 * Von Window Builder generierte Klasse 
 */
public class View extends JFrame {
	private JPanel contentPane;
	private JTextField textField_Input;
	private JTextField textField_Value;
	private JTextField textField_Message;
	private JButton btnEvaluateButton;
	private JButton btnPruefeSyntax;
	private JScrollPane scrollPane;
	private JTree treeDisplay;

	public View() {
		this.initialize();
		this.getTheContentPane();		
		this.contentPane.add(this.getTextField_Input()); 
		this.contentPane.add(this.getBtnEvaluateButton());
		this.contentPane.add(this.getBtnCheckSyntaxButton());
		this.contentPane.add(this.getTextField_Value());
		this.contentPane.add(this.getTextField_Message());
		this.contentPane.add(this.getScrollPane());
	}
	
	private void initialize() {
		this.setTitle("Bearbeitung arithmetischer Ausdruecke");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 762, 306);		
	}
	
// ============== Buttons ====================================
// ========= Visible for all classes in the package ==========
	JButton getBtnEvaluateButton() {
		if(this.btnEvaluateButton==null) {
			this.btnEvaluateButton = new JButton("Auswerten");
			this.btnEvaluateButton.setBounds(5, 91, 288, 35);
			this.btnEvaluateButton.setToolTipText("Hier wertet man den eingegebenen Ausdruck aus!");
			this.btnEvaluateButton.setEnabled(false);
		}
		return this.btnEvaluateButton;
	}
	
	JButton getBtnCheckSyntaxButton() {
		if(this.btnPruefeSyntax == null) {
			this.btnPruefeSyntax = new JButton("Pruefe Syntax");
			btnPruefeSyntax.setBounds(5, 45, 288, 35);
			contentPane.add(btnPruefeSyntax);
		}
		return this.btnPruefeSyntax;
	}
	
	public JTextField getTextField_Input(){
		if(this.textField_Input==null) {
			this.textField_Input = new JTextField();
			this.textField_Input.setBounds(131, 2, 288, 32);
			this.textField_Input.setColumns(10);
			this.textField_Input.setToolTipText("Hier bitte Ausdruck eingeben!");
		}
		return this.textField_Input;
	}

// ============== Field Access Methods ======================================
	String getInput() {
		return this.textField_Input.getText();
	}
	void setValue(String s) {
		this.textField_Value.setText(s);
	}
	void setMessage(String s) {
		this.textField_Message.setText(s);
	}
	public void setCheckBtnVisibility(boolean enabled) {
		this.btnPruefeSyntax.setEnabled(enabled);
	}
	public void setEvaluationButtonVisibility(boolean enabled) {
		this.btnEvaluateButton.setEnabled(enabled);
	}
// ===================== Private UI Elements ===============================	
	private JPanel getTheContentPane() {
		if(this.contentPane==null) {
			this.contentPane = new JPanel();
			this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.setContentPane(contentPane);
			this.contentPane.setLayout(null);
			
			JLabel lblAusdruck = new JLabel("Ausdruck");
			lblAusdruck.setBounds(5, 5, 414, 26);
			this.contentPane.add(lblAusdruck); 

			JLabel lblWert = new JLabel("Wert");
			lblWert.setBounds(18, 134, 92, 26);
			this.contentPane.add(lblWert);			
		}
		return this.contentPane;
	}
	
	
	private JTextField getTextField_Value(){
		if(this.textField_Value==null) {
			this.textField_Value = new JTextField();
			this.textField_Value.setEditable(false);
			this.textField_Value.setBounds(131, 131, 286, 32);
			this.textField_Value.setColumns(10);
		}
		return this.textField_Value;
	}
	
	private JTextField getTextField_Message(){
		if(textField_Message==null) {
			this.textField_Message = new JTextField();
			this.textField_Message.setEditable(false);
			this.textField_Message.setBounds(5, 176, 414, 32);
			this.textField_Message.setColumns(10);
		}
		return this.textField_Message;
	}
	private JScrollPane getScrollPane() {
		if(this.scrollPane==null) {
			this.scrollPane = new JScrollPane();
			this.scrollPane.setBounds(437, 5, 278, 209);
			this.scrollPane.setViewportView(this.getTreeDisplay());
		}
		return this.scrollPane;
	}
	public JTree getTreeDisplay() {
		if (this.treeDisplay==null) {
			this.treeDisplay = new JTree();
		}
		return this.treeDisplay;
	}
}
