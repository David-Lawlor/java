package layoutExamples;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutEx extends JFrame {
	private JButton left, right, center;

	public FlowLayoutEx() {
		super("FlowLayout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		left = new JButton("Left");
		right = new JButton("Right");
		center = new JButton("Center");

		this.add(left);
		this.add(center);
		this.add(right);

		this.setSize(300, 80);

	}

	public static void main(String[] args) {
		FlowLayoutEx f = new FlowLayoutEx();
		f.setVisible(true);
	}
}
