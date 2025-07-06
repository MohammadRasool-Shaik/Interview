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
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rasool.Shaik
 *
 */
public class Java8Practice {
    public static void main(String[] args) {

        String[] t = {"apple", "apple", "banana", "apple", "orange", "banana", "papaya"};
        StringBuilder b = new StringBuilder();


        Map<Character, Long> collect1 = Arrays.stream(t).collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println(collect1);

        Map<String, Long> collect2 = Arrays.stream(t).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collect2);

        // String reduce = Arrays.stream(t).reduce("", StringBuilder::append);

        Map<String, Long> collect = Arrays.stream(t).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();
        collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        int sum = Arrays.stream(new int[]{4, 6, 2, 3, 9}).reduce(0, (int i, int j) -> {
            System.out.println(i + " " + j);
            return (i + j);
        });

        System.out.println(sum);

        String collect3 = Arrays.stream(new String[]{"one", "two", "three", "four", "five"}).collect(Collectors.joining(""));
        System.out.println(collect3);

        String reduce = Arrays.stream(new String[]{"one", "two", "three", "four", "five"}).reduce("", (s1, s2) -> {
            System.out.println(s1 + " " + s2);
            return s1.concat(s2);
        });
        System.out.println(reduce);

        IntSummaryStatistics summaryStatistics = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println(summaryStatistics.getSum());
    }

    public static void compareByValueDesc() {
        String[] names = {"Rasool", "Prathik", "Durga", "Sai", "Durga", "Rasool", "Jianni", "Durga", "Rasool", "Prathik", "z"};
        Map<String, Long> collect = Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // sort by Value desc
        collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> System.out.println(e.getKey() + " " + e.getValue()));
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
        employees.stream().map(e -> e.getEmployeeName() + " " + e.getGender()).forEach(System.out::print);

        // Select FIRST_NAME from employee order by FIRST_NAME desc
        employees.stream().map(e -> e.getEmployeeName().toLowerCase()).sorted(Collections.reverseOrder()).forEach(System.out::println);
        employees.stream().map(e -> e.getEmployeeName().toLowerCase()).sorted().forEach(System.out::println);

        // Select * from employee order by FIRST_NAME asc,SALARY desc
        employees.stream().sorted(Employee::compare).forEach(System.out::println);

        // select * from employee where age<25 or Get employee details from
        employees.stream().filter(e -> e.getAge() < 25).forEach(System.out::println);

        // Select * from EMPLOYEE where FIRST_NAME like 't%' or Get employee
        // details from employee table whose first name starts with 't'
        employees.stream().filter(e -> e.getEmployeeName().toLowerCase().startsWith("t")).forEach(System.out::println);

        // Select * from EMPLOYEE where Salary between 25000 and 30000
        employees.stream().filter(e -> e.getSalary() >= 25000 && e.getSalary() <= 30000).forEach(System.out::println);

        // select * from employee group by gender	-> Male: List of employees, FeMale: List of Employees
        employees.stream().collect(Collectors.groupingBy(Employee::getGender)).forEach((key, value) -> System.out.println(key + " " + value));
        Map<String, Long> genderCount = employees.stream().collect(Collectors.groupingBy((Employee e) -> e.getGender().toUpperCase(), Collectors.counting()));

        // *** Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by department
        Map<Department, Double> groupByEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        groupByEmployee.forEach((key, value) -> System.out.println(key + " " + value));

        // Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by DEPARTMENT having sum(SALARY) >30000
        groupByEmployee.entrySet().stream().filter(e -> e.getValue() > 30000).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        // Select DEPARTMENT,sum(SALARY) Total_Salary from employee group by DEPARTMENT order by Total_Salary descending
        // OR
        // To Sort a map by value
        groupByEmployee.entrySet().stream().sorted(Map.Entry.<Department, Double>comparingByValue().reversed()).forEach((e -> System.out.println(e.getKey() + " " + e.getValue())));

        //OR
        Comparator<Map.Entry<Department, Double>> t = new Comparator<>() {
            @Override
            public int compare(Entry<Department, Double> o1, Entry<Department, Double> o2) {
                if (o1.getValue().compareTo(o2.getValue()) < 1) {
                    return 1;
                } else if (o1.getValue().compareTo(o2.getValue()) > 1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        groupByEmployee.entrySet().stream().sorted(t).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        // To Sort a map by value Example
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "one");
        myMap.put(2, "two");
        myMap.put(3, "three");
        myMap.put(4, "four");

        List<Map.Entry<Integer, String>> myList = new ArrayList<>(myMap.entrySet());

        Collections.sort(myList, Map.Entry.<Integer, String>comparingByValue());
        // OR
        Collections.sort(myList, new Comparator<Map.Entry<Integer, String>>() {

            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // select DEPARTMENT,avg(SALARY) AvgSalary from employee group by DEPARTMENT order by AvgSalary asc
        Map<Department, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        collect.entrySet().stream().sorted(Map.Entry.<Department, Double>comparingByValue()).forEach((e) -> System.out.println(e.getKey() + " " + e.getValue()));

        // select DEPARTMENT,max(SALARY) MaxSalary from employee group by DEPARTMENT order by MaxSalary asc
        employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((key, value) -> System.out.println(key + " " + value));

        // toList(), toMap(), toSet() introduced from java16
        employees.stream().sorted(Collections.reverseOrder()).toList();
        // OR
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

}
