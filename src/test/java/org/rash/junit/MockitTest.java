/**
 * 
 */
package org.rash.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.rash.interview.Department;
import org.rash.interview.Employee;
import org.rash.interview.Java8Practice;

import junit.framework.Assert;

/**
 * @author Admin
 */
public class MockitTest {

	@Test
	public void sortTest() {
		List<Employee> employees = new ArrayList<>();
		Department d1 = new Department(1, "done");
		Department d3 = new Department(3, "dthree");

		employees.add(new Employee(4, "four", 24, "M", 28000.00, d3));
		employees.add(new Employee(5, "five", 25, "M", 24000.00, d1));

		Java8Practice java = Mockito.mock(Java8Practice.class);
		Mockito.when(java.getEmployees("f")).thenReturn(employees);

		Assert.assertEquals(2, java.getEmployees("f").size());
	}
}
