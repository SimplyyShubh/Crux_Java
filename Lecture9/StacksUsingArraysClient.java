package Lecture9;

public class StacksUsingArraysClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StacksUsingArrays stack = new StacksUsingArrays(5);
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 10);
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
