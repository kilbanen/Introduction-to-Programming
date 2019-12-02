import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		
		int inputCounter = 1;
		double previousAverage = 0;
		double previousVariance = 0;
		
		System.out.println("This program computes the average and variance of all numbers entered. \n Enter a number (or type 'exit'):");
		Scanner input = new Scanner(System.in);
		while(!input.hasNext("exit")) {
			if(input.hasNextDouble()) {
				double currentNumber = input.nextDouble();
				double currentAverage = previousAverage + (currentNumber - previousAverage) / inputCounter;
				double currentVariance = ((previousVariance * (inputCounter - 1)) + (currentNumber - previousAverage) * (currentNumber - currentAverage)) / inputCounter;
				
				System.out.println("So far the average is " + currentAverage + " and the variance is " + currentVariance + ". \n Enter another number (or type 'exit'):");
				
				previousAverage = currentAverage;
				previousVariance = currentVariance;
				inputCounter = inputCounter + 1;
			}
			else{
				System.out.println("Invalid input. Enter a number (or type 'exit'):");
			}
			input = new Scanner(System.in);
		}
		System.out.println("Goodbye.");
		input.close();
	}

}
