package stacksandqueues;

import arraysandLLs.SinglyLinkedList;
import java.util.Iterator;

public class LinkedStack<E> implements StackADT<E>, Iterable<E> {

	final private SinglyLinkedList<E> L = new SinglyLinkedList<>();

	public int size() { return L.size(); }
	public boolean isEmpty() { return L.isEmpty(); }
	public void push(E e) { L.addFirst(e); }
	public E pop() { return L.removeFirst(); }
	public E top() { return L.first(); }

	public Iterator<E> iterator() { return L.iterator(); }
}
