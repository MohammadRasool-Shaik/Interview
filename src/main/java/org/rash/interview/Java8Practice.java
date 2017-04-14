/**
 * 
 */
package org.rash.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rasool.Shaik
 *
 */
public class Java8Practice {
	Function<Integer, Boolean> is_odd() {
		return (n) -> {
			if (n % 2 != 0)
				return true;
			else {
				return false;
			}
		};
	}

	Function<Integer, Boolean> is_even() {
		return (n) -> {
			if (n % 2 == 0)
				return true;
			else {
				return false;
			}
		};
	}

	Function<Integer, Boolean> is_palindrome() {
		return (n) -> {
			int sum = 0;
			for (int t = n; t > 0; t /= 10)
				sum = (sum * 10) + (t % 10);

			if (sum == n)
				return true;
			else
				return false;
		};
	}

	public static void main(int args[]) {
		List<Employee> employees = new ArrayList<Employee>();
		List<Integer> tempEmployees = new ArrayList<Integer>();

		List<Integer> t = new ArrayList<Integer>();

		for (int i = 1; i <= 100000; i++)
			t.add(i);

		employees.add(new Employee(1, "one", 30, "Male"));
		employees.add(new Employee(2, "two", 16, "Female"));
		employees.add(new Employee(3, "three", 28, "Male"));
		employees.add(new Employee(7, "seven", 36, "female"));
		employees.add(new Employee(4, "four", 14, "Male"));
		employees.add(new Employee(5, "five", 23, "Female"));
		employees.add(new Employee(6, "six", 26, "Male"));
		employees.add(new Employee(7, "seven", 27, "FeMale"));

		Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy((Employee e) -> e.getGender().toUpperCase(), Collectors.counting()));

		Stream<String> map = employees.stream().map(Employee::getEmployeeName);
		map.forEach(System.out::println);

		employees.stream().map(Employee::getAge).map((i) -> i * 10).forEach(System.out::println);

		IntSummaryStatistics sts = employees.stream().map(Employee::getAge).mapToInt((x) -> x).summaryStatistics();

		System.out.println(sts.getMin() + " " + sts.getMax() + " " + sts.getAverage());

		Long collect2 = employees.stream().collect(Collectors.counting());

		collect.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println(collect2);

		t.parallelStream().forEach((Integer e) -> tempEmployees.add(e));

		Integer a = new Integer("3");
		Integer b = 6;

		System.out.println(a + b);

	}

	public static void mainx(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		Department d1 = new Department(1, "done");
		Department d2 = new Department(2, "dtwo");
		Department d3 = new Department(3, "dthree");
		employees.add(new Employee(1, "one", 30, "Male", d1));
		employees.add(new Employee(2, "two", 16, "Female", d1));
		employees.add(new Employee(3, "three", 28, "Male", d2));
		employees.add(new Employee(7, "seven", 36, "female", d2));
		employees.add(new Employee(4, "four", 14, "Male", d3));
		employees.add(new Employee(5, "five", 23, "Female", d2));
		employees.add(new Employee(6, "six", 26, "Male", d1));
		employees.add(new Employee(7, "seven", 27, "FeMale", d1));

		// Select first_name, Last_Name from employee
		employees.stream().filter(e -> e.getAge() > 25).map(e -> {
			return e.getEmployeeName() + " " + e.getGender();
		}).forEach(System.out::println);

		// Select upper(FIRST_NAME) from EMPLOYEE
		employees.stream().filter(e -> e.getAge() > 25).map(e -> e.getEmployeeName().toUpperCase()).forEach(System.out::println);

		// select distinct DEPARTMENT from EMPLOYEE
		employees.stream().map(e -> e.getDepartment()).distinct().forEach(System.out::println);

		// Select * from employee order by FIRST_NAME desc
		employees.stream().map(e -> e.getEmployeeName().toUpperCase()).sorted(Collections.reverseOrder()).forEach(System.out::println);

		// Select * from employee order by FIRST_NAME desc
		employees.stream().map(e -> e.getEmployeeName().toUpperCase()).sorted(Collections.reverseOrder()).forEach(System.out::println);

		// Select * from employee order by FIRST_NAME asc,SALARY desc

		// select gender, from employee e group by gender
		// employees.stream().collect(Collectors.groupingBy(e->e.get));

	}

	public static void main(String[] args) {

		String[] t = { "apple", "apple", "banana", "apple", "orange", "banana", "papaya" };

		// String reduce = Arrays.stream(t).reduce("", StringBuilder::append);

		Map<String, Long> collect = Arrays.stream(t).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();
		collect.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);

		int sum = Arrays.stream(new int[] { 4, 6, 2, 3, 9 }).reduce(0, (int i, int j) -> {
			System.out.println(i + " " + j);
			return (i + j);
		});

		System.out.println(sum);

		String reduce = Arrays.stream(new String[] { "one", "two", "three", "four", "five" }).reduce("", (s1, s2) -> {
			System.out.println(s1 + " " + s2);
			return s1.concat(s2);
		});
		System.out.println(reduce);

		IntSummaryStatistics summaryStatistics = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).mapToInt(Integer::valueOf).summaryStatistics();
		System.out.println(summaryStatistics.getSum());
	}

	/**
	 * @param args
	 */
	public static void maint(String[] args) {

		List<Employee> employees = new ArrayList<>();
		Department d1 = new Department(1, "done");
		Department d2 = new Department(2, "dtwo");
		Department d3 = new Department(3, "dthree");

		employees.add(new Employee(1, "one", 24, "M", 28000.00, d1));
		employees.add(new Employee(2, "two", 26, "F", 30000.00, d2));
		employees.add(new Employee(3, "three", 28, "M", 38000.00, d2));
		employees.add(new Employee(4, "four", 24, "M", 28000.00, d3));
		employees.add(new Employee(5, "five", 25, "M", 24000.00, d1));
		employees.add(new Employee(6, "six", 23, "F", 32000.00, d2));

		/*
		 * int[] array = { 23, 43, 56, 97, 32 }; // By default start value is 0. Result will be sum of array. ArraysAlgorithms.stream(array).reduce((x, y) -> x + y).ifPresent(s ->
		 * System.out.println(s)); ArraysAlgorithms.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
		 * ArraysAlgorithms.stream(array).reduce(Java8Practice::addIntData). ifPresent(s -> System.out.println(s));
		 */

		ArrayList<Object> collect = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("m")).map(Employee::getEmployeeName).collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);
		collect.forEach(System.out::print);

		Stream<String> map = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("m")).map(Employee::getEmployeeName);

		// <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T>
		// accumulator, BiConsumer<R,R> combiner)
		ArrayList<String> collect2 = map.collect(() -> new ArrayList<>(), (c, e) -> c.add(e), (c1, c2) -> c1.addAll(c2));
		System.out.println();
		collect2.forEach(System.out::print);
	}

	public List<Employee> getEmployees(String employeeNameStartsWith) {
		List<Employee> employees = new ArrayList<>();
		Department d1 = new Department(1, "done");
		Department d2 = new Department(2, "dtwo");
		Department d3 = new Department(3, "dthree");

		employees.add(new Employee(1, "one", 24, "M", 28000.00, d1));
		employees.add(new Employee(2, "two", 26, "F", 30000.00, d2));
		employees.add(new Employee(3, "three", 28, "M", 38000.00, d2));
		employees.add(new Employee(4, "four", 24, "M", 28000.00, d3));
		employees.add(new Employee(5, "five", 25, "M", 24000.00, d1));
		employees.add(new Employee(6, "six", 23, "F", 32000.00, d2));

		return employees.stream().filter(e -> e.getEmployeeName().startsWith(employeeNameStartsWith)).collect(Collectors.toList());
	}

	public void java8PracticeWithSQL() {
		List<Employee> employees = new ArrayList<>();
		Department d1 = new Department(1, "done");
		Department d2 = new Department(2, "dtwo");
		Department d3 = new Department(3, "dthree");

		employees.add(new Employee(1, "one", 24, "M", 24000.00, d1));
		employees.add(new Employee(2, "two", 26, "F", 30000.00, d2));
		employees.add(new Employee(3, "three", 28, "M", 32000.00, d2));
		employees.add(new Employee(4, "four", 24, "M", 28000.00, d3));
		employees.add(new Employee(5, "five", 25, "M", 24000.00, d1));
		employees.add(new Employee(6, "six", 23, "F", 32000.00, d2));

		// Select first_name, Last_Name from employee
		employees.stream().map(e -> e.getEmployeeName() + " " + e.getGender()).forEach(System.out::println);

		// Select * from employee order by FIRST_NAME desc
		employees.stream().map(e -> e.getEmployeeName().toLowerCase()).sorted(Collections.reverseOrder()).forEach(System.out::println);

		// Select * from employee order by FIRST_NAME asc,SALARY desc
		employees.stream().sorted(Employee::compare).forEach(System.out::println);

		// select * from employee where age<25 or Get employee details from
		employees.stream().filter(e -> e.getAge() < 25).forEach(System.out::println);

		// Select * from EMPLOYEE where FIRST_NAME like 't%' or Get employee
		// details from employee table whose first name starts with 't'
		employees.stream().filter(e -> e.getEmployeeName().toLowerCase().startsWith("t")).forEach(System.out::println);

		// Select * from EMPLOYEE where Salary between 25000 and 30000
		employees.stream().filter(e -> e.getSalary() >= 25000 && e.getSalary() <= 30000).forEach(System.out::println);

		// select * from employee group by gender
		employees.stream().collect(Collectors.groupingBy(Employee::getGender)).forEach((key, value) -> System.out.println(key + " " + value));

		// Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by department
		Map<Department, Double> groupByEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		groupByEmployee.forEach((key, value) -> System.out.println(key + " " + value));

		// Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by DEPARTMENT having sum(SALARY) >30000
		groupByEmployee.entrySet().stream().filter(e -> e.getValue() > 30000).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		// Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by DEPARTMENT order by Total_Salary descending
		// OR
		// To Sort a map by value
		groupByEmployee.entrySet().stream().sorted(Map.Entry.<Department, Double> comparingByValue()).forEach((e -> System.out.println(e.getKey() + " " + e.getValue())));

		// To Sort a map by value Example
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "one");
		myMap.put(2, "two");
		myMap.put(3, "three");
		myMap.put(4, "four");

		List<Map.Entry<Integer, String>> myList = new ArrayList<>(myMap.entrySet());
		Collections.sort(myList, Map.Entry.<Integer, String> comparingByValue());
		// OR
		Collections.sort(myList, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		// select DEPARTMENT,avg(SALARY) AvgSalary from employee group by DEPARTMENT order by AvgSalary asc
		Map<Department, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		collect.entrySet().stream().sorted(Map.Entry.<Department, Double> comparingByValue()).forEach((e) -> System.out.println(e.getKey() + " " + e.getValue()));

		// select DEPARTMENT,max(SALARY) MaxSalary from employee group by DEPARTMENT order by MaxSalary asc
		employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)))
				.forEach((key, value) -> System.out.println(key + " " + value));

		// OR
		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
				.forEach((key, value) -> System.out.println(key + " " + value));
	}

	public static void compareByValueDesc() {
		String[] names = { "Rasool", "Prathik", "Durga", "Sai", "Durga", "Rasool", "Jianni", "Durga", "Rasool", "Prathik", "z" };
		Map<String, Long> collect = Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// sort by Value desc
		collect.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEachOrdered(e -> System.out.println(e.getKey() + " " + e.getValue()));
	}

	static Iterator<Object> func(List<Object> mylist) {
		Iterator<Object> it = mylist.iterator();
		while (it.hasNext()) {
			Object element = it.next();
			if (element instanceof Integer) {
				it.remove();
			} else if (element instanceof String) {
				String temp = (String) element;
				if (temp.equals("###")) {
					it.remove();
				}
			}
		}
		return mylist.iterator();
	}

	/*
	 * Sort a map according to values.
	 * 
	 * @param <K> the key of the map.
	 * 
	 * @param <V> the value to sort according to.
	 * 
	 * @param sortMap the map to sort.
	 * 
	 * @return a map sorted on the values.
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> mySortMap(final Map<K, V> mapToSort) {
		List<Map.Entry<K, V>> entries = new ArrayList<>(mapToSort.entrySet());

		Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

		Map<K, V> sortedMap = new LinkedHashMap<>();

		entries.forEach((entry) -> sortedMap.put(entry.getKey(), entry.getValue()));

		return sortedMap;
	}

}
