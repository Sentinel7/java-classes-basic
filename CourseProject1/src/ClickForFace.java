import acm.program.*;
import java.awt.event.*;

public class ClickForFace extends GraphicsProgram {
	
	public static final double FACE_DIAM = 30;
	
	public void init()
	{
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e)
	{
		GFace face = new GFace(FACE_DIAM, FACE_DIAM);
		add(face, e.getX(), e.getY());
	}

}
