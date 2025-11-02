package recursion;

import java.util.*;

public class SortingSpeedComparison {

	public static void main(String[] args) {
		int n = 13150;
		Random generator = new Random();

		Integer[] arr1 = new Integer[n], arr2 = new Integer[n], arr3 = new Integer[n], arr4 = new Integer[n],
				  arr5 = new Integer[n], arr6 = new Integer[n], arr7 = new Integer[n], arr8 = new Integer[n];

		for (int i = 0; i < n; i++)
			arr1[i] = arr2[i] = arr3[i] = arr4[i] = arr5[i] = arr6[i] = arr7[i] = arr8[i] = generator.nextInt();

		Arrays.sort(arr1); Arrays.sort(arr2); Arrays.sort(arr3); Arrays.sort(arr4);
		Arrays.sort(arr5); Arrays.sort(arr6); Arrays.sort(arr7); Arrays.sort(arr8);

		//long start = 0;

		long start = System.currentTimeMillis();
		QuickSort.sort(arr1);
		System.out.println("Time taken by QuickSort (O(n^2)): " + (System.currentTimeMillis() - start) + " ms");

//		long start = System.currentTimeMillis();
//		NonRecursiveQuickSort.sort(arr2);
//		System.out.println("Time taken by NonRecursiveQuickSort (O(n^2)): " + (System.currentTimeMillis() - start) + " ms" );
//
//		start = System.currentTimeMillis();
//		NonRecursiveRandomizedQuickSort.sort(arr3);
//		System.out.println("Time taken by NonRecursiveRandomizedQuickSort (O(n log n) behavior expected): " + (System.currentTimeMillis() - start) + " ms" );

//		start = System.currentTimeMillis();
//		MedOfThreeNonRecQuickSort.sort(arr4);
//	    System.out.println("Time taken by MedOfThreeNonRecQuickSort (O(n log n) behavior expected): " + (System.currentTimeMillis() - start) + " ms" );

		start = System.currentTimeMillis();
		MergeSort.sort(arr5);
		System.out.println("Time taken by MergeSort (O(n log n)): " + (System.currentTimeMillis() - start) + " ms");

//		start = System.currentTimeMillis();
//		Arrays.sort(arr6);
//		System.out.println("Time taken by Arrays.sort() (O(n log n)): " + (System.currentTimeMillis() - start) + " ms" );

//		start = System.currentTimeMillis();
//		Arrays.parallelSort(arr6);
//		System.out.println("Time taken by Arrays.parallelSort() (O(n log n)): " + (System.currentTimeMillis() - start) + " ms" );

		start = System.currentTimeMillis();
		InsertionSort.sort(arr7);
	    System.out.println("Time taken by InsertionSort (O(n^2)): " + (System.currentTimeMillis() - start) + " ms" );
	}
}
