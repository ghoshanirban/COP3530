package maps;

import stacksandqueues.LinkedStack; // needed for the iterator
import java.util.*;
import java.util.AbstractMap.SimpleEntry; // a built-in record class in Java

@SuppressWarnings("unchecked")
public class TreeMapBST<K extends Comparable<K>, V> implements MapADT<K,V>, Iterable< SimpleEntry<K,V> > {
    private static class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> left, right;

        public Node(K k, V v) {
            key = k; val = v;
            left = right = null;
        }

        public String toString() {
            if (val != null) return key.toString() + ", " + val.toString();
            else return key.toString();
        }
    }

    private Node<K, V> root; // the root node
    private int nodeCount = 0; // stores the number of nodes/records
    public TreeMapBST() { } // an empty constructor

    public boolean isEmpty() {
        return root == null;
    }

    //**********************************************************//
    // returns the value part of the record whose key is 'key'
    public V get(K key) {
        if( key == null )
            throw new IllegalArgumentException("Null keys are not allowed.");

        Node<K,V> current = root;
        while( current != null) {
            if (key.compareTo(current.key) == 0) // a record exists with key 'key'; insertion failed
                return current.val;
            else if (key.compareTo(current.key) < 0)  // go to the left subtree
                current = current.left;
            else  // go the right subtree
                current = current.right;
        }
        return null; // record with key 'key' is not present, return null
    }
    //**********************************************************//
    // updates the value part of the record whose key is 'key' with a new value
    // returns the old value
    public V updateValue(K key, V newValue) {
        if( key == null )
            throw new IllegalArgumentException("Null keys are not allowed.");

        Node<K,V> current = root;
        while( current != null) {
            if (key.compareTo(current.key) == 0) {// a record exists with key 'key'; insertion failed
                V oldValue = current.val;
                current.val = newValue;
                return oldValue;
            }
            else if (key.compareTo(current.key) < 0)  // go to the left subtree
                current = current.left;
            else  // go the right subtree
                current = current.right;
        }
        return null; // signal failure; such a record does not exist in the tree
    }
    //**********************************************************//
    // puts a new record with key 'key' and value 'value' in the tree
    public boolean put(K key, V value) {
        if( key == null )   throw new IllegalArgumentException("Null keys are not allowed.");
        if( value == null ) throw new IllegalArgumentException("Null values are not allowed.");

        Node<K,V> newNode = new Node<>(key,value);

        if( isEmpty() ) {
            root = newNode;
            nodeCount++;
            return true;
        }

        Node<K,V> current = root, parentOfCurrent;
        boolean isLeftChild;

        do {
            if (key.compareTo(current.key) == 0) // a record exists with key 'key'; insertion failed
                return false;
            else if (key.compareTo(current.key) < 0) { // go to the left subtree and continue
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
        if( isLeftChild )  parentOfCurrent.left  = newNode;
        else               parentOfCurrent.right = newNode;
        nodeCount++;
        return true;
    }

    //**********************************************************//
    // finds and deletes the largest child (based on keys) of node 'n'; needed for Case 3 of deletion
    private Node<K, V> findAndDeleteLargestChild(Node<K, V> n) {
        Node<K,V> current = n;

        while( current.right.right != null ) // keep on moving right as long as we can
            current = current.right;

        Node<K, V> hold = current.right;
        current.right = current.right.left;
        return hold;
    }

    // returns a reference to the modified tree
    // returns null if the target key is not found
    public V remove(K key) {
        if( key == null )
            throw new IllegalArgumentException("Null keys are not allowed.");

        if( isEmpty() )
            return null;

        Node<K,V> current = root, parentOfCurrent = null;
        boolean isLeftChild = false;

        while ( current != null ) {
            if (key.compareTo(current.key) < 0) { // delete in the left subtree
                parentOfCurrent = current;
                current = current.left;
                isLeftChild = true;
            }
            else if (key.compareTo(current.key) > 0) { // delete in the right subtree
                parentOfCurrent = current;
                current = current.right;
                isLeftChild = false;
            }
            else { // found the desired record that has key 'key'
                V holdValue = current.val; // hold the value part before deleting the record; need to return it later

                // Case 1 + Case 2 (has only right child)
                if( current.left == null ) { // left subtree is nonexistent
                    if( parentOfCurrent == null ) // the desired record is found at the root
                        root = current.right;
                    else if( isLeftChild )  parentOfCurrent.left = current.right;
                    else                    parentOfCurrent.right = current.right;
                    return holdValue;
                }
                // Case 2 (has only left child)
                if( current.right == null ) { // right subtree is nonexistent
                    if( parentOfCurrent == null ) // the desired record is found at the root
                        root = current.left;
                    else if( isLeftChild )  parentOfCurrent.left = current.left;
                    else                    parentOfCurrent.right = current.left;
                    return holdValue;
                }
                // Case 3 (has both left and right children):
                // left child of 'current' does not have a right child; use Case 2 to delete
                if (current.left.right == null) { // move the content of its current's left child to current
                    current.key = current.left.key;
                    current.val = current.left.val;
                    current.left = current.left.left;
                }
                // Case 3 (has both left and right children):
                // left child of 'current' has a right child; delete using its inorder predecessor
                else {
                    Node<K, V> inorderPredecessor = findAndDeleteLargestChild(current.left); // also deletes!
                    // then, move the record inside the inorderPredecessor to Current
                    current.key = inorderPredecessor.key;
                    current.val = inorderPredecessor.val;
                }
                return holdValue;
            }
        }
        return null; // no record exists whose key is 'key' - return null in this case
    }
    //**********************************************************//
    // prints the inorder traversal sequence of the tree
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<K, V> n) {
        if (n == null)
            return;

        printInOrder(n.left);
        System.out.print("<" + n + "> ");
        printInOrder(n.right);
    }
    //**********************************************************//

    // returns the number of records stored in the tree
    public int size() { return nodeCount; }

    //**********************************************************//
    // puts the keys from all records in an arraylist
    public void getAllKeys(ArrayList<K> A) {
        getAllKeysRec(root,A);
    }

    private void getAllKeysRec(Node<K, V> n,ArrayList<K> A) {
        if (n == null)
            return;

        getAllKeysRec(n.left,A);
        A.add(n.key);
        getAllKeysRec(n.right,A);
    }

    //**********************************************************//
    // puts the values from all records in an arraylist
    public void getAllValues(ArrayList<V> A) {
        getAllValuesRec(root,A);
    }

    private void getAllValuesRec(Node<K, V> n,ArrayList<V> A) {
        if (n == null)
            return;

        getAllValuesRec(n.left,A);
        A.add(n.val);
        getAllValuesRec(n.right,A);
    }
    //**********************************************************//
    // clears the binary search tree
    public void clear() {
        root = null; nodeCount = 0;
    }
    //**********************************************************//
    // find height of the binary search tree
    public int height( ){ return heightRec(root); }
    private boolean isLeaf(Node<K,V> n) { return n.left == null && n.right == null; }
    private int heightRec(Node<K,V> n){
        if( n == null || isLeaf(n) )  return 0;
        else return 1 + Math.max( heightRec(n.left) , heightRec(n.right) );
    }
    //**********************************************************//
    public Iterator<SimpleEntry<K,V>> iterator() {
        return new TreeMapIterator<>(this);
    }

    public static class TreeMapIterator<K extends Comparable<K>, V> implements Iterator<SimpleEntry<K,V>> {
        private Node<K,V> current;
        private final LinkedStack<Node<?,?>> stack = new LinkedStack<>();
        public TreeMapIterator(TreeMapBST<?,?> T)   {
            current = (Node<K, V>) T.root;
        }

        public boolean hasNext()  {
            return current != null || !stack.isEmpty();
        }

        public SimpleEntry<K,V> next() {
            while (current !=  null) { // keep on moving left and stop when stuck
                stack.push(current);
                current = current.left;
            }
            current = (Node<K, V>) stack.pop(); // pop an item
            SimpleEntry<K,V> data = new SimpleEntry<>( current.key, current.val);
            current = current.right; // traverse its right subtree
            return data;
        }
    }
}
