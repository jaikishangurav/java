package org.jack.java;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Employee("jack",25,"accenture");
		Employee e =  (Employee) new Person("jack",25);
		e.setCompany("accenture");
	}

}
