package decorator;

import Event.TodoPaneColorChanged;
import mediator.Mediator;
import strategy.ColorMode;

public class TodoPanelColor extends FrameDecorator{	
	public TodoPanelColor(Frame wrappee,ColorMode colorMode) {
		// TODO Auto-generated constructor stub
		super(wrappee,colorMode);
	}

	@Override
	public Mediator decorate() {
		// TODO Auto-generated method stub
		 Mediator tf = this.wrappee.decorate();
		 tf.broadcast(new TodoPaneColorChanged(colorMode));
//		 for(Todo td : tf.getTodos().getTodoItems()) {
//			 td.setColorConfig(tf.getColorMode());
//		 }
//		 
		 return tf;
	}

}
