package analysis;

import java.util.*;

public class PrefixAverage {
	
	public static double[] findPrefixAveragesA(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		
		for(int i = 0; i < n; i++) {
			double total = 0;
			for( int j = 0; j <= i; j++)
				total += x[j];
			a[i] = total/(i+1);
		}
		return a;
	}
	
	public static double[] findPrefixAveragesB(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		
		double total = 0;
		
		for(int i = 0; i < n; i++) {
			total += x[i];
			a[i] = total/(i+1);
		}
		
		return a;
	}

	public static void main(String[] args) {
		
//		double[] x = {10, 0, 1, 5, 99, 3};
//		System.out.println( Arrays.toString( findPrefixAveragesA(x)) );
//		System.out.println( Arrays.toString( findPrefixAveragesB(x)) );

		Random generator = new Random();
		int n = 100000;
		double[] testArray = new double[n];
		for( int i = 0; i < n; i++)
			testArray[i] = generator.nextInt(n);

		long startA = System.currentTimeMillis();
		var resultA = findPrefixAveragesA(testArray);
		long timeTakenA = System.currentTimeMillis() - startA;

		System.out.println("Time taken by approach A (runs in O(n^2) time): " + timeTakenA + " ms" );

		long startB = System.currentTimeMillis();
		var resultB = findPrefixAveragesB(testArray);
		long timeTakenB = System.currentTimeMillis() - startB;

		if( !Arrays.equals(resultA,resultB) )
			throw new RuntimeException("Issues detected with the implementations.");

		System.out.println("Time taken by approach B (runs in O(n) time): " + timeTakenB + " ms" );

		System.out.println("Speedup: " + (double)timeTakenA/timeTakenB);
	}
}
