package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuDemo extends JFrame {
    private JMenuBar menuBar;                 // program's main menu bar

    private JMenu fileMenu;                   // file menu
    private JMenu formatMenu;                 // format menu
    private JMenu helpMenu;                   // help menu

    private JMenuItem file_exit;              // file menu, exit item
    private JMenuItem format_font;            // format menu, font item
    private JMenuItem format_color;           // format menu, color item
    private JMenuItem help_about;             // help menu, about item

    private Container cpane;

    public MenuDemo() {                       // set up GUI
        super("Menu Demo");

        cpane = getContentPane();
        menuBar = new JMenuBar();              // construct menu bar

        fileMenu = new JMenu("File");          // define file menu
        fileMenu.setMnemonic('F');             // shortcut - press Alt and the letter

        file_exit = new JMenuItem("Exit");     // define file menu options
        file_exit.setMnemonic('E');
        file_exit.addActionListener(new ActionListener() {
        @Override
           public void actionPerformed(ActionEvent e) {
              System.exit(0);
           }
        });


        fileMenu.add(file_exit);

        menuBar.add(fileMenu);                 // add file menu to menu bar

        formatMenu = new JMenu("Format");      // define format menu
        formatMenu.setMnemonic('m');           // shortcut

        format_font = new JMenuItem("Font");   // define format menu options
        format_font.setMnemonic('F');
        format_font.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Font choice goes here");
            }
        });
        formatMenu.add(format_font);
        format_color = new JMenuItem("Color"); // define format menu options
        format_color.setMnemonic('C');
        format_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color;                               // color chosen

                color = Color.GREEN;
                color = JColorChooser.showDialog(MenuDemo.this,
                        "Choose a color", color);
                cpane.setBackground(color);
            }
        });
        formatMenu.add(format_color);

        menuBar.add(formatMenu);               // add format menu to menu bar

        helpMenu = new JMenu("Help");          // define help menu
        helpMenu.setMnemonic('H');             // shortcut

        help_about = new JMenuItem("About");   // define help menu options
        help_about.setMnemonic('A');
        help_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This program just shows menu setup.");
            }
        });
        helpMenu.add(help_about);

        menuBar.add(helpMenu);                  // add help menu to menu bar

        setJMenuBar(menuBar);                   // put menu bar on application
    }



    public static void main(String[] args) {
        MenuDemo prog = new MenuDemo();
        prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prog.setSize(500, 400);
        prog.setVisible(true);
    }
}