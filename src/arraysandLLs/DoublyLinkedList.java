package arraysandLLs;

import java.util.*;

public class DoublyLinkedList<E> implements Iterable<E>{

	private static class Node<E> {
		final private E element;
		private Node<E> prev, next;

		public Node(E e, Node<E> prevNode, Node<E> nextNode) {
			element = e;
			prev = prevNode;
			next = nextNode;
		}

		public E getElement() { return element; }
		public Node<E> getPrev() { return prev; }
		public Node<E> getNext() { return next; }
		public void setPrev(Node<E> prevNode) { prev = prevNode; }
		public void setNext(Node<E> nextNode) { next = nextNode; }
	}

	private Node<E> head = null, tail = null;
	private int size = 0;

	public DoublyLinkedList() { }

	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }

	public E first() {
		if( isEmpty() )
			return null;

		return head.getElement();
	}

	public E last() {
		if( isEmpty() )
			return null;

		return tail.getElement();
	}

	// Since this is a private method, we cannot actually invoke this method on an object from a tester class
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {

		Node<E> newNode = new Node<>(e, predecessor, successor);

		if( predecessor != null ) // if predecessor exists
			predecessor.setNext(newNode);

		if( successor != null ) // if successor exists
			successor.setPrev(newNode);

		if( successor == head )
			head = newNode;

		if( predecessor == tail )
			tail = newNode;

		size++;
	}

	// Since this is a private method. So, we cannot
	// actually invoke this method on an object from a tester class
	private E remove(Node<E> node) {
		if( node == null )
			return null;

		E answer = node.getElement();
		Node<E> predecessor = node.getPrev(), successor = node.getNext();

		if( predecessor != null )
			predecessor.setNext(successor);

		if( successor != null)
			successor.setPrev(predecessor);

		if( node == head )
			head = successor;

		if( node == tail )
			tail = predecessor;

		size--;
		return answer;
	}

	public void addFirst(E e) {
		addBetween(e, null, head);
	}

	public void addLast(E e) { 
		addBetween(e, tail, null);
	}

	public E removeFirst() {
		return remove(head);
	}

	public E removeLast() {
		return remove(tail);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		Node<E> current = head;

		while(current != null) {
			str.append(current.element.toString());

			if(current.next != null)
				str.append(" <-> ");

			current = current.next;
		}
		return str.toString();
	}

	public String print() {
		return (printRecursive(head)).toString();
	}

	private StringBuilder printRecursive(Node<E> n) {
		if( n == null )
			return new StringBuilder();

		StringBuilder s = new StringBuilder(n.element.toString() + " ");
		s.append(printRecursive(n.next));
		return s;
	}
	
	// returns a new iterator; this method is declared inside the Iterable interface
	public Iterator<E> iterator() {
		return new DoublyLinkedListIterator<>(this);
	}
	
	public static class DoublyLinkedListIterator<E> implements Iterator<E> {
	    private Node<E> current; // points to the node currently being considered during iteration
	      
	    // set current to the head of the list for iteration 
	    public DoublyLinkedListIterator(DoublyLinkedList<E> list)   {
	    	current = list.head;
	    }
	      
	    // returns false if current has already past the tail
	    public boolean hasNext()  {
	    	return current != null;
	    }

		// returns the data/element stored in the current node and then set current to the next node
	    public E next() { 
	        E data  = current.getElement(); 
	        current = current.getNext(); 
	        return data; 
	    }

	}
}