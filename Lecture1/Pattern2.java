package Lecture1;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int row = 1;
		int col = 1;
		while (row <= N) {
			col = 1;
			while (col <= row) {
				System.out.print("* ");
				col++;
			}
			System.out.println();
			row++;
		}
	}

}
