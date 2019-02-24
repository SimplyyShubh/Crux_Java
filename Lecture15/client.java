package Lecture15;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 18 true 24 true 48 false false true 10 false false true 39 true 46 false false false
		BinaryTree tree = new BinaryTree();
		tree.display();
		System.out.println(tree.size2());
		System.out.println(tree.find(114));
		System.out.println(tree.height());
		System.out.println(tree.max());
		System.out.println("*************");
		tree.preOrderIterative();
		
		System.out.println(tree.isBST());
	}

}
