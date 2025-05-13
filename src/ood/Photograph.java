package ood;

public class Photograph implements SuperStoreSellableItem{
	final private String description, supplier;
	final private double listPrice;
	
	public Photograph(String description, double listPrice, String supplier) {
		this.description = description;
		this.listPrice = listPrice;
		this.supplier = supplier;
	}
	
	public String getDescription() { return description; }
	
	public double getListPrice() { return listPrice; }
	
	public String findWhoSupplies() { return supplier; }
}
