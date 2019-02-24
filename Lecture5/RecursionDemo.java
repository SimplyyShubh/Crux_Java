package Lecture5;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PD(5);
		// PI(5);
		// PDI(5);
		// PDISkip(5);
		System.out.println(fact(5));
		System.out.println(power(2, 5));
		System.out.println(fib(10));

		int[] arr = { 8, 6, 2, 3, 2, 2, 1 };
		System.out.println(find(arr, 0, 28));
		System.out.println(isSorted(arr, 0));
		System.out.println(lastIndex(arr, 0, 2));
		System.out.println("******************************");
		int[] result = allIndices(arr, 0, 2, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		pattern(5, 1, 1);

	}

	public static void PD(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		PD(num - 1);
	}

	public static void PI(int num) {
		if (num == 0) {
			return;
		}

		PI(num - 1);
		System.out.println(num);
	}

	public static void PDI(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		PDI(num - 1);
		System.out.println(num);
	}

	public static void PDISkip(int num) {
		if (num == 0) {
			return;
		}
		if (num % 2 != 0) {
			System.out.println(num);
		}
		PDISkip(num - 1);
		if (num % 2 == 0) {
			System.out.println(num);
		}
	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		int fnm1 = fact(n - 1);
		int fn = n * fnm1;
		return fn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pnm1 = power(2, n - 1);
		int pn = x * pnm1;
		return pn;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		return fibn;
	}

	public static int find(int[] arr, int si, int num) {
		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == num) {
			return si;
		} else {
			int x = find(arr, si + 1, num);
			return x;
		}
	}

	public static boolean isSorted(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}
		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			return isSorted(arr, si + 1);
		}
	}

	public static int lastIndex(int[] arr, int si, int num) {
		if (arr.length == si) {
			return -1;
		}
		int index = lastIndex(arr, si + 1, num);
		if (index != -1) {
			return index;
		} else {
			if (arr[si] == num) {
				return si;
			} else {
				return index;
			}
		}
	}

	public static int[] allIndices(int[] arr, int si, int num, int count) {
		if (si == arr.length) {
			return new int[count];
		}
		int[] indices = null;
		if (arr[si] == num) {
			indices = allIndices(arr, si + 1, num, count + 1);
		} else {
			indices = allIndices(arr, si + 1, num, count);
		}

		if (arr[si] == num) {
			indices[count] = si;
		}

		return indices;

	}

	public static void pattern(int N, int row, int col) {
		if (row > N) {
			return;
		}
		if (col > row) {
			System.out.println();
			pattern(N, row + 1, 1);
			return;
		}
		System.out.print("*\t");
		pattern(N, row, col + 1);
	}

}
