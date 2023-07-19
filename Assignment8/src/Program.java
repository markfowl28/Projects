
/* Mark Fowler
 * 4/7/22
 * Menu driven program with 4 different options that perform various actions based on user input
 */

import java.io.*;
import java.util.Scanner;

public class Program 
{
	public static void EchoName(String name)
	{
		//prints out name entered 20 times
		for (int x = 0; x < 20; x++)
		{
			System.out.println(name);
		}
	}
	public static void DoubleAge(int age)
	{
		//prints out age entered and age doubled
		System.out.println("Your age is: " + age);
		System.out.println("Your age doubled is " + (age * 2));
	}
	public static void TeenagerTest(int age)
	{
		//prints out whether the age entered is in the range of a teenager
		if(age > 12 && age < 20)
		{
			System.out.println("Since you are " + age + " years old, you are a teenager");
		}
		else 
		{
			System.out.println("Since you are " + age + " years old, you are NOT a teenager");
		}
	}
	public static void TriangleMaker(int rows) throws IOException
	{
		//file object created
		File file = new File("triangle.txt");
		
		//file writer object created
		FileWriter fw = new FileWriter(file);
		
		//print writer object created
		PrintWriter pw = new PrintWriter(fw);
		
		//prints out a triangle based off the number of rows entered
		for (int i = 1; i < (2 * rows) + 1; i += 2)
		{
			for (int j = 0; j < (50 - i / 2); j++)
			{
				System.out.print(" ");
				pw.print(" ");
			}
			for (int k = 0; k < i; k++)
			{
				System.out.print("*");
				pw.print("*");
			}
			System.out.println("");
			pw.println("");
		}
		//flushes data to the file
		pw.close();
	}
	public static void main(String[] args) throws IOException
	{
		//Creates a scanner object
		Scanner input = new Scanner(System.in);
		
		//Creates base for age variable
		int age = 0;
		
		//loop starts until user selects 5 to exit
		boolean end = false;
		while(!end)
		{
			System.out.println("Please select from the following options:");
			System.out.println("Option: 1");
			System.out.println("Option: 2");
			System.out.println("Option: 3");
			System.out.println("Option: 4");
			System.out.println("Enter 5 to End Program");
			int choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Please enter your name:");
				String name = input.next();
				EchoName(name);
				break;
			case 2:
				System.out.println("Please enter your age:");
				age = input.nextInt();
				DoubleAge(age);
				break;
			case 3:
				//tests to see if user already entered their age in option 2
				if (age == 0)
				{
					System.out.println("Please enter your age:");
					age = input.nextInt();
				}
				TeenagerTest(age);
				break;
			case 4:
				System.out.println("Please select a single number from 3 to 50");
				int num = input.nextInt();
				
				//verifies if the user entered a number between 3 to 50 or loops them to re-enter it
				while (num < 3 || num > 50)
				{
					System.out.println("Sorry! That number isn't between 3 to 50. Please select again");
					System.out.println("Please select a single number from 3 to 50");
					num = input.nextInt();
				}
				TriangleMaker(num);
				break;
			case 5:
				//breaks loop
				end = !end;
				break;
			default:
				break;
			}
		}
		input.close();
	}
}
