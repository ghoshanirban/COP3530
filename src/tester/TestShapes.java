package tester;
import ood.*;

public class TestShapes {
	public static void main(String[] args) {
		
		Shape someRandomShape = new Shape();
		System.out.println(someRandomShape);

		System.out.println(someRandomShape instanceof Shape);

		Rectangle someRectangle = new Rectangle();
		System.out.println(someRectangle);
		System.out.println(someRectangle instanceof Shape);

		Square S = new Square(10.23);
		System.out.println(S);
		System.out.println(S instanceof Shape);

		Circle myCircle = new Circle(20.0, "Red", false);
		System.out.println(myCircle);
		System.out.println(myCircle instanceof Shape);

		Circle myCircle2 = new Circle(20.0, "Red", false);
		System.out.println(myCircle2.equals(myCircle));

		Rectangle R = new Square(2000.01);
		System.out.println(R.getDiagonalLength());
	}
}