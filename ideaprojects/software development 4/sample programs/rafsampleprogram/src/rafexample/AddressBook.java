package rafexample;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class AddressBook extends JFrame {
    // Specify the size of four fields in the record
    final static int NAME_SIZE = 32;
    final static int STREET_SIZE = 32;
    final static int CITY_SIZE = 20;
    final static int PCODE_SIZE = 2;
    final static int RECORD_SIZE =
            (NAME_SIZE + STREET_SIZE + CITY_SIZE  + PCODE_SIZE);
    // Access address.dat using RandomAccessFile
    private RandomAccessFile raf;
    // Text fields
    private JTextField jtfName = new JTextField(NAME_SIZE);
    private JTextField jtfStreet = new JTextField(STREET_SIZE);
    private JTextField jtfCity = new JTextField(CITY_SIZE);
    private JTextField jtfPcode = new JTextField(PCODE_SIZE);
    // Buttons
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtFirst = new JButton("First");
    private JButton jbtNext = new JButton("Next");
    private JButton jbtPrevious = new JButton("Previous");
    private JButton jbtLast = new JButton("Last");
    public AddressBook() {
        // Open or create a random access file
        try {
            raf = new RandomAccessFile("files/address.dat", "rw");
        }
        catch(IOException ex) {
            System.out.print("Error: " + ex);
            System.exit(0);
        }
        // Panel p1 for holding labels Name, Street, and City
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        p1.add(new JLabel("Name"));
        p1.add(new JLabel("Street"));
        p1.add(new JLabel("City"));

        // Panel jpcode for holding postcode
        JPanel jppcode = new JPanel();
        jppcode.setLayout(new BorderLayout());
        jppcode.add(new JLabel("Post Code"), BorderLayout.WEST);
        jppcode.add(jtfPcode, BorderLayout.CENTER);
        // Panel p2 for holding jpState and jpZip
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
//        p2.add(jpState, BorderLayout.WEST);
        p2.add(jppcode, BorderLayout.CENTER);
        // Panel p3 for holding jtfCity and p2
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(jtfCity, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.EAST);
        // Panel p4 for holding jtfName, jtfStreet, and p3
        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3, 1));

        jtfName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearFields();
            }
        });
        p4.add(jtfName);
        p4.add(jtfStreet);
        p4.add(p3);
        // Place p1 and p4 into jpAddress
        JPanel jpAddress = new JPanel(new BorderLayout());
        jpAddress.add(p1, BorderLayout.WEST);
        jpAddress.add(p4, BorderLayout.CENTER);
        // Set the panel with line border
        jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));
        // Add buttons to a panel
        JPanel jpButton = new JPanel();
        jpButton.add(jbtAdd);
        jpButton.add(jbtFirst);
        jpButton.add(jbtNext);
        jpButton.add(jbtPrevious);
        jpButton.add(jbtLast);
        // Add jpAddress and jpButton to the frame
        add(jpAddress, BorderLayout.CENTER);
        add(jpButton, BorderLayout.SOUTH);

        jbtAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeAddress();
                clearFields();
            }
        });
        jbtFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (raf.length() > 0) readAddress(0);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long currentPosition = raf.getFilePointer();
                    if (currentPosition < raf.length())
                        readAddress(currentPosition);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long currentPosition = raf.getFilePointer();
                    System.out.println("length"+currentPosition);
                    System.out.println("Record Size"+RECORD_SIZE);
                    if (currentPosition - 2 * RECORD_SIZE > 0)
                        readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
                    else
                        readAddress(0);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long lastPosition = raf.length();
                    System.out.println("length"+lastPosition);
                    System.out.println("Record Size"+RECORD_SIZE);
                    if (lastPosition > 0)
                        readAddress(lastPosition - 2 * RECORD_SIZE);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Display the first record if exists
        try {
            if (raf.length() > 0) readAddress(0); }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearFields()
    {
        jtfName.setText("");
        jtfStreet.setText("");
        jtfCity.setText("");
        jtfPcode.setText("");
    }
    /** Write a record at the end of the file */
    public void writeAddress() {
        try {
            raf.seek(raf.length());
            FixedLengthStringIO.writeFixedLengthString(
                    jtfName.getText(), NAME_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfStreet.getText(), STREET_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfCity.getText(), CITY_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfPcode.getText(), PCODE_SIZE, raf);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /** Read a record at the specified position */
    public void readAddress(long position) throws IOException {
        raf.seek(position);
        String name = FixedLengthStringIO.readFixedLengthString(
                NAME_SIZE, raf);
        String street = FixedLengthStringIO.readFixedLengthString(
                STREET_SIZE, raf);
        String city = FixedLengthStringIO.readFixedLengthString(
                CITY_SIZE, raf);
        String pcode = FixedLengthStringIO.readFixedLengthString(
                PCODE_SIZE, raf);
        jtfName.setText(name);
        jtfStreet.setText(street);
        jtfCity.setText(city);
        jtfPcode.setText(pcode);
    }
    public static void main(String[] args) {
        AddressBook frame = new AddressBook();
        frame.pack();
        frame.setTitle("AddressBook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }}
