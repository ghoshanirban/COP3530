package ood;

public class Rectangle extends Shape { // a child class of the Shape class
	private Double height, width; // not accessible to any other class
	
	public Rectangle() {
		super("dark green",true); // super constructor use is optional
		System.out.println("No arg contructor in Rectangle is being executed.");
		height = 1.0;
		width = 2.0;
	}
	
	public Rectangle(Double height, Double width, String color, boolean filledOrNot) {
		super(color,filledOrNot);

		System.out.println("Rectangle(Double height, Double width, String color, boolean filled) contructor in Rectangle is being executed.");
		if(!isDimensionSafe(height) || !isDimensionSafe(width) ) 
			throw new IllegalArgumentException("Impermissible side-length.");
				
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Double height, Double width) {
		System.out.println("Rectangle(Double height, Double width) contructor in Rectangle is being executed.");
		if(!isDimensionSafe(height) || !isDimensionSafe(width) ) 
			throw new IllegalArgumentException("Impermissible side-length.");
			
		this.height = height;
		this.width = width;
	}
	
	public Double getWidth() { return width; }
	
	public void setWidth(Double width) {
		if(!isDimensionSafe(width) )
			throw new IllegalArgumentException("Impermissible side-length.");
		this.width = width;
	}
	
	public Double getHeight() { return height;}

	public void setHeight(Double height) {
		if(!isDimensionSafe(height)) throw new IllegalArgumentException("Critical runtime failure.");
		this.height = height;
	}

	public Double getArea() { return height * width; }
	
	public Double getPerimeter() { return 2 * (height + width); }
	
	public String toString() {
		String str = super.toString();
		str += ", HEIGHT: " + height + ", ";
		str += "WIDTH: " + width;
		
		return str;
	}
	
	protected boolean isDimensionSafe(Double length) { return length <= 100; }
	
	public Double getDiagonalLength() {
		System.out.println("getDiagonalLength from Rectangle");
		return Math.sqrt( Math.pow(height, 2) + Math.pow(width, 2) );
	}
}