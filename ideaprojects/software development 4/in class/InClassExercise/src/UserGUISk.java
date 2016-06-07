import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class UserGUISk extends JFrame {

    private JTextField name, address1, address2, age, emailAddress;
    private JRadioButton mr, mrs, ms;
    private JTextArea status;
    private ButtonGroup title;
    private JComboBox<String> choiceBox;
    private JButton submit, quit;
    private JLabel choose;





    public UserGUISk() {
        super("Add User");
        this.setTitle("GridBagLayout");


        this.setSize(800, 400);



        choose = new JLabel("Please Choose:");





        title = new ButtonGroup();
        mr = new JRadioButton("Mr", false);

        mr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + mr.getText());
            }
        });
        title.add(mr);

        mrs = new JRadioButton("Mrs", false);

        mrs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + mrs.getText());
            }
        });
        title.add(mrs);

        ms = new JRadioButton("Ms", false);

        ms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + ms.getText());
            }
        });
        title.add(ms);

        JLabel n = new JLabel("Name:");


        name = new JTextField(15);


        JLabel a1 = new JLabel("Address 1:");


        address1 = new JTextField(15);


        JLabel ag = new JLabel("Age:");


        age = new JTextField(15);


        JLabel a2 = new JLabel("Address 2:");


        address2 = new JTextField(15);


        JLabel em = new JLabel("Email Address:");


        emailAddress = new JTextField(15);


        JLabel a3 = new JLabel("Address 3:");


        choiceBox = new JComboBox<String>();
        choiceBox.addItem("Waterford");
        choiceBox.addItem("Dublin");
        choiceBox.addItem("Cork");
        choiceBox.addItem("Galway");
        choiceBox.addItem("Belfast");
        choiceBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                status.setText("You chose: "
                        + choiceBox.getSelectedItem().toString());
            }
        });



        submit = new JButton("Submit");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameString = name.getText();
                if (validateEmail(emailAddress.getText())) {
                    String em = emailAddress.getText();
                    status.setText("Valid Email address: " + em);
                } else {
                    status.setText("Email address must contain an @");
                }

                if (nameString.length() > 15) {
                    status.setText("The name entered is too long");
                }
            }
        });

        quit = new JButton("Quit");

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        status = new JTextArea(5, 50);
        JScrollPane scroll = new JScrollPane(status);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        this.setVisible(true);
    }











    public boolean validateEmail(String e) {
        boolean valid = false;

        int index = e.indexOf('@');
        if (index != -1) {
            valid = true;
        }
        return valid;
    }
}
