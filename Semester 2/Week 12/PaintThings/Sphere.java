
public class Sphere extends Shape{
	private double radius;
	Sphere(String shapeName, double radius)
	{
		super(shapeName);
		this.radius = radius;
	}
	
	public String toString()
    {
       return shapeName + " of radius " + radius;
    }
	
	public double area()
	{
		return 4 * Math.PI * radius * radius;
	}
}
