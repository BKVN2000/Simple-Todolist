package Event;

import strategy.ColorMode;

public abstract class ColorEvent extends Event{
	private ColorMode colorMode;
	public ColorEvent(ColorMode colorMode) {
		super();
		this.colorMode = colorMode;
		// TODO Auto-generated constructor stub
	}
	public ColorMode getColorMode() {
		return this.colorMode;
	}
}
