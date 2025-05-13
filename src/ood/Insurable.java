package ood;

// Demonstrating multiple inheritance for interfaces
public interface Insurable extends SuperStoreSellableItem, Transportable {
	 double getInsuredValue();
}
