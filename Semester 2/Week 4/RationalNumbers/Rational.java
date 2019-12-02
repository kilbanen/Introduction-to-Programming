
public class Rational {
	int numerator;
	int denominator;
	
	Rational(int passedNumerator, int passedDenominator)
	{
		numerator = passedNumerator;
		denominator = passedDenominator;
	}
	
	Rational(int passedNumerator)
	{
		numerator = passedNumerator;
		denominator = 1;
	}
	
	public Rational add(Rational otherRational)
	{
		int sumNumerator = (numerator * otherRational.denominator) + (otherRational.numerator * denominator);
		int sumDenominator = denominator * otherRational.denominator;
		Rational sum = new Rational (sumNumerator, sumDenominator);
		return sum;
	}
	
	public Rational subtract(Rational otherRational)
	{
		int differenceNumerator = (numerator * otherRational.denominator) - (otherRational.numerator * denominator);
		int differenceDenominator = denominator * otherRational.denominator;
		Rational difference = new Rational (differenceNumerator, differenceDenominator);
		return difference;
	}
	
	public Rational multiply(Rational otherRational)
	{
		int productNumerator = numerator *otherRational.numerator;
		int productDenominator = denominator *otherRational.denominator;
		Rational product = new Rational(productNumerator, productDenominator);
		return product;
	}
	
	public Rational divide(Rational otherRational)
	{
		int quotientNumerator = numerator *otherRational.denominator;
		int quotientDenominator = denominator *otherRational.numerator;
		Rational quotient = new Rational(quotientNumerator, quotientDenominator);
		return quotient;
	}
	
	public boolean equals(Rational otherRational)
	{
		if(numerator * otherRational.denominator == otherRational.numerator * denominator)
		{
			return true;
		}
		return false;
	}
	
	public boolean isLessThan(Rational otherRational)
	{
		if(numerator * otherRational.denominator < otherRational.numerator * denominator)
		{
			return true;
		}
		return false;
	}
	
	public Rational simplify()
	{
		int simplifiedNumerator = numerator / greatestCommonDivisor(numerator, denominator);
		int simplifiedDenominator = denominator / greatestCommonDivisor(numerator, denominator);
		Rational simplifiedRational = new Rational(simplifiedNumerator, simplifiedDenominator);
		return simplifiedRational;
	}
	
	public int greatestCommonDivisor(int numberA, int numberB)
	{
		int greatestCommonDivisor = 1;
		for(int index = 2; index <= Math.abs(numberA); index++)
		{
			if(numberA % index == 0 && numberB % index == 0)
			{
				greatestCommonDivisor = index;
			}
		}
		return greatestCommonDivisor;
	}
	
	public String toString()
	{
		String rationalString = numerator + "/" + denominator;
		return rationalString;
	}

}
