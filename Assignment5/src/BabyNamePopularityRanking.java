import java.util.*;
import java.io.*;

/*Mark Fowler
 * 4/14/22
 * Program that allows user to enter a name, gender, and year and displays its popularity ranking
 */
public class BabyNamePopularityRanking {
	// Creates a scanner object
	private static Scanner dataIn = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// Prompts user to enter the year, gender, and name
		System.out.println("Enter the year:");
		int year = dataIn.nextInt();
		System.out.println("Enter the gender:");
		String gender = dataIn.next();
		System.out.println("Enter the name:");
		String name = dataIn.next();
		
		boolean found = false;

		try {
			BufferedReader bReader = new BufferedReader(new FileReader(
					"C:\\Users\\markf\\Documents\\Java Class\\BabyNames\\BabyNames\\Babynamesranking" + year + ".txt"));

			int rankCount = 0;
			String line = "";

			while ((line = bReader.readLine()) != null) {
				rankCount++;
				int posFound = line.indexOf(name);

				if (posFound > -1) {
					System.out.println(name + " is ranked #" + rankCount + " in year " + year);
					found = true;
				}
			}
			bReader.close();
		} finally {
			if (!found) {
				System.out.println("The name " + name + " was not found in year " + year);
			}
			dataIn.close();
		}
	}
}
