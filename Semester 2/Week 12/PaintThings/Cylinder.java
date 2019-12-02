
public class Cylinder extends Shape {
	private double radius;
	private double height;
	Cylinder(String shapeName, double radius, double height)
	{
		super(shapeName);
		this.radius = radius;
		this.height = height;
	}
	
	public String toString()
    {
       return shapeName + " of radius " + radius + " and height " + height;
    }
	
	public double area()
	{
		return Math.PI * radius * radius * height;
	}

}
