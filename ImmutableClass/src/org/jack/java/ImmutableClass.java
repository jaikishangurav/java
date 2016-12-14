/*
 * 1.Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * 2.Make all fields final and private.
 * 3.Don’t allow subclasses to override methods. Simplest way is to make class final.
 * 4.Special attention when having mutable instance variables.
 * */

package org.jack.java;

import java.util.Date;

public final class ImmutableClass {
	/*Integer class is immutable as it does not provide any setter to change its content
	 * */
	final private Integer immutableField1;
	
	/*String class is immutable as it does not provide any setter to change its content
	 * */
	final private String immutableField2;
	
	/*Date class is mutable as it does not provide any setter to change date/time parts
	 * */
	final private Date mutableField;
	
	private ImmutableClass(Integer field1, String field2, Date field3){
		immutableField1=field1;
		immutableField2=field2;
		mutableField=new Date(field3.getTime());
	}
	
	public static ImmutableClass createNewInstance(Integer field1, String field2, Date field3){
		return new ImmutableClass(field1, field2, field3);
	}

	/* Integer class is immutable so we can return the instance as it is
	 * */
	public Integer getImmutableField1() {
		return immutableField1;
	}

	/* String class is immutable so we can return the instance as it is
	 * */
	public String getImmutableField2() {
		return immutableField2;
	}

	/* Date class is mutable so return copy of date instance.
	 * */
	public Date getMutableField() {
		return new Date(mutableField.getTime());
	}
	
	
}
