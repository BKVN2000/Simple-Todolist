package strategy;

import java.awt.Color;
import decorator.ActionsPanelColor;
import decorator.Frame;
import decorator.TodoInputColor;
import decorator.TodoPanelColor;
import decorator.TodosPanelColor;

public class DarkMode extends ColorMode {
	
	private static Color BACKGROUND_COLOR = Color.BLACK;
	private static Color TEXT_COLOR = Color.WHITE;
	private static Color BUTTON_COLOR = Color.ORANGE;
	private static Color JTEXT_FIELD_COLOR = Color.ORANGE;
	private static Color TODO_COLOR = Color.ORANGE;

	@Override
	public void DecorateColor(Frame frame) {
		// TODO Auto-generated method stub
		
		frame = new ActionsPanelColor(frame,this);
		frame = new TodoInputColor(frame,this);
		frame = new TodoPanelColor(frame,this);
		frame = new TodosPanelColor(frame,this);
		
		frame.decorate();
	}

	@Override
	public Color getButtonColor() {
		// TODO Auto-generated method stub
		return BUTTON_COLOR;
	}

	@Override
	public Color getTextColor() {
		// TODO Auto-generated method stub
		return TEXT_COLOR;
	}

	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return BUTTON_COLOR;
	}

	@Override
	public Color getPanelColor() {
		// TODO Auto-generated method stub
		return BACKGROUND_COLOR;
	}

	@Override
	public Color getJtextFieldColor() {
		// TODO Auto-generated method stub
		return JTEXT_FIELD_COLOR;
	}

	@Override
	public ColorMode switchMode() {
		// TODO Auto-generated method stub
		return new LightMode();
	}
}
