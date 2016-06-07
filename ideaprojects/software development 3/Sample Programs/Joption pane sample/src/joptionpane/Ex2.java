package joptionpane;

import javax.swing.*;

public class Ex2
{		
	public static void main(String args[])
	{
		String name = JOptionPane.showInputDialog(null, "What is your name?");
		JOptionPane.showMessageDialog(null, "Hello " + name);
	}
}

