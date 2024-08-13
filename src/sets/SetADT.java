package sets;

import java.util.Iterator;

public interface SetADT<E> extends Iterable<E>{
    boolean contains(E e); // verifies if the element e is a member of the set
    boolean add(E e); // adds the element e to the set
    boolean remove(E e); // removes the element e from the set
    void addAll(SetADT<E> T); // updates the set to also include all elements of T that are not present in the set
    void removeAll(SetADT<E> T); // updates the set by removing any of its elements that also occur in T
    void retainAll(SetADT<E> T); // updates the set so that it only keeps those elements that are also elements of T

    void clear(); // clears the set
    int size(); // returns the size of the set
    boolean isEmpty(); // verifies if the set is empty

    Iterator<E> iterator(); // returns an iterator
}
