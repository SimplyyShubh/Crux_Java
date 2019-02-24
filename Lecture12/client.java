package Lecture12;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addFirst(20);
		list.addFirst(10);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		// list.addLast(60);

		// list.addAt(45, 4);
		list.display();

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(4));

		// list.removeFirst();
		// list.display();
		// list.removeLast();
		// list.display();
		// list.removeAt(4);
		// list.display();

		list.reverseDR();
		list.display();

		// Add(null);
	}

	public static void Add(Integer obj) {
		System.out.println("Hi");
	}

	// public static void Add(Object obj) {
	// System.out.println("Object");
	// }
	public static void Add(String obj) {
		System.out.println("In string");
	}
}
