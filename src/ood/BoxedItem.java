package ood;

public class BoxedItem implements Insurable {
	private String description, supplier;
	private double listPrice, weight;
	private boolean haz;

	public String getDescription() { return description; }
	public double getListPrice() { return listPrice; }
	public String findWhoSupplies() { return supplier; }

	public double weight() { return weight; }
	public boolean isHazardous() { return haz; }
	public double getInsuredValue() { return listPrice * 1.5; }
}