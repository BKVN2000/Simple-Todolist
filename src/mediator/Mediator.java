package mediator;

import java.util.Vector;

import Event.Event;

public abstract class Mediator {
	Vector<Colleague> colleagues;

	public Mediator() {
		colleagues = new Vector<>();
	}

	public void attach(Colleague c) {
		colleagues.add(c);
	}

	public void broadcast(Event e) {
		for (Colleague c : colleagues) {
			c.updateEvent(e);
		}
	}
}

