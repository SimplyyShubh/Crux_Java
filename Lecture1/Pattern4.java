package Lecture1;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 1;
		int N = 4;
		int col = 1;
		int value = 1;
		while (row <= N) {
			col = 1;
			while (col <= row) {
				System.out.print(value + " ");
				value++;
				col++;
			}
			System.out.println();
			row++;
		}
	}

}
