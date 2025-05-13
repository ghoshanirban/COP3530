package recursion;

import java.util.*;

public class RandomizedQuickSort {
    public static <K extends Comparable<K>> void sort(K[] S) {
        recurseAndSort(S, 0, S.length - 1);
    }

    private static <K extends Comparable<K>> void recurseAndSort(K[] S, int first, int last) {
        if (first < last) {
            int pivotIndex = partition(S, first, last);
            recurseAndSort(S, first, pivotIndex - 1);
            recurseAndSort(S, pivotIndex , last);
        }
    }

    private static <K extends Comparable<K>> void swapTheItemsAt(K[] S, int i, int j) {
        K hold = S[i];
        S[i] = S[j];
        S[j] = hold;
    }

    private static <K extends Comparable<K>> int partition(K[] S, int first, int last) {
        Random generator = new Random();
        int pivotIndex =  generator.nextInt(first, last + 1);
        K pivot = S[pivotIndex];
        int up = first, down = last;

        do {
            while ((up < last) && (pivot.compareTo(S[up]) >= 0))
                up++;

            while (down >= 0 && pivot.compareTo(S[down]) <= 0 )
                down--;

            if (up < down)
                swapTheItemsAt(S, up, down);

        } while ( up < down );

        if (pivot.compareTo(S[up]) > 0)
            swapTheItemsAt(S, pivotIndex, up);

        return up;
    }
}

