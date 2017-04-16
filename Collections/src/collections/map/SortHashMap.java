package collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

class Employee implements Comparable{
	private String name;
	private String dept;
	
	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + "]";
	}

	@Override
	public int compareTo(Object obj) {
		Employee e=(Employee)obj;
		int comp=this.getName().compareTo(e.getName());
		int comp1=this.getDept().compareTo(e.getDept());
		return comp<0||comp>0?comp:comp1;
	}
		
}

public class SortHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee("Jack","Sales");
		Employee e2=new Employee("Aaron","Account");
		Employee e3=new Employee("Mark","Marketing");
		Employee e4=new Employee("Rahul","Finance");
		Employee e5=new Employee("Sara","HR");
		HashMap<Employee,String> map=new HashMap<>();
		map.put(e1, e1.getDept());
		map.put(e2, e2.getDept());
		map.put(e3, e3.getDept());
		map.put(e4, e4.getDept());
		map.put(e5, e5.getDept());
		
		System.out.println(map);
		System.out.println("\n****Map sorted using keys****");
		LinkedHashMap<Employee,String> sortedMap=sortByKey(map);
		System.out.println(sortedMap);
		
		System.out.println("\n****Map sorted using value****");
		sortedMap=sortByValue(map);
		System.out.println(sortedMap);
		
	}
	
	public static LinkedHashMap<Employee,String> sortByKey(HashMap<Employee,String> map){
		LinkedHashMap<Employee,String> sortedMap=new LinkedHashMap<Employee,String>();
		TreeMap<Employee,String> treeMap=new TreeMap<>();
		treeMap.putAll(map);
		sortedMap.putAll(treeMap);
		return sortedMap;
	}
	
	public static LinkedHashMap<Employee,String> sortByValue(HashMap<Employee,String> map){
		LinkedHashMap<Employee,String> sortedMap=new LinkedHashMap<Employee,String>();
		List<Entry<Employee,String>> list=new LinkedList<>(map.entrySet());
		Collections.sort(list, (obj1,obj2)->{
			return obj1.getValue().compareTo(obj2.getValue());
		});
		for(Entry<Employee,String> entry:list){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	

}
