/**
 * 
 */
package org.rash.interview;

/**
 * @author Ammi
 */
public class Department implements Cloneable {
	private Integer departmentId;
	private String dname;


	/**
	 * @param departmentId
	 * @param dname
	 */
	public Department(Integer departmentId, String dname) {
		super();
		this.departmentId = departmentId;
		this.dname = dname;
	}

	
	
	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}



	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname
	 *            the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this || obj.getClass() == this.getClass()) {
			return true;
		}
		Department d = (Department) obj;
		return d.getDepartmentId() == this.getDepartmentId() && d.getDname().equals(this.getDname());
	}

	@Override
	public String toString() {
		return this.getDname();
	}

	@Override
	public Department clone() throws CloneNotSupportedException {
		return (Department) super.clone();
	}
	
	public void compareTo(Department d){
		d.getDepartmentId().compareTo(this.getDepartmentId());
	}

}
