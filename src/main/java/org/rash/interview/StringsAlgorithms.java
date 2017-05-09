package org.rash.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsAlgorithms {

	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static boolean vowelOrNot(char c) {
		char ch = Character.toLowerCase(c);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		return false;
	}

	public static String longestPalindrome(String str) {
		int max = 1;
		String longestPalindrome = null;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String substring = str.substring(i, j + 1);
				if (substring.length() > 1 && isPallindrom(substring)) {
					if (substring.length() > max) {
						longestPalindrome = substring;
						max = substring.length();
					}
				}
			}
		}
		// for (int i = 0; i < str.length(); i++) {
		// for (int j = 1; j <= str.length() - i; j++) {
		// System.out.println(str.substring(i, i + j));
		// }
		// System.out.println();
		// }
		return longestPalindrome;
	}

	public static String longestSubStringWithoutRepeatingChars(String str) {
		char[] charArray = str.toCharArray();
		String longestSubString = null;
		int longestSubStringLength = 0;
		Map<Character, Integer> subString = new LinkedHashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!subString.containsKey(ch)) {
				subString.put(ch, i);
			} else {
				i = subString.get(ch);
				subString.clear();
			}
			if (subString.size() > longestSubStringLength) {
				longestSubString = subString.keySet().toString();
				longestSubStringLength = subString.size();
			}
		}
		System.out.println("Input String " + str);
		System.out.println("Longest SubString " + longestSubString);
		System.out.println("longest SubString Length " + longestSubStringLength);
		return longestSubString;
	}

	public static boolean isAnagram(String str, String str1) {
		System.out.println(str + " " + str1);
		String sortStr1 = sortStringBasedOnCharacters(str);
		String sortStr2 = sortStringBasedOnCharacters(str1);
		System.out.println(sortStr1 + " " + sortStr2);
		return sortStr1.equals(sortStr2);
	}

	public static String sortStringBasedOnCharacters(String str) {
		return new String(insertionSort(str.toLowerCase().toCharArray()));
	}

	public static char[] insertionSort(char a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j])
					swap(a, j - 1, j);
				else
					break;
			}
		}
		return a;
	}

	public static String reverseWords(String str) {
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = words.length - 1; i <= j; i++, j--)
			swap(words, i, j);

		for (String word : words)
			sb.append(word).append(" ");
		return sb.toString().trim();
		// return Arrays.toString(words);
	}

	public static String reversewords(String str) {
		String[] words = str.split(" ");
		StringBuilder tempString = new StringBuilder();
		for (int i = (words.length - 1); i >= 0; i--) {
			tempString.append(words[i] + " ");
		}

		return tempString.toString().trim();
	}

	public String reverseWordsTokenizer(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str);
		StringBuilder builder = new StringBuilder();
		while (tokenizer.hasMoreTokens()) {
			builder.insert(0, tokenizer.nextToken() + " ");
		}
		return builder.toString().trim();
	}

	public static void swap(char[] a, int i, int j) {
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(String[] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void frequencyOfWordsInFile() throws IOException {
		FileReader fr = new FileReader("E:\\Workspace\\work.txt");
		BufferedReader br = new BufferedReader(fr);
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		for (String readLine = br.readLine(); readLine != null; readLine = br.readLine()) {
			String[] words = readLine.split(" ");
			for (String word : words) {
				if (myMap.containsKey(word)) {
					myMap.put(word, myMap.get(word) + 1);
				} else {
					myMap.put(word, 1);
				}
			}
		}

		myMap.forEach((key, value) -> System.out.println(key + " " + value));
		br.close();
		fr.close();
	}

	public static void frequencyOfWordsWOTUsingCollections(String str) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Enter the sentence");
		// String st = br.readLine();
		String arr[] = new String[str.length()];
		String[] words = new String[str.length()];
		int[] counts = new int[arr.length];
		words[0] = words[0];
		counts[0] = 1;
		for (int i = 1, j = 0; i < arr.length; i++) {
			if (words[j].equals(arr[i])) {
				counts[j]++;
			} else {
				j++;
				words[j] = arr[i];
				counts[j] = 1;
			}
		}

		System.out.println(Arrays.toString(words));
	}

	// O(n2)
	public static char firstNonRepetableCharacterDS(String str) {
		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j) && i != j) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return str.charAt(i);
		}
		return '\u0000';
	}

	public static char firstNonRepetableCharacterC(String str) {

		Map<Character, Integer> firstNonRepatableCharacter = new HashMap<Character, Integer>();

		for (Character c : str.toCharArray()) {
			if (firstNonRepatableCharacter.containsKey(c)) {
				firstNonRepatableCharacter.put(c, firstNonRepatableCharacter.get(c) + 1);
			} else {
				firstNonRepatableCharacter.put(c, 1);
			}
		}

		for (Character c : str.toCharArray())
			if (firstNonRepatableCharacter.get(c) == 1)
				return c;

		return '\u0000';
	}

	// unique Characters in a String
	public static void nonRepeatableCharachters(String str) {
		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					if (i != j) {
						flag = true;
						break;
					}
				}
			}
			if (!flag)
				System.out.println(str.charAt(i));
		}
	}

	public static String duplicateCharachters(String str) {
		StringBuffer duplicateString = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (duplicateString.indexOf(str.charAt(i) + "") > -1)
					break;
				else if (str.charAt(i) == str.charAt(j) && i != j) {
					duplicateString.append(str.charAt(i));
					break;
				}

			}
		}
		return duplicateString.toString();
	}

	public static void duplicateChars(String str) {
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		for (char t : str.toCharArray()) {
			if (count.containsKey(t)) {
				count.put(t, count.get(t) + 1);
			} else {
				count.put(t, 1);
			}
		}

		count.forEach((key, value) -> {
			if (value > 1) {
				System.out.println(key + " -->" + value);
			}
		});
	}

	public static void frequencyOfCharactersInAString(String str) {
		str = str.toLowerCase();
		int[] charCount = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				charCount[(int) (str.charAt(i) - 'a')]++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (charCount[i] != 0) {
				char t = (char) (i + 'a');
				System.out.println(t + " " + charCount[i]);
			}
		}
	}

	public static void frequencyOfCharactersInString(String str) {
		for (int i = 65; i < 90; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == (char) i || str.charAt(j) == (char) (i + 32)) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println((char) i + " " + count);
			}
		}
	}

	public void frequencyOfCharacters(String str) {
		char[] c = str.toCharArray();
		int count = 0;

		for (int i = 0; i < c.length; i++) {
			boolean flag = true;
			for (int k = 0; k < i; k++) {
				if (c[i] == (str.charAt(k)))
					flag = false;
			}
			if (flag) {
				for (int j = 0; j < str.length(); j++) {
					if (c[i] == str.charAt(j))
						count = count + 1;
				}
				System.out.println(c[i] + " " + " " + (count));
				count = 0;
			}
		}
	}

	public static String removeDuplicateCharaters(String str) {

		Set<Character> t = new LinkedHashSet<>();
		for (char c : str.toCharArray()) {
			t.add(c);
		}
		StringBuilder s = new StringBuilder();

		t.forEach(s::append);
		return s.toString();
	}

	public static String removeDuplicateChars(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(i) == sb.charAt(j) && i != j) {
					sb.deleteCharAt(j);
				}
			}
		}
		return sb.toString();
	}

	public static String removeDuplicatewords(String str) {
		String[] words = str.split(" ");
		Set<String> rw = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		for (String word : words)
			rw.add(word);

		rw.forEach(s -> sb.append(s).append(" "));
		return sb.toString().trim();
	}

	public static String removeDuplicateWordsDS(String str) {
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < words.length; i++)
			for (int j = i + 1; j < words.length; j++)
				if (words[j] != null && words[i].toLowerCase().equals(words[j].toLowerCase()))
					copyArray(words, j);

		for (String word : words)
			if (word != null)
				sb.append(word).append(" ");
		return sb.toString().trim();
	}

	public static String removeDuplicateWordsC(String str) {
		String[] words = str.split(" ");
		Set<String> rw = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		for (String word : words)
			rw.add(word);

		rw.forEach(s -> sb.append(s).append(" "));
		return sb.toString().trim();
	}

	public static String removeSpecificChar(String str, char c) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++)
			if (charArray[i] == c)
				copyArray(charArray, i);

		// StringBuffer sb = new StringBuffer(str); for (int i = 0; i <
		// charArray.length; i++) { if (charArray[i] == c) sb.deleteCharAt(i); }
		// sb.toString();

		return String.valueOf(charArray);
	}

	public static void copyArray(String[] a, int index) {
		for (int i = index; i < a.length - 1; i++)
			a[i] = a[i + 1];
		a[a.length - 1] = null;
	}

	public static void copyArray(char[] a, int index) {
		for (int i = index; i < a.length - 1; i++)
			a[i] = a[i + 1];
		a[a.length - 1] = '\u0000';
	}

	public static boolean ispallindrom(String str) {
		StringBuilder b = new StringBuilder(str);
		for (int i = 0, j = b.length() - 1; i <= j; i++, j--) {
			char t = b.charAt(i);
			b.setCharAt(i, b.charAt(j));
			b.setCharAt(j, t);
		}
		return b.toString().equalsIgnoreCase(str);

	}

	public static boolean isPallindrom(String str) {
		char[] m = str.toCharArray();
		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
			char t = m[i];
			m[i] = m[j];
			m[j] = t;
		}
		return new String(m).equals(str);
	}

	// if string length is even, optimized code
	public static boolean isPalindrome(String str) {
		if (str == null)
			return false;
		int mid = (str.length() - 1) / 2, i, j;
		if (str.length() % 2 == 0) {
			if (str.charAt(mid) != str.charAt(mid + 1)) {
				return false;
			} else {
				i = mid - 1;
				j = mid + 2;
			}
		} else {
			i = mid - 1;
			j = mid + 1;
		}

		while (i >= 0 && j < str.length()) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i--;
			j++;
		}
		if (i >= 0 || j <= str.length() - 1)
			return false;
		return true;
	}

	public String findDuplicateCharatersInString(String str) {
		Map<Character, Integer> x = new HashMap<Character, Integer>();
		for (char t : str.toCharArray()) {
			if (x.containsKey(t)) {
				x.put(t, x.get(t) + 1);
			} else {
				x.put(t, 1);
			}
		}

		for (Map.Entry<Character, Integer> m : x.entrySet()) {
			if (m.getValue() > 1) {
				System.out.println(m.getKey() + " -->" + m.getValue());
			}
		}

		return null;
	}

	public String removeDuplicatesFromString(String str) {

		Set<Character> t = new LinkedHashSet<Character>();
		for (char c : str.toCharArray()) {
			t.add(c);
		}
		StringBuilder s = new StringBuilder();
		for (Character m : t) {
			s.append(m);
		}

		/*
		 * StringBuilder b = new StringBuilder(str); for (int i = 0; i < b.length(); i++) { for (int j = i + 1; j < b.length(); j++) { if (b.charAt(i) == b.charAt(j)) {
		 * b.deleteCharAt(j); } } }
		 */

		return s.toString();
	}

	public String removeDuplicateWordsFromString(String str) {
		Set<String> s = new LinkedHashSet<String>();
		for (String t : str.split(" ")) {
			s.add(t);
		}
		StringBuilder b = new StringBuilder();
		for (String t : s) {
			b.append(t + " ");
		}
		return b.toString().trim();
	}

	public String stringPallindrom(String str) {
		StringBuilder b = new StringBuilder(str);
		for (int i = 0, j = b.length() - 1; i <= j; i++, j--) {
			char t = b.charAt(i);
			b.setCharAt(i, b.charAt(j));
			b.setCharAt(j, t);
		}
		return b.toString();

	}

	public String reverseStringWords(String str) {
		String[] words = str.split(" ");
		StringBuilder tempString = new StringBuilder();
		for (int i = (words.length - 1); i > 0; i--) {
			tempString.append(words[i] + " ");
		}
		String trim = tempString.toString().trim();
		return trim;
	}

	public static void main(int[] args) throws Throwable {

		// System.out.println(StringsAlgorithms.reverseWords("Monday Tuesday Wednesday Thursday Friday Saturday Sunday"));
		// StringsAlgorithms.frequencyOfCharactersInAString("hhaaHhhr");
		//
		// System.out.println((int) 'a' + " " + (int) 'A');

		/*
		 * t.findDuplicateCharatersInString("Java2Novice"); System.out.println(t.removeDuplicatesFromString("Java2Novice"));
		 * 
		 * System.out.println(t.removeDuplicateWordsFromString( "Twinkle Twinkle Little Star Little"));
		 * 
		 * StringBuilder b = new StringBuilder(t.stringPallindrom("MADAM"));
		 * 
		 * System.gc();
		 * 
		 * t.finalize();
		 */
	}

	public static boolean ispalindrome(String str) {
		if (str == null)
			return false;
		int mid = (str.length() - 1) / 2, i, j;
		if (str.length() % 2 == 0) {
			if (str.charAt(mid) != str.charAt(mid + 1)) {
				return false;
			} else {
				i = mid - 1;
				j = mid + 2;
			}
		} else {
			i = mid - 1;
			j = mid + 1;
		}

		while (i >= 0 && j < str.length()) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i--;
			j++;
		}
		if (i >= 0 || j <= str.length() - 1)
			return false;
		return true;
	}

	public static String intermediatePalindrome(String s, int left, int right) {
		if (left > right)
			return null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	// O(n^2)
	public static String longestPalindromeString(String s) {
		if (s == null)
			return null;

		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			// odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			// even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

	public void allPossibleCombinationofCharsinString() {

	}

	public void checkPallindromAfterShuffeling() {

	}

	public String palindromUsingLinkedList(String str) {
		// List<String> t = new LinkedList<String>();
		for (int i = str.length() - 1; i >= 0; i--) {

		}
		return null;
	}

	public static void removeDuplicatesCharacters(String str) {

	}

	public String removeSpecificCharactersFromString(String str) {
		return null;
	}

	public static void mains(String args[]) {

		String str = "This is String , split by StringTokenizer, created by mkyong";
		StringTokenizer st = new StringTokenizer(str);

		System.out.println("---- Split by space ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("---- Split by comma ',' ------");
		StringTokenizer st2 = new StringTokenizer(str, ",");

		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
	}

	public static boolean check(String str) {
		if (str != null && str.length() != 0) {
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
		Stack<Character> stack = new Stack<>();
		for (char ch : inputChar) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (stack.empty() || ((ch == ')') && stack.pop() != '(') || (ch == ']' && stack.pop() != '[') || (ch == '}' && stack.pop() != '{')) {
				return false;
			}
		}
		return stack.empty();
	}

	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	// {Rasool, Shahez, Bannu, Papi, Rasool, Papi, Bannu, Papi, Rasool }
	// Elections winner should be calcluated on above set. If 2 persons got same no.of votes, based on name(Bigger String) winner has to decide
	public static String electionJava(String[] names) {
		Map<String, Integer> myMap = new TreeMap<String, Integer>();

		for (String name : names) {
			if (myMap.containsKey(name)) {
				myMap.put(name, myMap.get(name) + 1);
			} else {
				myMap.put(name, 1);
			}
		}

		int max = 0;
		String leader = null;
		for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
			if (entry.getValue() >= max) {
				leader = entry.getKey();
				max = entry.getValue();
			}
		}
		return leader;
	}

	public static String election(String[] names) {
		Map<String, Long> collect = Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Entry<String, Long>> sortedList = collect.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).collect(Collectors.toList());

		List<Entry<String, Long>> highestVotedElector = sortedList.stream().filter(e -> e.getValue() == sortedList.get(0).getValue()).collect(Collectors.toList());

		if (highestVotedElector.size() > 1) {
			Collections.sort(highestVotedElector, Map.Entry.<String, Long> comparingByKey().reversed());
		}

		return highestVotedElector.get(0).getKey();
	}

	public static String characterCounter(String a) {
		if (a.length() < 2) {
			return a;
		}
		if (a.length() == 2) {
			if (a.charAt(0) == a.charAt(1)) {
				return a.charAt(0) + "2";
			} else {
				return a;
			}
		}
		for (int i = 0; i < a.length(); i++) {
			int c = i + 1;
			while (c < a.length() && a.charAt(c) == a.charAt(i)) {
				c++;
			}
			if (c - i != 1) {
				a = a.substring(0, i + 1) + (c - i) + a.substring(c);
				i++;
			}

		}
		return a;
	}

	// {"ABC","DBC","DDD","BCA","ACB", "BDC"} -> {{"ABC"-> "BCA","ACB"},{"DBC"->"BDC"}}
	public static void groupAnagrams(String[] args) {
		Map<String, List<String>> matchMap = new HashMap<>();
		for (String word : args) {
			String key = anagramKey(word);
			if (!matchMap.containsKey(key)) {
				matchMap.put(key, new ArrayList<String>());
			}
			matchMap.get(key).add(word);
		}
		System.out.println(matchMap);
	}

	private static final String anagramKey(String word) {
		word = word.toLowerCase();
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static Collection<String> crunchifyPermutation(String str) {
//		 List<String> crunchifyResult = new ArrayList<String>(); if need to print duplicates as well
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}

		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Collection<String> words = crunchifyPermutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				crunchifyResult.add(crunchifyCharAdd(newString, firstChar, i));
			}
		}
		return crunchifyResult;
	}

	public static String crunchifyCharAdd(String str, char c, int i) {
		String first = str.substring(0, i);
		String last = str.substring(i);
		return first + c + last;
	}

	public static void mainss(String[] args) {
		String s1 = "xxx";
		// String s2 = "ABC";
		System.out.println("\nString " + s1 + ":\nPermutations: " + crunchifyPermutation(s1));
		// System.out.println("\nString " + s2 + ":\nPermutations: " + crunchifyPermutation(s2));
	}

	public static boolean canBeTurnedIntoAPalindrome(String drome) {
		// If we've found a letter that has no match, the center letter.
		boolean centerUsed = false;
		char center = '\000';

		char c;
		int count = 0;

		// Check each letter to see if there's an even number of it.
		for (int i = 0; i < drome.length(); i++) {
			c = drome.charAt(i);
			count = 0;

			for (int j = 0; j < drome.length(); j++) {
				if (drome.charAt(j) == c)
					count++;
			}

			// If there was an odd number of those entries and the center is already used, then a palindrome is impossible, so return false.
			if (count % 2 == 1) {
				if (centerUsed && center != c)
					return false;
				else {
					centerUsed = true;
					center = c; // This is so when we encounter it again it doesn't count it as another separate center.
				}
			}
		}
		// If we made it all the way through that loop without returning false, then
		return true;
	}

	private static boolean canMakeAPalindrome(String testStr) {
		int[] frequencyArr = createFrequencyArray(testStr);

		int oddCharCount = 0;

		for (int ch : frequencyArr) {

			// Count characters with odd occurrence.
			if (ch % 2 != 0)
				oddCharCount++;

			// If more than one character in the string has odd occurrence then
			// palindrome cannot be formed from given string
			if (oddCharCount > 1)
				return false;
		}

		return true;
	}

	private static int[] createFrequencyArray(String testStr) {
		int[] frequencyArr = new int[256];

		char[] charArray = testStr.toCharArray();

		for (char ch : charArray)
			frequencyArr[ch]++;

		return frequencyArr;
	}

	public static class Interview {

		public static void interview(String obj) {
			System.out.println("String");
		}

		public static void interview(Object obj) {
			System.out.println("Object");
		}

		public static void main(int args[]) {
			interview(null);
			if (null == null) {
				System.out.println("true");
			}
		}
	}

	public static class Interviewq {

		public static void interview(String obj) {
			System.out.println("String");
		}

		public static void interview(Object obj) {
			System.out.println("Object");
		}

		public static void interview(Integer obj) {
			System.out.println("Integer");
		}

		public static void main(int args[]) {
			// interview(null);
		}
	}

}