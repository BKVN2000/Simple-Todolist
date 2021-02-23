package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JFrame;

import Event.ColorModeChanged;
import Event.Event;
import Event.FinishEvent;
import Event.NewActivityEvent;
import decorator.Frame;
import mediator.Colleague;
import mediator.Form;
import mediator.Mediator;
import strategy.ColorMode;
import strategy.DarkMode;
import strategy.LightMode;

public class TodoFrame extends JFrame implements Colleague,Frame,KeyListener,MouseListener{
	private Form mediator = new Form();
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private int totalDone;
	private ColorMode colorMode;
	
	public TodoFrame() {
		totalDone = 0;
		setTitle(totalDone);
		todoInput = new TodoInput(mediator);
		mediator.attach(todoInput);
		this.add(todoInput, BorderLayout.NORTH);

		todos = new Todos(mediator);
		mediator.attach(todos);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(mediator);
		mediator.attach(actions);
		this.add(actions, BorderLayout.SOUTH);

		mediator.attach(this);	
		addKeyListener(this);
		setFocusable(true);
        addMouseListener(this);
       
        statTime();
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}


	private void setTitle(int done) {
		totalDone += done;
		this.setTitle("Done: "+ totalDone);
	}
	
	@Override
	public void updateEvent(Event e) {
		// TODO Auto-generated method stub
		if (e instanceof FinishEvent) {
			setTitle(this.todos.getCheckedTodo());
		}
		
		else if (e instanceof NewActivityEvent) {
			this.colorMode.DecorateColor(this);
		}
		
		else if (e instanceof ColorModeChanged) {
			colorMode = ((ColorModeChanged)e).getColorMode();
			colorMode.DecorateColor(this);
		}
		
		this.pack();
	}

	public TodoInput getTodoInput() {
		return todoInput;
	}


	public void setTodoInput(TodoInput todoInput) {
		this.todoInput = todoInput;
	}


	public Todos getTodos() {
		return todos;
	}

	public Actions getActions() {
		return actions;
	}

	@Override
	public Mediator decorate() {
		// TODO Auto-generated method stub
		return this.mediator;
	}


	@Override
	public void setColorConfig(ColorMode colormode) {
		// TODO Auto-generated method stub
	}
	
	public ColorMode getColorMode() {
		return colorMode;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 'N') 
		{
			colorMode = this.colorMode.switchMode();
			colorMode.DecorateColor(this);
		}		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		setFocusable(true);
		this.requestFocusInWindow();
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void statTime(){
	    new Thread(new Runnable() {

	        @Override
	        public void run() {
	            try {
	            	Calendar c = Calendar.getInstance();
                	int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
                	int minOfDay = c.get(Calendar.MINUTE);
                	int secOfDay = c.get(Calendar.SECOND);
                	
                	if((timeOfDay >= 6 && timeOfDay < 17)){
                		mediator.broadcast(new ColorModeChanged(new LightMode()));
            		
                	}else {
                		mediator.broadcast(new ColorModeChanged( new DarkMode())); 		
                	} 	
                	
	                while (true) {   
	                	c = Calendar.getInstance();
	                	timeOfDay = c.get(Calendar.HOUR_OF_DAY);
	                	minOfDay = c.get(Calendar.MINUTE);
	                	secOfDay = c.get(Calendar.SECOND);
	                	
	                	if (timeOfDay == 18 && minOfDay == 00 && secOfDay == 00){
	                		if (!(colorMode instanceof DarkMode))
	                		{
	                    		mediator.broadcast(new ColorModeChanged(new DarkMode())); 		
	                		}
	                	}
	                	
	                	else if (timeOfDay == 06 && minOfDay == 00 && secOfDay == 00){
	                     	if (!(colorMode instanceof LightMode))
	                		{
	                    		mediator.broadcast(new ColorModeChanged( new LightMode())); 		
	                		}	
	                	}
	                	Thread.sleep(1000);
	                }

	            } catch (Exception e) {
	            }
	        }
	    }).start();
	}
}
