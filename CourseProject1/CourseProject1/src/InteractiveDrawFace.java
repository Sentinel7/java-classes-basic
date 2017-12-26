import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InteractiveDrawFace extends GraphicsProgram {

	private JCheckBox checkbox;
	private JRadioButton smallRB;
	private JRadioButton medRB;
	private JRadioButton largeRB;
	private JComboBox pickColor;
	
	public void init() 
	{
		add(new JButton("Clear"), SOUTH);
		
		checkbox = new JCheckBox("Front");
		checkbox.setSelected(true);
		add(checkbox, SOUTH);
		
		addRadioButtons();
		addColorPicker();
		
		addMouseListeners();
		addActionListeners();
	}
	
	private void addColorPicker() 
	{
		pickColor = new JComboBox();
		pickColor.addItem("Black");
		pickColor.addItem("Blue");
		pickColor.addItem("Red");
		pickColor.addItem("Green");
		
		pickColor.setEditable(false);
		pickColor.setSelectedItem("Black");
		
		add(new JLabel("  Color:"), SOUTH);
		add(pickColor, SOUTH);
	}

	private void addRadioButtons() 
	{
		ButtonGroup bGroup = new ButtonGroup();
		smallRB = new JRadioButton("Small");
		medRB = new JRadioButton("Medium");
		largeRB = new JRadioButton("Large");
		
		bGroup.add(smallRB);
		bGroup.add(medRB);
		bGroup.add(largeRB);
		
		medRB.setSelected(true);
		
		add(smallRB, SOUTH);
		add(medRB, SOUTH);
		add(largeRB, SOUTH);
	}
	
	public double getDiamSize()
	{
		double size = 0;
		
		if (smallRB.isSelected())
			size = 40;
		else if (medRB.isSelected())
			size = 60;
		else if (largeRB.isSelected())
			size = 80;
		
		return size;
	}
	
	private Color getCurrentColor()
	{
		String color = (String) pickColor.getSelectedItem();
		
		if (color.equals("Blue"))
			return Color.BLUE;
		else if (color.equals("Red"))
			return Color.RED;
		else if (color.equals("Green"))
			return Color.GREEN;
		else
			return Color.BLACK;
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		GObject obj;
		double diam = getDiamSize();
		
		if (checkbox.isSelected())
			obj = new GFace(diam, diam);
		else
			obj = new GOval(diam, diam);
		
		obj.setColor(getCurrentColor());
		add(obj, e.getX(), e.getY());
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Clear"))
			removeAll();
	}
	
}
