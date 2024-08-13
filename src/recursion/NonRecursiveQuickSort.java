package recursion;

import stacksandqueues.*;

public class NonRecursiveQuickSort {
    public static <K extends Comparable<K>> void sort(K[] S) {
        record Pair(int leftIndex, int rightIndex) { } // A shorthand for defining a pair class

        LinkedStack<Pair> stack = new LinkedStack<>();
        stack.push(new Pair(0,S.length-1));

        while( !stack.isEmpty() ) {
            var currentPair = stack.pop();

            if( currentPair.leftIndex >= currentPair.rightIndex )
                continue;

            int pivotIndex = partition(S, currentPair.leftIndex, currentPair.rightIndex);
            stack.push(new Pair(currentPair.leftIndex, pivotIndex - 1));
            stack.push(new Pair(pivotIndex+1, currentPair.rightIndex));
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
