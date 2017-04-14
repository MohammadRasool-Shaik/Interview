/**
 * 
 */
package org.rash.exception;

/**
 * @author Ammi
 *
 */
public class MyExceptionOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int x = 5 / 0;
			System.out.println("temp");
		} finally {
			System.out.println("finally");
		}
		System.out.println("done");
	}

	public static class ExceptionTest {
		static class TestException extends Exception {
		}

		public static void test() throws TestException /* Point X */
		{
			throw new TestException();
		}

		public static void main(String[] args) {
			
		}
	}
}
