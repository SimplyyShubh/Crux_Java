package Lecture6;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSS("abc"));
		System.out.println(getSSWAscii("ab"));
		System.out.println(getPermuations("abc"));
		System.out.println(getBoardPath(10, 0));

		printSS("abc", "");
		printSSWAscii("ab", "");
		printPermutations("abc", "");
		printBoardPath(10, 0, "");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getSS(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myResult.add(recResult.get(i));
			myResult.add(cc + recResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getSSWAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getSSWAscii(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myResult.add(recResult.get(i));
			myResult.add(cc + recResult.get(i));
			myResult.add((int) cc + recResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getPermuations(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getPermuations(ros);
		for (int i = 0; i < recResult.size(); i++) {
			String recString = recResult.get(i);
			for (int j = 0; j <= recString.length(); j++) {
				String mystring = recString.substring(0, j) + cc + recString.substring(j);
				myResult.add(mystring);
			}
		}
		return myResult;

	}

	public static ArrayList<String> getBoardPath(int end, int curr) {
		if (curr == end) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		if (curr > end) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = null;

		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPath(end, curr + dice);
			for (int j = 0; j < recResult.size(); j++) {
				myResult.add(dice + recResult.get(j));
			}
		}
		return myResult;
	}

	public static void printSS(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, result);
		printSS(ros, result + cc);
	}

	public static void printSSWAscii(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSSWAscii(ros, result);
		printSSWAscii(ros, result + cc);
		printSSWAscii(ros, result + (int) cc);
	}

	public static void printPermutations(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, result + cc);
		}

	}

	public static void printBoardPath(int end, int curr, String path) {
		if (curr == end) {
			System.out.println(path);
			return;
		}
		if (curr > end) {
			return;
		}
		for(int dice=1;dice<=6;dice++){
			printBoardPath(end, curr+dice, path+dice);
		}
	}

}
