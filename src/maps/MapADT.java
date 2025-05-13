package maps;

public interface MapADT<K,V> {
    boolean put(K k, V v); // adds a new record with key k and value v
    V remove(K k); // removes the record having key k
    V get(K k); // return the value part of the record whose key is k
    V updateValue(K k, V v); // updates the value part of the record whose key is k with a new value v
    int size(); // returns the number of records stored in the map
    void clear(); //Removes all records from the map
}
