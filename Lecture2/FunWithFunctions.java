package Lecture2;

public class FunWithFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part 1
		// HelloFun();
		//
		// // Part 2
		// HelloFun();
		// HelloFun();
		//
		// // Part 3
		// HelloFun();
		// HelloGun();

		// Part 4
		// HelloFunGun();

		// Part 5
		// String name="Anuj";
		// System.out.println(name);
		// name=funwithArguments(name);
		// System.out.println(name);

		// Part 6
		int a = 10, b = 20;
		System.out.println(a + "," + b);
		swap(a, b);
		System.out.println(a + "," + b);

	}

	public static void HelloFun() {
		System.out.println("HelloFun");
	}

	public static void HelloGun() {
		System.out.println("HelloGun");
	}

	public static void HelloFunGun() {
		HelloFun();
		HelloGun();
	}

	public static String funwithArguments(String name) {
		name = "Rishab";
		System.out.println(name);
		return name;
	}

	public static void swap(int a, int b) {
		System.out.println(a + "," + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a + "," + b);
	}

}
