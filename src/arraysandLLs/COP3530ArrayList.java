package arraysandLLs;

public class COP3530ArrayList<E> {
    Object[] A; // generic array
    int size = 0;

    public COP3530ArrayList(){ }

    // adds a new element at the back; returns true
    // if reallocation is required else returns false
    public boolean add(E e) {
        if( size == 0 ) {
            A =  new Object[10]; // initial array size is set to 10 (other values can be used as well)
            A[0] = e;
            size++;
            return true;
        }
        if( size == A.length ) { // reallocate
            Object[] Aprime =  new Object[ (int)(A.length * 1.5) ];
            System.arraycopy(A, 0, Aprime, 0, size);
            Aprime[size] = e;
            A = Aprime;
            size++;
            return true;
        }
        else {
            size++;
            A[size -1] = e;
            return false;
        }
    }

    public void remove(int index) { // takes O(n) time in the worst case
        if( index >= size || index < 0 )
            throw new IllegalArgumentException("Passed index is out of bound.");

        for(int i = index + 1; i < size; i++) // left shift elements to compact the array
            A[i-1] = A[i];

        A[size -1] = null;
        size--;
    }

    public void insert(int index, E e) { // takes O(n) time in the worst case
        if( index >= size || index < 0 )
            throw new IllegalArgumentException("Passed index is out of bound.");

        if( size == A.length ) { // no space remaining in A; reallocate
            Object[] Aprime =  new Object[ (int)(A.length * 1.5)];
            System.arraycopy(A, 0, Aprime, 0, size);
            A = Aprime;
        }

        for(int i = size; i >= index + 1; i--) // right shift elements to free an empty spot
            A[i] = A[i-1];

        A[index] = e;
        size++;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < size; i++)
            str.append(A[i].toString()).append(" ");
        return str.toString();
    }

    // Food for thought: can you make this class
    // iterable so that one can use a for-each loop?
}
