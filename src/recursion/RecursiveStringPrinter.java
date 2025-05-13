package recursion;

public class RecursiveStringPrinter {
	
	public static String printer(int n) {
		if( n <= 0)	     return null;
		else if( n == 1) return "computing";
		else             return "comp" + printer(n-1) + "ting"; 
	}

	public static void main(String[] args) {
		System.out.print(printer(10));
	}
}
