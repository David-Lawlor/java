package examplesPanels;

import javax.swing.*;
import java.awt.*;

public class JFrameWithPanels extends JFrame {
	private final int WIDTH = 350;
	private final int HEIGHT = 220;
	private JButton button1 = new JButton("One");
	private JButton button2 = new JButton("Two");
	private JButton button3 = new JButton("Three");

	public JFrameWithPanels() {
		super("JFrame with Panels");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);

		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();

		this.setLayout(new FlowLayout());

		this.add(pane1);
		this.add(pane2);

		pane1.add(button1);
		pane1.setBackground(Color.BLUE);

		pane2.add(button2);
		pane2.add(button3);
		pane2.setBackground(Color.PINK);

	}

	public static void main(String[] args) {
		JFrameWithPanels panel = new JFrameWithPanels();
		panel.setVisible(true);
	}
}
