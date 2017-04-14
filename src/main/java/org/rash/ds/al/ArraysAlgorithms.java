/**
 * 
 */
package org.rash.ds.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ammi
 */
public class ArraysAlgorithms {

	public void add(int... vars) {
		int sum = 0;
		for (int var : vars) {
			sum += var;
		}
		System.out.println(sum);
	}

	public static int sizeOfArray(int[] a) {
		int size = 0;
		for (int i = 0; i < a.length && a[i] > 0; i++)
			size++;
		return size;
	}

	public static int[] insertAnElement(int[] a, int e) {
		int i;
		for (i = 0; i < a.length; i++)
			if (a[i] == 0)
				break;
		a[i] = e;
		return a;
	}

	// insert an element at nth position from last
	public static int[] insertAnElement(int[] a, int e, int p) {

		int sizeOfArray = sizeOfArray(a);
		for (int i = sizeOfArray; i >= p; i--)
			a[i + 1] = a[i];
		a[p] = e;
		for (int i = 0; i < sizeOfArray + 1; i++)
			System.out.println(a[i]);
		return a;
	}

	public static int[] removeAnElement(int[] a, int e) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == e)
				copyArray(a, i);
		}
		return a;
	}

	public static void copyArray(int[] a, int index) {
		for (int i = index; i < a.length - 1; i++)
			a[i] = a[i + 1];
		a[a.length - 1] = 0;
	}

	public static int[] reverseArray(int[] a) {
		for (int i = 0, j = a.length - 1; i <= j; i++, j--) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		return a;
	}

	public static boolean pallindrome(int[] a) {
		return false;
	}

	public static int[][] createMatrix() {
		int[][] a = new int[3][3];
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = ++c;
			}
		}
		return a;
	}

	public static void displayMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] additionOfMatrices(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	public static void findLargeAndSamllestNumbers(int[] a) {
		int l = a[0], s = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > l)
				l = a[i];
			if (a[i] < s)
				s = a[i];
		}
		System.out.println("Largest Number: " + l + " Smallest Number: " + s);
	}

	public static int linearSearch(int[] a, int e) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == e)
				return i;
		}
		return -1;
	}

	public static int binarySearch(int[] a, int e) {
		int[] s = SortingAlgorithms.insertionSort(a);
		int l = 0, u = s.length - 1;
		int m = s[0];
		while (l <= u) {
			m = (u + l) / 2;
			if (s[m] < e) {
				l = m + 1;
			} else if (s[m] > e) {
				u = m - 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	public static int[] removeDuplicates(int[] numbersWithDuplicates) {

		// Sorting array to bring duplicates together
		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];
		int previous = numbersWithDuplicates[0];
		result[0] = previous;

		for (int i = 1, j = 1; i < numbersWithDuplicates.length; i++) {
			int ch = numbersWithDuplicates[i];

			if (previous != ch) {
				result[j] = ch;
				j++;
			}
			previous = ch;
		}
		return result;

	}

	public static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

	/* missingNumber takes array and size of array as arguments */
	public static int missingNumber(int a[], int n) {
		int sum = Arrays.stream(a).sum();
		int mysum = (n * (n + 1)) / 2;
		return mysum - sum;
	}

	public static int[] intersectionDS(int[] a, int[] b) {
		Arrays.sort(a);
		int[] intersection = new int[a.length];
		for (int i = 0, j = 0; i < b.length; i++) {
			if (Arrays.binarySearch(a, b[i]) >= 0) {
				intersection[j] = b[i];
				j++;
			}
		}
		return intersection;
	}

	public static Integer[] intersectionCollections(int[] a, int[] b) {
		Set<Integer> a1 = new HashSet<>();
		List<Integer> intersection = new ArrayList<>();
		Arrays.stream(a).forEach(a1::add);
		Arrays.stream(b).filter(a1::contains).forEach(intersection::add);
		return intersection.toArray(new Integer[intersection.size()]);
	}

	// Both arrays doesn't have duplicates
	public static int[] unionDS(int[] a, int[] b) {
		int[] union = new int[a.length + b.length];
		System.arraycopy(a, 0, union, 0, a.length);
		Arrays.sort(a);
		for (int i = 0, j = a.length; i < b.length; i++) {
			if (Arrays.binarySearch(a, b[i]) < 0) {
				union[j] = b[i];
				j++;
			}
		}
		return union;
	}

	public static Integer[] unionC(int[] a, int[] b) {
		Set<Integer> union = new HashSet<>();
		Arrays.stream(a).forEach(union::add);
		Arrays.stream(b).forEach(union::add);
		// or
		// Set<Integer> union = Arrays.stream(new Integer[] { 4, 5, 7, 3, 1, 2
		// }).collect(Collectors.toSet());

		// Arrays.stream(new Integer[] { 6, 8, 9
		// }).collect(Collectors.toCollection(() -> union));

		return union.toArray(new Integer[union.size()]);
	}

	// Time complexity of this solution is O(n1 + n2 + n3) where n1, n2 and n3
	// are sizes of a[],
	// b[] and c[] respectively
	public static int[] commonElements(int[] a, int[] b, int[] c) {
		int[] temp = Arrays.stream(intersectionCollections(a, b)).mapToInt(Integer::intValue).toArray();
		int[] inter = Arrays.stream(intersectionCollections(temp, c)).mapToInt(Integer::intValue).toArray();
		return inter;
	}

	public static void topTwoNumbers(int[] numbers) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int number : numbers) {
			if (number > max1) {
				max2 = max1;
				max1 = number;
			} else if (number > max2) {
				max2 = number;
			}
		}
		System.out.println(max1 + " " + max2);
	}

	public static int[] mergeSortedArrays(int[] a, int[] b) {
		int[] r = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		for (; i < a.length && j < b.length; k++) {
			if (a[i] < b[j]) {
				r[k] = a[i];
				i++;
			} else {
				r[k] = b[j];
				j++;
			}
		}
		if (i < a.length)
			System.arraycopy(a, i, r, k, a.length - i);
		if (j < b.length)
			System.arraycopy(b, j, r, k, b.length - j);
		return r;
	}

	// O(n2)
	public static int firstRepeatableElement(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i != j && a[i] == a[j]) {
					return a[i];
				}
			}
		}
		return 0;
	}

	public static int firstRepeatableElementDS(int[] a) {
		for (int e : a) {
			if (findOccurences(a, e) > 1)
				return e;
		}
		return 0;
	}

	// O(n)
	public static int firstRepeatableElementCollections(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int min = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			// If element is already in hash set, update min
			if (set.contains(arr[i]))
				min = i;
			else // Else add element to hash set
				set.add(arr[i]);
		}
		// Print the result
		if (min != -1)
			return arr[min];
		else
			return 0;

	}

	// O(n)
	public static int firstRepeatableElementC(Integer[] a) {
		Map<Integer, Long> collect = Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return Arrays.stream(a).filter(e -> collect.get(e) > 1).findFirst().get();
	}

	// find frequency Of An Element in an array
	// O(log n)
	public static int findOccurences(int a[], int e) {
		Arrays.sort(a);
		int firstOccurence = findFirstOccurence(a, e, 0, a.length - 1);
		if (firstOccurence < 0) {
			return firstOccurence;
		}
		int lastOccurence = findLastOccurence(a, e, firstOccurence, a.length - 1);
		return lastOccurence - firstOccurence + 1;
	}

	private static int findFirstOccurence(int[] a, int e, int start, int end) {
		if (end >= start) {
			int mid = (start + end) / 2;
			if ((mid == 0 || a[mid - 1] < e) && a[mid] == e) {
				return mid;
			} else if (a[mid] < e) {
				return findFirstOccurence(a, e, mid + 1, end);
			} else {
				return findFirstOccurence(a, e, start, mid - 1);
			}
		} else

			return -1;

	}

	private static int findLastOccurence(int[] a, int e, int start, int end) {
		if (end >= start) {
			int mid = (start + end) / 2;
			if ((mid == a.length - 1 || a[mid + 1] > e) && a[mid] == e) {
				return mid;
			} else if (a[mid] > e) {
				return findLastOccurence(a, e, start, mid - 1);
			} else {
				return findLastOccurence(a, e, mid + 1, end);
			}
		} else
			return -1;
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

	// Sub-Arrays Questions
	// O(n2)
	public static void pairsNumberSum(int[] a, int sum) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int temp = a[i] + a[j];
				if (sum == temp)
					System.out.println(a[i] + " " + a[j]);
			}
		}
	}

	// O(nlogn) if array is already sorted O(logn)
	public static void pairsNumberSumDS(int[] a, int num) {
		Arrays.sort(a);
		for (int i = 0, t = 0; i < a.length; i++) {
			if (a[i] > num)
				t = a[i] - num;
			else if (a[i] < num)
				t = num - a[i];
			else
				t = 0;
			if (Arrays.binarySearch(a, t) > -1)
				System.out.println(a[i] + " " + t);
		}
	}

	// O(nlogn) if array is already sorted O(n)
	public static void pairsNumberSumDSS(int[] a, int num) {
		Arrays.sort(a);
		int l = 0;
		int h = a.length - 1;
		while (l < h) {
			int s = a[l] + a[h];
			if (s == num) {
				System.out.println(a[l] + " " + a[h]);
				l++;
				h--;
			} else if (s < num) {
				l++;
			} else if (s > num) {
				h--;
			}

		}
	}

	// O(n)
	public static void pairsNumberSumC(int[] array, int num) {
		Set<Integer> mySet = new HashSet<>();

		for (int e : array) {
			int t = num - e;
			if (!mySet.contains(t)) {
				mySet.add(e);
			} else {
				System.out.printf("%d , %d", e, t);
			}
		}
	}

	// find and print its number of negative subarrays on a new line.
	public static void CountOfNegativeSubarrays(int[] a) {
		// int[] a = new int[] { 1, -2, 4, -5, 1 };
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

	// http://javarevisited.blogspot.in/2015/06/top-20-array-interview-questions-and-answers.html
	// How to find the smallest positive integer value that cannot be represented as sum of any subset of a given array?
	// How to find if there is a sub array with sum equal to zero?
	// How to find sub array with maximum sum in an array of positive and negative number And
	// How to find sub array with largest product in array of both positive and negative number?
	// Write a program to find length of longest consecutive sequence in array of integers?

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int[] a = new int[4];
		int[] b = new int[4];
		while ((s = in.readLine()) != null) {
			String[] array = s.split(" ");
			for (int i = 0, j = 0, k = 0; i < 8; i++) {
				if (i < 4) {
					a[j] = Integer.parseInt(array[i]);
					j++;
				} else {
					b[k] = Integer.parseInt(array[i]);
					k++;
				}
			}
			System.out.println(isRectaclesOverlaps(a, b));
		}
	}

	/**
	 * @param a
	 * @param b
	 */
	public static boolean isRectaclesOverlaps(int[] a, int[] b) {
		Point l1 = new Point(a[0], a[1]);
		Point r1 = new Point(a[0] + a[2], a[1] + a[3]);
		Point l2 = new Point(b[0], b[1]);
		Point r2 = new Point(b[0] + b[2], b[1] + b[3]);
		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}

		if (l1.y > r2.y || l2.y > r1.y) {
			return false;
		}
		return true;
	}

	static class Point {
		int x;
		int y;

		/**
		 * @param x
		 * @param y
		 */
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
