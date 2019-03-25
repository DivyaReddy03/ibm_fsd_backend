package com.example.core.oops;

public class Contractor extends Person {
  
	int salary;
	String duration;
	String dept;
	int id;
	
	public Contractor(String name, int age, String role, int salary, String duration, String dept, int id ) {
		super(name, age, role);
		this.salary=salary;
		this.duration=duration;
		this.dept=dept;
		this.id=id;
	}
	public void printContractorDetails()
	{
		System.out.println("\n"+"name:"+getName()+"\n"+"id:"+id+"\n"+"age:"+getAge()+"\n"+"salary:"+salary+"\n"+"dept:"+dept+"\n"+"role:"+getRole());

	}
	

}
