package joptionpane;

import javax.swing.*;

public class Ex1
	{
		public static void main(String[] args)
			{
				String b;
				String h;
    
				b = JOptionPane.showInputDialog(null,"Enter the base: ",
						"Triangle Area Program", JOptionPane.QUESTION_MESSAGE);
       
				h = JOptionPane.showInputDialog(null, "Enter the height: ",
						"Triangle Area Program", JOptionPane.INFORMATION_MESSAGE);
  
				double area = 1.0 / 2.0 * Double.parseDouble(b) * Double.parseDouble(h);
  

				JOptionPane.showMessageDialog(null, "The area is " + area, "The Answer",
						JOptionPane.WARNING_MESSAGE);
			}
	}

