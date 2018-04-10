import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TextBoxExample extends ConsoleProgram {

	private JTextField nameField;
	
	public void init()
	{
		setFont("Courier-24");
		
		nameField = new JTextField(10);
		
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		
		nameField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == nameField)
		{
			println("Hello, " + nameField.getText());
		}
	}
	
}
