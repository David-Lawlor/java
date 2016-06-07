package examplesGBL;
import java.awt.GridBagLayout;
import javax.swing.*;

public class Ex1GBL extends JFrame 
{
	public Ex1GBL()
		{
			super("GridBagLayout Demo 1");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			setSize(300,150 ); 
			setVisible( true ); 
	
			JPanel testPanel = new JPanel();
			GridBagLayout gridbagLayoutSettings = new GridBagLayout(); 
			testPanel.setLayout(gridbagLayoutSettings); 
			
			testPanel.add(new JButton("Grid"));
			testPanel.add(new JButton("Bag"));
			testPanel.add(new JButton("Layout"));
			this.add(testPanel);
		}
	public static void main( String[] args )
	   { 
	      Ex1GBL gbl = new Ex1GBL(); 
	     
	   } // end main
}
