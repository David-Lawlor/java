package examplesGBL;

//When component size is less than the container size 
//the fill option comes in very handy. Basically this 
//option is to specify how much distribution of component 
//we want in display area. We can have options such as 
//NONE, VERTICAL, HORIZONTAL or BOTH as a fill options. 
//By default value of the fill option is set to NONE.

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.*;


public class Ex3GBL extends JFrame 
{
	
	public Ex3GBL()
		{
			super("GridBagLayout Demo 3");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			setSize(300,150 ); // set frame size
			setVisible( true ); // display frame
	
			JPanel testPanel = new JPanel();
			GridBagLayout gridbagLayoutSettings = new GridBagLayout(); 
			testPanel.setLayout(gridbagLayoutSettings); 
  
		    GridBagConstraints gc = new GridBagConstraints();    
		    gc.gridx = 0;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;      
		    gc.fill = GridBagConstraints.VERTICAL;
		    testPanel.add(new JButton("Grid"), gc);    
		   
		    gc.gridx = 1;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;         
		    gc.fill = GridBagConstraints.BOTH;
		    testPanel.add(new JButton("Bag"), gc);    
		    gc.gridx = 0;    
		    gc.gridy = 1;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;   
		    gc.fill = GridBagConstraints.HORIZONTAL;
		    testPanel.add(new JButton("Layout"), gc);
		    this.add(testPanel);
		}
	
	public static void main( String[] args )
	   { 
	      Ex3GBL gbl = new Ex3GBL(); 
	     
	   } // end main
}
