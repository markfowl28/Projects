import java.util.Scanner;
import java.util.Arrays;

public class Account 
{
	private static Scanner dataIn = new Scanner(System.in);

	public static double withdraw(double accounts[], int accountNum)
	{
		//prompts user to enter an amount to withdraw
		System.out.println("Enter an amount to withdraw:");
		double withdrawAmount = dataIn.nextDouble();
		
		//ensures withdraw amount does not exceed available funds
		if (withdrawAmount <= accounts[accountNum])
		{
			//subtracts from current balance
			accounts[accountNum] -= withdrawAmount;
			System.out.println("Success! Your new amount is: $" + accounts[accountNum]);
		}
		else
		{
			System.out.println("Insufficient funds! Cannot withdraw.");
		}
		//returns new balance
		return accounts[accountNum];
	}
	public static double deposit(double accounts[], int accountNum)
	{
		//prompts user to enter an amount to deposit
		System.out.println("Enter an amount to deposit:");
		double depositAmount = dataIn.nextDouble();
		
		//adds deposit to the current balance
		accounts[accountNum] += depositAmount;
		System.out.println("Success! Your new balance is: $" + accounts[accountNum]);
		
		//returns new balance
		return accounts[accountNum];
	}
	public static void main(String[] args)
	{
		//creates an array of 10 accounts that have $100.00 each
		double[] accounts = new double[10];
		Arrays.fill(accounts, 100.00);
		
		//starts loop
		boolean start = true;
		while(start)
		{
			//prompts user to enter their account number and stores it
			System.out.println("What is your account number?");
			int accountNum = dataIn.nextInt();
			
			//ensures account number is valid
			if(accountNum > 0 && accountNum < 11)
			{
				//ATM options for user to select from
				System.out.println("Welcome account holder " + accountNum + "!");
				System.out.println("ATM Options: (1) Balance  (2) Withdraw  (3) Deposit  (4) Exit");
				System.out.println("Please select transaction:");
				int choice = dataIn.nextInt();
				
				//Subtract 1 to match array number
				accountNum -= 1;
				
				while (choice != 4)
				{	
					//switch statement based on user selection
					switch(choice)
					{
					case 1:
						System.out.println("Your current account balance is $" + accounts[accountNum]);
						break;
					case 2:
						withdraw(accounts, accountNum);
						break;
					case 3:
						deposit(accounts, accountNum);
						break;
					case 4:
						break;
					default:
						System.out.println("Invalid option. Please try again.");
					}
					//loops until user selects 4 to exit
					System.out.println("ATM Options: (1) Balance  (2) Withdraw  (3) Deposit  (4) Exit");
					System.out.println("Please select transaction:");
					choice = dataIn.nextInt();
				}
				System.out.println("Sign off.");
				System.out.println("Thank you for using our ATM. Come back Soon!");
			}
			else
			{
				System.out.println("Invalid Account Number. Please try again.");
			}
		}
		dataIn.close();
	}
}
