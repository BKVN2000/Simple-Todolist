package decorator;

import strategy.ColorMode;

public abstract class FrameDecorator implements Frame{
	protected Frame wrappee;
	protected ColorMode colorMode;
	
	public FrameDecorator(Frame wrappee,ColorMode colorMode) {
		// TODO Auto-generated constructor stub
		this.wrappee = wrappee;
		this.colorMode = colorMode;
	}

}
