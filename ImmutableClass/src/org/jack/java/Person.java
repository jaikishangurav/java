package org.jack.java;

public class Person {

	final private String name;
	final private Integer age;
	
	public Person(String name, Integer age){
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
	
	
}
