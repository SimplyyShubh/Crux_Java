package Lecture1;

public class PrintReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5431;
		while(n!=0){
			int rem=n%10;
			System.out.print(rem);
			n=n/10;
		}
	}

}
