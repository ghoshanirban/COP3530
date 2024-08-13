package sets;

import stacksandqueues.LinkedStack;
import java.util.Iterator;

@SuppressWarnings("SuspiciousNameCombination") // for suppressing unnecessary variable name warnings
public class TreeSetRBTree<E extends Comparable<E>> implements SetADT<E>, Iterable<E> { // Since the remove method is missing, we are
                                                         // unable to implement the MapADT interface
    private static final boolean RED = false, BLACK = true;

    private static class Node<E> {
        final private E item;
        private Node<E> left, right, parent;
        private boolean color;
        public Node(E e) {
            item = e;
            left = right = parent = null;
            color = RED; // new incoming nodes are always colored RED
        }

        public String toString() {
            return item.toString();
        }
    }

    private Node<E> root; // the root node
    private int nodeCount = 0; // stores the number of nodes/records
    public TreeSetRBTree() { }

    //**********************************************************//
    // checks if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    //**********************************************************//
    private boolean isLeftChild( Node<E> node ) {
        return node.parent != null && node.parent.left == node;
    }

    private boolean isRightChild( Node<E> node ) {
        return node.parent != null && node.parent.right == node;
    }

    private Node<E> grandParent(Node<E> node ){
        return node.parent.parent;
    }

    private Node<E> uncle(Node<E> node ){
        if( node == null ) return null;
        return ( isLeftChild(node.parent) ) ? node.parent.parent.right : node.parent.parent.left;
    }

    // right rotates the subtree rooted at node 'y'; takes O(1) time
    private void rightRotateAt(Node<E> y) {
        Node<E> x = y.left;
        y.left = x.right;

        if( x.right != null )
            x.right.parent = y;

        x.parent = y.parent;

        if( y.parent == null ) root = x;
        else if( y == y.parent.right ) y.parent.right = x;
        else y.parent.left = x;

        x.right = y;
        y.parent = x;
    }

    // left rotates the subtree rooted at node 'x'; takes O(1) time
    private void leftRotateAt(Node<E> x) {
        Node<E> y = x.right;
        x.right = y.left;

        if( y.left != null )
            y.left.parent = x;

        y.parent = x.parent;

        if( x.parent == null )  root = y;
        else if( x == x.parent.left ) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // inserts a new record <key,value> in the tree and then fixes the tree using re-colorings and rotations
    public boolean add(E e) {
        if( e == null )   throw new IllegalArgumentException("Null items are not allowed.");

        Node<E> z = new Node<>(e); // node is RED right now

        if( isEmpty() ) {
            root = z;
            root.color = BLACK;
            nodeCount++;
            return true;
        }

        Node<E> current = root, parentOfCurrent;
        boolean isLeftChild;

        do {
            if (e.compareTo(current.item) == 0) // a record exists with key 'key; insertion failed
                return false;
            else if (e.compareTo(current.item) < 0) { // go to the left subtree and continue
                parentOfCurrent = current;
                current = current.left;
                isLeftChild = true;
            } else { // go the right subtree and continue
                parentOfCurrent = current;
                current = current.right;
                isLeftChild = false;
            }

        } while (current != null);

        // insert the new record as a left/right child
        z.parent = parentOfCurrent;
        if( isLeftChild )  parentOfCurrent.left  = z;
        else               parentOfCurrent.right = z;

        nodeCount++;

        // Fixing up the tree by climbing up
        // This part of the code has been inspired from the pseudocode presented in the
        // famous CLRS book 'Introduction to Algorithms' (no need to refer to it in COP 3530).
        while( z.parent != null && z.parent.color == RED ){
            Node<E> y = uncle(z);
            if( y != null && y.color == RED ){                          // Case 1
                // Note: Case 1 code is generalized and works both for Case 1a and 1b
                z.parent.color = BLACK;                                 // Case 1
                y.color = BLACK;                                        // Case 1
                grandParent(z).color = RED;                             // Case 1
                z = grandParent(z);                                     // Case 1
            }
            else { // y == null || y.color == BLACK
                if( isLeftChild(z.parent) && isRightChild(z) ) {
                    z = z.parent;                                                                   // Case 2
                    leftRotateAt(z);                                                                // Case 2
                }                                                                                   // Case 2
                else if ( isRightChild(z.parent) && isLeftChild(z) ) {                              // Case 2
                    z = z.parent;                                                                   // Case 2
                    rightRotateAt(z);                                                               // Case 2
                }

                // Note: if Case 2 is executed, Case 3 must be executed as well
                // However, Case 3 may get executed without Case 2 being executed
                z.parent.color = BLACK;                                                                       // Case 3
                grandParent(z).color = RED;                                                                   // Case 3
                if( isLeftChild(z.parent) ) rightRotateAt(grandParent(z));                                    // Case 3
                else leftRotateAt( grandParent(z) );                                                          // Case 3
            }
        }

        root.color = BLACK; // color the root BLACK
        return true;
    }

    public void addAll(SetADT<E> S) { // S = S union T
        for(var e : S)
            add(e);
    }

    public void removeAll(SetADT<E> S) {
        throw new IllegalStateException("Items cannot be removed since RB-Tree deletion is out of scope");
    }

    public boolean remove(E e) {
        throw new IllegalStateException("Items cannot be removed since RB-Tree deletion is out of scope");
    }

    //**********************************************************//
    // returns the number of records stored in the tree
    public int size() {
        return nodeCount;
    }
    //**********************************************************//
    // clears the binary search tree
    public void clear() {
        root = null; nodeCount = 0;
    }
    //**********************************************************//
    public boolean contains(E e) { // runs in O(log n) time since a RB-Tree is being used
        if( root == null )
            return false;

        Node<E> current = root;

        do {
            if (e.compareTo(current.item) == 0) // a record exists with key 'key
                return true;
            else if (e.compareTo(current.item) < 0) { // go to the left subtree and continue
                current = current.left;
            } else { // go the right subtree and continue
                current = current.right;
            }

        } while (current != null);

        return false;
    }

    public void addAll(TreeSetRBTree<E> T) { // S = S union T; runs in O(m log m) time since a RB-Tree is being used
        for( var e : T )
            add(e); // duplicates won't get added in the tree
    }

    public void retainAll(SetADT<E> T) { // S = S intersection T
        TreeSetRBTree<E> tempS = new TreeSetRBTree<>();

        for( var e : this )
            if( T.contains(e) )
                tempS.add(e);

        root = tempS.root;
        nodeCount = tempS.nodeCount;
    }

    /**************************************************/
    public Iterator<E> iterator() {
        return new TreeSetIterator<>(this);
    }

    public static class TreeSetIterator<E extends Comparable<E>> implements Iterator<E> {
        private Node<E> current;
        private final LinkedStack<Node<E>> stack = new LinkedStack<>();
        public TreeSetIterator(TreeSetRBTree<E> T)   {
            current = T.root;
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
            E data = current.item;
            current = current.right; // traverse its right subtree
            return data;
        }
    }
}
