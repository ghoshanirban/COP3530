package arraysandLLs;

public class COP3530ArrayList<E> {
    Object[] A; // generic array
    int elementCount = 0;

    public COP3530ArrayList(){ }

    public boolean add(E e) {
        if( elementCount == 0 ) {
            A =  new Object[10]; // initial array size is set to 10 (other values can be used as well)
            A[0] = e;
            elementCount++;
            return false;
        }
        if( elementCount == A.length ) { // reallocate
            Object[] Aprime =  new Object[ (int)(A.length * 1.5) ];
            System.arraycopy(A, 0, Aprime, 0, elementCount);
            Aprime[elementCount] = e;
            A = Aprime;
            elementCount++;
            return true;
        }
        else {
            elementCount++;
            A[elementCount-1] = e;
            return false;
        }
    }

    public void remove(int index) { // takes O(n) time in the worst case
        if( index >= elementCount || index < 0 )
            throw new IllegalArgumentException("Passed index is out of bound.");

        for(int i = index + 1; i < elementCount; i++) // left shift elements to compact the array
            A[i-1] = A[i];

        A[elementCount-1] = null;
        elementCount--;
    }

    public void insert(int index, E e) { // takes O(n) time in the worst case
        if( index >= elementCount || index < 0 )
            throw new IllegalArgumentException("Passed index is out of bound.");

        if( elementCount == A.length ) { // no space remaining in A; reallocate
            Object[] Aprime =  new Object[ (int)(A.length * 1.5)];
            System.arraycopy(A, 0, Aprime, 0, elementCount);
            A = Aprime;
        }

        for(int i = elementCount; i >= index + 1; i--) // right shift elements to free an empty spot
            A[i] = A[i-1];

        A[index] = e;
        elementCount++;
    }

    public int size() {
        return elementCount;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < elementCount; i++)
            str.append(A[i].toString()).append(" ");
        return str.toString();
    }
}
