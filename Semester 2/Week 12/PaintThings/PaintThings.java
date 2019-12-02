
public class PaintThings {

	public static void main(String[] args) {
		Paint paint = new Paint(350);
		Rectangle deck = new Rectangle("Rectangle", 35, 20);
		Sphere bigBall = new Sphere("Sphere", 15);
		Cylinder tank = new Cylinder("Cylinder", 10, 30);
		System.out.println("Computing amount for " + deck.toString());
		System.out.println("Amount of paint required is " + paint.amount(deck));
		System.out.println("Computing amount for " + bigBall.toString());
		System.out.println("Amount of paint required is " + paint.amount(bigBall));
		System.out.println("Computing amount for " + tank.toString());
		System.out.println("Amount of paint required is " + paint.amount(tank));

	}

}
