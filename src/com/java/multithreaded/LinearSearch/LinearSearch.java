package com.java.multithreaded.LinearSearch;
import java.util.Scanner;

public class LinearSearch implements Runnable {

	private int startIndex, endIndex;
	private static int nElements, key, myArray [];
	private boolean flag;
	private String thName;
	public static Scanner scanner = new Scanner(System.in);
	
	public LinearSearch(int startIndex, int endIndex, String thName) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.thName = thName;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public static void setValues() {
		System.out.println("Enter the " + nElements + " elements ");
		myArray = new int[nElements];
		for(int i = 0; i<nElements; i++) {
			myArray[i] = scanner.nextInt();
		}
		
		System.out.println("Enter the key");
		key = scanner.nextInt();
	}
	
	public static void getValues() {
		System.out.println("Entered " + nElements + " elements are ");
		for(int i = 0; i<nElements; i++) {
			System.out.println(myArray[i]);
		}
		
		
	}
	
	@Override
	public void run() {
		for(int i = startIndex; i<=endIndex; i++) {
			if(key == myArray[i]) {
				System.out.println("Search is successful by " + thName);
				flag = true;
				return;
			}
		}
		if(flag == false) {
			System.out.println("Search is unsuccessful by " + thName);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number of elements ");
		nElements = scanner.nextInt();
		setValues();
		getValues();

		new LinearSearch(0, (nElements/2)-1, "Thread 1");
		new LinearSearch(nElements/2, nElements-1, "Thread 2");
		
	}
}
