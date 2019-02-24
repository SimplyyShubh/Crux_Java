package Lecture18;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Heap<Student> heap = new Heap();
		// heap.add(new Student(200, 8, "A"));
		// heap.add(new Student(500, 5, "B"));
		// heap.add(new Student(700, 3, "C"));
		// heap.add(new Student(100, 9, "D"));
		// heap.add(new Student(900, 1, "E"));
		// heap.add(new Student(800, 2, "F"));
		// heap.add(new Student(600, 4, "G"));
		// heap.add(new Student(300, 7, "H"));
		// heap.add(new Student(400, 6, "I"));
		//
		// heap.display();

		Student[] students = new Student[9];
		students[0] = new Student(200, 8, "A");
		students[1] = new Student(500, 5, "B");
		students[2] = new Student(700, 3, "C");
		students[3] = new Student(100, 9, "D");
		students[4] = new Student(900, 1, "E");
		students[5] = new Student(800, 2, "F");
		students[6] = new Student(600, 4, "G");
		students[7] = new Student(300, 7, "H");
		students[8] = new Student(400, 6, "I");
		Heap<Student> heap = new Heap<>(students, false);
		heap.display();
	
	}

	private static class Student implements Comparable<Student> {
		int marks;
		int rank;
		String name;

		Student(int marks, int rank, String name) {
			this.marks = marks;
			this.rank = rank;
			this.name = name;
		}

		public String toString() {
			return "{R=" + this.rank + ", M=" + this.marks + ", Name=" + this.name + "}";
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.marks - o.marks;
		}
	}
	
	

}
