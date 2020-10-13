package client;

public abstract class ControllerState {
	private Controller myController;
	public ControllerState(Controller myController) {
		super();
		this.myController = myController;
	}
	
	public abstract void changeBtnState();
	
	protected Controller getMyController() {
		return this.myController;
	}
}
