package Lecture9;

public class QueueUsingArrays {
	private int[] data;
	private int size;
	private int front;

	public static final int DEFAULT_CAPACITY = 10;

	public QueueUsingArrays() throws Exception {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}

	public QueueUsingArrays(int capacity) throws Exception {
		// TODO Auto-generated constructor stub
		if (capacity <= 0) {
			throw new Exception("Queue is Full");
		}

		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Queue is Full");
		}

		int ai = (this.front + this.size) % this.data.length;
		this.data[ai] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty");
		}

		int retVal = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return retVal;
	}

	public int front() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty");
		}

		int retVal = this.data[this.front];
		return retVal;
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + ", ");
		}
		System.out.println("END");
	}

}
