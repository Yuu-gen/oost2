package client;

public class ErrorState extends ControllerState {

	public ErrorState(Controller myController) {
		super(myController);
	}

	@Override
	public void changeBtnState() {
		this.getMyController().getView().getBtnCheckSyntaxButton().setEnabled(false);
		this.getMyController().getView().getBtnEvaluateButton().setEnabled(false);

	}

}
