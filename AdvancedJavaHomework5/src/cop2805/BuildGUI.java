package cop2805;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BuildGUI {

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}	
		});
	}

	static class MyButtonListener implements ActionListener {
		MyFrame fr;
		public MyButtonListener(MyFrame frame)
		{
			fr = frame;
		}

		public void actionPerformed(ActionEvent e) 
		{
			double result = 0;
			
			//converts input into type double
			Double num1 = Double.parseDouble(fr.num1.getText());
			Double num2 = Double.parseDouble(fr.num2.getText());
			
			//inserts selected item into a string value and uses if statements to find the corresponding calculation and outputs answer
			String selection = String.valueOf(fr.comboBox.getSelectedItem());
			if (selection == "Add") {
				result = num1 + num2;
			}
			else if (selection == "Subtract") {
				result = num1 - num2;
			}
			else if (selection == "Multiply") {
				result = num1 * num2;
			}
			else if (selection == "Divide") {
				result = num1 / num2;
			}
			fr.output.setText("Result: " + result);
		}
	}

	static class MyFrame extends JFrame {
		public JTextField num1;
		public JTextField num2;
		public JComboBox<String> comboBox;
		public JLabel output;

		public MyFrame() {
			super();
			init();
		}

		private void init() {
			num1 = new JTextField();
			num2 = new JTextField();
			output = new JLabel("Result: ");

			//creates combo box using an array of strings and defaults the starting box with nothing selected
			String[] selections = { "Add", "Subtract", "Multiply",
			"Divide" };
			comboBox = new JComboBox<String>(selections);
			comboBox.setSelectedIndex(-1);

			//creates a calculate button that reacts to user click
			JButton calculateBtn = new JButton("Calculate");
			calculateBtn.addActionListener(new MyButtonListener(this));

			//creates layout and look of UI
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Calculator");
			this.setLayout(new GridLayout(5, 2));
			this.add(new JLabel("Enter 1st number:"));
			this.add(num1);
			this.add(new JLabel("Enter 2nd number:"));
			this.add(num2);
			this.add(new JLabel());
			this.add(comboBox);
			this.add(new JLabel());
			this.add(calculateBtn);
			this.add(output);
			int frameWidth = 300;
			int frameHeight = 200;
			Dimension screenSize =
					Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds((int) screenSize.getWidth() - frameWidth, 0,
					frameWidth, frameHeight);
		}
	}
}
