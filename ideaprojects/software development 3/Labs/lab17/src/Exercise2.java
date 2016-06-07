import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DL on 24/11/2014.
 */
public class Exercise2 extends JFrame{
    private JButton add;
    private JButton clear;
    private JTextField text;
    private JTextArea textArea;

    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 300;


    public Exercise2(){
        super("TextArea Program");
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.lightGray);
        setLayout(new FlowLayout());
        add = new JButton("Add");
        add(add);
        clear = new JButton("Clear");
        add(clear);
        text = new JTextField("Please enter your message here", 22);
        add(text);
        textArea = new JTextArea(8, 18);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        textArea.setEditable(false);
        add(textArea);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(text.getText());
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //text.setText("Please enter your message here");
                text.setText("");
                textArea.setText("");
            }
        });

    }

    public static void main(String[] args) {
        Exercise2 test = new Exercise2();
        test.setVisible(true);
    }
}
