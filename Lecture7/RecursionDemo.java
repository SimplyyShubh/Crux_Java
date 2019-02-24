package Lecture7;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countMazePath(2, 2, 0, 0));
		System.out.println(getMazePath(2, 2, 0, 0));
		printMazePath(2, 2, 0, 0, "");

		boolean[][] board = new boolean[5][5];
		System.out.println(countNQueens(board, 0));
	}

	public static int countMazePath(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		int count = 0;
		count = count + countMazePath(er, ec, cr, cc + 1);
		count = count + countMazePath(er, ec, cr + 1, cc);

		return count;
	}

	public static ArrayList<String> getMazePath(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		ArrayList<String> hResult = getMazePath(er, ec, cr, cc + 1);
		ArrayList<String> vResult = getMazePath(er, ec, cr + 1, cc);
		ArrayList<String> myResult = new ArrayList<>();
		for (int i = 0; i < hResult.size(); i++) {
			myResult.add("H" + hResult.get(i));
		}
		for (int i = 0; i < vResult.size(); i++) {
			myResult.add("V" + vResult.get(i));
		}

		return myResult;
	}

	public static void printMazePath(int er, int ec, int cr, int cc, String path) {
		if (er == cr && ec == cc) {
			System.out.println(path);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}
		printMazePath(er, ec, cr, cc + 1, path + "H");
		printMazePath(er, ec, cr + 1, cc, path + "V");
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board[row].length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

}
