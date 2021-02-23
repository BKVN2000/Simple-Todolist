package strategy;

import java.awt.Color;
import decorator.Frame;

public abstract class ColorMode {
	
	public abstract void DecorateColor(Frame frame);	
	
	public abstract Color getButtonColor();
	public abstract Color getTextColor();
	public abstract Color getBorderColor();
	public abstract Color getPanelColor();
	public abstract Color getJtextFieldColor();
	public abstract ColorMode switchMode();
}
