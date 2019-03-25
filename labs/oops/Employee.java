package com.example.core.oops;
public class Employee {
	String name;
	static int id;
	int age;
	String dept;
	double salary;
	public Employee(String name,  int age, String dept, double salary) {
		this.name=name;
		this.age=age;
		this.dept=dept;
		this.salary=salary;
		id++;
	}
	public void empDetails() {
		System.out.println("name:"+name);
		System.out.println("id:"+id);
		System.out.println("age:"+age);
		System.out.println("dept:"+dept);
		System.out.println("salary:"+salary);
	}
   public void editEmployee(String name,int id, int age, String dept, double salary) {
	   this.name=name;
	   this.id=id;
	   this.age=age;
	   this.dept=dept;
	   this.salary=salary;

		
	}
	

	
}
