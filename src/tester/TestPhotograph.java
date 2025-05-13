package tester;

import java.util.ArrayList;

import ood.Photograph;

public class TestPhotograph {
	public static void main(String[] args) {
		
		ArrayList<Photograph> wareHouse = new ArrayList<>();
		wareHouse.add(new Photograph("Dali Painting (Print)", 8753.67, "JAX Paintings"));
		wareHouse.add(new Photograph("Local Painting (Original)", 625.99, "Independent Painter"));
		
		System.out.print(wareHouse.get(0).getListPrice());
	}
}
