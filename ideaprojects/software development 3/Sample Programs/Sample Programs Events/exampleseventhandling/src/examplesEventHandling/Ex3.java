package examplesEventHandling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*  In this program we have only a single button, but now it
 * toggles each time it is clicked. Adapted from  Ramirez/Dillon
 */
public class Ex3 extends JFrame implements ActionListener
{
	private int toggle = 0;
	private JButton theButton;
	
	public Ex3()
	{
		super("Example 3");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		theButton = new JButton("Turn Off Light");
		theButton.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 28));
		
		// Now set both foreground and background of the JButton
		theButton.setForeground(Color.RED);
		theButton.setBackground(Color.WHITE);

		theButton.addActionListener(this);
	
		this.add(theButton);
		this.setSize(300, 100);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if (toggle == 0)
		{
			theButton.setBackground(Color.BLACK);
			theButton.setText("Turn On Light");
			toggle = 1;
		}
		else
		{
			theButton.setBackground(Color.WHITE);
			theButton.setText("Turn Off Light");
			toggle = 0;
		}
	}	
	
	public static void main(String[] args)
	{
		Ex3 example3 = new Ex3();
		example3.setVisible(true);	
	}
}



