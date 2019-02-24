package Lecture11;

import Lecture10.DynamicStack;

public class QUSEnqueueEfficient {
	private DynamicStack sPrimary;
	private DynamicStack sSecondary;

	public QUSEnqueueEfficient() throws Exception {
		// TODO Auto-generated constructor stub
		this.sPrimary = new DynamicStack();
		this.sSecondary = new DynamicStack();
	}

	public boolean isEmpty() {
		return this.sPrimary.isEmpty();
	}

	public int size() {
		return this.sPrimary.size();
	}

	public void enqueue(int item) throws Exception {
		this.sPrimary.push(item);
	}

	public int dequeue() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty");
		}

		while (!(sPrimary.size() == 1)) {
			sSecondary.push(sPrimary.pop());
		}
		int rv = sPrimary.pop();
		while (!sSecondary.isEmpty()) {
			sPrimary.push(sSecondary.pop());
		}

		return rv;
	}

	public int front() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty");
		}

		while (!(sPrimary.size() == 1)) {
			sSecondary.push(sPrimary.pop());
		}
		int rv = sPrimary.pop();
		sSecondary.push(rv);
		while (!sSecondary.isEmpty()) {
			sPrimary.push(sSecondary.pop());
		}

		return rv;
	}

	public void display() throws Exception {
		reverseStack(sPrimary, new DynamicStack(), 0);
		sPrimary.display();
		reverseStack(sPrimary, new DynamicStack(), 0);

	}

	private static void reverseStack(DynamicStack stack, DynamicStack helper, int index) throws Exception {
		if (stack.isEmpty()) {
			return;
		}
		int item = stack.pop();
		reverseStack(stack, helper, index + 1);
		helper.push(item);
		if (index == 0) {
			while (!helper.isEmpty()) {
				stack.push(helper.pop());
			}
		}
	}

}
