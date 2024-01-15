package introduction;

public class LinearSearch {
    /**
     * This method checks whether the integer 'key' is present in the array named 'list'.
     * @param list A sequence of integers (possibly unsorted)
     * @param key  The key that needs to be searched in 'list'
     * @return If the integer 'key' is present in 'list', the method returns its index otherwise returns -1.
     * If 'key' occurs multiple times in 'list', this method returns the index of the first occurrence of 'key'
     */
    public static int search(int[] list, int key) {
        for (int pos = 0; pos < list.length; pos++) {
            if (key == list[pos])
                return pos;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myList = {4, 5, 1, 2, 9, -3};
        int result = search (myList, 2);
        System.out.println( result );
    }
}