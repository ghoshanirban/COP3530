package maps;

import java.util.*;
import java.util.AbstractMap.SimpleEntry; // A built-in record class in Java

@SuppressWarnings("unchecked")
public class HashMapSeparateChaining<K,V> implements Iterable<SimpleEntry<K,V>>, MapADT<K,V>  {
    final double desiredLoadFactor = 0.75; // Java chose this number in their implementation
    final int initialNumberOfBuckets = 16; // Java chose this number in their implementation

    //****************************************************//
    //A singly-linked list class to represent the buckets, containing records
    private static class RecordsSinglyLinkedList<K,V> implements Iterable<SimpleEntry<K,V>> {
        protected static class Node<K,V> {
            final SimpleEntry<K,V> rec;
            Node<K,V> next;

            public Node(SimpleEntry<K,V> r, Node<K,V> refToTheNextNode) {
                rec = r;
                next = refToTheNextNode;
            }
        }
        protected Node<K,V> head = null, tail = null;
        protected int size = 0;

        public RecordsSinglyLinkedList() { }

        public boolean isEmpty() { return (size == 0); }

        public void addLast(SimpleEntry<K,V> r) {
            Node<K,V> newest = new Node<>(r,null);
            if( isEmpty() ) head = newest;
            else tail.next = newest;
            tail = newest;
            size++;
        }

        public V remove(K key) {
            Node<K,V> current = head, prev = null;

            while(current != null) {
                if(current.rec.getKey().equals(key)) {
                    if( prev == null ) head = current.next;
                    else prev.next = current.next;
                    return current.rec.getValue();
                }
                prev = current;
                current = current.next;
            }

            return null;
        }

        public V updateValue(K key, V newValue){
            Node<K,V> current = head;

            while(current != null) {
                if(current.rec.getKey().equals(key)) {
                    V holdValue = current.rec.getValue();
                    current.rec.setValue(newValue);
                    return holdValue;
                }
                current = current.next;
            }

            return null;
        }

        public Iterator<SimpleEntry<K,V>> iterator() { return new SinglyLinkedListIterator(this); }

        public class SinglyLinkedListIterator implements Iterator<SimpleEntry<K,V>> {
            private Node<?,?> current;
            public SinglyLinkedListIterator(RecordsSinglyLinkedList<?,?> L)   {
                current =  L.head;
            }

            public boolean hasNext()  { return current != null; }

            public SimpleEntry<K,V> next() {
                SimpleEntry<K,V> data  = (SimpleEntry<K, V>) current.rec;
                current = current.next;
                return data;
            }
        }

        public String toString() {
            StringBuilder str = new StringBuilder();
            var current = head;
            while( current != null ) {
                String s = "[" + current.rec.getKey() + ", " + current.rec.getValue() + "]";
                str.append( s );
                if( current.next != null ) str.append(" -> ");
                current = current.next;
            }
            return str.toString();
        }

    }
    //****************************************************//
    RecordsSinglyLinkedList<K,V>[] buckets;

    int numberOfRecordsPresent = 0;

    public HashMapSeparateChaining() {
        buckets = (RecordsSinglyLinkedList<K,V>[]) new RecordsSinglyLinkedList[initialNumberOfBuckets];
        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new RecordsSinglyLinkedList<>();
    }

    public double loadFactor() {
        return numberOfRecordsPresent / (double)buckets.length;
    }

    private int compressionFunction( int x, int N ) {
        return ( Math.abs(x) % N );
    }

    public boolean put(K k, V value){
        if(k == null)   throw new IllegalArgumentException("Key cannot be null.");
        if(value == null) throw new IllegalArgumentException("Value cannot be null.");

        int hashCode = k.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);

        for( var record : buckets[bucketIndex]) // check if a record with key 'k' already exists
            if( record.getKey().equals(k) )
                return false;

        buckets[ bucketIndex ].addLast(new SimpleEntry<>(k,value)); // add the new record at the end of the list
        numberOfRecordsPresent++;

        if( loadFactor() > desiredLoadFactor ) // rehash if required
            rehash();

        return true;
    }

    private void rehash(){
        var newBuckets = (RecordsSinglyLinkedList<K,V>[]) new RecordsSinglyLinkedList[buckets.length * 2];
        for(int i = 0; i < newBuckets.length; i++)
            newBuckets[i] = new RecordsSinglyLinkedList<>();

        for (RecordsSinglyLinkedList<K, V> L : buckets)
            for (var record : L) {
                int hashCode = record.getKey().hashCode();
                newBuckets[compressionFunction(hashCode, newBuckets.length)].addLast(record);
            }
        buckets = newBuckets;
    }


    public V get(K key) {
        int hashCode = key.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        for( var record : buckets[bucketIndex] )
            if (record.getKey().equals(key))
                return record.getValue();
        return null;
    }

    public V remove(K key) {
        int hashCode = key.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        return buckets[bucketIndex].remove(key);
    }

    public V updateValue(K key, V newValue) {
        int hashCode = key.hashCode(), bucketIndex = compressionFunction(hashCode, buckets.length);
        return buckets[bucketIndex].updateValue(key,newValue);
    }

    public void getAllKeys( ArrayList<K> S ) {
        for (SimpleEntry<K, V> r : this)
            S.add(r.getKey());
    }

    public void getAllValues( ArrayList<V> S ) {
        for (SimpleEntry<K,V> r : this)
            S.add(r.getValue());
    }

    public int size() {
        return numberOfRecordsPresent;
    }

    public void clear() {
        buckets = (RecordsSinglyLinkedList<K,V>[]) new RecordsSinglyLinkedList[initialNumberOfBuckets];
        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new RecordsSinglyLinkedList<>();
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

    public Iterator<SimpleEntry<K,V>> iterator() {
        return new HashMapIterator(this);
    }

    public class HashMapIterator implements Iterator<SimpleEntry<K,V>> {
        RecordsSinglyLinkedList<K,V>.SinglyLinkedListIterator it;
        int currentBucket = 0;
        HashMapSeparateChaining<K,V> H;

        public HashMapIterator(HashMapSeparateChaining<K,V> H)   {
            this.H = H;
            it = (RecordsSinglyLinkedList<K,V>.SinglyLinkedListIterator) H.buckets[0].iterator();
        }

        public boolean hasNext()  {
            while( currentBucket < H.buckets.length-1 && (!it.hasNext() || H.buckets[currentBucket].isEmpty()) )
                it = (RecordsSinglyLinkedList<K,V>.SinglyLinkedListIterator) H.buckets[++currentBucket].iterator();
            return it.hasNext();
        }

        public SimpleEntry<K,V> next() {
            return it.next();
        }
    }
}


