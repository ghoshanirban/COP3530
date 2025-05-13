package tester;

import maps.TreeMapBST;
import java.util.*;

public class TestTreeMapBST {
	public static void main(String[] args) {
//		TreeMapBST<Integer,String> myBST = new TreeMapBST<>();
//
//		myBST.put(55, "Eric");
//		myBST.put(45, "Pat");
//		myBST.put(35, "Caroline");
//		myBST.put(50, "Tom");
//		myBST.put(46, "Ann");
//		myBST.put(52, "Jennifer");
//		myBST.put(54, "Peter");
//		myBST.put(56, "Melissa");
//
//		for(var record : myBST ) // we are actually doing an inorder traversal; so the records are retrieved in a sorted fashion based on keys
//			System.out.println(record.getKey() + ", " + record.getValue());
//
//		System.out.print("Height. " + myBST.height() + "\n");
//
//		ArrayList<Integer> keys = new ArrayList<>();
//		myBST.getAllKeys(keys);
//		for(var key : keys) // keys are output in sorted order using inorder traversal
//			System.out.print(key + " ");
//
//		System.out.println();
//
//		ArrayList<String> values = new ArrayList<>();
//		myBST.getAllValues(values); // values are not output in sorted order
//		for(var val : values)
//			System.out.print(val + " ");
//
//		System.out.print("\nInorder traversal. ");
//		myBST.printInOrder();
//		System.out.println();
//
//		myBST.remove(50);
//
//		System.out.print("Inorder traversal. ");
//		myBST.printInOrder();
//		System.out.println();

        // creating an English dictionary
		TreeMapBST<String,String> dictionary = new TreeMapBST<>();
		dictionary.put("perplexed","very puzzled");
		dictionary.put("ardent","enthusiastic or passionate");
		dictionary.put("aardvark","a mammal native to Africa");
		dictionary.put("flabbergasted","greatly surprised or astonished");

		System.out.print("Inorder traversal. ");
		dictionary.printInOrder();
//
//		//demonstrating binary search trees on randomly ordered datasets
//		int n = 10000;
//		ArrayList<Integer> A = new ArrayList<>(n);
//		for(int i = 0; i < n; i++)
//			A.add(i);
//
//		TreeMapBST<Integer,String> T = new TreeMapBST<>();
//		for(int i : A)
//			T.put(i,"junkString");
//		//System.out.println("\nHeight(T): " + T.height());
//
//		Collections.shuffle(A);
//		T.clear();
//
//		for(int i : A)
//			T.put(i,"junkString");
//		//System.out.println("\nHeight(T): " + T.height());

	}
}
