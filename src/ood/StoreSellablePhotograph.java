package ood;

public class StoreSellablePhotograph extends AbstractSuperStoreSellableItem {
	final private String supplier;
	final private double listPrice;
	
	public StoreSellablePhotograph(String description, double listPrice, String supplier) {
		this.description = description;
		this.listPrice = listPrice;
		this.supplier = supplier;
	}
	
	public String getDescription() { return description; }
	
	public double getListPrice() { return listPrice; }
	
	public String findWhoSupplies() { return supplier; }
}
