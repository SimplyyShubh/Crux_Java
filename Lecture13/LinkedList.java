package Lecture12;

public class LinkedList {
	private class Node {
		int data;
		Node next;

		private Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.isEmpty()) {
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}
		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp;
	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}
		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node temp = getNodeAt(index - 1);
			Node node = new Node(data, temp.next);
			temp.next = node;
			this.size++;
		}

	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		return getNodeAt(index).data;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("END");

	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = getNodeAt(this.size() - 2);
			temp.next = null;
			this.tail = temp;
		}
		this.size--;
	}

	public void removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (index == 0) {
			this.removeFirst();
		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node temp = getNodeAt(index - 1);
			temp.next = temp.next.next;
			this.size--;
		}
	}

	public void reverseDI() throws Exception {
		int li = 0, ri = this.size - 1;
		while (li <= ri) {
			Node left = getNodeAt(li);
			Node right = getNodeAt(ri);

			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			li++;
			ri--;
		}
	}

	public void reversePI() {
		Node prev = this.head, curr = prev.next;
		while (curr != null) {
			Node tempPrev = prev;
			Node tempCurr = curr;

			prev = curr;
			curr = curr.next;
			tempCurr.next = tempPrev;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (node == this.tail) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}

	public void reverseDR() {
		HeapMover obj = new HeapMover(this.head);
		reverseDR(obj, this.head, 0);

	}

	private void reverseDR(HeapMover left, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR(left, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}

	}

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	public int mid() {
		return getMidNode().data;
	}

	private Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public int KthNodeFromEnd(int k) throws Exception {
		if (k < 0 || k > this.size) {
			throw new Exception("Invalid Index");
		}

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public LinkedList merge(LinkedList other) {
		Node thistemp = this.head;
		Node othertemp = other.head;
		LinkedList rv = new LinkedList();
		while (thistemp != null && othertemp != null) {
			if (thistemp.data < othertemp.data) {
				rv.addLast(thistemp.data);
				thistemp = thistemp.next;
			} else {
				rv.addLast(othertemp.data);
				othertemp = othertemp.next;
			}
		}
		while (thistemp != null) {
			rv.addLast(thistemp.data);
			thistemp = thistemp.next;
		}

		while (othertemp != null) {
			rv.addLast(othertemp.data);
			othertemp = othertemp.next;
		}

		return rv;

	}

	public void mergeSort() {
		LinkedList sorted = this.mergeSortHelper(this.head, this.tail);
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}

	private LinkedList mergeSortHelper(Node head, Node tail) {
		if (this.size() == 1) {
			return this;
		}
		Node mid = this.getMidNode();
		Node midnext = mid.next;
		mid.next = null;

		LinkedList list1 = new LinkedList(this.head, mid, (this.size() + 1) / 2);
		LinkedList list2 = new LinkedList(midnext, this.tail, this.size() / 2);

		list1.mergeSort();
		list2.mergeSort();

		return list1.merge(list2);
	}

	private LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

}
