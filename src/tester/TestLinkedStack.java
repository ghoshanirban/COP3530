package tester;

import introduction.Point;
import stacksandqueues.LinkedQueue;
import stacksandqueues.LinkedStack;

import java.util.Scanner;

public class TestLinkedStack {
	public static void main(String[] args) {
//		LinkedStack<String> cityNames = new LinkedStack<>();
//
//		cityNames.push("Jacksonville");
//		cityNames.push("Atlanta");
//		cityNames.push("Orlando");
//		cityNames.push("Miami");
//		cityNames.push("Gainesville");
//
//		System.out.println("Popped element: " + cityNames.pop());
//
//		while( !cityNames.isEmpty() ) {
//			String s = cityNames.pop();
//			System.out.println(s);
//		}
//
//		System.out.println(cityNames.size());
//		System.out.println(cityNames.isEmpty());

		Scanner input = new Scanner(System.in);
		StringBuilder userString = new StringBuilder( input.nextLine() );
		LinkedStack<Character> characters = new LinkedStack<>();

		for( int i = 0; i < userString.length(); i++ )
			characters.push( userString.charAt( i ) );

		while( !characters.isEmpty() )
			System.out.print( characters.pop() );
	}
}
