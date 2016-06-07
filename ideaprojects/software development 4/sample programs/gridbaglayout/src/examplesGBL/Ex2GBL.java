package examplesGBL;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.*;

public class Ex2GBL extends JFrame 
{
	public Ex2GBL()
		{
			super("GridBagLayout Demo 2");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			setSize(300,150 ); // set frame size
			setVisible( true ); // display frame
	
			JPanel testPanel = new JPanel();
			GridBagLayout gridbagLayoutSettings = new GridBagLayout(); 
			testPanel.setLayout(gridbagLayoutSettings); 
			   
		    GridBagConstraints gc = new GridBagConstraints();    
		    gc.gridx = 0;    // col
		    gc.gridy = 0;    // row
		    gc.weighty = 1.0;    // amount of space to allocate vertically
		    gc.weightx = 1.0;    // amount of space to allocate horizontally
		    testPanel.add(new JButton("Grid"), gc);    
		    gc.gridx = 1;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;         
		    testPanel.add(new JButton("Bag"), gc);    
		    gc.gridx = 0;    
		    gc.gridy = 1;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;         
		    testPanel.add(new JButton("Layout"), gc);
		    this.add(testPanel);
		}
	
	public static void main( String[] args )
	   { 
	      Ex2GBL gbl = new Ex2GBL(); 
	     
	   } // end main
}

