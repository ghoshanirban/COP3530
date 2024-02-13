package stacksandqueues;

import java.util.Scanner;

public class ExpresssionChecker {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
			
		LinkedStack<Character> S = new LinkedStack<>();

		int pos;
		
		for(pos = 0; pos < expression.length(); pos++) {

			char current = expression.charAt(pos);
			
			if( current == '(' || current == '{' || current == '[') 
				S.push(current);
			else if( current == ')' && !S.isEmpty() && S.top() == '(' ) 
				S.pop();
			else if( current == ')' && !S.isEmpty() && S.top() != '(' )
				break;
			else if( current == '}' && !S.isEmpty() && S.top() == '{' ) 
				S.pop();
			else if( current == '}' && !S.isEmpty() && S.top() != '{' )
				break;	
			else if( current == ']' && !S.isEmpty() && S.top() == '[' )
				S.pop();
			else if( current == ']' && !S.isEmpty() && S.top() != '[' )
				break;		
		}	
		
		if( S.isEmpty() && pos == expression.length() ) // stack is empty and the whole expr has been traversed
			System.out.println("VALID");
		else
			System.out.println("INVALID");
		
		input.close();		
	}
}

// VALID: (a + b) + (66 * (s / t) - 12) * {p + (z - [2 + 99.1 / (m - x)])}
// VALID: 30 + (40 + (9 * (6 - 10) * (1 - (17 + 19 + 99) - 1) / {5 + (8 - [6 + 2 * (1 + (-99)) - 1] - 4) - 1} - 1) - 1) * 88
// INVALID: (a+b)*((c+d^e/99)})

