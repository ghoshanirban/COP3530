package recursion;

public class ArraySummer {

	public static int add(int[] A, int i) {
		//System.out.println("Invoking add method using i = " +i);
		if ( i < 0 ) 
			throw new IllegalArgumentException("i should be non-negative.");
		else if( i == 0 )
			return A[0];
		else
			return add(A, i-1) + A[i];
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		System.out.print( add(arr,arr.length-1) ); 
	}
}
