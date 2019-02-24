package Lecture4;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		printAllChars(str);
		System.out.println("****************");
		printSS(str);
		System.out.println("****************");
		System.out.println(toggleCase(str));
	}

	public static void printAllChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	public static void printSS(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static String toggleCase(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (cc >= 97 && cc <= 122) {
				char tbi = (char) (cc - 32);
				sb.append(tbi);
			} else {
				char tbi = (char) (cc + 32);
				sb.append(tbi);
			}
		}

		return sb.toString();
	}

}
