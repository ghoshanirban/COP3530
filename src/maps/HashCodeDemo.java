package maps;

import introduction.Point;

public class HashCodeDemo {
	public static void main(String[] args) {
		String s1 = "UNF is FUN";
		String s2 = "UNF is   FUN";
		String s3 = "UNF iss FUN";

		System.out.println("s1.hashCode() = " + s1.hashCode() + " ");
		System.out.println("s2.hashCode() = " + s2.hashCode() + " ");
		System.out.println("s3.hashCode() = " + s3.hashCode());

		double d1 = -1234888888;
		System.out.print(Double.hashCode(d1) + " ");

		double d2 = 101.981;
		System.out.print(Double.hashCode(d2) + " ");

		double d3 = -101.981;
		System.out.print(Double.hashCode(d3) + " ");

		Point p = new Point(1.0,2.0);
		Point q = new Point(1.0,2.0);
		System.out.println(p.hashCode());
		System.out.println(q.hashCode());
	}
}
