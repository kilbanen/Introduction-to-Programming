
/* SELF ASSESSMENT  
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: I created an array of size (number) and initialised it.
Did I return the correct item?
Mark out of 5: 5
Comment: I returned the array. 
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: I made sure that he parameters are not null. One of them is a valid index to the
         array.
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: I looped through the array using the correct multiple.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: I crossed out correct items in the array that were not already crossed out.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I make calls to other methods?
Mark out of 5: 5
Comment: I made calls to the createSequence, crossOutHigherMultiples and sequenceToString 
         methods.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: I returned an array with all composite numbers crossed out.
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I ensured that the parameter is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment: I looped through the array to update the string with the appropriate form.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment: I used the correct method definition.
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: I ensured that the parameter is not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: I looped through the array to update the string with the appropriate form.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: I asked the user to input a positive number greater than or equal to 2, and I
          handled input errors.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: I made calls to the createSequence, sequenceToString, sieve, and
         nonCrossedOutSubseqToString methods.
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: I printed the output as shown in the question.
   7.  Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: My code is indented correctly.
Do my variable names make sense?
Mark out of 4: 4
Comments: My variable names make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: My names follow the coding standard.
      Total Mark out of 100 (Add all the previous marks): 100 
*/

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		try {
			System.out.println("Enter int >= 2:");
			Scanner inputScanner = new Scanner( System.in );
			int number = inputScanner.nextInt();
			if (number >= 2)
			{
				int[][] initialSequence = createSequence(number);
				String initialSequenceString = sequenceToString(initialSequence);
				System.out.println(initialSequenceString);
				int[][] sieve = sieve(number);
				String primeNumbers = nonCrossedOutSubseqToString(sieve);
				System.out.println(primeNumbers);
			}
			else
			{
				System.out.print("That is an invalid input.");
			}
		}
		catch( Exception inputMismatchException)
		{
			System.out.print("That is an invalid input.");
		}
	}

	public static int[][] createSequence(int number)
	{
		int[][] sequence = new int[number-1][2];
		for(int index = 0; index <= sequence.length - 1; index++)
		{
			sequence[index][0] = index + 2;
		}
		return sequence;
	}
	
	public static void crossOutHigherMultiples(int[][] sequence, int number)
	{
		if(sequence!= null)
		{
			int[][] crossedOutSequence = sequence;
			for(int index = (2 * number) - 2; index <= sequence.length-1; index += number)
			{
				crossedOutSequence[index][1] = 1;
				if((index == sequence.length-1)||(index == sequence.length-2))
				{
					crossedOutSequence[index][1] = 1;
				}
			}
		}
	}
	
	public static int[][] sieve(int number)
	{
		int[][] sequence = createSequence(number);
		String sequenceString = "";
		String oldSequenceString = sequenceString;
		for(int index = 0; index <= sequence.length-1; index++)
		{
			if(sequence[index][1] == 0)
			{
				crossOutHigherMultiples(sequence, index + 2);
				sequenceString = sequenceToString(sequence);
				if (sequenceString.length() != oldSequenceString.length())
				{
					System.out.println(sequenceString);
					oldSequenceString = sequenceString;
				}
			}
		}
		return sequence;
	}
	
	public static String sequenceToString(int[][] sequence)
	{
		String sequenceString = "";
		if (sequence != null)
		{
			String[] stringArray = new String[sequence.length];
			for (int index = 0; index <= sequence.length-1; index++)
			{
				if(sequence[index][1] == 0)
				{
					stringArray[index] = String.valueOf(sequence[index][0]) + ", ";
				}
				else if (sequence[index][1] == 1)
				{
					stringArray[index] = "[" + String.valueOf(sequence[index][0]) + "], ";
				}
			}
			for(int index = 0; index <= stringArray.length - 1; index++)
			{
				sequenceString += stringArray[index];
			}
		}
			return sequenceString;
	}
	
	public static String nonCrossedOutSubseqToString(int[][] sequence)
	{
		String sequenceString = "";
		if (sequence != null)
		{
			String[] stringArray = new String[sequence.length];
			for (int index = 0; index <= sequence.length-1; index++)
			{
				if(sequence[index][1] == 0)
				{
					stringArray[index] = String.valueOf(sequence[index][0]) + ", ";
				}
				if (sequence[index][1] == 1)
				{
					stringArray[index] = "[" + String.valueOf(sequence[index][0]) + "], ";
				}
			}
			for(int index = 0; index <= stringArray.length - 1; index++)
			{
				if (sequence[index][1] == 0)
				{
					sequenceString += stringArray[index];
				}
			}
		}
		return sequenceString;
	}
}
