import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 1200;

	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	private static final int PADDLE_WIDTH = 120;
	private static final int PADDLE_HEIGHT = 20;

	private static final int PADDLE_Y_OFFSET = 30;

	private static final int NBRICKS_PER_ROW = 10;

	private static final int NBRICK_ROWS = 10;

	private static final int BRICK_SEP = 4;

	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	private static final int BRICK_HEIGHT = 16;

	private static final int BALL_DIAM = 25;

	private static final int BRICK_Y_OFFSET = 70;

	private static final int NTURNS = 3;
	
	private static final int PADDLE_SPEED = 10;

	private GRect paddle;
	private GRect brick;
	private GOval ball;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	double xVel = rgen.nextDouble(1.0, 3.0); 
	double yVel = 3;
	
	public void run() 
	{	
		addKeyListeners();
		setupGame();
		playGame();
	}
	
	public void setupGame()
	{
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle, (APPLICATION_WIDTH-PADDLE_WIDTH)/2, APPLICATION_HEIGHT/2 + PADDLE_Y_OFFSET);
		
		ball = new GOval(BALL_DIAM, BALL_DIAM);
		ball.setFilled(true);
		add(ball, (APPLICATION_WIDTH-BALL_DIAM)/2, APPLICATION_HEIGHT/2);
		
		//Brick color array
		Color[] rowColor = new Color[NBRICK_ROWS];
		rowColor[0] = Color.red;
		rowColor[1] = Color.red;
		rowColor[2] = Color.orange;
		rowColor[3] = Color.orange;
		rowColor[4] = Color.yellow;
		rowColor[5] = Color.yellow;
		rowColor[6] = Color.green;
		rowColor[7] = Color.green;
		rowColor[8] = Color.cyan;
		rowColor[9] = Color.cyan;
				
		//Add bricks
		for(int i = 0; i < NBRICK_ROWS; i++)
		{ 
			for(int j = 0; j < NBRICKS_PER_ROW; j++) 
			{
				brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setFillColor(rowColor[i]);
				add(brick, j*(BRICK_WIDTH + BRICK_SEP), i*(BRICK_HEIGHT + BRICK_SEP)+BRICK_Y_OFFSET);
			}
		}
	}
	
	private void playGame() 
	{
		waitForClick();
		
		while (true) 
		{
			moveBall();
			
			if (ball.getY() >= getHeight())
				break;
		}
		
		//Makes X-Velocity negative half the time
		if (rgen.nextBoolean(0.5)) 
			xVel = -xVel;
	}

	public void moveBall()
	{
		ball.move(xVel, yVel);
		pause(10);
		checkWallCollisions();
		
		GObject collider = getCollidingObject();
		
		if (collider == paddle) {
			yVel = -yVel;
			xVel = -xVel;
		} 
		else if (collider != null) 
		{
			remove(collider);
			yVel = -yVel;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
			paddle.setLocation(paddle.getX()+PADDLE_SPEED, paddle.getY());
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			paddle.setLocation(paddle.getX()-PADDLE_SPEED, paddle.getY());
	}
	
	private void checkWallCollisions()
	{
		double ballX = ball.getX();
		double ballY = ball.getY();
		
		double bottomWall = 700;
		
		//Wall collision bottom
		if (ballY > bottomWall - BALL_DIAM)
			yVel = -yVel;
		
		//Wall collision top
		if (ballY < BALL_DIAM)
			yVel = -yVel;
		
		//Wall collision right
		if (ballX > APPLICATION_WIDTH - BALL_DIAM)
			xVel = -xVel;
		
		//Wall collision left
		if (ballX < BALL_DIAM)
			xVel = -xVel;
	}
	
	private GObject getCollidingObject() 
	{
		double ballX = ball.getX();
		double ballY = ball.getY();
		double ballX2 = ball.getX()+BALL_DIAM;
		double ballY2 = ball.getY()+BALL_DIAM;
		
		if (getElementAt(ballX, ballY) != null) {
			return getElementAt(ballX, ballY);
        }
        else if (getElementAt((ballX2), ballY) != null) {
        	return getElementAt(ballX2, ballY);
        }
        else if (getElementAt(ballX, ballY2) != null) {
        	return getElementAt(ballX, ballY2);
        }
        else if (getElementAt(ballX2, ballY2) != null) {
        	return getElementAt(ballX2, ballY2);
        }
		return null;
	}

}
