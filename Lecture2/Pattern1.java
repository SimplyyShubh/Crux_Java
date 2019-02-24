package Lecture2;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int row = 1, col = 1;
		int nstars = N, nsp = 0;
		while (row <= 2 * N - 1) {
			col = 1;
			while (col <= nsp) {
				System.out.print(" ");
				col++;
			}
			col = 1;
			while (col <= nstars) {
				System.out.print("*");
				col++;
			}
			if (row < N) {
				nstars = nstars - 1;
				nsp = nsp + 2;
			} else {
				nstars = nstars + 1;
				nsp = nsp - 2;
			}
			row++;
			System.out.println();
		}

	}

}
