package tester;

import stacksandqueues.ArrayQueue;
import introduction.Point;

public class TestArrayQueue {



	public static void main(String[] args) {





		ArrayQueue<Point> Q = new ArrayQueue<>(5);

		Q.enqueue(new Point(10.0,11.0));
		Q.enqueue(new Point(20.0,21.0));
		Q.enqueue(new Point(30.0,31.0));
		Q.enqueue(new Point(40.0,41.0));
		Q.enqueue(new Point(50.0,51.0));

		for (var point : Q )
			System.out.print( point + " ");
		
		System.out.println("\nQueue size: " + Q.size());

		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		Q.enqueue(new Point(60.0,61.0));

		for (var point : Q )
			System.out.print( point + " ");

		System.out.println("\nQueue size: " + Q.size());
		System.out.println(Q.first());
	}
}
