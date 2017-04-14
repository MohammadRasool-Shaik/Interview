package org.rash.exception;

public class Interview {

	public static void interview(Object obj) {
		System.out.println("Object");
	}

	public static void interview(ArithmeticException obj) {
		System.out.println("ArithmeticException");
	}

	public static void interview(RuntimeException obj) {
		System.out.println("Exception");
	}

	
	/*public static void interview(String str){
		System.out.println("String");
	}*/
	public static void main(String args[]) {
		interview(null);
	}
}
