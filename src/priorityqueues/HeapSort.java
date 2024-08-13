package priorityqueues;

public class HeapSort {
    public static <K extends Comparable<K>> void sort(K[] S) {
        MinHeap<K> H = new MinHeap<>();

        // Create a min-heap from scratch using the elements of 'S'
        for(K item : S)
            H.insert(item);

        // Execute removeMin 'n' times to get a sorted sequence
        int pos = 0;
        while( !H.isEmpty() )
            S[pos++] = H.removeMin();
    }
}