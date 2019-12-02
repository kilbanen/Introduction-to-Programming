
public class SquareAges {
	
	public static final int CURRENT_YEAR = 2019;
	
	public static void main(String[] args) {
		
		int age;
		for (age = 0; age <= 123; age++)
		{
			int squareYear = age * age;
			int birthYear = squareYear - age;
			if ((CURRENT_YEAR - 123 <= birthYear) && (CURRENT_YEAR >= birthYear))
			{
			    System.out.println("A person aged " + age +" in the year " + squareYear);
			}
		}

	}

}
