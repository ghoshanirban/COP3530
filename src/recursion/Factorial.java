package recursion;

public class Factorial {
	public static long factorial(int n) {
		System.out.println("Executing factorial(" + n + ")");
		if( n < 0 )
			throw new IllegalArgumentException("n must non-negative!");
		else if( n == 0 || n == 1 ) // base cases
			return 1;
		else
			return n * factorial(n-1); // recursive call
	}
	
	public static void main(String[] args) {
		long result = factorial(5);
		System.out.println( result );
	}
}