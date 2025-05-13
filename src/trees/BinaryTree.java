package trees;

import stacksandqueues.LinkedStack;
import java.util.Iterator;

public class BinaryTree<E> implements Iterable<E>{
	private static class BinaryTreeNode<E> {
		final private E element;
		private BinaryTreeNode<E> left, right;
		
		public BinaryTreeNode(E e) {
			element = e;
			left = right = null;
		}
		
		public E getElement() { return element; }
		//public void setElement(E e) { element = e; }
		public BinaryTreeNode<E> getLeft() { return left; }
		public BinaryTreeNode<E> getRight() { return right; }
		public String toString() { return element.toString(); }
	}
	
	private BinaryTreeNode<E> root;
	
	public BinaryTree() { }
	public boolean isEmpty() { return root == null; }
	//========================================================
	public void printInOrder() {
		inOrder(root);
	}

	private void inOrder(BinaryTreeNode<E> n) {
		if( n == null )
			return;

		inOrder(n.getLeft());
		System.out.print(" " + n.getElement() + " " );
		inOrder(n.getRight());
	}
	//========================================================
	public void printPreOrder() {
		preOrder(root);
	}
		
	private void preOrder(BinaryTreeNode<E> n) {
		if( n == null )
			return;
		
		System.out.print(" " + n.getElement() + " " );
		preOrder(n.getLeft());
		preOrder(n.getRight());
	}
	//========================================================
	public void printPostOrder() {
		postOrder(root);
	}
		
	private void postOrder(BinaryTreeNode<E> n) {
		if( n == null )
			return;
		
		postOrder(n.getLeft());
		postOrder(n.getRight());
		System.out.print(" " + n.getElement() + " " );
	}
	//========================================================
	public void insert(E e, String path) {
		if( e == null || path == null )
			throw new IllegalArgumentException("Unable to create a node. Missing information.");

		if( isEmpty() && path.equals("root") ) {
			root = new BinaryTreeNode<>(e);
			return;
		}

		// check if the path string is made up of 0s and 1s only
		for( int pos = 0; pos < path.length(); pos++)
			if( path.charAt(pos) != '0' && path.charAt(pos) != '1')
				throw new IllegalArgumentException("Invalid path string!");
		
		BinaryTreeNode<E> current = root, newNode = new BinaryTreeNode<>(e);
		
		for( int pos = 0; pos < path.length() - 1; pos++ )
			current = (path.charAt(pos) == '0') ? current.left : current.right;
		
		if( path.charAt( path.length() - 1 ) == '0' ) {
			if( current.left != null )
				throw new IllegalArgumentException("Some other node already exists. Insertion failed");
			
			current.left = newNode;
		}
		else {
			if( current.right != null )
				throw new IllegalArgumentException("Some other node already exists. Insertion failed");
			
			current.right = newNode;
		}
	}
	//========================================================
	public int countNodes() {
		return countNodesRec(root);
	}

	private int countNodesRec(BinaryTreeNode<E> n) {
		if( n == null ) return 0;
		else return countNodesRec(n.left) + countNodesRec(n.right) + 1;
	}
	//========================================================
	public void printInOrderIterative() {
		BinaryTreeNode<E> current = root;
		LinkedStack<BinaryTreeNode<E>> stack = new LinkedStack<>();

		while( current != null || !stack.isEmpty() ) {
			while (current != null) { // keep on moving left and stop when stuck
				stack.push(current);
				current = current.left;
			}
			current = stack.pop(); // pop an item
			System.out.print(" " + current.getElement() + " " );
			current = current.right; //
		}
	}
	//========================================================

	public Iterator<E> iterator() {
		return new BinaryTreeIterator<>(this);
	}

	public static class BinaryTreeIterator<E> implements Iterator<E> {
		private BinaryTreeNode<E> current;
		private final LinkedStack<BinaryTreeNode<E>> stack = new LinkedStack<>();
		public BinaryTreeIterator(BinaryTree<E> T)   {
			current = T.root; // set current to the root
		}

		public boolean hasNext()  {
			return current != null || !stack.isEmpty();
		}

		public E next() {
			while (current !=  null) { // keep on moving left and stop when stuck
				stack.push(current);
				current = current.left;
			}
			current = stack.pop(); // pop an item
			E data = current.element;
			current = current.right; // traverse its right subtree
			return data;
		}
	}
}
