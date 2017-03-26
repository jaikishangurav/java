package org.jack.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Company company=new Company("Google","San Francisco");
		Person employee01 = new Employee("emp01", "10000", "finance",company, "Mike", 30);
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
		        "src\\org\\jack\\resources\\employee01.ser"));
		out.writeObject(employee01);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("src\\org\\jack\\resources\\employee01.ser"));
        Employee serializedEmployee01 = (Employee) in.readObject();
        in.close();
        
        System.out.println("Non Serialized employee object");
        System.out.println(employee01);
        System.out.println("Serialized employee object");
        System.out.println(serializedEmployee01);
        System.out.println(serializedEmployee01.getName()+":"+serializedEmployee01.getAge());
	}

}
