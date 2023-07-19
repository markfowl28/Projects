package cop2805;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadAndWrite {

	public static void main(String[] args) {
		List<Double> list = ReadFile("data.txt"); //calls method to read the file into a list
		Collections.sort(list); //sorts data from smallest to largest
		WriteFile(list, "data-sorted.txt"); //calls method to write sorted list into new file
	}

	static List<Double> ReadFile(String file) {
		List<Double> temp = new ArrayList<Double>(); //temporary list to hold data
		Path path = Paths.get(file); //opens file
		
		try {
			BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
			String line = br.readLine();
			
			//passes each line of data into the temporary list
			while (line != null) { 
				temp.add(Double.parseDouble(line));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp; //returns list 
	}
	
	static void WriteFile(List<Double> data, String file) {
		Path path = Paths.get(file);
		
		try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), 
					StandardOpenOption.CREATE); // creates new file if the file doesn't exist
				PrintWriter pw = new PrintWriter(bw)) {
				pw.println(data); //writes the data from the list into the new file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
