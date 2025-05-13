package sets;

import java.util.*;

@SuppressWarnings("unchecked")
public class HashSetSeparateChaining<E> implements SetADT<E>, Iterable<E>  {
    final double desiredLoadFactor = 0.75; // Java chose this number in their implementation
    final private int initialNumberOfBuckets = 16; // Java chose this number in their implementation

    //****************************************************//
    private static class SinglyLinkedList<E> implements Iterable<E> {
        protected static class Node<E> {
            final private E item;
            private Node<E> next;

            public Node(E e, Node<E> refToTheNextNode) {
                item = e;
                next = refToTheNextNode;
            }
        }
        protected Node<E> head = null, tail = null;
        protected int size = 0;

        public SinglyLinkedList() { }

        public boolean isEmpty() { return (size == 0); }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e,null);
            if( isEmpty() ) head = newest;
            else tail.next = newest;
            tail = newest;
            size++;
        }

        public boolean remove(E e) {
            Node<E> current = head, prev = null;

            while(current != null) {
                if(current.item.equals(e)) {
                    if( prev == null ) head = current.next;
                    else prev.next = current.next;
                    return true;
                }
                prev = current;
                current = current.next;
            }

            return false;
        }


        public Iterator<E> iterator() { return new SinglyLinkedList.SinglyLinkedListIterator<>(this); }

        public static class SinglyLinkedListIterator<E> implements Iterator<E> {
            private Node<E> current;
            public SinglyLinkedListIterator(SinglyLinkedList<?> L)   {
                current = (SinglyLinkedList.Node<E>) L.head;
            }

            public boolean hasNext()  { return current != null; }

            public E next() {
                E data  = current.item;
                current = current.next;
                return data;
            }
        }

        public String toString() {
            StringBuilder str = new StringBuilder();
            var current = head;
            while( current != null ) {
                str.append( current.item );
                if( current.next != null ) str.append(" -> ");
                current = current.next;
            }
            return str.toString();
        }
    }
    //****************************************************//
    SinglyLinkedList<E>[] buckets;
    int numberOfRecordsPresent = 0;

    public HashSetSeparateChaining() {
        buckets = (SinglyLinkedList<E>[]) new SinglyLinkedList[initialNumberOfBuckets];
        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new SinglyLinkedList<>();
    }

    public double loadFactor() {
        return numberOfRecordsPresent / (double)buckets.length;
    }

    private int compressionFunction( int x, int N ) {
        return ( Math.abs(x) % N );
    }

    public boolean add(E e){
        if(e == null)   throw new IllegalArgumentException("Item cannot be null.");

        int hashCode = e.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);

        for( var item : buckets[bucketIndex])
            if( item.equals(e) )
                return false;

        buckets[ bucketIndex ].addLast(e);
        numberOfRecordsPresent++;

        if( loadFactor() > desiredLoadFactor )
            rehash();

        return true;
    }

    private void rehash(){
        var newBuckets = (SinglyLinkedList<E>[]) new SinglyLinkedList[buckets.length * 2];
        for(int i = 0; i < newBuckets.length; i++)
            newBuckets[i] = new SinglyLinkedList<>();

        for (SinglyLinkedList<E> L : buckets)
            for (var item : L) {
                int hashCode = item.hashCode();
                newBuckets[compressionFunction(hashCode, newBuckets.length)].addLast(item);
            }
        buckets = newBuckets;
    }

    public boolean remove(E e) {
        int hashCode = e.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        return buckets[bucketIndex].remove(e);
    }

    public int size() {
        return numberOfRecordsPresent;
    }

    public void clear() {
        buckets = (SinglyLinkedList<E>[]) new SinglyLinkedList[initialNumberOfBuckets];
        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new SinglyLinkedList<>();
        numberOfRecordsPresent = 0;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < buckets.length; i++) {
            str.append("Bucket ");
            str.append(i);
            str.append(": ");
            str.append(buckets[i].toString());
            str.append("\n");
        }
        return str.toString();
    }

    public Iterator<E> iterator() {
        return new HashSetIterator<>(this);
    }

    public static class HashSetIterator<H> implements Iterator<H> {
        SinglyLinkedList.SinglyLinkedListIterator<H> it;
        int currentBucket = 0;
        HashSetSeparateChaining<H> H;

        public HashSetIterator(HashSetSeparateChaining<H> H)   {
            this.H = H;
            it = (SinglyLinkedList.SinglyLinkedListIterator<H>) H.buckets[0].iterator();
        }

        public boolean hasNext()  {
            while( currentBucket < H.buckets.length-1 && (!it.hasNext() || H.buckets[currentBucket].isEmpty()) )
                it = (SinglyLinkedList.SinglyLinkedListIterator<H>) H.buckets[++currentBucket].iterator();
            return it.hasNext();
        }

        public H next() {
            return it.next();
        }

        //**********************************************************//
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(E e) {
        int hashCode = e.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        for( var item : buckets[bucketIndex] )
            if( item.equals(e) )
                return true;
        return false;
    }

    public E find(E e) { // finds and returns the object in the hash-table that is equal to 'e'
        int hashCode = e.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        for( var item : buckets[bucketIndex] )
            if( item.equals(e) )
                return item;
        return null;
    }

    public void addAll(SetADT<E> T) { // S = S union T
        for(var e : T)
            add(e);
    }

    public void retainAll(SetADT<E> T) { // S = S intersect T
        HashSetSeparateChaining<E> tempS = new HashSetSeparateChaining<>();

        for(var e : this)
            if( T.contains(e) )
                tempS.add(e);

        buckets = tempS.buckets;
        numberOfRecordsPresent = tempS.numberOfRecordsPresent;
    }

    public void removeAll(SetADT<E> T) { // S = S difference T
        HashSetSeparateChaining<E> tempS = new HashSetSeparateChaining<>();

        for(var e : this)
            if( !T.contains(e) )
                tempS.add(e);

        buckets = tempS.buckets;
        numberOfRecordsPresent = tempS.numberOfRecordsPresent;
    }
}
