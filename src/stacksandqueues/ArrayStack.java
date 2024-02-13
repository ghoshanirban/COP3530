package stacksandqueues;

import java.util.Iterator;

public class ArrayStack<E> implements StackADT<E>, Iterable<E>{
	final private E[] items; // the array used to store the stack items
	private int stackTop = -1; // stores the index of the top element

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity ) {
		items = (E[]) new Object[capacity];
	}
	
	public int size() {	return stackTop + 1; }
	
	public boolean isEmpty() { return stackTop == -1; }
	
	public void push(E e) throws IllegalStateException{
		if( size() == items.length )
			throw new IllegalStateException("Oops! stack is full!");
		items[++stackTop] = e;
	}
	
	public E pop() {
		if( isEmpty() )
			return null;
		
		E answer = items[stackTop];
		items[stackTop] = null;
		stackTop--;
		return answer;
	}
	public E top() {
		if( isEmpty() ) return null;
		return items[stackTop];
	}

	public Iterator<E> iterator() {
		return new ArrayStackIterator<>(this);
	}

	public static class ArrayStackIterator<E> implements Iterator<E> {
		int current = 0;
		ArrayStack<E> S;
		public ArrayStackIterator(ArrayStack<E> S) {
			this.S = S;
		}

		public boolean hasNext() {
			return current <= S.stackTop;
		}

		public E next() {
			E hold = S.items[current];
			current++;
			return hold;
		}
	}
}
