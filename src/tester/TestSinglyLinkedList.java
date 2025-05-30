package tester;

import arraysandLLs.*;
import introduction.Point;

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		// ============================================================= //
		SinglyLinkedList<Character> charSLL = new SinglyLinkedList<>();

		charSLL.addLast('X');
		charSLL.addLast('A');
		charSLL.addLast('K');
		charSLL.addLast('P');
		charSLL.addLast('C');

		//System.out.println(charSLL.removeFirst());

		//System.out.println(charSLL); // the toString method from SinglyLinkedList is invoked

//		for( var c : charSLL )
//			System.out.println(c);

		//charSLL.addAfter('K', 'T');

//		System.out.println(charSLL);
//
//		for( var item : charSLL ) // SinglyLinkedList is iterable; so for-each loop works!
//			System.out.print(item + " ");
//		// ============================================================= //
//		SinglyLinkedList<Point> pointLL = new SinglyLinkedList<>();
//
//		pointLL.addFirst(new Point(1.0,2.0));
//		pointLL.addFirst(new Point(99.18,-2.464));
//		pointLL.addLast(new Point(100.11, 0.0));
////
////		System.out.println(pointLL); // the toString method from SinglyLinkedList is invoked
////
////		pointLL.removeFirst();
////
////		System.out.println(pointLL);
////
//		for( var item : pointLL ) // SinglyLinkedList is iterable; so for-each loop works!
//			System.out.print(item + " ");
		// ============================================================= //
	}

}
