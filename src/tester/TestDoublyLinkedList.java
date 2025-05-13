package tester;

import arraysandLLs.DoublyLinkedList;

import java.util.Iterator;

public class TestDoublyLinkedList {
	public static void main(String[] args)  {
		int myVar = 99;

		DoublyLinkedList<Character> myFirstDLL = new DoublyLinkedList<>();
		
//		for( Character c : myFirstDLL )
//			System.out.print(c + " ");
			
		myFirstDLL.addLast('X');
		myFirstDLL.addLast('A');
		myFirstDLL.addLast('K');
		myFirstDLL.addLast('P');
		myFirstDLL.addLast('C');

		for( var c : myFirstDLL )
			System.out.print(c + " ");

//		Iterator it = myFirstDLL.iterator();
//
//		while( it.hasNext() )
//			System.out.print( it.next() + " ");

//		System.out.println(myFirstDLL);
		
	//	System.out.println(myFirstDLL);
		
//		myFirstDLL.removeFirst();
//		System.out.println(myFirstDLL);	
//		
//		myFirstDLL.removeLast();
//		System.out.println(myFirstDLL);
//		
//		myFirstDLL.addFirst('O');
//		System.out.println(myFirstDLL);	
//		
//		myFirstDLL.addLast('Z');
//		System.out.println(myFirstDLL);	
	}
}
