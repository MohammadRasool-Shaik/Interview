/**
 * 
 */
package org.rash.inheritance;

/**
 * @author Admin
 */
/*public interface MyInterface {
	int a=10;
	void methodOne();
	void methodTwo();
}*/
public class MyInterface{
	public int test(int a,int b){
		System.out.println("one");
		return 0;
	}
	public long test(long a,long b){
		System.out.println("two");
		return 1;
	}
	public static void main(String[] args) {
		MyInterface t=new MyInterface();
		t.test(1, 20);
	}
}
