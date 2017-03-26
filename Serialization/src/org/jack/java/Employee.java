package org.jack.java;

import java.io.Serializable;

/*
 * If parent class Person is serializable then child class doesnt have to implement Serializable
An object is serializable only if its class or its superclass implements the Serializable (or Externalizable) interface.
An object is serializable (itself implements the Serializable interface) even if its superclass is not. However, the firstsuperclass in the hierarchy of the serializable class, that does not implements Serializable interface, MUST have a no-arg constructor. 
If this is violated, readObject() will produce a java.io.InvalidClassException in runtime.
 * 
 */

public class Employee extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 776068909917367157L;

	private String id;
	
	private String salary;
	
	private String department;
	
	//Company class has to be serializable otherwise java.io.NotSerializableException thrown for company object
	private Company company;
	
	public Employee(String id, String salary, String department, Company company, String name, int age) {
		super(name,age);
		this.id = id;
		this.salary = salary;
		this.department = department;
		this.company=company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", department=" + department + ", company=" + company
				+ "]";
	}
	
}
