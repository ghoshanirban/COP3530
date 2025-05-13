package ood;

public class Circle extends Shape {
	protected Double radius;
	
	public Circle() {
		this(1.0);
		System.out.println("No arg contructor in Circle is being executed.");
	}
	
	public Circle(Double radius) {
		if(radius < 0)  throw new IllegalArgumentException("Radius cannot be negative.");
		this.radius = radius;
		System.out.println("Circle(Double radius) contructor in Circle is being executed.");
	}
	
	public Circle(Double radius, String color, boolean filled) {
		this.radius = radius;
		this.color = color;
		isFilled = filled;
		System.out.println("Circle(Double radius, String color, boolean filled) contructor in Circle is being executed.");
	}
	
	public Double getRadius() { return radius; }
	
	public void setRadius(Double radius) { this.radius = radius; }
	
	@Override
	public String getColor() {
		System.out.println("getColor() from Circle class is being executed");
		return color;
	}
	
	public Double getArea() { return Math.PI * radius * radius; }
	
	public Double getPerimeter() { return 2 * Math.PI * radius; }
	
	public Double getDiameter() { return 2 * radius; }
	
	// The method is already declared to be final in the superclass
//	public Date getDateCreated() {
//		return dateCreated;
//	}
	
	public void printCircle() {
		System.out.println("This circle this created on " + getDateCreated() +
		      " having radius " + radius);
	 }
	
	public boolean equals(Object ob) {
		if (ob instanceof Circle)
			return Math.abs(radius - ((Circle) ob).radius) < 0.000001;
		else
			return false;
	} 
}