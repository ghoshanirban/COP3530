package tester;

import introduction.Point;
import stacksandqueues.LinkedQueue;

public class TestLinkedQueue {

	public static void main(String[] args) {
		LinkedQueue<Point> Q = new LinkedQueue<>();
		
		Q.enqueue(new Point(10.0,11.0));
		Q.enqueue(new Point(20.0,21.0));
		Q.enqueue(new Point(30.0,31.0));
		Q.enqueue(new Point(40.0,41.0));
		Q.enqueue(new Point(50.0,51.0));
		
		System.out.println(Q.size());
		
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		
		Q.enqueue(new Point(60.0,61.0));
		
		System.out.println(Q.size());
		System.out.println(Q.first());
	}
}
