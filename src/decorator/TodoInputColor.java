package decorator;

import Event.TodoInputPaneColorChanged;
import mediator.Mediator;
import strategy.ColorMode;

public class TodoInputColor extends FrameDecorator{
	
	public TodoInputColor(Frame wrappe,ColorMode colorMode) {
		// TODO Auto-generated constructor stub
		super(wrappe,colorMode);
	}

	@Override
	public Mediator decorate() {
		// TODO Auto-generated method stub

		Mediator tf = this.wrappee.decorate();
		tf.broadcast(new TodoInputPaneColorChanged(colorMode));
			
//		tf.getTodoInput().setColorConfig(tf.getColorMode());
//		tf.getTodoInput().getAdd().setBackground(buttonColor);
//		tf.getTodoInput().getAdd().setForeground(textColor);
//		tf.getTodoInput().getText().setBackground(buttonColor);
//		tf.getTodoInput().getText().setForeground(textColor);
		
		return tf;
	}

	
}
