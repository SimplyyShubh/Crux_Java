package Lecture1;

public class LargestOf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100;
		int b = 15;
		int c = 25;
		// Largest of 3 numbers
		if (a >= b && a >= c) {
			System.out.println(a);
			return;
		}
		if (b >= a && b >= c) {
			System.out.println(b);
			return;
		}
		System.out.println(c);

		// if (a > b && a > c) {
		// System.out.println(a);
		// } else if (b > a && b > c) {
		// System.out.println(b);
		// } else {
		// System.out.println(c);
		// }

	}

}
