package Lecture1;

import java.util.Scanner;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the number");
		int n = s.nextInt();
		int divisor = 2;
		while (divisor < n) {
			if (n % divisor == 0) {
				System.out.println("Not Prime");
				return;
			}
			divisor++;
		}
		System.out.println("Prime");

	}

}
