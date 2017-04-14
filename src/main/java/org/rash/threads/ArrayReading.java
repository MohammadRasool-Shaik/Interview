/**
 * 
 */
package org.rash.threads;

import java.util.Arrays;

/**
 * @author Ammi
 */
public class ArrayReading extends Thread {

	boolean isEven;
	char arr[];

	public ArrayReading(String name, boolean b, char[] arr) {
		super(name);
		isEven = b;
		this.arr = arr;
	}

	public void run() {
		if (isEven) {
			even();
		} else {
			odd();
		}
	}

	private void even() {
		for (int i = 0; i < 26; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " " + arr[i]);
				try {
					sleep(2000);
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		}
	}

	private void odd() {
		for (int i = 0; i < 26; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + " " + arr[i]);
				try {
					sleep(2000);
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		}
	}

	public static void main(String[] args) {
		char arr[] = new char[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = (char) (i + 65);
		}
		System.out.println(Arrays.toString(arr));
		ArrayReading to1 = new ArrayReading("Thread1", true, arr);
		ArrayReading to2 = new ArrayReading("Thread2", false, arr);
		// to1.start();
		// to2.start();

		int a[] = { 1, 0, 3, 0, 6, 2 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] < a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
			if (a[a.length - 1] > 0)
				break;
		}

		System.out.println(Arrays.toString(a));
	}
}