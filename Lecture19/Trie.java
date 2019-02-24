package Lecture19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(char data, boolean isTerminal) {
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = isTerminal;
		}
	}

	private Node root;
	private int numWords;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public void add(String word) {
		this.add(this.root, word);
	}

	private void add(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {

			} else {
				node.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if (child == null) {
			child = new Node(cc, false);
			node.children.put(cc, child);
		}
		this.add(child, ros);
	}

	public void displayAll(String tocheck) {
		this.displayAll(this.root, tocheck, "");
	}

	private void displayAll(Node node, String tocheck, String osf) {
		if (node.isTerminal) {
			String toPrint = osf.substring(1) + node.data;
			if (toPrint.startsWith(tocheck)) {
				System.out.println(toPrint);
			} else {

			}
		}
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for (Map.Entry<Character, Node> entry : entries) {
			this.displayAll(entry.getValue(), tocheck, osf + node.data);
		}
	}

	public void display() {
		this.display(this.root, "");
	}

	private void display(Node node, String osf) {
		if (node.isTerminal) {
			String toPrint = osf.substring(1) + node.data;

			System.out.println(toPrint);

		}
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for (Map.Entry<Character, Node> entry : entries) {
			this.display(entry.getValue(), osf + node.data);
		}
	}

	public boolean search(String word) {
		return this.search(this.root, word);
	}

	private boolean search(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if (child == null) {
			return false;
		}
		return this.search(child, ros);
	}

	public void remove(String word) {
		this.remove(this.root, word);
	}

	private void remove(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.numWords--;
			} else {

			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if (child == null) {
			return;
		}
		this.remove(child, ros);
		if(!child.isTerminal&&child.children.size()==0){
			parent.children.remove(cc);
		}
	}

}
