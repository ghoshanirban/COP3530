package tester;

import priorityqueues.*;

public class TestHeap {

	public static void main(String[] args) {
//		MinHeap<String> H = new MinHeap<>();
//
//		H.insert("Alice");
//		H.insert("Bob");
//		H.insert("Melissa");
//		H.insert("Kate");
//		H.insert("Ryan");
//		H.insert("Jack");
//		H.insert("Rose");
//		H.insert("Oliver");
//		H.insert("William");
//		H.insert("James");
//		H.insert("Benjamin");
//		H.insert("Noah");

		MinHeap<Integer> H = new MinHeap<>();

		H.insert(70);
		H.insert(60);
		H.insert(50);
		H.insert(40);
		H.insert(30);
		H.insert(20);
		H.insert(10);


		for(var item : H )
			System.out.print(item + " ");

	}
}
