package mediator;

import Event.Event;
import strategy.ColorMode;

public interface Colleague {
	void updateEvent(Event e);
	void setColorConfig(ColorMode colormode);
}
