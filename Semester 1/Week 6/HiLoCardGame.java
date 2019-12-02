import java.util.Random;
import java.util.Scanner;

public class HiLoCardGame {

	public static final int INCORRECT_GUESS = -1;
	public static final int CORRECT_GUESSES_NEEDED_TO_WIN = 4;
	public static final int ACE = 14;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	
	public static void main(String[] args) {
		Random cardGenerator = new Random();
		int nextCard = cardGenerator.nextInt(13) + 2;
		int correctGuesses = 0;
		String nextCardName;
		
		while (correctGuesses <= CORRECT_GUESSES_NEEDED_TO_WIN){
			if (nextCard == ACE)
				nextCardName = "Ace";
			else if (nextCard == KING)
				nextCardName = "King";
			else if (nextCard == QUEEN)
				nextCardName = "Queen";
			else if (nextCard == JACK)
				nextCardName = "Jack";
			else
				nextCardName = "" + nextCard;
			
			System.out.println("The card is a " + nextCardName);
			
			if (correctGuesses == INCORRECT_GUESS){
				System.out.println("You lose.");
				System.exit(0);
			}
			if (correctGuesses == CORRECT_GUESSES_NEEDED_TO_WIN){
				System.out.println("Congratulations. You got them all correct.");
				System.exit(0);
			}
			
			int previousCard = nextCard;
			nextCard = cardGenerator.nextInt(13) + 2;
			System.out.println("Do you think the next card will be higher, lower or equal?");
			Scanner inputScanner = new Scanner( System.in );
			if(nextCard > previousCard){
				if (inputScanner.hasNext("higher"))
					correctGuesses++;
				else
					correctGuesses = INCORRECT_GUESS;
			}
			else if(nextCard < previousCard){
				if (inputScanner.hasNext("lower"))
					correctGuesses++;
				else
					correctGuesses = INCORRECT_GUESS;
			}
			else if(nextCard == previousCard){
				if (inputScanner.hasNext("equal"))
					correctGuesses++;
				else
					correctGuesses = INCORRECT_GUESS;
			}
			
		}	
			
	}

}
