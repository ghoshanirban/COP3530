package recursion;

import stacksandqueues.ArrayStack;

public class MedOfThreeNonRecQuickSort {

    private static  <K extends Comparable<K>> void insertionSort(K[] a, int first, int last) {
        for (int i = first+1; i <= last; i++) {

            K current = a[i];
            int j = i;

            while (j > first  && a[j - 1].compareTo(current) > 0) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = current;
        }
    }

    public static <K extends Comparable<K>> void sort(K[] S) {
        record Pair(int leftIndex, int rightIndex) { } // A shorthand for defining a pair class

        ArrayStack<Pair> stack = new ArrayStack<>(S.length);
        stack.push(new Pair(0,S.length-1));

        while( !stack.isEmpty() ) {
            var currentPair = stack.pop();

            if( currentPair.leftIndex >= currentPair.rightIndex )
                continue;

            int pivotIndex = partition(S, currentPair.leftIndex, currentPair.rightIndex);

            if( (currentPair.rightIndex - pivotIndex + 1) > 50)
                stack.push(new Pair(pivotIndex, currentPair.rightIndex));
            else
                insertionSort(S,pivotIndex,currentPair.rightIndex);

            if( (pivotIndex -  currentPair.leftIndex) > 50)
                stack.push(new Pair(currentPair.leftIndex, pivotIndex - 1));
            else
                insertionSort(S,currentPair.leftIndex,pivotIndex-1);
        }

    }

    private static <K extends Comparable<K>> void swapTheItemsAt(K[] S, int i, int j) {
        K hold = S[i];
        S[i] = S[j];
        S[j] = hold;
    }

    private static <K extends Comparable<K>> int partition(K[] S, int first, int last) {

        // using median of three heuristic
        int mid = (first + last)/2;
        if (S[last].compareTo( S[first] ) < 0)  swapTheItemsAt(S, first, last);
        if (S[mid].compareTo( S[first]) < 0)    swapTheItemsAt(S, mid, first);
        if (S[last].compareTo( S[mid]) < 0 )    swapTheItemsAt(S, last, mid);

        K pivot = S[mid]; // S[mid] is now the pivot since the median item is now present at S[mid]
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
            swapTheItemsAt(S, mid, up);

        return up;
    }

}
