package gui;
import model.PhoneBook;
import database.ContactOperations;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class updateGUI extends JFrame implements ActionListener{
	private JPanel p1,p2;
	private JTextField nameF, addF, phoneF,emailF;
	private JButton ok;
	private PhoneBook pbook;
	private int updateIndex;
	private JDialog updateD;
	
	public updateGUI(PhoneBook p, JFrame parent,int i)
	{
		updateD = new JDialog(parent,true);
		updateD.setSize(300, 250);
		updateD.setTitle("PhoneBook Application");
		updateD.setLocationRelativeTo(null);
		updateD.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	  	
	  	pbook = p;
	  	updateIndex = i;
	  	
	  	p1 = new JPanel(new GridLayout(4,2));	  	  	
	  	p1.add(new Label("Name:"));
	  	nameF = new JTextField(p.getContact(updateIndex).getName());
	  	nameF.setEditable(false);
	  	p1.add(nameF);
	  	
	  	p1.add(new Label("Address: "));
	  	addF = new JTextField(p.getContact(updateIndex).getAddress());
	  	addF.setEditable(false);
	  	p1.add(addF);
	  	
	  	p1.add(new Label("Phone:"));
	  	phoneF = new JTextField(p.getContact(updateIndex).getPhoneNumber());
	  	phoneF.setEditable(true);
	  	p1.add(phoneF);
	  	phoneF.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                phoneF.setText("");
            }
        });
	  	
	  	p1.add(new Label("E-mail:"));
	  	emailF = new JTextField(p.getContact(i).getEmail());
	  	emailF.setEditable(false);
	  	p1.add(emailF);
	  	

	  	p1.setBorder(new TitledBorder("Contact Details"));
	  	updateD.add(p1, BorderLayout.CENTER);
	  	
	  	p2 = new JPanel();
	  	ok = new JButton("Save");
		ok.addActionListener(this);
		p2.add(ok);
		
		updateD.add(p2,BorderLayout.SOUTH);
	  	updateD.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == ok)
		{
			//updateNumber();
			updateD.setVisible(false);
		}

	}

	public void updateNumber(){
		String phone = phoneF.getText();
		if (phone.equals("")){
			JOptionPane.showMessageDialog(null, "Please enter number.");
		}else{
			pbook.updatePhoneNum(phone, pbook.getContact(updateIndex).getName());
			JOptionPane.showMessageDialog(null, "Person Saved");
			setVisible(false);
		}
	}
}

