package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Event.CheckEvent;
import Event.Event;
import Event.NewActivityEvent;
import Event.RemoveEvent;
import mediator.Colleague;
import mediator.Mediator;
import strategy.ColorMode;

public class Todo extends JPanel implements Colleague, ItemListener{
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;
	private Mediator mediator;
	
	public Todo(String text,Mediator mediator) {
		this.setPreferredSize(new Dimension(350, 30));
		this.mediator = mediator;
			
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		checkbox.addItemListener(this);
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);
	}

	public Border getBorder() {
		return border;
	}

	public JLabel getLabel() {
		return label;
	}

	public JCheckBox getCheckbox() {
		return checkbox;
	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void updateEvent(Event e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		mediator.broadcast(new CheckEvent());
	}

	@Override
	public void setColorConfig(ColorMode colormode) {
		// TODO Auto-generated method stubs
		System.out.println("masuk");
		label.setForeground(colormode.getTextColor());
		border = new LineBorder(colormode.getBorderColor());
		setBackground(colormode.getPanelColor());
	}
}
