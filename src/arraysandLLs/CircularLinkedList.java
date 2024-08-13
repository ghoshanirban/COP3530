package arraysandLLs;

import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        final private E element; // stores data
        private Node<E> next; // points to the next node in the list

        public Node(E e, Node<E> refToTheNextNode) {
            element = e;
            next = refToTheNextNode;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> refToTheNextNode) {
            next = refToTheNextNode;
        }
    }

    private Node<E> tail = null; // we maintain just the tail; head is not needed in our implementation
    // Note that tail.getNext() will give us the head
    private int size = 0;

    public CircularLinkedList() { }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns the item stored inside the node right after the tail node (the virtual head)
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() { // returns the item stored inside the tail node
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void rotate() { // rotates the list (moves tail to the next node)
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) { // adds a node after the tail node
        Node<E> newest = new Node<>(e, null);

        if ( isEmpty() ) {
            tail = newest;
            tail.setNext(tail);
        } else {
            newest.setNext(tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(E e) {  // adds a node after the tail node but the tail is set to the new node
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() { // removes the node right after the tail node
        if (isEmpty())
            return null;

        Node<E> head = tail.getNext();

        if (head == tail)
            tail = null; // the list has just one node currently; delete it
        else
            tail.setNext(head.getNext()); // else, the next node of tail must be the next node of the head

        size--;
        return head.getElement();
    }

    public Iterator<E> iterator() {
        return new CircularLinkedListIterator<>(this);
    }

    public static class CircularLinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;
        private int elementsMetSoFar;
        private final CircularLinkedList<E> L;

        public CircularLinkedListIterator(CircularLinkedList<E> list) {
            L = list;
            if( L.tail != null )
                 current = L.tail.getNext(); // set current to head
            elementsMetSoFar = 0;
        }

        public boolean hasNext() {
            return elementsMetSoFar < L.size();
        }

        public E next() {
            E hold = current.getElement();
            current = current.getNext();
            elementsMetSoFar++;
            return hold;
        }
    }
}