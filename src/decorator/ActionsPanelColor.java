package decorator;

import Event.ActionsPaneColorChanged;
import mediator.Mediator;
import strategy.ColorMode;


public class ActionsPanelColor extends FrameDecorator{	
	public ActionsPanelColor(Frame wrappe,ColorMode colorMode) {
		// TODO Auto-generated constructor stub
		super(wrappe,colorMode);
	}

	@Override
	public Mediator decorate() {
		// TODO Auto-generated method stub
	
		Mediator tf = this.wrappee.decorate();
		tf.broadcast(new ActionsPaneColorChanged(colorMode));
//		tf.getActions().setBackground(backgroundColor);
//		tf.getActions().getDone().setBackground(buttonColor);
//		tf.getActions().getDone().setForeground(textColor);
//		tf.getActions().getRemove().setBackground(buttonColor);
//		tf.getActions().getRemove().setForeground(textColor);
		
		return tf;
	}

}
