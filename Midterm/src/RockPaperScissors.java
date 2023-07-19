/*
 * Mark Fowler
 * 3/9/22
 * MidTerm Exam
 * A program that plays rock-paper-scissors game using a randomly generated number of 0, 1, or 2. 
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors 
{
	public static void main(String[] args)
	{
		//Creates a scanner object
		Scanner input = new Scanner(System.in);
		
		//Variable established to enter game loop at least once
		int keepPlaying = 10;
		
		//Loop for game to continue until the users enters -1 to quit
		while (keepPlaying != -1) 
		{
		//Prompts the user to make a choice of rock, paper, or scissors
		System.out.println("Please select the following choices for Rock-Paper-Scissors:");
		System.out.println("Scissor (0), Rock (1), Paper (2)");
		
		//stores choice selected for rock, paper, or scissors
		int playerChoice = input.nextInt();
		
		//creates instance of random class
		Random rand = new Random();
		
		//Switch statement based on choice selected
		switch(playerChoice)
		{
		case 0:
			//Scissor choice
			//Creates random number from 0-2
			int computerChoice = rand.nextInt(2);
			
			//if else statements to show outcome
			if (computerChoice == 0)
			{
				System.out.println("The computer chose Scissors. You also chose Scissors. It's a draw.");
			}
			else if (computerChoice == 1)
			{
				System.out.println("The computer chose Rock. You chose Scissors. You've lost.");
			}
			else if (computerChoice == 2)
			{
				System.out.println("The computer chose Paper. You chose Scissors. You've won!");
			}
			break;
		case 1:
			//Rock choice
			//Creates random number from 0-2
			computerChoice = rand.nextInt(2);
					
			//if else statements to show outcome
			if (computerChoice == 0)
			{
				System.out.println("The computer chose Scissors. You chose Rock. You've won!");
			}
			else if (computerChoice == 1)
			{
				System.out.println("The computer chose Rock. You also chose Rock. It's a draw.");
			}
			else if (computerChoice == 2)
			{
				System.out.println("The computer chose Paper. You chose Rock. You've lost.");
			}	
			break;
		case 2:
			//Paper choice
			//Creates random number from 0-2
			computerChoice = rand.nextInt(2);
					
			//if else statements to show outcome
			if (computerChoice == 0)
			{
				System.out.println("The computer chose Scissors. You chose Paper. You've lost.");
			}
			else if (computerChoice == 1)
			{
				System.out.println("The computer chose Rock. You chose paper. You've won!");
			}
			else if (computerChoice == 2)
			{
				System.out.println("The computer chose Paper. You also chose paper. It's a draw.");
			}	
			break;
		default:
			//Invalid choice made
			System.out.println("Not a valid option. Please select again");
		}
		//Prompts user to select if they want to play again or loop breaks
		System.out.println("Play again? (Yes = 10, No = -1)");
		keepPlaying = input.nextInt();
		}
		System.out.println("Good Bye!");
		
		//Closes scanner object
		input.close();
	}
}
