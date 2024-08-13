package ood;

public class Square extends Rectangle { // a child class of the Rectangle; 
	                                    // this class does not have any instance variable!		
	public Square() {
		super(1.0,1.0);
		System.out.println("No arg contructor in Square is being executed.");
	}
	
	public Square(Double side) {
		System.out.println("Square(Double side) contructor in Square is being executed.");
		if(!isDimensionSafe(side)) 
			throw new IllegalArgumentException("Impermissible side-length.");
		
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public void setSide(Double side) {
		if(!isDimensionSafe(side)) 
			throw new IllegalArgumentException("Impermissible side-length.");
		
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public Double getSide() {
		return super.getHeight();
	}

	@Override
	protected boolean isDimensionSafe(Double side) {
		return side <= 50;
	}
	
	@Override
	public Double getDiagonalLength() {
		System.out.println("getDiagonalLength from Square");
		return Math.sqrt(2) * getSide();
	}
}