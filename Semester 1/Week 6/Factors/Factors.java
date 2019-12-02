import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {
		System.out.println("Please enter a positive whole number:");
		Scanner inputScanner = new Scanner(System.in);
		int number = inputScanner.nextInt();
		int smallFactor;
		int bigFactor;
		int primeCounter = 0;
		
		System.out.print("The factors of " + number + " are ");
		for (smallFactor = 1; smallFactor <= Math.sqrt(number); smallFactor++){	
			if(number % smallFactor == 0){	
				bigFactor = number / smallFactor;
				System.out.print(smallFactor + "x" + bigFactor + ", ");
				primeCounter += 1;
			}	
		}
		if (primeCounter == 1)
			System.out.println("\n" + number + " is a prime number.");
		else
			System.out.println("\n" + number + " is a not prime number.");
		
	}

}
