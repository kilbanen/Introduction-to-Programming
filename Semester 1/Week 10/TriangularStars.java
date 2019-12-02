public class TriangularStars {

	public static final int NONE_AVAILABLE = 0;
	public static final int INITIAL_VALUE = 1;
	public static void main(String[] args) {
	
		int number = NONE_AVAILABLE;
		int previousNumber = NONE_AVAILABLE;
		for (int index = INITIAL_VALUE; number >= previousNumber; index++)
		{
			previousNumber = number;
			number = determineTriangleNumber(index);
			if (isStarNumber(number))
			{
				System.out.println(number);
			}	
		}
	}
	
	public static int determineTriangleNumber(int index)
	{
		int triangleNumber = NONE_AVAILABLE;
		for (int adder = INITIAL_VALUE; adder <= index; adder++)
		{
			triangleNumber += adder;
		}
		return triangleNumber;
	}
	
	public static int determineStarNumber(int index)
	{
		int starNumber = (6 * index) * (index - 1) + 1;
		return starNumber;
	}
	
	public static boolean isStarNumber(int number)
	{
		int starNumber = NONE_AVAILABLE;
		for(int index = INITIAL_VALUE; starNumber < number; index++)
		{
			starNumber = determineStarNumber(index);
		}
		if (starNumber == number)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
