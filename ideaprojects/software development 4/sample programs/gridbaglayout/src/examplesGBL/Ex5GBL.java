package examplesGBL;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.*;


public class Ex5GBL extends JFrame 
{	
	public Ex5GBL()
		{
			super("GridBagLayout Demo 5");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			setSize(300,150 ); 
			setVisible( true ); 
	
			JPanel testPanel = new JPanel();
			GridBagLayout gridbagLayoutSettings = new GridBagLayout(); 
			testPanel.setLayout(gridbagLayoutSettings); 
			
		    GridBagConstraints gc = new GridBagConstraints();  
		    Insets insets = new Insets(5,10,15,5);   // Creating insets TLBR
		    
		    gc.gridx = 0;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;      
		    gc.insets = insets; //Assigning the insets
		    gc.fill = GridBagConstraints.BOTH;
		    testPanel.add(new JButton("Grid"), gc);    
		   
		    gc.gridx = 1;    
		    gc.gridy = 0;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;         
		    gc.insets = insets; //Assigning the insets
		    gc.fill = GridBagConstraints.BOTH;
		    testPanel.add(new JButton("Bag"), gc);    
		    
		    gc.gridx = 0;    
		    gc.gridy = 1;    
		    gc.weighty = 1.0;    
		    gc.weightx = 1.0;   
		    gc.insets = insets; //Assigning the insets
		    gc.fill = GridBagConstraints.BOTH;
		    testPanel.add(new JButton("Layout"), gc);
		    
		    this.add(testPanel);
		}
	
	public static void main( String[] args )
	   { 
	      Ex5GBL gbl = new Ex5GBL(); 
	     
	   } // end main
}
