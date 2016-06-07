package examplesGBL;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.*;


public class Ex4GBL extends JFrame 
{	
	public Ex4GBL()
		{
			super("GridBagLayout Demo 4");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			setSize(300,150 ); 
			setVisible( true ); 
	
			JPanel testPanel = new JPanel();
			GridBagLayout gridbagLayoutSettings = new GridBagLayout(); 
			testPanel.setLayout(gridbagLayoutSettings); 
			
		    GridBagConstraints gc = new GridBagConstraints();    
		    gc.gridx = 0;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;      
		    gc.anchor = GridBagConstraints.NORTHWEST;
		    testPanel.add(new JButton("Grid"), gc);    
		   
		    gc.gridx = 1;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;         
		    gc.anchor = GridBagConstraints.NORTHEAST;
		    testPanel.add(new JButton("Bag"), gc);    
		    gc.gridx = 0;    
		    gc.gridy = 1;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;   
		    gc.anchor = GridBagConstraints.SOUTHEAST;
		    testPanel.add(new JButton("Layout"), gc);
		    this.add(testPanel);
		}
	
	public static void main( String[] args )
	   { 
	      Ex4GBL gbl = new Ex4GBL(); 
	     
	   } // end main
}

