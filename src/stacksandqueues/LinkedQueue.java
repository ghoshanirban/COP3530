package stacksandqueues;

import arraysandLLs.SinglyLinkedList;

import java.util.Iterator;

public class LinkedQueue<E> implements QueueADT<E>, Iterable<E> {
	final private SinglyLinkedList<E> L = new SinglyLinkedList<>();

	// Head is the front, Tail is the back
	public void enqueue(E e) {
		L.addLast(e);
	}
	public E dequeue() {
		return L.removeFirst();
	}
	public int size() {
		return L.size();
	}
	public boolean isEmpty() {
		return L.isEmpty();
	}
	public E first() {
		return L.first();
	}
	public Iterator<E> iterator() { return L.iterator(); }
}
