/* Mark Fowler
 * Assignment 3
 * 2/11/22
 * A program that lets the user enter the loan amount and loan period in number of years 
and displays the monthly and total payments for each interest rate starting from 5% to 8% with 
an increment of 1/8.
*/

import java.util.Scanner;

public class Assignment3
{
	public static void main(String[] args)
	{
		//Creates a scanner object
		Scanner input = new Scanner(System.in);
		
		//asks user to input the loan amount and loan period
		System.out.println("Please enter the loan amount you're looking recieve: ");
		int loanAmount = input.nextInt();
		System.out.println("Please enter the number of years for the loan period: ");
		int numYears = input.nextInt();
		
		//establishes starting interest rate
		double rate = .05;
		
		//converts years to months
		int months = numYears * 12;
		
		System.out.println("Interest Rate   Monthly Payment   Total Payment");
		
		while(rate < .081) 
		{
			//formulas to calculate monthly payments and total payments
			double monthlyPay = (loanAmount * rate) / (1 - Math.pow(1.0 + rate, numYears * -12.0));
			double totalPay = monthlyPay * months;
			
			//outputs the rates, monthly payments, and total payments
			System.out.printf("%.3f%%          ",(rate * 100));
			System.out.printf("$%.2f           ", monthlyPay);
			System.out.printf("$%.2f", totalPay);
			System.out.println("");
			
			//increases interest rate by 1/8
			rate += .00125;
		}
		input.close();
	}
}
