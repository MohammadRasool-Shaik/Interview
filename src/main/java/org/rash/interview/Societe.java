/**
 * 
 */
package org.rash.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Admin
 */
public class Societe {
	public static String concat(String[] strings) {
		StringBuilder sb = new StringBuilder();
		for (String str : strings)
			sb.append(str);
		return sb.toString();
	}

	public static boolean sum(int i, int j) {
		if ((i == 1 || j == 1) || i + j == 1)
			return true;
		return false;
	}

	public static void a() {
		// s.setConnection();
		// try{
		// s.execute();
		// c.commit();
		// }catch(Exception e){
		// c.rollback();
		// e.printStackTrace();
		// }finally{
		// c.close();
		// }
	}

	public static int sumRange(int[] ints) {
		int sum = 0;
		for (int i = 1; i < ints.length; i++) {
			int n = ints[i];
			if (n >= 10 && n <= 100)
				sum += n;
		}
		return sum;
	}

	public static boolean check(String str) {
		if (str != null && !str.isEmpty()) {
			Map<Character, Character> map = new HashMap<>();
			map.put('(', ')');
			map.put('[', ']');
			Stack<Character> stack = new Stack<>();
			for (char ch : str.toCharArray()) {
				if (map.containsKey(ch)) {
					stack.push(ch);
				} else if (map.containsValue(ch)) {
					if (!stack.empty() && map.get(stack.peek()) == ch) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
			return stack.empty();
		}
		return false;
	}

	public static boolean checkIfBalanced(String str) {
		char[] inputChar = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char ch : inputChar) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (stack.empty() || ((ch == ')') && stack.pop() != '(') || (ch == ']' && stack.pop() != '[') || (ch == '}' && stack.pop() != '{')) {
				return false;
			}
		}
		return stack.empty();
	}

	public static void checkIfBalance(String input) {
		Stack<Character> stack = new Stack<>();
		for (char ch : input.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (stack.empty() || (ch == ')' && stack.pop() != '(') || (ch == ']' && stack.pop() != '[') || (ch == '}' && stack.pop() != '{')) {
				System.out.println("false");
				return;
			}
		}
		if (stack.empty()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	// find and print its number of negative subarrays on a new line.
	public static void java_Subarray(String[] args) {
		int[] a = new int[] { 1, -2, 4, -5, 1 };
		int count = 0;
		for (int l = 0; l < a.length; l++) {
			for (int i = 0; i < a.length; i++) {
				int sum = 0;
				int t = i + l;
				if (t < a.length) {
					for (int j = i; j <= t; j++) {
						sum += a[j];
					}
					if (sum < 0)
						count += 1;
				}
			}
		}
		System.out.println(count);
	}

	public static int closestToZero(int[] ints) {
		if (ints != null && ints.length > 0) {
			int min = ints[0];
			int absMin = Math.abs(min);
			for (int i = 1; i < ints.length; i++) {
				int currentAbsValue = Math.abs(ints[i]);
				if (currentAbsValue < absMin) {
					absMin = currentAbsValue;
					min = ints[i];
				}
			}
			return min;
		}
		return 0;
	}

	public static int closetToZero(int[] ints) {
		if (ints != null && ints.length != 0) {
			int index = 0;
			int num = ints[index];
			for (int i = 1, absNum = Math.abs(num); i < ints.length; ++i) {
				int newAbs = Math.abs(ints[i]);
				if (newAbs < absNum) {
					index = i;
					absNum = newAbs;
					num = ints[index];
				}
			}
			return num;
		}
		return 0;
	}


}
