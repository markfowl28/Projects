package cop2805;

import java.net.*;
import java.io.*;
import java.nio.charset.*;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		boolean shutdown = false;

		try {
			server = new ServerSocket(1236);
			System.out.println("Port bound. Accepting connections");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		while(!shutdown) {
			Socket client = null;
			InputStream input = null;
			OutputStream output = null;

			try {
				client = server.accept();
				input = client.getInputStream();
				output = client.getOutputStream();

				int n = input.read();
				byte[] data = new byte[n];
				input.read(data);

				String clientInput = new String(data, StandardCharsets.UTF_8);
				
				// try/catch to ensure input is an integer 
				try {
					int numInput = Integer.parseInt(clientInput);
					
					// if/else statement to ensure input is a positive number
					if(numInput > 0) {
						int answer = FibbonacciCalc(numInput);
	
						String response = Integer.toString(answer);
	
						output.write(response.length());
						output.write(response.getBytes());
					}
					else {
						String error1 = ("Error...Please enter a positive number");
						
						output.write(error1.length());
						output.write(error1.getBytes());
					}
					
				} catch (NumberFormatException e) {
					String error2 = ("Error....Please enter a number");
	
					output.write(error2.length());
					output.write(error2.getBytes());
				}

			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	private static int FibbonacciCalc(int numInput) {
		int v1 = 0,
			v2 = 1,
			v3 = 0;

		for(int i = 2; i <= numInput; i++)
		{
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}

		return v3;
	}
}
