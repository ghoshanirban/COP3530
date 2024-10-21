package tester;

import recursion.MergeSort;
import java.util.Random;

public class TestMergeSort {

	public static void main(String[] args) {
//		Integer[] A = {50, 40, 30, 20, 10};
//		MergeSort.sort(A);
//		for(Integer x : A)
//			System.out.print(x + " ");
//
//		System.out.println();
//
		Random r = new Random();
		ComparablePoint[] P = new ComparablePoint[10];

		for(int i = 0; i < 10; i++)
			P[i] = new ComparablePoint(r.nextInt(100),r.nextInt(100));

		for(ComparablePoint x : P)
			System.out.print(x + " ");

		System.out.println();

		MergeSort.sort(P);

		for(ComparablePoint x : P)
			System.out.print(x + " ");

		//String[] S = {"Jax","Atl","Artic","Beijing","London"};
//		String[] S = {"Alexandria","Alex","Alexandrib"};
//		for(String s : S)
//			System.out.print(s + " ");
//		System.out.println();
//
//		MergeSort.sort(S);
//		for(String s : S)
//			System.out.print(s + " ");

	}

}
