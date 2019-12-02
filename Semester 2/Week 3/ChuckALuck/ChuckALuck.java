
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: I have correctly defined the ResolveBet method.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: My program tells the user how much cash they have and then asks them how much they would like to bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: My program will ask the user to input another number if the bet amount is too high.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: My program creates an array of three Dice objects, rolls them, and creates a diceTotal variable.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: My program determines the winnings by comparing the bet type with the faces for Triple and with the dice total for the other bet types.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: My program outputs the results and adds or subtracts the appropriate amount from the wallet.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: I created a method howMuchCash which asks the user how much cash they have and puts this cash into the wallet.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: My program loops until the user enters "Quit" or until the cash in the wallet is 0.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: I ask the user to enter any of the bet types, or "Quit".
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: My program calls resolveBet for each bet type entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: My program ends by telling the user how much money they had at the start and how much they have now.

 Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.Scanner;

public class ChuckALuck {

	public static void main(String[] args) {
		Wallet playerWallet = new Wallet();
		Scanner inputScanner = new Scanner( System.in );
		double playerCash = howMuchCash(playerWallet);
		while(playerWallet.check() > 0)
		{
			String betType = askBetType();
			if(quit)
			{
				endGame(playerCash, playerWallet);
			}
			resolveBet(betType, playerWallet);
			if(quit)
			{
				endGame(playerCash, playerWallet);
			}
		}
		endGame(playerCash, playerWallet);
	}
	
	public static void resolveBet(String betType, Wallet playerWallet)
	{
		double betAmount = askBetAmount(playerWallet);
		double betReturn = 0;
		Dice[] dice = {new Dice(), new Dice(), new Dice()};
		for(int index = 0; index < 3; index++)
		{
			dice[index].roll();
			System.out.println(dice[index].toString());
		}
		
		int diceTotal = dice[0].topFace() + dice[1].topFace() + dice[2].topFace();
		
		boolean isTriple = ((dice[0].topFace() == dice[1].topFace()) && (dice[0].topFace() == dice[2].topFace())
                && (dice[0].topFace() != 1) && (dice[0].topFace() != 6));
		
		boolean isField = diceTotal < 8 || diceTotal > 12;
		
		boolean isHigh = diceTotal > 10 && !isTriple;
		
		boolean isLow = diceTotal < 11 && !isTriple;
		
		
		boolean win = false;

		switch (betType)
		{
		case "Field":
			if (isField)
			{
				win = true;
				betReturn = betAmount;
			}
			break;
		case "High":
			if ((isHigh) && (isTriple = false))
			{
				win = true;
				betReturn = betAmount;
			}
			break;
		case "Low":
			if ((isLow) && (isTriple = false))
			{
				win = true;
				betReturn = betAmount;
			}
			break;
		case "Triple":
			if (isTriple)
			{
				win = true;
				betReturn = 30 * betAmount;
			}
			break;
		}
		
		if (win)
		{
			System.out.println("You win!");
			playerWallet.put(betReturn);
		}
		else
		{
			System.out.println("You lose.");
			playerWallet.get(betAmount);
		}
		
	
	}
	
	public static double howMuchCash(Wallet playerWallet)
	{
		System.out.println("How much money do you have?");
		Scanner inputScanner = new Scanner( System.in );
		if(inputScanner.hasNextDouble())
		{
			double playerCash = inputScanner.nextDouble();
			playerWallet.put(playerCash);
			return playerCash;
		}
		else if (inputScanner.hasNext("Quit"))
		{
			quit = true;
		}
		else
		{
			System.out.println("Invalid input.");
			return howMuchCash(playerWallet);
		}
		return 0;
	}
	
	public static String askBetType()
	{
		System.out.println("What type of bet would you like to place? (Triple, Field, High, Low, or type Quit to quit)");
		Scanner inputScanner = new Scanner( System.in );
		if((inputScanner.hasNext("Triple")) || (inputScanner.hasNext("Field")) || 
				               (inputScanner.hasNext("High")) || (inputScanner.hasNext("Low")))
		{
			String betType = inputScanner.next();
			return betType;
		}
		else if (inputScanner.hasNext("Quit"))
		{
			quit = true;
		}
		else
		{
			System.out.println("Invalid input.");
			askBetType();
		}
		return "";
	}
	
	public static double askBetAmount(Wallet playerWallet)
	{
		double betAmount;
		System.out.println("Cash in wallet: " + playerWallet.check());
		System.out.println("How much would you like to bet? (or type Quit to quit)");
		Scanner inputScanner = new Scanner ( System.in );
		if(inputScanner.hasNextDouble())
		{
			betAmount = inputScanner.nextDouble();
			if((betAmount > 0) && (betAmount <= playerWallet.check()))
			{
				return betAmount;
			}
			else
			{
				System.out.println("Invalid input.");
				return askBetAmount(playerWallet);
			}
		}
		else if (inputScanner.hasNext("Quit"))
		{
			quit = true;
		}
		else
		{
			System.out.println("Invalid input.");
			askBetAmount(playerWallet);
		}
		return 0;
	}
	
	public static void endGame(double playerCash, Wallet playerWallet)
	{
		System.out.println("Cash at start: " + playerCash + ", Current cash: " + playerWallet.check());
		System.exit(0);
	}
	
	public static boolean quit = false;

}
