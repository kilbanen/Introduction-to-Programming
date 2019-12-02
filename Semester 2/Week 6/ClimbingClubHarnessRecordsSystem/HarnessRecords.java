import java.util.ArrayList;

public class HarnessRecords {
	private ArrayList<Harness> harnessList = new ArrayList<Harness>();
	
	HarnessRecords()
	{
		//harnessList = null;
	}
	
	HarnessRecords(ArrayList<ArrayList<Object>> harnessCharacteristics)
	{
		for(int index = 0; index < harnessCharacteristics.size(); index++)
		{
			String harnessMake = (String)harnessCharacteristics.get(index).get(0);
			int harnessModelNumber = (int)harnessCharacteristics.get(index).get(1);
			int harnessTimesUsed = (int)harnessCharacteristics.get(index).get(2);
			String harnessLastSafetyCheckerName = (String)harnessCharacteristics.get(index).get(3);
			boolean harnessOnLoan = (boolean)harnessCharacteristics.get(index).get(4);
			String harnessBorrowerName = (String)harnessCharacteristics.get(index).get(5);
			harnessList.add(index, new Harness(harnessMake, harnessModelNumber, harnessTimesUsed, 
			                       harnessLastSafetyCheckerName, harnessOnLoan, harnessBorrowerName));
		}
	}
	
	ArrayList<Harness> getHarnessList()
	{
		return harnessList;
	}
	
	boolean isEmpty()
	{
		if(harnessList == null)
		{
			return true;
		}
		return false;
	}
	
	void addHarness(String harnessMake, int harnessModelNumber, String harnessLastSafetyCheckerName)
	{
		harnessList.add(new Harness(harnessMake, harnessModelNumber, harnessLastSafetyCheckerName));
	}
	
	Harness findHarness(String harnessMake, int harnessModelNumber)
	{
		for(int index = 0; index < harnessList.size(); index++)
		{
			if(harnessList.get(index).getMake().equals(harnessMake) && harnessList.get(index).getModelNumber() == harnessModelNumber)
			{
				return harnessList.get(index);
			}
		}
		return null;
	}
	
	Harness checkHarness(String harnessLastSafetyCheckerName, String harnessMake, int harnessModelNumber)
	{
		Harness thisHarness = findHarness(harnessMake, harnessModelNumber);
		if(thisHarness != null && !thisHarness.isHarnessOnLoan())
		{
			thisHarness.CheckHarness(harnessLastSafetyCheckerName);
			return thisHarness;
		}
		return null;
	}
	
	Harness loanHarness(String harnessBorrowerName)
	{
		for(int index = 0; index < harnessList.size(); index++)
		{
			if(harnessList.get(index).canHarnessBeLoaned())
			{
				harnessList.get(index).loanHarness(harnessBorrowerName);
				return harnessList.get(index);
			}
		}
		return null;
	}
	
	Harness returnHarness(String harnessMake, int harnessModelNumber)
	{
		Harness thisHarness = findHarness(harnessMake, harnessModelNumber);
		if(thisHarness.isHarnessOnLoan())
		{
			thisHarness.returnHarness();
			return thisHarness;
		}
		return null;
	}
	
	Harness removeHarness(String harnessMake, int harnessModelNumber)
	{
		Harness thisHarness = findHarness(harnessMake, harnessModelNumber);
		if(thisHarness != null)
		{
			harnessList.remove(thisHarness);
			return thisHarness;
		}
		return null;
	}
}
