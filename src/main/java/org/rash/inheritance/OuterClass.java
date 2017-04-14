package org.rash.inheritance;

/**
 * @author mshai9
 *
 */
public class OuterClass {
	

	public class InnerClass {

		private int t;

		public InnerClass() {

		}

		public InnerClass(int t) {
			this.t = t;
		}

		private void iMethodOne() {
			test();
			sTest();
		}

		/**
		 * @return the t
		 */
		public int getT() {
			return t;
		}

		/**
		 * @param t
		 *            the t to set
		 */
		public void setT(int t) {
			this.t = t;
		}

	}

	private static class StaticInnerClass {
		private int x;

		public StaticInnerClass(int x) {
			this.x = x;
		}

		private void sMethodOne() {
			sTest();
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x
		 *            the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

	}

	public static void sTest() {
		System.out.println("sTest");
	}

	public void test() {
		System.out.println("Test");
		StaticInnerClass t = new StaticInnerClass(1);
		t.sMethodOne();

		OuterClass o = new OuterClass();
		OuterClass.InnerClass i = o.new InnerClass();
		i.iMethodOne();
	}

}
