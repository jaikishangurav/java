package org.jack.java;

import java.util.Date;

public class TestImmutableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImmutableClass im = ImmutableClass.createNewInstance(1,"Qwerty",new Date());
		System.out.println(im.getImmutableField2()+" "+im.getImmutableField1()+" "+im.getMutableField());
		im = ImmutableClass.createNewInstance(2,"ASDFGH",new Date());
		System.out.println(im.getImmutableField2()+" "+im.getImmutableField1()+" "+im.getMutableField());
	}

}
