package state;

import ui.Actions;

public class DisableButtonState implements  ButtonState{

	private Actions action;
	public DisableButtonState(Actions action) {
		// TODO Auto-generated constructor stub
		this.action = action;
		this.setDisability();
	}

	@Override
	public void setDisability() {
		// TODO Auto-generated method stub
		action.getDone().setEnabled(false);
		action.getRemove().setEnabled(false);
	}

}
