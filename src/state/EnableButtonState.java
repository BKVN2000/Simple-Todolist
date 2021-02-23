package state;

import javax.swing.JButton;

import ui.Actions;

public class EnableButtonState implements ButtonState{

	private Actions action;
	public EnableButtonState(Actions action) {
		// TODO Auto-generated constructor stub
		this.action = action;
		this.setDisability();
	}
	@Override
	public void setDisability() {
		// TODO Auto-generated method stub
		action.getDone().setEnabled(true);
		action.getRemove().setEnabled(true);
	}

}
