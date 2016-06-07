/*IdeaProjects
  PACKAGE_NAME
  Created by David
  12:08   18/03/2015
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EventHandlersIncREAD extends JFrame implements ActionListener{

  private RandomAccessFile raf;

  final static int HOST_SIZE = 10;
  final static int WEEK_NUMBER_SIZE = 4;
  final static int GUESTS_SIZE = 4;
  final static int RECORD_SIZE = HOST_SIZE + WEEK_NUMBER_SIZE + GUESTS_SIZE;

  JTextField host;
  JTextField weekNumber;
  JTextField guests;

  JButton enter;
  JButton exit;

  public EventHandlersIncREAD(){
    try{
      raf = new RandomAccessFile("Software Development 4/Labs/Lab10 RAF/res/event.dat", "rw");

    }catch (IOException e) {
      System.out.println(e);
    }

    JLabel titleLabel = new JLabel("Event Handelers Incorporated");
    titleLabel.setFont(new Font("Calibri", Font.ITALIC, 25));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new FlowLayout());
    this.setSize(320, 200);
    this.setResizable(false);
    this.setTitle("EventHandlersV2");

    host = new JTextField(HOST_SIZE);
    host.setPreferredSize(new Dimension(120, 20));

    weekNumber = new JTextField(WEEK_NUMBER_SIZE);
    weekNumber.setPreferredSize(new Dimension(75,20));

    guests = new JTextField(GUESTS_SIZE);
    guests.setPreferredSize(new Dimension(50,20));

    enter = new JButton("Enter Week Number");
    enter.addActionListener(this);

    exit = new JButton("Exit");
    exit.addActionListener(this);

    this.add(titleLabel);
    this.add(new JLabel("Enter this month's events Host"));
    this.add(host);
    this.add(new JLabel("Week Number"));
    this.add(weekNumber);
    this.add(new JLabel("Guests"));
    this.add(guests);
    this.add(enter);
    this.add(exit);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == enter){
      try {
        long position = (Integer.parseInt(weekNumber.getText())-1)* RECORD_SIZE;
        raf.seek(position);
        System.out.println(position);
        System.out.println(RECORD_SIZE);
        host.setText(raf.readUTF());
        weekNumber.setText(Integer.toString(raf.readInt()));
        guests.setText(Integer.toString(raf.readInt()));

     } catch (IOException e1) {
        e1.printStackTrace();
        System.out.println("here");
      }
    }
    else if(e.getSource() == exit){
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    EventHandlersIncREAD ehi = new EventHandlersIncREAD();
    ehi.setVisible(true);
  }

}
