package decorator;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import Event.TodosPaneColorChanged;
import mediator.Mediator;
import strategy.ColorMode;
import ui.TodoFrame;


public class TodosPanelColor extends FrameDecorator{
	
	public TodosPanelColor(Frame wrappe,ColorMode colorMode) {
		// TODO Auto-generated constructor stub
		super(wrappe,colorMode);
	}

	@Override
	public Mediator decorate() {
		// TODO Auto-generated method stub
		Mediator tf = this.wrappee.decorate();
		tf.broadcast(new TodosPaneColorChanged(colorMode));
//		tf.getTodos().setColorConfig(tf.getColorMode());
		 return tf;
	}

}
