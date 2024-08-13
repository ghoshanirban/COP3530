package recursion;

import stacksandqueues.ArrayStack;

import java.util.Random;

public class NonRecursiveRandomizedQuickSort {

    public static <K extends Comparable<K>> void sort(K[] S) {
        record Pair(int leftIndex, int rightIndex) { } // A shorthand for defining a pair class

        ArrayStack<Pair> stack = new ArrayStack<>(S.length);
        stack.push(new Pair(0,S.length-1));

        while( !stack.isEmpty() ) {
            var currentPair = stack.pop();

            if( currentPair.leftIndex >= currentPair.rightIndex )
                continue;

            int pivotIndex = partition(S, currentPair.leftIndex, currentPair.rightIndex);
            stack.push(new Pair(pivotIndex, currentPair.rightIndex));
            stack.push(new Pair(currentPair.leftIndex, pivotIndex - 1));
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
