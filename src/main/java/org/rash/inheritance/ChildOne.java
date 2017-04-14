/**
 * 
 */
package org.rash.inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Ammi
 */
class Purr extends ParentOne {
	public static void main(String args[]) {
		MyChild m = new MyChild();
	}

}

class MyParent {
	private int a;

	protected int b;
	public int c;
	int d;

	public MyParent() {

	}

	public MyParent(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void test() throws FileNotFoundException, IOException, CloneNotSupportedException {

	}
}

class MyChild extends MyParent {

	public MyChild() {
		super();

	}

	public void test() throws IOException, CloneNotSupportedException {
		this.clone();
	}
}

public class ChildOne {

	private String name;

	ChildOne(int x) {
		System.out.println("In 1 argument constructor, name = " + this.name);
	}

	ChildOne() {
		name = "prasad";
		System.out.println("In no argument constructor, name = " + this.name);
	}

	static {
		System.out.println("In first static init block ");
	}

	{
		System.out.println("In first instance init block, name = " + this.name);
	}

	{
		System.out.println("In second instance init block, name = " + this.name);
	}

	static {
		System.out.println("In second static int block ");
	}

	public static void main(String args[]) {
		new ChildOne();
		new ChildOne();
		new ChildOne(7);
	}

}