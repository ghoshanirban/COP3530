package tester;

import trees.BinaryTree;

public class TestBinaryTree {
	public static void main(String[] args) {
		BinaryTree<String> cityTree = new BinaryTree<>();

		cityTree.insert("Jacksonville","root");
		cityTree.insert("Atlanta", "0");
		cityTree.insert("Miami", "1");
		cityTree.insert("Orlando", "00");
		cityTree.insert("Tampa", "01");
		cityTree.insert("Charleston", "010");
		cityTree.insert("NYC", "10");
		cityTree.insert("New Jersey", "11");
		cityTree.insert("Sarasota", "100");
		cityTree.insert("Destin", "101");

		System.out.print("PreOrder: ");
		cityTree.printPreOrder();
		
		System.out.print("\nInOrder: ");
		cityTree.printInOrder();

		System.out.print("\nInOrder: ");
		cityTree.printInOrderIterative();
		
		System.out.print("\nPostOrder: ");
		cityTree.printPostOrder();
		
		System.out.print("\nNumber of nodes in the tree: " + cityTree.countNodes() + "\n");

		for( var item : cityTree ) // Using the inorder iterator for the binary tree class
			System.out.print(item + " ");
	}
}