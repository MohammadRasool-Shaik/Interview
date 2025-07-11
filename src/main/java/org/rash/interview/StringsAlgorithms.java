package org.rash.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsAlgorithms {

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static boolean vowelOrNot(char c) {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        if (characters.contains('c')) {
            return true;
        }
        char ch = Character.toLowerCase(c);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    public static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static String reverseString(String str) {
        char[] m = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            char t = m[i];
            m[i] = m[j];
            m[j] = t;
        }
        return new String(m);
    }

    public static boolean isPalindrome(String str) {
        return reverseString(str).equals(str);
    }

    public static boolean isPalindromeUsingStringBuilder(String str) {
        StringBuilder b = new StringBuilder(str);
        for (int i = 0, j = b.length() - 1; i <= j; i++, j--) {
            char t = b.charAt(i);
            b.setCharAt(i, b.charAt(j));
            b.setCharAt(j, t);
        }
        return b.toString().equalsIgnoreCase(str);
    }

    // if string length is even, optimized code
    public static boolean isPalindromeBinarySearch(String str) {
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

    public static boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true; // An empty string or null can be considered a palindrome
        }

        // Using a HashMap to store character frequencies
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : charCounts.values()) {
            if (count % 2 != 0) { // If the count is odd
                oddCount++;
            }
        }

        // A palindrome can be formed if at most one character has an odd count
        return oddCount <= 1;
    }

    // Optimized version for ASCII characters using an array
    public static boolean canPermutePalindromeOptimized(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // Assuming ASCII characters (0-127). For extended ASCII or Unicode,
        // a HashMap is more appropriate or a larger array.
        int[] charCounts = new int[256];
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }

        int oddCount = 0;
        for (int count : charCounts) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // A palindrome can be formed if at most one character has an odd count
        return oddCount <= 1;
    }

    //Input: Hello World output: ollH dlroW
    public static String reverseStringWords(String str) {
        return Arrays.stream(str.split("\\s+")).map(StringsAlgorithms::reverseString).collect(Collectors.joining(" "));
    }

    //Input: Hello World output: World Hello
    public static String reverseWords(String str) {
        String[] words = str.split("\\s+");
        StringBuilder tempString = new StringBuilder();
        for (int i = (words.length - 1); i > 0; i--) {
            tempString.append(words[i]).append(" ");
        }
        return tempString.toString().trim();
    }

    //Input: Hello World output: World Hello
    public String reverseWordsTokenizer(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str);
        StringBuilder builder = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            builder.insert(0, tokenizer.nextToken() + " ");
        }
        return builder.toString().trim();
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

    // sort characters in a string
    private static String anagramKey(String word) {
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isAnagram(String str, String str1) {
        System.out.println(str + " " + str1);
        String sortStr1 = sortStringBasedOnCharacters(str);
        String sortStr2 = sortStringBasedOnCharacters(str1);
        System.out.println(sortStr1 + " " + sortStr2);
        return sortStr1.equals(sortStr2);
    }

    public static void groupAnagrams(String[] args) {
        HashMap<String, List<String>> matchMap = new HashMap<>();
        for (String word : args) {
            String key = anagramKey(word);
            if (!matchMap.containsKey(key)) {
                matchMap.put(key, new ArrayList<String>());
            }
            matchMap.get(key).add(word);
        }
        System.out.println(matchMap);
    }

    public String frequencyOfCharactersInStringUsingCollections(String str) {
        Map<Character, Integer> x = new HashMap<>();
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

    public static void frequencyOfCharactersInStringUsingStreams(String str) {
        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + " " + v));
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

    public void frequencyOfWords(String myString) {
        Map<String, Long> collect = Arrays.stream(myString.split("\\s+")).filter(Objects::nonNull).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public void frequencyOfWordsInStringWOTUsingCollections() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the sentence");
        String st = br.readLine();
        String arr[] = new String[st.length()];
        String[] words = new String[st.length()];
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
    }

    public static void frequencyOfWordsInFileUsingStreams(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            Map<String, Long> myMap = lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+"))) // Split lines into words
                    .filter(word -> !word.isEmpty()) // Filter out empty strings
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Collect words into a map and count their occurrences

            myMap.forEach((key, value) -> System.out.println(key + " " + value));
        }
    }

    public void frequencyOfWordsInFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        for (String readLine = br.readLine(); readLine != null; readLine = br.readLine()) {
            String[] words = readLine.split("\\s+");
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

    public static char firstNonRepeatableCharacterC(String str) {

        Map<Character, Integer> firstNonRepeatableCharacter = new HashMap<>();

        for (Character c : str.toCharArray()) {
            if (firstNonRepeatableCharacter.containsKey(c)) {
                firstNonRepeatableCharacter.put(c, firstNonRepeatableCharacter.get(c) + 1);
            } else {
                firstNonRepeatableCharacter.put(c, 1);
            }
        }

        for (Character c : str.toCharArray())
            if (firstNonRepeatableCharacter.get(c) > 1)
                return c;

        return '\u0000';
    }

    public static char firstNonRepeatableCharacterDS(String str) {
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

    public static void uniqueCharacters(String str) {
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

    public static void duplicateChars(String str) {
        Map<Character, Integer> count = new HashMap<>();
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

    public static String duplicateCharacters(String str) {
        StringBuilder duplicateString = new StringBuilder();
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

    public static String removeDuplicateCharacter(String str) {
        Set<Character> t = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            t.add(c);
        }
        StringBuilder s = new StringBuilder();

        t.forEach(s::append);
        return s.toString();
    }

    public static String removeDuplicateWords(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        Set<String> rw = new LinkedHashSet<>(Arrays.asList(words));

        rw.forEach(s -> sb.append(s).append(" "));
        return sb.toString().trim();
    }

    public static String removeDuplicateWordsDS(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[j] != null && words[i].equalsIgnoreCase(words[j]))
                    copyArray(words, j);

        for (String word : words)
            if (word != null)
                sb.append(word).append(" ");
        return sb.toString().trim();
    }

    public static String removeSpecificChar(String str, char c) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : str.toCharArray())
            if (ch != c)
                sb.append(c);
        //OR
        str.chars().mapToObj(x -> (char) x).filter(x -> x != c).forEach(sb::append);
        return sb.toString();
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

    public static void main(String[] args) {

        frequencyOfCharactersInAString("Hello World");
        String[] x = {"apple", "apple", "banana", "apple", "orange", "banana", "papaya"};

        Map<Character, Long> collect = Arrays.stream(x).collect(Collectors.groupingBy(m -> m.charAt(0), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + " " + v));

        StringBuilder sb = new StringBuilder();
        sb.append("madams");
        System.out.println(sb);
        System.out.println(sb.reverse());
        System.out.println(isPalindrome("madams"));
        String s1 = "xxx";
        // String s2 = "ABC";
        System.out.println("\nString " + s1 + ":\nPermutations: " + possiblePermutations(s1));
        // System.out.println("\nString " + s2 + ":\nPermutations: " + crunchifyPermutation(s2));
    }

    public static class Interview {

        public static void interview(String obj) {
            System.out.println("String");
        }

        public static void interview(double d) {
            System.out.println("double");
        }

        public static void interview(int i) {
            System.out.println("int");
        }

        public static void interview(Integer in) {
            System.out.println("Integer");
        }

        public static void interview(Object obj) {
            System.out.println("Object");
        }


        public static void main(String args[]) {
//            interview(null);
            interview(3);
            if (null == null) {
                System.out.println("true");
            }
        }
    }

    public static void election(String[] names) {
//         names = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice", "David", "Bob", "Alice"};

        Optional<Entry<String, Long>> winner = Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Entry.comparingByValue());
        winner.ifPresent(entry -> {
            System.out.println("Winner: " + entry.getKey());
            System.out.println("Votes: " + entry.getValue());
        });

        //OR
        Map<String, Long> collect = Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Entry<String, Long>> sortedList = collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toList());

        Optional<Entry<String, Long>> first = sortedList.stream().findFirst();

        first.ifPresent(entry -> {
            System.out.println("Winner: " + entry.getKey());
            System.out.println("Votes: " + entry.getValue());
        });
    }

    //Real String algo==============================

    //LCS (Longest Common Sub-sequence https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/)

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
            if (palindrome != null && palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            // even cases like 1221
            palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome != null && palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
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
        Set<String> perm = new HashSet<>();
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

    public static List<String> possiblePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            result.add("");
            return result;
        }

        char firstChar = str.charAt(0);
        String rem = str.substring(1);
        List<String> words = possiblePermutations(rem);
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                result.add(permutation(newString, firstChar, i));
            }
        }
        return result;
    }

    public static String permutation(String str, char c, int i) {
        String first = str.substring(0, i);
        String last = str.substring(i);
        return first + c + last;
    }

}