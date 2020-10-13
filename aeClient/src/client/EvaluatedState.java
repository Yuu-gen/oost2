package client;

public class EvaluatedState extends ControllerState {

	public EvaluatedState(Controller myController) {
		super(myController);

	}

	@Override
	public void changeBtnState() {
		this.getMyController().getView().getBtnCheckSyntaxButton().setEnabled(false);
		this.getMyController().getView().getBtnEvaluateButton().setEnabled(false);

	}

}
