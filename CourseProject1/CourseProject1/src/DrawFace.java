import acm.program.*;

public class DrawFace extends GraphicsProgram {
	
	public static final double FACE_WIDTH = 200;
	public static final double FACE_HEIGHT = 200;
	
	public void run() 
	{
		GFace jason = new GFace(FACE_WIDTH, FACE_HEIGHT);
		add(jason, (getWidth() - FACE_WIDTH) / 2, (getHeight() - FACE_HEIGHT) / 2);
	}

}
