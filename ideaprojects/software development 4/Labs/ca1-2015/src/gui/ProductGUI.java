package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import db.ProductOperations;

public class ProductGUI extends JFrame implements ActionListener {
    private JButton displayB;
    private JButton searchB, searchC;
    private JButton clearB;
    private JButton exitB;
    private JButton addB;

    private JPanel northPanel;
    private JPanel cPanel;
    private JPanel rPanel;
    private JPanel addPanel;
    private JPanel resultsPanel;
    private JPanel searchPanel;

    private ProductOperations po;
    private ResultSet rset;
    private JTextArea details;
    private JFrame f;
    private boolean displayarea = false;


    public ProductGUI(ProductOperations po) {
        this.po = po;
        f = new JFrame();
        f.setTitle("PC Worldwide");
        f.setLayout(new BorderLayout());
        f.setSize(700, 400);
        f.setResizable(false);
        f.setLocationRelativeTo(null);


        northPanel = new JPanel();
        Icon tvIcon = new ImageIcon("imgs/tv.jpg");
        JLabel northLabel = new JLabel(" For All Your Computer Needs", tvIcon,
                SwingConstants.CENTER);
        northLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        northPanel.setBackground(Color.white);
        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        northPanel.add(northLabel);
        f.add(northPanel, BorderLayout.NORTH);

        // Choices Panel on left hand side of main screen
        cPanel = new JPanel();
        cPanel.setSize(350, 100);
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
        cPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));

        displayB = new JButton("Display Products");
        displayB.addActionListener(this);
        cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        displayB.setMaximumSize(new Dimension(250, 25));
        cPanel.add(displayB);

        searchB = new JButton("Search for Product by Brand");
        searchB.addActionListener(this);
        cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        searchB.setMaximumSize(new Dimension(250, 25));
        cPanel.add(searchB);

        searchC = new JButton("Search for Product by Category");
        searchC.addActionListener(this);
        cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        searchC.setMaximumSize(new Dimension(250, 25));
        cPanel.add(searchC);

        addB = new JButton("Add a new Product");
        addB.addActionListener(this);
        cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        addB.setMaximumSize(new Dimension(250, 25));
        cPanel.add(addB);

        cPanel.setBackground(Color.white);
        cPanel.setMaximumSize(new Dimension(300, 50));
        setSize(350, 100);

        cPanel.setBackground(Color.white);

        f.add(cPanel, BorderLayout.WEST);

        JPanel blankPanel = new JPanel();
        f.add(blankPanel, BorderLayout.CENTER);
        blankPanel.setBackground(Color.white);

        f.setBackground(Color.white);
        f.setVisible(true);
    }

    public JPanel addresultsPanel() {
        // Results Panel
        rPanel = new JPanel();
        rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.PAGE_AXIS));

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched,
                "Results Window");
        rPanel.setBorder(titled);

        details = new JTextArea(4, 30);
        JScrollPane scrollPane = new JScrollPane(details);
        scrollPane
                .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rPanel.add(scrollPane);

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        clearB = new JButton("Clear");
        clearB.addActionListener(this);
        buttonPanel.add(clearB);
        buttonPanel.setBackground(Color.white);

        exitB = new JButton("Exit");
        exitB.addActionListener(this);
        buttonPanel.add(exitB);
        buttonPanel.setBackground(Color.white);

        rPanel.add(buttonPanel);
        rPanel.setBackground(Color.white);
        return rPanel;

    }

    public String getStringResults(ResultSet rset) {
        String r = "";

        try {
            while (rset.next()) {
                r += (rset.getInt(1) +"  " + rset.getString(2)+" "+rset.getString(3)+" "+rset.getDouble(4) +" "+
                        +rset.getInt(5) +" " + rset.getString(6)+" "+rset.getString(7)+"\n");
            }
        } catch (SQLException qe) {
            System.out.println("SQL Exception - query did not work");
        }

        return r;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exitB)) {
            po.closeDB();
            System.exit(0);
        } else if (e.getSource().equals(clearB)) {
            details.setText("");
        } else if (e.getSource().equals(displayB)) {
            if (displayarea) {
                f.remove(resultsPanel);
              }

                resultsPanel = addresultsPanel();
                f.add(resultsPanel, BorderLayout.CENTER);
                f.setVisible(true);

                displayarea = true;

			/*Insert code for Exercise 1 here*/
            String results1 = "";
            try {
                rset = po.getProducts();
                while (rset.next()) {
                    results1 += (rset.getInt(1) + "\t"
                            + rset.getString(2) + "\t"
                            + rset.getString(3) + "\t"
                            + rset.getDouble(4) + "\t"
                            + + rset.getInt(5) + "\t"
                            + rset.getString(6) + "\t"
                            + rset.getString(7) + "\t"
                            + "\n");
                }
            }catch(SQLException sqlE){
                System.out.println(sqlE);
            }
            details.setText(results1);





            } else if (e.getSource().equals(searchB)) {
                SearchbyBrandGUI sa = new SearchbyBrandGUI(po);

                if (displayarea) {
                    f.remove(resultsPanel);
                }
                resultsPanel = sa.addSearchBrandPanel();
                f.add(resultsPanel, BorderLayout.CENTER);
                f.setVisible(true);
                displayarea = true;


            } else if (e.getSource().equals(searchC)) {
                SearchbyCategoryGUI sc = new SearchbyCategoryGUI(po);

                if (displayarea) {
                    f.remove(resultsPanel);
                }
                resultsPanel = sc.addSearchCatPanel();
                f.add(resultsPanel, BorderLayout.CENTER);
                f.setVisible(true);

                displayarea = true;
            } else if (e.getSource().equals(addB)) {
                addProductGUI ag = new addProductGUI(po);

                if (displayarea) {
                    f.remove(resultsPanel);
                }
                resultsPanel = ag.addPlaceAdPanel();
                f.add(resultsPanel, BorderLayout.CENTER);
                f.setVisible(true);
				displayarea = true;
            }
        }
    }

