/**
 * 
 */
package org.rash.exception;

/**
 * @author Ammi
 */
public class MyException {
	
	static int test(int a, int b) {
		int m;
		try {
			m = b / a;
			return m;
		} catch (Exception e) {
			System.out.println("toi ");
			if (e instanceof ArithmeticException)
				System.exit(0);
			return 5;
		} finally {
			System.out.println("Rasool ");
		}
	}

	public static void main(String arg[]) {
		int i = -1;
		Parent c = new Child();
		System.out.println(c.a);
		c.methodOne();
		if (i < 0) {
			try {
				throw new NegativeAgeException(i);
			} catch (NegativeAgeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable t) {

			}
		}
	}
	
	protected void methodOne(){
		
	}

}

class Parent {
	int a = 10;

	public void methodOne(){
		System.out.println("parent methodOne");
	}
}

class Child extends Parent {
	int a = 20;

	public void methodOne() {
		System.out.println("Chi methodOne");
	}
}

class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String msg) {
		System.out.println("sub class exception");
	}
}

class NegativeAgeException extends Exception {
	int age;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6680653639178534044L;

	public NegativeAgeException(int age) {
		this.age = age;
	}

	@Override
	public String toString() {

		return "Age can not be negative " + age;
	}

}
