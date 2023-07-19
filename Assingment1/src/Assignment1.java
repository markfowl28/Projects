/* Mark Fowler
 * Assignment 1
 * 1/18/22
 * Project designed to take 3 numbers entered by a user and display the sum and average of them
 */
 
import java.util.Scanner;

public class Assignment1 
{
	public static void main(String[] args)
	{
		//Creates a scanner object
		Scanner input = new Scanner(System.in);
		
		//Asks user to input 3 numbers
		System.out.println("Please enter 1st number: ");
		int num1 = input.nextInt();
		System.out.println("Please enter 2nd number: ");
		int num2 = input.nextInt();
		System.out.println("Please enter 3rd number: ");
		int num3 = input.nextInt();
		
		//Calculates the sum and average of the numbers inputed
		int sum = num1 + num2 + num3;
		int average = sum / 3;
		
		//Displays the numbers entered with their sum and average
		System.out.println("The three numbers are: " + num1 + ", " + num2 + ", and " + num3);
		System.out.println("The sum of the numbers is: " + sum);
		System.out.println("The average of the numbers is: " + average);
		
		input.close();
	}
}
