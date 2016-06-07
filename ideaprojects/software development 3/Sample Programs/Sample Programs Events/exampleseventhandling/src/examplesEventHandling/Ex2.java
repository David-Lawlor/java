package examplesEventHandling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex2 extends JFrame implements ActionListener 
{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;
	private JButton blue, pink, yellow;
	private Container cPane;

	public Ex2()
	{
		this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Changing the Colour");
		this.setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		cPane = this.getContentPane();
		cPane.setBackground(Color.WHITE);
		this.setLayout (new FlowLayout());

		blue = new JButton ("Blue");
		blue.addActionListener(this);
		this.add(blue);
		pink = new JButton ("Pink");
		pink.addActionListener(this);
		this.add(pink);
		yellow = new JButton ("Yellow");
		yellow.addActionListener(this);
		this.add(yellow);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==blue)
			cPane.setBackground(Color.BLUE);
		else if(ae.getSource()==pink)
			cPane.setBackground(Color.PINK);
		else
			cPane.setBackground(Color.YELLOW);

	}
	
	public static void main (String args[])
	{
		Ex2 example = new Ex2();
		example.setVisible(true);
	}
}

