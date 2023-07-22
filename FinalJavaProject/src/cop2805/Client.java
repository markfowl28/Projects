package cop2805;

import java.net.*;
import java.io.*;
import java.nio.charset.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client {

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
			new BufferedReader(new InputStreamReader(System.in));
			try {
				//retrieves answer from the server
				String userString = fr.num1.getText();
				Socket connection = new Socket("127.0.0.1", 1236);
				InputStream input = connection.getInputStream();
				OutputStream output = connection.getOutputStream();
				
				output.write(userString.length());
				output.write(userString.getBytes());
				
				int n = input.read();
				byte[] data = new byte[n];
				input.read(data);
				
				String serverResponse = new String(data, StandardCharsets.UTF_8);
				fr.output.setText("Result: " + serverResponse);
				
				if(!connection.isClosed())
					connection.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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
			int frameWidth = 300;
			int frameHeight = 150;
			Dimension screenSize =
					Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds((int) screenSize.getWidth() - frameWidth, 0,
					frameWidth, frameHeight);
		}
	}
}
