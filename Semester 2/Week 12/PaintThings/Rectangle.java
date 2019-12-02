
public class Rectangle extends Shape{
	private double length;
	private double width;
	Rectangle(String shapeName, double length, double width)
	{
		super(shapeName);
		this.length = length;
		this.width = width;
	}
	
	public String toString()
    {
       return shapeName + " of length " + length + " and width " + width;
    }
	
	public double area()
	{
		return length * width;
	}

}
