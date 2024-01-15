package ood;

import java.util.ArrayList;

public class Canvas {
	
	public void drawShapesVersionA(ArrayList<Shape> shapes) {
		// some code for drawing...
	}
	
	public void drawShapesVersionB(ArrayList<? extends Shape> shapes) {
		// some code for drawing...
	}
	
	public void doSomething(ArrayList<? super Square> shapes) {
		// some code
	}
}
