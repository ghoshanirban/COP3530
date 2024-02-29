package tester;

import recursion.QuickSort;
import recursion.RandomizedQuickSort;

public class TestQuickSort {

	public static void main(String[] args) {
		Integer[] A = {50, 40, 30, 20, 10};
		QuickSort.sort(A);
		for(Integer x : A)
			System.out.print(x + " ");
		
		System.out.println();

		ComparablePoint[] P = {new ComparablePoint(2.0,1.5), new ComparablePoint(-1.0,0.0),
				               new ComparablePoint(4.0,7.0), new ComparablePoint(-5.0,20.0)};
		QuickSort.sort(P);
		for(ComparablePoint p : P)
			System.out.print(p + " ");
	}

}
