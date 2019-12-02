/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: All the member variables are private and I have a constant for the maximum number of uses for the harness. (8/8)

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: I initialise all the variables with the correct parameters and set other variables to suitable default values. (6/6)

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: My method resets the number of times the harness was used and sets the lastSafetyChecker member variable to the parameter value, assuming the instructors name is not null and the harness is not on loan. (5/5)

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: My method returns the value of the loan status variable and it has no parameters. (2/2)

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: My method has no parameters and returns true if the timesUsed variable is less than the maximum and if the harness is not on loan already. Otherwise it returns false. (4/4)

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: My method takes a borrower name as a parameter and uses the canHarnessBeLoaned method to check if the harness can be loaned. If the harness can be loaned, it updates the characteristics. (6/6)
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: My method has no parameters, checks if the harness is on loan, and if so, updates the characteristics. (5/5)

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: My method returns a String representation of all the Harness variables. (3/3)

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment: I declare the member variable as a private ArrayList of Harnesses. (3/3)

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment:In the first constructor, the harnessList is set to null. In the second constructor, I use the set of characteristics in the list to create Harness objects and I add these harnesses to the harnessList. (9/9)

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: I return true if the harnessList is null and false otherwise. (1/1)

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: My method takes a Harness object as a parameter and adds it to the harnessList. (5/5)

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: My method takes a make and model number as parameters. It checks if a harness with these properties exists. If it does, it returns the harness, otherwise returns null.(6/6)

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: My method takes an instructor name, a harness make and a harness model number. It uses the findHarness method to check if such a harness exists and then uses the checkHarness Harness method to update the characteristics of the harness. If the harness is not available the harness returns null. (6/6)

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: My method takes a borrower name as a parameter and uses canHarnessBeLoaned to look for an available harness. If an available harness is found it is loaned using the Harness method loanHarness, which updates the characteristics of the harness. If no harness is available, null is returned. (7/7)

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: My method takes a make and model number as parameters. It uses findHarness to check if a harness with those properties exists. If the harness is not null, it returns it using the Harness method returnHarness, otherwise it returns null. (7/7)

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: My method takes a make and model number as parameters. It checks for a harness with those properties and removes it from the collection. It returns the Harness if it is found, otherwise it returns null. (8/8)

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: My test class presents the user with the five options specified, and also the option to quit. It asks the user to type in which option they want to perform. (5/5)

*/


import java.util.Scanner;
import java.util.ArrayList;

public class ClimbingClubHarnessRecordsSystem {

	public static void main(String[] args) {
		HarnessRecords clubHarnessRecords = new HarnessRecords();
		askForInput(clubHarnessRecords);
		

	}
	
	public static String askForInput(HarnessRecords clubHarnessRecords)
	{
		for(int index = 0; index < clubHarnessRecords.getHarnessList().size(); index++)
		{
			System.out.println("Harness #" + (index + 1) + "\n" + 
		                                        clubHarnessRecords.getHarnessList().get(index).toString());
		}
		System.out.println("What would you like to do? (add, remove, check, loan, return or quit)");
		Scanner inputScanner = new Scanner( System.in );
		String response = inputScanner.nextLine();
		if(response.equals("add"))
		{
			
			String make = askForMake();
			int modelNumber = askForModelNumber();
			String lastSafetyCheckerName = askForInstructor();
			clubHarnessRecords.addHarness(make, modelNumber, lastSafetyCheckerName);
			return askForInput(clubHarnessRecords);
		}
		else if (response.equals("remove"))
		{
			String make = askForMake();
			int modelNumber = askForModelNumber();
			clubHarnessRecords.removeHarness(make, modelNumber);
			return askForInput(clubHarnessRecords);
		}
		else if (response.equals("check"))
		{
			String lastSafetyCheckerName = askForInstructor();
			String make = askForMake();
			int modelNumber = askForModelNumber();
			clubHarnessRecords.checkHarness(lastSafetyCheckerName, make, modelNumber);
			return askForInput(clubHarnessRecords);
		}
		else if(response.equals("loan"))
		{
			String borrowerName = askForBorrower();
			clubHarnessRecords.loanHarness(borrowerName);
			return askForInput(clubHarnessRecords);
		}
		else if (response.equals("return"))
		{
			String make = askForMake();
			int modelNumber = askForModelNumber();
			clubHarnessRecords.returnHarness(make, modelNumber);
			return askForInput(clubHarnessRecords);
		}
		else if (response.equals("quit"))
		{
			System.out.println("Goodbye.");
		}
		else
		{
			System.out.println("Invalid input.");
			return askForInput(clubHarnessRecords);
		}
		return "Goodybye.";
	}
	
	static String askForMake()
	{
		System.out.println("Please enter the make of the harness.");
		Scanner makeScanner = new Scanner( System.in );
		String scannedMake = makeScanner.nextLine();
		return scannedMake;
	}
	
	static int askForModelNumber()
	{
		System.out.println("Please enter the model number of the harness.");
		Scanner modelNumberScanner = new Scanner( System.in );
		if(modelNumberScanner.hasNextInt())
		{
			int scannedModelNumber = modelNumberScanner.nextInt();
			return scannedModelNumber;
		}
		System.out.println("Invalid input.");
		return askForModelNumber();
	}
	
	static String askForInstructor()
	{
		System.out.println("Please enter the name of the instructor who last checked the safety of the harness.");
		Scanner instructorScanner = new Scanner( System.in );
		String scannedInstructor = instructorScanner.nextLine();
		return scannedInstructor;
	}
	
	static String askForBorrower()
	{
		System.out.println("Please enter the make of club member who wants to borrow a harness.");
		Scanner borrowerScanner = new Scanner( System.in );
		String scannedBorrower = borrowerScanner.nextLine();
		return scannedBorrower;
	}

}
