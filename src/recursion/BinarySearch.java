package recursion;

public class BinarySearch {

	public static boolean binarySearchRec(int[] A, int target, int low, int high) {
		//System.out.println("Searching in "+ low + ", " + high);
		
		if( low > high )
			return false;
		else {
			int mid = (low + high) / 2; // mid takes the floor of (low + high) / 2
			if( target == A[mid] )		return true;
			else if( target < A[mid] ) 	return binarySearchRec(A, target, low, mid - 1 ); // recursive call
			else        				return binarySearchRec(A, target, mid + 1, high );// recursive call
		}
	}
	
	public static boolean binarySearch(int[] A, int target) {
		return binarySearchRec(A, target, 0, A.length-1);
	}
	
	public static void main(String[] args) {
		int[] A = {2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};
		System.out.println(binarySearch(A,22)); // prints true
		System.out.println(binarySearch(A,21)); // prints false
	}
}
