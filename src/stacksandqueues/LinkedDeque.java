package stacksandqueues;

import arraysandLLs.DoublyLinkedList;
import java.util.Iterator;

public class LinkedDeque<E> implements DequeADT<E>, Iterable<E> {
    private final DoublyLinkedList<E> L = new DoublyLinkedList<>();

    public LinkedDeque() { }
    public int size() { return L.size(); }

    public boolean isEmpty() { return L.isEmpty(); }

    public E first() { return L.first(); }

    public E last() { return L.last(); }

    public void addFirst(E e) { L.addFirst(e); }

    public void addLast(E e) { L.addLast(e); }

    public E removeFirst() { return L.removeFirst(); }

    public E removeLast() { return L.removeLast(); }

    public Iterator<E> iterator() {
        return L.iterator();
    }
}
