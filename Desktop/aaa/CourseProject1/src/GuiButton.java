import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiButton extends ConsoleProgram {

	public void init() 
	{
		add(new JButton("Hi"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Hi"))
			println("Hello there");
	}
	
}
