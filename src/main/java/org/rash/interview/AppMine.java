/**
 * 
 */
package org.rash.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * R
 * 
 * @author Ammi
 */
public class AppMine {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * for (String t : list) { System.out.println(t); if (t.equals("two"))
		 * list.add("five"); } for (String t : list) { System.out.println(t); }
		 */
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			if (next.equals("two"))
				iterator.remove();
		}
		iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

	}

}

class Tot1 {
	{
		System.out.println("three");
	}
	static {
		System.out.println("one");
	}
}

class Tot2 extends Tot1 {
	{
		System.out.println("Four");
	}
	static {
		System.out.println("two");
	}
}