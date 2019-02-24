package Lecture2;

import java.util.Scanner;

public class FunWithQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bin = 100000;
		System.out.println(bintodec(bin));
		System.out.println(dectoBin(32));
		System.out.println(AnyToDec(2, 100000));
		System.out.println(decToAny(8, 31));
		System.out.println(AnyToAny(37, 8, 2));
		System.out.println(log(32, 2));

		Scanner s = new Scanner(System.in);
		char ch=s.next().charAt(0);
		System.out.println(ch);

	}

	public static int bintodec(int bin) {
		int dec = 0;
		int twopowers = 1;
		while (bin != 0) {
			int rem = bin % 10;
			dec = dec + rem * twopowers;
			twopowers = twopowers * 2;
			bin = bin / 10;
		}
		return dec;
	}

	public static int dectoBin(int dec) {
		int tenpowers = 1;
		int bin = 0;
		while (dec != 0) {
			int rem = dec % 2;
			bin = bin + tenpowers * rem;
			tenpowers = tenpowers * 10;
			dec = dec / 2;
		}
		return bin;
	}

	public static int AnyToDec(int sb, int num) {
		int dec = 0;
		int sbpowers = 1;
		while (num != 0) {
			int rem = num % 10;
			dec = dec + rem * sbpowers;
			sbpowers = sbpowers * sb;
			num = num / 10;
		}
		return dec;
	}

	public static int decToAny(int db, int dec) {
		int tenpowers = 1;
		int ans = 0;
		while (dec != 0) {
			int rem = dec % db;
			ans = ans + tenpowers * rem;
			tenpowers = tenpowers * 10;
			dec = dec / db;
		}
		return ans;
	}

	public static int AnyToAny(int num, int sb, int db) {
		int dec = AnyToDec(sb, num);
		int ans = decToAny(db, dec);
		return ans;
	}

	public static int log(int x, int n) {
		int counter = 0;
		while (x != 1) {
			counter = counter + 1;
			x = x / n;
		}
		return counter;
	}

}
