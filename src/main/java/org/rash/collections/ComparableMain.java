/**
 * 
 */
package org.rash.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.rash.interview.Employee;

/**
 * @author Ammi
 * 
 */
public class ComparableMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee(4, "Rasool");
		Employee e2 = new Employee(1, "Shaik");
		Employee e3 = new Employee(2, "Mohammad");
		Employee e4 = new Employee(3, "Myb");
		Employee e5 = new Employee(5, "Ammu");

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);

		for (Employee e : employees) {
			System.out.println(e.toString());
		}
		System.out.println();
		Collections.sort(employees);
		for (Employee e : employees) {
			System.out.println(e.toString());
		}

		System.out.println();
		Collections.sort(employees, Collections.reverseOrder());

		Collections.reverse(employees);
		for (Employee e : employees) {
			System.out.println(e.toString());
		}

		Comparator<Employee> t = new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				String e1Name = o1.getEmployeeName();
				String e2Name = o2.getEmployeeName();
				return e1Name.compareTo(e2Name);
			}
		};

		Collections.sort(employees, t);

		System.out.println();
		for (Employee e : employees) {
			System.out.println(e.toString());
		}

	}

	public static void mains(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Papi", "HR"));
		employees.add(new Employee("Rasool", "CEO"));
		employees.add(new Employee("Saddam", "Manager"));
		employees.add(new Employee("Imam", "Co-ordinater"));
		employees.add(new Employee("Rasool", "CEO"));

		System.out.println(employees.toString());
		employees.sort(Employee::compareByName);

		System.out.println(employees.toString());

	}

}
