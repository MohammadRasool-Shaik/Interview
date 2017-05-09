/**
 * 
 */
package org.rash.interview;

/**
 * @author Ammi
 * 
 */
public class Employee implements Cloneable, Comparable<Employee> {

	private Integer employeeId;
	private String employeeName;
	private int age;
	private String gender;
	private Double salary;
	private String designation;
	private Department department;

	/**
	 * @param employeeName
	 * @param designation
	 */
	public Employee(String employeeName, String designation) {
		super();
		this.employeeName = employeeName;
		this.designation = designation;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize Method");
		super.finalize();
	}

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName, Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;

	}

	public Employee(int eid, String ename, int age, String gender) {
		super();
		this.employeeId = eid;
		this.employeeName = ename;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * @param employeeId
	 * @param employeeName
	 * @param age
	 * @param gender
	 * @param salary
	 * @param department
	 */
	public Employee(Integer employeeId, String employeeName, int age, String gender, Double salary, Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.department = department;
	}

	/**
	 * @param i
	 * @param string
	 * @param j
	 * @param string2
	 * @param d1
	 */
	public Employee(Integer employeeId, String employeeName, int age, String gender, Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.gender = gender;
		this.department = department;
	}

	/**
	 * @param i
	 * @param string
	 */
	public Employee(Integer employeeId, String employeeName) {
		// super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age + ", gender=" + gender + ", salary=" + salary + ", department=" + department
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	@Override
	public Employee clone() {
		Employee clone = null;
		if (this instanceof Cloneable) {
			try {
				clone = (Employee) super.clone();
				clone.setDepartment(clone.getDepartment().clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		return this.getEmployeeId().compareTo(o.getEmployeeId());
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	// Select * from employee order by FIRST_NAME asc,SALARY desc
	public static int compare(Employee e1, Employee e2) {
		if (e1.getSalary().compareTo(e2.getSalary()) == 0) {
			return e1.getEmployeeName().compareToIgnoreCase(e2.getEmployeeName());
		} else if (e1.getSalary() > e2.getSalary()) {
			return -1;
		} else {
			return 1;
		}
	}

	// compare employees based on name and in sorted list/set always first employee is designation='CEO'
	public static int compareByName(Employee e1, Employee e2) {
		if (e1.getDesignation().equalsIgnoreCase("CEO"))
			return -1;
		return e1.getEmployeeName().compareTo(e2.getEmployeeName());
	}

	public static int compareByDepartment(Employee e1, Employee e2) {
		return e1.getDepartment().getDepartmentId().compareTo(e2.getEmployeeId());
	}

}
