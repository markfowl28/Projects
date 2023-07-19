package cop2805;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FibbonacciCalculator {

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
			int v1 = 0,
				v2 = 1,
				v3 = 0;
			
			//converts input into a whole number
			int num1 = Integer.parseInt(fr.num1.getText());
			
			//for loop to calculate fibbonacci sequence value
			for(int i = 2; i <= num1; i++)
			{
				v3 = v1 + v2;
				v1 = v2;
				v2 = v3;
			}
			
			fr.output.setText("Result: " + v3);
		}
	}

	static class MyFrame extends JFrame {
		public JTextField num1;
		public JLabel output;

		public MyFrame() {
			super();
			init();
		}

		private void init() {
			num1 = new JTextField();
			output = new JLabel("Result: ");

			//creates a calculate button that reacts to user click
			JButton calculateBtn = new JButton("Calculate");
			calculateBtn.addActionListener(new MyButtonListener(this));
			 BoxLayout boxLayout = new 	BoxLayout(this.getContentPane(),
					 BoxLayout.Y_AXIS);

			//creates layout and look of UI
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Fibbonacci Calculator");
			this.setLayout(boxLayout);
			this.add(new JLabel("Enter a number:"));
			this.add(num1);
			this.add(new JLabel());
			this.add(calculateBtn);
			this.add(output);
			int frameWidth = 250;
			int frameHeight = 150;
			Dimension screenSize =
					Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds((int) screenSize.getWidth() - frameWidth, 0,
					frameWidth, frameHeight);
		}
	}
}