import java.util.Scanner;

public class HighScores {

	public static void main(String[] args) {
		try
		{
			System.out.println("How many scores do you want to maintain?");
			Scanner inputScanner = new Scanner(System.in);
			int numberOfScores = inputScanner.nextInt();
			int[] highScores = new int[numberOfScores];
			initialiseHighScores(highScores);
			do
			{
				System.out.println("\nEnter a new score");
				int newScore = inputScanner.nextInt();
				if (higherThan(highScores, newScore))
				{
					insertScore(highScores, newScore);
				}
				printHighScores(highScores);
			}
			while(highScores != null);
		}
		catch(java.util.InputMismatchException | java.lang.NegativeArraySizeException exception)
		{
			System.out.println("Invalid input.");
		}

	}
	
	public static void initialiseHighScores(int[] highScores)
	{
		if (highScores != null)
		{
			for (int index = 0; index < highScores.length; index++)
			{
				highScores[index] = 0;
			}
		}
	}
	
	public static void printHighScores(int[] highScores)
	{
		System.out.print("The high scores are ");
		for (int index = 0; index < highScores.length; index++)
		{
			if (highScores[index] != 0)
			{
			System.out.print(highScores[index] + ", ");
			}
		}
	}
	
	public static boolean higherThan(int[] highScores, int newScore)
	{
		for (int index = 0; index < highScores.length; index++)
		{
			if(newScore > highScores[index])
			{
				return true;
			}
		}
		return false;
	}
	
	public static void insertScore(int[] highScores, int newScore)
	{
		for (int index = 0; index < highScores.length; index++)
		{
			if (newScore > highScores[index])
			{
				int movedScore = highScores[index];
				highScores[index] = newScore;
				newScore = movedScore;
			}
		}
	}

}
