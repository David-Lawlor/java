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
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EventHandlersIncWRITE extends JFrame implements ActionListener{

  private RandomAccessFile raf;
  File out = new File("Software Development 4/Labs/Lab10 RAF/res/event.dat");

  final static int HOST_SIZE = 5;
  final static int WEEK_NUMBER_SIZE = 4;
  final static int GUESTS_SIZE = 4;
  final static int RECORD_SIZE = (HOST_SIZE *2) + WEEK_NUMBER_SIZE + GUESTS_SIZE;

  JTextField host;
  JTextField weekNumber;
  JTextField guests;

  JButton enter;
  JButton exit;

  public EventHandlersIncWRITE(){
    try{
        raf = new RandomAccessFile(out, "rw");
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
    this.setTitle("EventHandlersV1");

    host = new JTextField(HOST_SIZE);
    host.setPreferredSize(new Dimension(120, 20));

    weekNumber = new JTextField(WEEK_NUMBER_SIZE);
    weekNumber.setPreferredSize(new Dimension(75,20));

    guests = new JTextField(GUESTS_SIZE);
    guests.setPreferredSize(new Dimension(50,20));

    enter = new JButton("Enter data");
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

  public void writeAddress(){
    try{
      System.out.println((Integer.parseInt(weekNumber.getText())-1)*RECORD_SIZE);
      raf.seek((Integer.parseInt(weekNumber.getText())-1)*RECORD_SIZE);

      raf.writeUTF(FixedLengthStringIO.padString(host.getText(), HOST_SIZE));
      System.out.println(FixedLengthStringIO.padString(host.getText(), HOST_SIZE));
      raf.writeInt(Integer.parseInt(weekNumber.getText()));
      System.out.println(Integer.parseInt(weekNumber.getText()));
      raf.writeInt(Integer.parseInt(guests.getText()));
      System.out.println(Integer.parseInt(guests.getText()));

    }catch (IOException e) {
      System.out.println(e);
    }
  }

  public void clearFields(){
    host.setText("");
    weekNumber.setText("");
    guests.setText("");
  }




  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == enter){
      writeAddress();
      clearFields();
    }
    else if(e.getSource() == exit){
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    EventHandlersIncWRITE ehi = new EventHandlersIncWRITE();
    ehi.setVisible(true);
  }

//  public void openFile(){
//    if (out == null || out.getName().equals("")){
//      System.out.println("Invalid File Name");
//    }
//    else{
//      try{
//        raf = new RandomAccessFile(out, "rw");
//
//        for (int i = 0; i < NUMBER_OF_RECORDS ; i++) {
//          raf.write();
//        }
//      }catch (IOException e) {
//        System.out.println(e);
//      }
//    }
//  }

}
