package client;


public class UnverifiedState extends ControllerState {

	public UnverifiedState(Controller myController) {
		super(myController);
		
	}

	@Override
	public void changeBtnState() {
		this.getMyController().getView().getBtnCheckSyntaxButton().setEnabled(true);
		this.getMyController().getView().getBtnEvaluateButton().setEnabled(false);
	}

}
