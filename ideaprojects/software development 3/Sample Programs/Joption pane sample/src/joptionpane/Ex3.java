package joptionpane;

import javax.swing.*;


public class Ex3
{
		
	public static void main(String args[])
	{
		int selection;
		
		selection=JOptionPane.showConfirmDialog(null, "Do you want to upgrade to first class?", 
				"Upgrade Options", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if (selection==JOptionPane.YES_OPTION)
			JOptionPane.showMessageDialog(null, "You answered yes");
		else if(selection==JOptionPane.NO_OPTION)
			JOptionPane.showMessageDialog(null, "You answered no");
		else
			JOptionPane.showMessageDialog(null, "You cancelled", "Warning", JOptionPane.WARNING_MESSAGE);
	}
    
}

