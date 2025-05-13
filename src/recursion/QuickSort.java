package recursion;

public class QuickSort {
    public static <K extends Comparable<K>> void sort(K[] S) {
        recurseAndSort(S, 0, S.length - 1);
    }

    private static <K extends Comparable<K>> void recurseAndSort(K[] S, int first, int last) {
        if (first < last) {
            int pivotIndex = partition(S, first, last); // partition and return the final index of the pivot
            recurseAndSort(S, first, pivotIndex - 1); // recursively sort the left portion
            recurseAndSort(S, pivotIndex + 1, last);  // recursively sort the right portion
        }
    }

    // a generic swap method
    private static <K extends Comparable<K>> void swapTheItemsAt(K[] S, int i, int j) {
        K hold = S[i];
        S[i] = S[j];
        S[j] = hold;
    }

    private static <K extends Comparable<K>> int partition(K[] S, int first, int last) {
        K pivot = S[first]; // select the first element as the pivot
        int up = first, down = last;

        do {
            while ((up < last) && (pivot.compareTo(S[up]) >= 0))
                up++;

            while (pivot.compareTo(S[down]) < 0)
                down--;

            if (up < down)
                swapTheItemsAt(S, up, down);

        } while (up < down);


        swapTheItemsAt(S, first, down);

        return down;
    }
}
