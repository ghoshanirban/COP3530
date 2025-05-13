package tester;

import recursion.GenericBinarySearch;

public class TestGenericBinarySearch {
    public static void main(String[] args) {
        Integer[] A = new Integer[]{2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};
        System.out.println(GenericBinarySearch.search(A, 22) ); // prints true
        System.out.println(GenericBinarySearch.search(A, 21) ); // prints false
    }
}
