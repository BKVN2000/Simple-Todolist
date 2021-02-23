package strategy;

import java.awt.Color;

import decorator.ActionsPanelColor;
import decorator.Frame;
import decorator.TodoInputColor;
import decorator.TodoPanelColor;
import decorator.TodosPanelColor;

public class LightMode extends ColorMode {
	private static Color BACKGROUND_COLOR = Color.WHITE;
	private static Color TEXT_COLOR = Color.BLACK;
	private static Color BUTTON_COLOR = Color.RED;
	private static Color JTEXT_FIELD_COLOR = Color.ORANGE;
//	private static HashMap<Component, Color> colorConfigs;
//	
//	static {
//		colorConfigs = new HashMap<Component, Color>();
//		colorConfigs.put(new JPanel(),BACKGROUND_COLOR);
//		colorConfigs.put(new JLabel(),TEXT_COLOR);
//		colorConfigs.put(new JButton(),BUTTON_COLOR);
//	}
	
	public LightMode() {
		// TODO Auto-generated constructor stub
//		super(colorConfigs);
	}

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
		return new DarkMode();
	}

}
