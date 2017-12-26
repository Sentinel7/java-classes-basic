import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram {
	
	private GLabel label;
	
	public void run() 
	{
		addMouseListeners();
		
		label = new GLabel("");
		label.setFont("Times New Roman-16");
		add(label, 50, 50);
	}
	
	public void mouseMoved(MouseEvent pos) 
	{
		label.setLabel("Mouse: (" + pos.getX() + ", " + pos.getY() + ")");
	}
	
}