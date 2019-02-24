package Lecture3;

import java.util.ArrayList;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		// System.out.println(arr);

		arr = new int[5];

		// System.out.println(arr[0]);
		// System.out.println(arr[1]);
		//
		// System.out.println(arr.length);
		//
		// arr[0] = 10;
		// System.out.println(arr[0]);

		// System.out.println(arr[arr.length]);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * 10;
		}
		System.out.println("********************");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// Part swap
		int i = 0, j = 2;
		System.out.println(arr[i] + "," + arr[j]);
		Swap(arr, i, j);
		System.out.println(arr[i] + "," + arr[j]);
		
		
		
		//ArrayList
		ArrayList<Integer> list=new ArrayList<>();
		System.out.println(list.size());
		list.add(10);
		list.add(20);
		System.out.println(list);
		System.out.println(list.size());
		
		list.add(30);
		System.out.println(list);
		System.out.println(list.size());
		list.set(0, 50);
		System.out.println(list);
		System.out.println(list.size());

	}

	public static void Swap(int[] arr, int i, int j) {
		int[] myarr = new int[5];
		for (int k = 0; k < myarr.length; k++) {
			myarr[k] = k * 10;
		}
		System.out.println(myarr[i] + "," + myarr[j]);
		int temp = myarr[i];
		myarr[i] = myarr[j];
		myarr[j] = temp;
		System.out.println(myarr[i] + "," + myarr[j]);
	    myarr=arr;
	    temp = myarr[i];
		myarr[i] = myarr[j];
		myarr[j] = temp;
		
	}

}
