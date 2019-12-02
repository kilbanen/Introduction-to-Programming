
import java.util.Scanner;

public class WeightConversion {
	
	public static final int NUMBER_OF_POUNDS_IN_A_STONE = 14;
	public static final int NUMBER_OF_OUNCES_IN_A_POUND = 16;
	public static final double NUMBER_OF_KILOGRAMS_IN_AN_OUNCE = 0.02834952;

	public static void main(String[] args) {
		String quit = "quit";
		System.out.println("Enter the number of Stones, Pounds and Ounces separated by spaces (or enter quit):");
		Scanner inputScanner = new Scanner( System.in );
		do
		{
			inputScanner = new Scanner( System.in );
			int stones = inputScanner.nextInt();
			int pounds = inputScanner.nextInt();
			int ounces = inputScanner.nextInt();
			System.out.println(getFormattedWeightString(stones, pounds, ounces) + "is equal to " + convertToKilograms(stones, pounds, ounces) + "kg");
			System.out.println("Enter the number of Stones, Pounds and Ounces separated by spaces (or enter quit):");
		}
		while(inputScanner.next() != quit);
	}

	public static double convertToKilograms(int stones, int pounds, int ounces)
	{
		double kilograms = ((stones * NUMBER_OF_POUNDS_IN_A_STONE * NUMBER_OF_OUNCES_IN_A_POUND) + (pounds * NUMBER_OF_OUNCES_IN_A_POUND) + ounces)
															 * NUMBER_OF_KILOGRAMS_IN_AN_OUNCE;
		return kilograms;
	}
	
	public static String getFormattedWeightString(int stones, int pounds, int ounces)
	{
		String formattedStonesString = "";
		if (stones == 1)
		{
			formattedStonesString = " stone ";
		}
		else
		{
			formattedStonesString = " stones ";
		}
		
		String formattedPoundsString = "";
		if (pounds == 1)
		{
			formattedPoundsString = " pound ";
		}
		else
		{
			formattedPoundsString = " pounds ";
		}
		String formattedOuncesString = "";
		
		if (ounces == 1)
		{
			formattedOuncesString = " ounces ";
		}
		else
		{
			formattedOuncesString = " ounces ";
		}
		String formattedWeightString = stones + formattedStonesString + pounds + formattedPoundsString + ounces + formattedOuncesString;
		return formattedWeightString;
	}
	
}
