package priorityqueues;

import java.util.*;

public class MinHeap<E extends Comparable<E>> implements PriorityQueue<E>, Iterable<E> {
    final private ArrayList<E> A = new ArrayList<>(11); // 11 is chosen by Java for its library PQ implementation

    public MinHeap() { }

    public int size() {
        return A.size();
    }

    public boolean isEmpty() {
        return A.isEmpty();
    }

    public E min() {
        return (!A.isEmpty()) ? A.get(0) : null;
    }

    public void insert(E e) {

        A.add(e); // insert at the end

        int childIndex = A.size() - 1, // index of the new record
		parentIndex = (childIndex - 1) / 2;

        // move the new record up the heap to the suitable place
        while (parentIndex >= 0 && getCompareToResult(parentIndex, childIndex) > 0) {
            swapTheItemsAt(childIndex, parentIndex); // swap the parent and child since the parent is larger
            childIndex = parentIndex; // update child index
            parentIndex = (childIndex - 1) / 2; // update parent index
        }
    }

    // compare the keys of the records at indexA and indexB
    private int getCompareToResult(int indexA, int indexB) {
        return A.get(indexA).compareTo(A.get(indexB));
    }

    // swap the records at the indices indexA and indexB
    private void swapTheItemsAt(int indexA, int indexB) {
        E hold = A.get(indexA);
        A.set(indexA, A.get(indexB));
        A.set(indexB, hold);
    }

    public E removeMin() {

        if (isEmpty()) // if heap is empty, return null
            return null;

        E deletedItem = min(); // store the record to be deleted in a variable

        if (size() == 1) { // if the heap has exactly one record, then just remove it
            A.remove(0);
            return deletedItem;
        }

        A.set(0, A.remove(A.size() - 1)); // bring the last element to the front

        int parentIndex = 0;

        while (true) { // bring down the root record to its suitable spot
            int leftChildIndex = 2 * parentIndex + 1, rightChildIndex = leftChildIndex + 1, minChildIndex = leftChildIndex;

            // if a left child does not exist, done!
            if (leftChildIndex >= size()) break;

            // if a right child exists and the left child is bigger than the right child,
            // choose the right child
            if (rightChildIndex < size() && getCompareToResult(leftChildIndex, rightChildIndex) > 0)
                minChildIndex = rightChildIndex;

            // the parent is bigger than the smaller child
            if ( getCompareToResult(parentIndex, minChildIndex) > 0) {
                swapTheItemsAt(parentIndex, minChildIndex);
                parentIndex = minChildIndex;
            } else
                break;
        }

        return deletedItem;
    }

    public String toString() {
        return A.toString(); // ArrayList already has a pre-defined toString()
    }

    public Iterator<E> iterator() {
        return A.iterator();
    }
}
