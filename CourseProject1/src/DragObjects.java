import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.event.*;

public class DragObjects extends GraphicsProgram {
	
	private GObject gObj;
	private GPoint lastPoint;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void init() 
	{
		GRect rect = new GRect(100, 100, 150, 100);
		rect.setFilled(true);
		add(rect);
		
		GOval oval = new GOval(50, 50, 150, 100);
		oval.setFilled(true);
		add(oval);
		
		addMouseListeners();
		addKeyListeners();
	}

	public void mousePressed(MouseEvent pos)
	{
		lastPoint = new GPoint(pos.getPoint());
		gObj = getElementAt(lastPoint);
	}

	public void mouseDragged(MouseEvent pos) 
	{
		if (gObj != null) 
		{
			gObj.move(pos.getX() - lastPoint.getX(), pos.getY() - lastPoint.getY());
			lastPoint = new GPoint(pos.getPoint());
		}
	}

	public void keyTyped(KeyEvent e)
	{
		System.out.println("HELLO...............");
		if (gObj != null) 
			gObj.setColor(rgen.nextColor());
	}
	
}