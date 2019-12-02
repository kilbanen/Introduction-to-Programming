
/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment: I declared a numerator variable and a denominator variable.

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: My program takes the numerator and the denominator as parameters and initialises the member variables. If the denominator is 0 I throw an arithmetic exception.

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: My program takes an integer as a parameter and sets the numerator to this value. The denominator is set to 1.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: My program takes a rational number and adds to it another rational number without overwriting either rational number.

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
Comment: My program takes a rational number and subtracts from it another rational number without overwriting either rational number.

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
Comment: My program takes a rational number and  multiplies it by another rational number without overwriting either rational number.

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
Comment: My program takes a rational number and divides it by another rational number without overwriting either rational number.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: My program takes a rational as a parameter and compares it to the reference object. I use multiplication to compare, and return a boolean value.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 8).
Comment: My program takes a rational as a parameter and compares it to the reference object. I use multiplication to compare, and return a boolean value.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: My program returns the simplified version of the reference rational.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: My program returns the greatest common divisor of the numerator and the denominator.

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment: My program returns a fraction representation of the number

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
Comment: My program does all of this.
*/

import java.util.Scanner;

public class RationalNumbers {

	public static void main(String[] args) {
		
		Rational firstRational = askForRational();
		Rational secondRational = askForRational();
		
		Rational rationalSum = firstRational.add(secondRational);
		Rational rationalDifference = firstRational.subtract(secondRational);
		Rational rationalProduct = firstRational.multiply(secondRational);
		Rational rationalQuotient = firstRational.divide(secondRational);
		
		System.out.println("Sum: " + firstRational.toString() + " + " + secondRational.toString()
		                                                 + " = " + rationalSum.simplify().toString());
		System.out.println("Difference: " + firstRational.toString() + " - " + secondRational.toString()
                                                  + " = " + rationalDifference.simplify().toString());
		System.out.println("Product: " + firstRational.toString() + " * " + secondRational.toString()
                                                     + " = " + rationalProduct.simplify().toString());
		System.out.println("Quotient: " + firstRational.toString() + " / " + secondRational.toString()
                                                    + " = " + rationalQuotient.simplify().toString());
		if(firstRational.isLessThan(secondRational))
		{
			System.out.println("Comparison: " + firstRational + " < " + secondRational);
		}
		else if(secondRational.isLessThan(firstRational))
		{
			System.out.println("Comparison: " + firstRational + " > " + secondRational);
		}
		else if (firstRational.equals(secondRational))
		{
			System.out.println("Comparison: " + firstRational + " = " + secondRational);
		}
		System.out.println("Simplified: " + firstRational.simplify() + " and " + secondRational.simplify());

	}
	
	public static Rational askForRational()
	{
		Rational newRational;
		System.out.println("Enter a rational number (numerator/denominator).");
		Scanner inputScanner = new Scanner( System.in );
		if(inputScanner.hasNext("-*\\d+/-*\\d+"))
		{
			String rationalString = inputScanner.nextLine();
			String[] rationalStringArray = rationalString.split("/");
			int numerator = Integer.parseInt(rationalStringArray[0]);
			if(rationalStringArray[1] != null)
			{
				int denominator = Integer.parseInt(rationalStringArray[1]);
				if(denominator == 0)
				{
					throw new ArithmeticException();
				}
				newRational = new Rational(numerator, denominator);
			}
			else
			{
				newRational = new Rational(numerator);
			}
		}
		else if (inputScanner.hasNextInt())
		{
			int firstNumerator = inputScanner.nextInt();
			newRational = new Rational(firstNumerator);
		}
		else
		{
			System.out.println("Invalid input.");
			return askForRational();
		}
		return newRational;
	}

}
