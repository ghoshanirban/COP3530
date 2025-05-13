package ood;

public abstract class AbstractSuperStoreSellableItem {
	
	String description;
	
	public String getDescription() { return description; }
	public abstract double getListPrice();
	public abstract String findWhoSupplies();
}
