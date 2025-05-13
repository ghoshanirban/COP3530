package recursion;

public class InsertionSort {
	public static  <K extends Comparable<K>> void sort(K[] a) {
		for (int i = 1; i < a.length; i++) {

			K current = a[i];
			int j = i;

			while (j > 0 && a[j - 1].compareTo(current) > 0) {
				a[j] = a[j - 1];
				j--;
			}

			a[j] = current;
		}
	}
}
