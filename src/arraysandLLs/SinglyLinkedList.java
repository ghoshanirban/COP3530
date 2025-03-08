package arraysandLLs;

import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {
	//****************************************************//
	private static class Node<E> { // Nested node class
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
	//****************************************************//

	private Node<E> head = null, tail = null;
	private int size = 0; // stores the number of nodes currently stored

	// an empty constructor
	public SinglyLinkedList() { }

	// returns the number of nodes in the list
	public int size() {
		return size;
	}

	// determines whether the list is empty
	public boolean isEmpty() {
		return (size == 0);
	}

	// return the data stored inside the head node
	public E first() {
		if( isEmpty() )
			return null;

		return head.getElement();
	}

	// return the data stored inside the tail node
	public E last() {
		if( isEmpty() )
			return null;

		return tail.getElement();
	}

	// adds a new node at the beginning of the list
	public void addFirst(E e) {
		head = new Node<>(e, head); // creating a new node and updating the head to the new node

		if ( isEmpty() )
			tail = head;

		size++;
	}

	// adds a new node at the end of the list
	public void addLast(E e) {
		Node<E> newest = new Node<>(e,null);

		if( isEmpty() )
			head = newest;
		else
			tail.setNext(newest);

		tail = newest;
		size++;
	}

	// removes the head node
	public E removeFirst() {
		if( isEmpty() )
			return null;

		E answer = head.getElement();
		head = head.getNext();
		size--;

		if( size == 0 )
			tail = null;

		return answer;
	}

	// adds a new node after the node that contains 'predecessor' as the element
	public boolean addAfter(E predecessor, E incomingItem) {
		Node<E> current = head, newNode = new Node<>(incomingItem, null);

		// go to the node whose element == predecessor
		while( current != null && !current.getElement().equals(predecessor) )
			current = current.getNext();

		if( current == null ) // 'predecessor' is not present in the list
			return false; // unsuccessful insertion
		else if ( current == tail ){ // 'predecessor' is present in the tail
			tail.setNext(newNode);
			tail = newNode;
		}
		else { // 'predecessor' is present elsewhere (not in the tail)
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}

		size++;      // increment size (number of nodes) by 1
		return true; // successful insertion
	}

	public String toString() {
		StringBuilder str = new StringBuilder();

		Node<E> current = head;

		while( current != null ) {
			str.append( current.element.toString() );

			if( current.next != null )
				str.append(" -> ");

			current = current.next;
		}

		return str.toString();
	}

	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator<>(this);
	}

	public static class SinglyLinkedListIterator<E> implements Iterator<E> {
		private Node<E> current; // points to the node currently being considered during iteration

		// set current to the head of the list for iteration
		public SinglyLinkedListIterator(SinglyLinkedList<E> list)   {
			current = list.head;
		}

		// returns false if current has already past the tail
		public boolean hasNext()  {
			//System.out.println("Using hasNext()");
			return current != null;
		}

		// returns the data/element stored in the current node and
		// then sets current to the next node
		public E next() {
			//System.out.println("Using next()");
			E data  = current.getElement();
			current = current.getNext();
			return data;
		}
	}
}
