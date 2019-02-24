package Lecture1;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the principal");
		int principal = scn.nextInt();
		System.out.println("Please enter the rate of interest");

		int rate = scn.nextInt();
		System.out.println("Please enter the time");
		int time = scn.nextInt();
		int si;
		si = (principal * rate * time) / 100;
		System.out.println("The simple interest is " + si);
	}
}
