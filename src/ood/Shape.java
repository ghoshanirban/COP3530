package ood;

import java.util.Date;

public class Shape {
	protected String color;
	protected boolean isFilled;
	protected final Date dateCreated; // once an object is created we cannot change its date of creation
	
	public Shape() {
		color = "black";
		isFilled = false;
		dateCreated = new Date();
		System.out.println("No arg contructor in Shape is being executed.");
	}
	
	public Shape(String color, boolean filled) {
		this.color = color;
		isFilled = filled;
		dateCreated = new Date();
		System.out.println("Shape(String color, boolean filled) contructor in Shape is being executed.");
	}
	
	public String getColor() {
		System.out.println("getColor() from Shape class is being executed");
		return color;
	}
	
	public void setColor(String color) { this.color = color; }
		
	public boolean isFilled() {
		return isFilled;
	}
	
	public void setFilled(boolean filled) { this.isFilled = filled; }
	
	final public Date getDateCreated() { // a child class cannot redefine this method
		return dateCreated;
	}
	
	public String toString() {
		String str = "";
		str += "COLOR: " + this.color + ", IS_FILLED: ";
		str += this.isFilled + ", DATE_CREATED: ";
		str += this.dateCreated;
		return str;
	}
}