package Lecture14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	Node root;
	int size = 0;

	GenericTree() {
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, 0);
	}

	public int size() {
		return this.size;
	}

	private Node takeInput(Scanner s, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + ithchild + " of " + parent.data);
		}
		int nodedata = s.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		System.out.println("Enter the number of children for " + node.data);
		int children = s.nextInt();
		for (int i = 0; i < children; i++) {
			Node child = takeInput(s, node, i);
			node.children.add(child);
		}

		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		System.out.print(node.data + "=>");
		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data + ", ");
		}
		System.out.println("END");
		for (int i = 0; i < node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int rv = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int childsize = this.size2(node.children.get(i));
			rv = rv + childsize;
		}
		rv = rv + 1;
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			int maxinchild = max(node.children.get(i));
			if (maxinchild > max) {
				max = maxinchild;
			}
		}

		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int height = -1;
		for (int i = 0; i < node.children.size(); i++) {
			int heightinchild = this.height(node.children.get(i));
			if (heightinchild > height) {
				height = heightinchild;
			}
		}
		height = height + 1;

		return height;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (int i = 0; i < node.children.size(); i++) {
			boolean isfoundinchild = this.find(node.children.get(i), data);
			if (isfoundinchild) {
				return true;
			}
		}
		return false;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			mirror(node.children.get(i));
		}

		int left = 0;
		int right = node.children.size() - 1;
		while (left <= right) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			left++;
			right--;
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(level, this.root);
	}

	private void printAtLevel(int level, Node node) {
		if (level == 0) {
			System.out.println(node.data);
			return;
		}
		for (int i = 0; i < node.children.size(); i++) {
			this.printAtLevel(level - 1, node.children.get(i));
		}
	}

	public void preOrder() {
		this.preOrder(this.root);
	}

	private void preOrder(Node node) {
		System.out.println(node.data + " ");
		for (int i = 0; i < node.children.size(); i++) {
			this.preOrder(node.children.get(i));
		}
	}

	public void postOrder() {
		this.postOrder(this.root);
	}

	private void postOrder(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			this.postOrder(node.children.get(i));
		}
		System.out.println(node.data + " ");
	}

	public void LevelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.println(temp.data);
			for (int i=0;i<temp.children.size();i++) {
				queue.addLast(temp.children.get(i));
			}
		}
	}

}
