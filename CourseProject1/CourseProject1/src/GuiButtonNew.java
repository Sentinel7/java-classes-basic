import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiButtonNew extends ConsoleProgram {

	private JButton hiButton;
	
	public void init()
	{
		hiButton = new JButton("Hi");
		add(hiButton, SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (hiButton == e.getSource())
		{
			println("Hello there");
		}
	}
	
}
