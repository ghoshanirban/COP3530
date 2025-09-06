package analysis;

import java.util.*;

public class SpeedDemo {
	private static Character randomLetter() {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int randomIndex = (int)(Math.random() * 52);
		return letters.charAt(randomIndex);
	}
	
	public static String generateLongStringA(int length) {
		String password = "";
		
		for(int i = 0; i < length; i++)
        	password += randomLetter();
		
		return password;
	}
	
	public static String generateLongStringB(int length) {
		StringBuilder password = new StringBuilder();
		
		for(int i = 0; i < length; i++)
        	password.append( randomLetter() );
		
		return password.toString();
	}

	public static void compare(){
		int n = 100000000, k = 10000;
		Random r = new Random();
		int[] arr1 = new int[n], arr2 = new int[n];

		for(int i = 0; i < n; i++)
			arr1[i] = arr2[i] = r.nextInt(k);

		long start = System.currentTimeMillis();
		Arrays.sort(arr1);
		System.out.println("Time taken by Arrays.sort(): " + (System.currentTimeMillis() - start) + " ms" );

		start = System.currentTimeMillis();

		int[] count = new int[k];
		for(int i = 0; i < n; i++)
			count[arr2[i]]++;

		int pos = 0;
		for(int i = 0; i < k; i++)
			for(int j = 0; j < count[i]; j++)
				arr2[pos++] = i;

		System.out.println("Time taken by our approach: " + (System.currentTimeMillis() - start) + " ms" );
	}
	
	public static void main(String[] args) {
		  
//	    long startA = System.currentTimeMillis();
//	    generateLongStringA(1000000);
//	    long timeTakenA = System.currentTimeMillis() - startA;
//
//	    System.out.println("Time taken by A: " + timeTakenA + " ms" );
//
//	    long startB = System.currentTimeMillis();
//	    generateLongStringB(1000000);
//	    long timeTakenB = System.currentTimeMillis() - startB;
//
//	    System.out.println("Time taken by B: " + timeTakenB + " ms" );
//
//	    System.out.println("Speedup: " + (double)timeTakenA/timeTakenB);

		compare();
	}

}
