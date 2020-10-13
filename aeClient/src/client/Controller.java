package client;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import facade.ApplicationFacade;
import facade.CalculationException;
import facade.ParserException;
import facade.TreeModelCreator;

public class Controller {
	private static final String syntaxok = "Syntax OK";
	private View view; // The View
	private ApplicationFacade model; // The Model
	private ControllerState state; // THE STATE

	public Controller(View view, ApplicationFacade facade) {
		this.view = view;
		this.model = facade;
		this.changeState(new UnverifiedState(this));
		this.registerListeners();
	}

	private void registerListeners() {
		this.view.getBtnCheckSyntaxButton().addActionListener((e) -> onCheckSyntaxButtonPressed());
		this.view.getBtnEvaluateButton().addActionListener((x) -> onEvaluationButtonPressed(x));
		//37b getTextFieldInput muss public oder protected gemacht werden
		this.view.getTextField_Input().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				onInputChanged();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				onInputChanged();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				onInputChanged();

			}
		});
	}

	/**
	 * Follow up action after having pressed "check syntax" button
	 */
	public void onCheckSyntaxButtonPressed() {
		try {
			this.initializeValue();
			this.view.getTreeDisplay()
					.setModel(new TreeModelCreator().create(this.model.checkSyntax(this.view.getInput())));
			this.view.getTreeDisplay().expandRow(0);
			this.view.setMessage(syntaxok);
			this.changeState(new EvaluableState(this));
		} catch (ParserException exception) {
			this.errorHandling(exception);

		}
	}

	/**
	 * Follow up action after having pressed the evaluation button
	 * 
	 * @param event may be used for analysing event features
	 */
	public void onEvaluationButtonPressed(ActionEvent event) {
		try {
			this.view.setValue(this.model.evaluate(this.view.getInput()).toString());
			this.view.setMessage("Evaluation performed at " + new Date(event.getWhen()).toString()); // An example for
				this.changeState(new EvaluatedState(this));																						// the use of
																										// the
																										// ActionEvent
		} catch (ParserException | CalculationException exception) {
			this.errorHandling(exception);
		}
	}

	/**
	 * Reinitializes TreeDisplay and disables EvaluateButton
	 */
	public void onInputChanged() {
		this.initializeTreeDisplay();
		this.changeState(new UnverifiedState(this));
	}

	/**
	 * Actions on occurrence of errors
	 */
	private void errorHandling(Exception exception) {
		this.initializeValue();
		this.view.setMessage(exception.getMessage());
		this.initializeTreeDisplay();
		this.changeState(new ErrorState(this));
	}

	/**
	 * Initialization of value field
	 */
	private void initializeValue() {
		this.view.setValue("");
	}

	/**
	 * Tree Initialization
	 */
	private void initializeTreeDisplay() {
		this.view.getTreeDisplay().setModel(new DefaultTreeModel(new DefaultMutableTreeNode("VOID")));
	}
	
	protected void changeState(ControllerState newState) {
		this.state = newState;
		this.state.changeBtnState();
	}
	
	/**View Getter**/
	protected View getView() {
		return this.view;
	}

}