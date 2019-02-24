package Lecture10;

import Lecture9.StacksUsingArrays;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StacksUsingArrays stack = new DynamicStack(5);
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 10);
			displayStackInfo(stack);
		}
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 100);
			displayStackInfo(stack);
		}
		// stack.push(60);
		while (!stack.isEmpty()) {
			displayStackInfo(stack);
			stack.pop();
		}

	}

	public static void displayStackInfo(StacksUsingArrays stack) throws Exception {
		System.out.println("*******************************");
		stack.display();
		System.out.println(stack.top());
		System.out.println(stack.size());
		System.out.println("*******************************");

	}

}
