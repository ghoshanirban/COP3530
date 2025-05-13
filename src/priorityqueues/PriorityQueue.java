package priorityqueues;

public interface PriorityQueue<E extends Comparable<E>> {
	int size(); // returns the number elements currently stored
	boolean isEmpty(); // checks if the priority queue is empty
	E min(); // returns the minimum element present in the priority queue
	E removeMin(); // returns and removes the minimum element present in the priority queue
	void insert(E e); // inserts a new element into the priority queue
}
