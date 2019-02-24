package Lecture15;

import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;
	int size = 0;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isleftorright) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (isleftorright) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int nodedata = s.nextInt();
		Node node = new Node(nodedata, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.left = takeInput(s, node, true);
		}
		choice = false;
		System.out.println("Do you have right child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.right = takeInput(s, node, false);
		}

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}

		System.out.print(node.data);
		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}

		System.out.println();

		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}

	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int x = this.size2(node.left);
		int y = this.size2(node.right);
		return x + y + 1;

	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}

		if (this.find(node.left, data)) {
			return true;
		} else if (this.find(node.right, data)) {
			return true;
		} else {
			return false;
		}
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lheight = this.height(node.left);
		int rheight = this.height(node.right);

		int height = Math.max(lheight, rheight);

		return height + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int m = node.data;
		int lmax = this.max(node.left);
		int rmax = this.max(node.right);
		int cmax = (lmax > rmax) ? lmax : rmax;

		return (m > cmax) ? m : cmax;
	}

	public void preOrderIterative() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);
		while (!stack.isEmpty()) {
			Node node = stack.removeFirst();
			System.out.println(node.data);

			if (node.right != null) {
				stack.addFirst(node.right);
			}

			if (node.left != null) {
				stack.addFirst(node.left);
			}
		}
	}

	// public int lca(int d1, int d2) {
	// return this.lca(this.root, d1, d2).data;
	// }
	//
	// private Node lca(Node node, int d1, int d2) {
	//
	// }

	public boolean isBST() {
		return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		} else if (!isBST(node.left, min, node.data)) {
			return false;
		} else if (!isBST(node.right, node.data, max)) {
			return false;
		}

		return true;
	}
	
	
	
}
