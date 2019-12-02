
public class Harness {
	public static final int MAX_NUMBER_OF_USES = 25;
	private String make;
	private int modelNumber;
	private int timesUsed;
	private String lastSafetyCheckerName;
	private boolean onLoan;
	private String borrowerName;
	
	Harness(String harnessMake, int harnessModelNumber, int harnessTimesUsed, 
			           String harnessLastSafetyCheckerName, boolean harnessOnLoan, String harnessBorrowerName)
	{
		make = harnessMake;
		modelNumber = harnessModelNumber;
		timesUsed = harnessTimesUsed;
		lastSafetyCheckerName = harnessLastSafetyCheckerName;
		onLoan = harnessOnLoan;
		borrowerName = harnessBorrowerName;
	}
	
	Harness(String harnessMake, int harnessModelNumber, String harnessLastSafetyCheckerName)
	{
		make = harnessMake;
		modelNumber = harnessModelNumber;
		timesUsed = 0;
		lastSafetyCheckerName = harnessLastSafetyCheckerName;
		onLoan = false;
		borrowerName = "N/A";
	}
	
	String getMake()
	{
		return make;
	}
	
	int getModelNumber()
	{
		return modelNumber;
	}
	
	void CheckHarness(String harnessLastSafetyCheckerName)
	{
		if(!onLoan && harnessLastSafetyCheckerName != null)
		{
			timesUsed = 0;
			lastSafetyCheckerName = harnessLastSafetyCheckerName;
		}
	}
	
	boolean isHarnessOnLoan()
	{
		return onLoan;	
	}
	
	boolean canHarnessBeLoaned()
	{
		if(timesUsed < MAX_NUMBER_OF_USES)
		{
			return !onLoan;
		}
		return false;
	}
	
	void loanHarness(String harnessBorrowerName)
	{
		if(canHarnessBeLoaned())
		{
			borrowerName = harnessBorrowerName;
			onLoan = true;
		}
	}
	
	void returnHarness()
	{
		if(onLoan)
		{
			borrowerName = "N/A";
			onLoan = false;
			timesUsed += 1;
		}
	}
	
	public String toString()
	{
		String harnessString = "Make: " + make + "\nModel Number: " + modelNumber + "\nTimes used: " + 
	              timesUsed + "\nLast Safety Checker: " + lastSafetyCheckerName + "\nOn loan: " + onLoan + 
	                                                                            "\nBorrower: " + borrowerName;
		return harnessString;
	}

}
