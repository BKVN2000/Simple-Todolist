package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Event.AllCheckboxNotCheckedEvent;
import Event.CheckboxCheckedEvent;
import Event.ColorEvent;
import Event.Event;
import Event.FinishEvent;
import Event.RemoveEvent;
import mediator.Colleague;
import mediator.Mediator;
import state.ButtonState;
import state.DisableButtonState;
import state.EnableButtonState;
import strategy.ColorMode;

public class Actions extends JPanel implements ActionListener, Colleague {
	private Mediator mediator;
	private JButton done;
	private JButton remove;
	private ButtonState buttonState;
	
	public Actions(Mediator mediator) {
		this.mediator = mediator;
		done = new JButton("Done");
		remove = new JButton("Remove");
		
		this.add(done);
		this.add(remove);

		done.addActionListener(this);
		remove.addActionListener(this);
		
		mediator.attach(this);
		buttonState = new DisableButtonState(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			mediator.broadcast(new FinishEvent());
			
		}

		if (e.getSource().equals(remove)) {
			mediator.broadcast(new RemoveEvent());
		}
		
		buttonState = new DisableButtonState(this);
	}

	@Override
	public void updateEvent(Event e) {
		// TODO Auto-generated method stub
		if (e instanceof AllCheckboxNotCheckedEvent && !(buttonState instanceof DisableButtonState)) {
			buttonState = new DisableButtonState(this);
		}
		
		else if(e instanceof CheckboxCheckedEvent && !(buttonState instanceof EnableButtonState)) {
			buttonState = new EnableButtonState(this);
		}
		
		else if (e instanceof ColorEvent) {
			setColorConfig(((ColorEvent)e).getColorMode());
		}
	}

	public JButton getDone() {
		return done;
	}

	public JButton getRemove() {
		return remove;
	}

	@Override
	public void setColorConfig(ColorMode colormode) {
		// TODO Auto-generated method stub
		setBackground(colormode.getPanelColor());
		done.setBackground(colormode.getButtonColor());
		done.setForeground(colormode.getTextColor());
		remove.setBackground(colormode.getButtonColor());
		remove.setForeground(colormode.getTextColor());
	}
}
