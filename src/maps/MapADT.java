package maps;

public interface MapADT<K,V> {
    boolean put(K key, V value); // adds a new record with key 'key' and value 'value'
    V remove(K key); // removes the record having key 'key'
    V get(K key); // return the value part of the record whose key is 'key'
    V updateValue(K key, V newValue); // updates the value part of the record whose key is 'key' with a new value
    int size(); // returns the number of records stored in the map
    void clear(); //Removes all records from the map
}
