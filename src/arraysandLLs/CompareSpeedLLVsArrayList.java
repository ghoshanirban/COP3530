package arraysandLLs;

import java.util.*;

public class CompareSpeedLLVsArrayList {

	public static void main(String[] args) {
		Random generator = new Random();
	
		SinglyLinkedList<Integer> LL = new SinglyLinkedList<>();

		int n = 1000000;

		//==============================================================================//
		long startA = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			Integer randomInteger = generator.nextInt();
			LL.addLast(randomInteger);
		}
	    long timeTakenA = System.currentTimeMillis() - startA;
	    System.out.println("Time taken by SLL: " + timeTakenA + " ms" );
		//==============================================================================//



		//==============================================================================//
		ArrayList<Integer> AL = new ArrayList<>(); // COP3530ArrayList can also be used
		
		long startB = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			Integer randomInteger = generator.nextInt();
			AL.add(randomInteger);
		}
	    long timeTakenB = System.currentTimeMillis() - startB;
	    System.out.println("Time taken by AL: " + timeTakenB + " ms" );
		//==============================================================================//

	}
}
