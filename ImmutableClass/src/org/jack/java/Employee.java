package org.jack.java;

public class Employee extends Person {

	private String company;
	
	public Employee(String name, Integer age, String company) {
		super(name, age);
		this.company=company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
}
