package Lecture14;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 50 3 40 2 20 0 15 0 80 0 10 1 19 0
		GenericTree tree = new GenericTree();
		tree.display();
//		System.out.println(tree.size2());
//		System.out.println(tree.max());
//
//		System.out.println(tree.height());
//		System.out.println(tree.find(90));
		System.out.println("*******************************");
		tree.printAtLevel(2);
		System.out.println("****");
//		tree.postOrder();
		tree.LevelOrder();
	}

}
