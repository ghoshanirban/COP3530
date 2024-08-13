package tester;
import java.util.ArrayList;

import ood.StoreSellablePhotograph;

public class TestStoreSellablePhotograph {

	public static void main(String[] args) {
		ArrayList<StoreSellablePhotograph> wareHouse = new ArrayList<>();
		wareHouse.add(new StoreSellablePhotograph("Dali Painting (Print)", 8753.67, "JAX Paintings"));
		wareHouse.add(new StoreSellablePhotograph("Local Painting (Original)", 625.99, "Independent Painter"));
		
		System.out.print(wareHouse.get(0).getDescription());
	}
}
