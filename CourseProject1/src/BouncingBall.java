import acm.program.*;
import acm.graphics.*;

public class BouncingBall extends GraphicsProgram {

	private static final int DIAM_BALL = 30;

	private static final double GRAVITY = 3;

	private static final int DELAY = 50;

	private static final double X_START = DIAM_BALL / 2;
	private static final double Y_START = 100;

	private static final double X_VEL = 5;
 
	private static final double BOUNCE_REDUCE = 0.9;
	
	private double xVel = X_VEL;
	private double yVel = 0.0;
	
	private GOval ball;
	
	public void run() {
		setup();
	
		while (ball.getX() < getWidth())
		{
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	private void setup() {
		ball = new GOval(DIAM_BALL, DIAM_BALL);
		add(ball);
	}

	private void moveBall() 
	{
		// increase yVelocity due to gravity on each cycle
		yVel += GRAVITY;
		ball.move(xVel, yVel);
	}
	
	private void checkForCollision() {
		
		if (ball.getY() > getHeight() - DIAM_BALL)
		{
			// change ball's Y velocity to now bounce upwards
			yVel = -yVel * BOUNCE_REDUCE;

			// assume bounce will move ball an amount above the
			// floor equal to the amount it would have dropped
			// below the floor.
			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2 * diff);
		}
	}
}