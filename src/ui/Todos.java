package ui;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Event.AllCheckboxNotCheckedEvent;
import Event.CheckEvent;
import Event.CheckboxCheckedEvent;
import Event.ColorEvent;
import Event.Event;
import Event.FinishEvent;
import Event.NewActivityEvent;
import Event.RemoveEvent;
import Event.TodoInputPaneColorChanged;
import Event.TodoPaneColorChanged;
import Event.TodosPaneColorChanged;
import mediator.Colleague;
import mediator.Mediator;
import strategy.ColorMode;

public class Todos extends JPanel implements Colleague{
	private Mediator mediator;
	private Vector<Todo> todos;
	private int checkedTodo;

	public Todos(Mediator mediator) {
		this.todos = new Vector<>();
		this.mediator = mediator;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		displayTodos();
	}

	private void addTodo(String text) {
		todos.add(new Todo(text,mediator));
		displayTodos();
	}

	private void updateTodos() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		displayTodos();
	}
	
	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo);
		}
	}

	@Override
	public void updateEvent(Event e) {
		// TODO Auto-generated method stub
		if (e instanceof NewActivityEvent) {
			addTodo(((NewActivityEvent)e).getValue());
		}
		
		else if (e instanceof CheckEvent) {
			checkedTodo = countListedTodos();
			if (checkListedTodos()) {
				mediator.broadcast(new CheckboxCheckedEvent()); 
			}
			
			else {
				mediator.broadcast(new AllCheckboxNotCheckedEvent());
			}
		}
		
		else if (e instanceof FinishEvent || e instanceof RemoveEvent) {
			updateTodos();
		}	
		
		else if(e instanceof ColorEvent) {
			if (e instanceof TodosPaneColorChanged)
				setColorConfig(((TodosPaneColorChanged)e).getColorMode());
			
			else if (e instanceof TodoPaneColorChanged)
			{
				 for(Todo td : todos) {
					 td.setColorConfig(((TodoPaneColorChanged)e).getColorMode());
				 }
			}
		}
	}
	
	private boolean checkListedTodos() {
		for(Todo t : todos) {
			if (t.isChecked()) {		
				return true;
			}
		}
		
		return false;
	}
	
	private int countListedTodos() {
		int checked = 0;
		
		for(Todo t : todos) {
			if (t.isChecked())
				checked++;
		}
		
		return checked;
	}
	
	public int getCheckedTodo() {
		return checkedTodo;
	}
	
	public Vector<Todo> getTodoItems(){
		return this.todos;
	}

	@Override
	public void setColorConfig(ColorMode colormode) {
		// TODO Auto-generated method stub
		setBackground(colormode.getPanelColor());
	}
}
