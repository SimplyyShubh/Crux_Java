package Lecture10;

import Lecture9.QueueUsingArrays;

public class DynamicQueue extends QueueUsingArrays {
	public DynamicQueue() throws Exception {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}

	public DynamicQueue(int capacity) throws Exception {

		super(capacity);
	}

	public void enqueue(int item) throws Exception {
		if (this.data.length == this.size()) {
			int[] arr = new int[2 * this.data.length];
			for (int i = 0; i < this.size; i++) {
				arr[i] = this.data[(this.front + i) % this.data.length];
			}
			this.front = 0;
			this.data = arr;
		}
		super.enqueue(item);
	}

}
