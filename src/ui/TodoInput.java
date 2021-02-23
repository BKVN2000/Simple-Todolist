package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Event.ActionsPaneColorChanged;
import Event.ColorEvent;
import Event.Event;
import Event.NewActivityEvent;
import Event.TodoInputPaneColorChanged;
import mediator.Colleague;
import mediator.Mediator;
import strategy.ColorMode;

public class TodoInput extends JPanel implements ActionListener,Colleague {
	private Mediator mediator;
	private JTextField text;
	private JButton add;

	public TodoInput(Mediator mediator) {
		this.mediator = mediator;

		text = new JTextField(20);
		add = new JButton("Add");
		this.add(text);
		this.add(add);
		add.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		if (!todoText.equals("")) {
			mediator.broadcast(new NewActivityEvent(this,todoText));
		}

		
		this.text.setText("");
	}

	public JTextField getText() {
		return text;
	}

	public JButton getAdd() {
		return add;
	}

	@Override
	public void updateEvent(Event e) {
		// TODO Auto-generated method stub
		if (e instanceof ColorEvent) {
			setColorConfig(((ColorEvent)e).getColorMode());
		}
	}

	@Override
	public void setColorConfig(ColorMode colormode) {
		// TODO Auto-generated method stub
		setBackground(colormode.getPanelColor());
		text.setForeground(colormode.getJtextFieldColor());
		add.setBackground(colormode.getButtonColor());
		add.setForeground(colormode.getTextColor());
	}
	
}
