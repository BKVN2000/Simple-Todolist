package Event;

public class NewActivityEvent extends Event {
	private String text;
	
	public NewActivityEvent(Object object, String text) {
		super();
		this.text = text;
	}
	
	public String getValue() {
		return text;
	}	
}
