package examplesEventHandling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex1 extends JFrame implements ActionListener 
{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;
	private JButton changeColour;
	private Container cPane;

	public Ex1()
	{
		this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Changing the Colour");
		this.setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cPane = this.getContentPane();
		this.setLayout (new FlowLayout());
		changeColour = new JButton ("Change Colour");
		changeColour.addActionListener(this);
		this.add(changeColour);
	}
	public void actionPerformed(ActionEvent ae)
	{
		cPane.setBackground(Color.BLUE);
	}
	public static void main (String args[])
	{
		Ex1 example = new Ex1();
		example.setVisible(true);
	}
}	


