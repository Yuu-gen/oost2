package client;

public class EvaluableState extends ControllerState {

	public EvaluableState(Controller myController) {
		super(myController);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeBtnState() {
		this.getMyController().getView().getBtnCheckSyntaxButton().setEnabled(false);
		this.getMyController().getView().getBtnEvaluateButton().setEnabled(true);

	}

}
