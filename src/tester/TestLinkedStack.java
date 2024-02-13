package tester;

import stacksandqueues.LinkedStack;

public class TestLinkedStack {
	public static void main(String[] args) {
		LinkedStack<String> cityNames = new LinkedStack<>();
		
		cityNames.push("Jacksonville");
		cityNames.push("Atlanta");
		cityNames.push("Orlando");
		cityNames.push("Miami");
		cityNames.push("Gainesville");
		
		System.out.println("Popped element: " + cityNames.pop());

		while( !cityNames.isEmpty() ) {
			String s = cityNames.pop();
			System.out.println(s);
		}

		System.out.println(cityNames.size());
		System.out.println(cityNames.isEmpty());
	}
}
