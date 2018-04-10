import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAndGraphics extends ConsoleProgram {

	public static final double SPACER = 30;
	
	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField textField;
	
	private double leftY = 10;
	private double rightY = 10;
	
	public void init()
	{
		leftCanvas = new GCanvas();
		add(leftCanvas);
		
		rightCanvas = new GCanvas();
		add(rightCanvas);
		
		textField = new JTextField(10);
		add(new JLabel("Some text"), SOUTH);
		add(textField, SOUTH);
		textField.addActionListener(this);
		
		add(new JButton("Draw left"), SOUTH);
		add(new JButton("Draw right"), SOUTH);
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if (e.getSource() == textField)
		{
			println("You typed: " + textField.getText());
		}
		
		if (cmd.equals("Draw left"))
		{
			leftCanvas.add(createFilledRect(), 20, leftY);
			leftY += SPACER;
		}
		else if (cmd.equals("Draw right"))
		{
			rightCanvas.add(createFilledRect(), 20, rightY);
			rightY += SPACER;
		}
	}
	
	public GRect createFilledRect()
	{
		GRect rect = new GRect(50, 20);
		rect.setFilled(true);
		
		return rect;
	}
	
}
