/*Mark Fowler
 * 2/27/22
 * Assignment 4
 * Project designed to determine what lockers out of 100 are open after 100 students pass through.
 * Lockers are all closed from the start and are changed by each student depending on their number.
 * (ex. student 2 would change every other locker, student 3 would change every 3 lockers, ect.)
 */
import java.util.Arrays;

public class Assignment4 
{
	public static void main(String[] args)
	{
		//boolean array created for 100 lockers and all are set to false to equal closed
		boolean [] lockers = new boolean[100];
		Arrays.fill(lockers, false);
		
		//set number of students
		int students = 100;
		
		//Determines changes by looping each student and looping lockers by starting on the same locker number as the current student's number and increasing the lockers by the current student's number  
		for(int s = 0; s < students; s++)
		{
			for(int l = s; l < lockers.length; l += (s + 1))
			{
				lockers[l] = !lockers[l];
			}
		}
		
		//for loop to print out what lockers are open by finding each element in the array that's true
		for(int l = 0; l < lockers.length; l++)
		{
			if(lockers[l]) 
			{
				System.out.println("Locker " + (l + 1) + " is open");
			}
		}
	}
}
