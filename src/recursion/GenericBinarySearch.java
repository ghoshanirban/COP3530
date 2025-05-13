package recursion;

public class GenericBinarySearch {
    private static <K extends Comparable<K>> boolean binarySearchRec(K[] A, K target, int low, int high) {
        if( low > high )
            return false;
        else {
            int mid = (low + high) / 2; // mid takes the floor of (low + high) / 2
            if( target.equals(A[mid]) )		return true;
            else if( target.compareTo( A[mid] ) < 0 ) return binarySearchRec(A, target, low, mid - 1 ); // recursive call
            else return binarySearchRec(A, target, mid + 1, high );// recursive call
        }
    }

    public static <K extends Comparable<K>> boolean search(K[] A, K target) {
        return binarySearchRec(A, target, 0, A.length-1);
    }
}
