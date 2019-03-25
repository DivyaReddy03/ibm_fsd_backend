package com.example.core.oops;

public class Emp extends Person implements Apprisable{
	private int id;
	private double salary;
	private String dept;
	
	
	public Emp(String name, int age, int id, double salary, String dept, String role)
	{
		super(name, age,role);
		this.id=id;
		this.salary=salary;
		this.dept=dept;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void sayHello()
	{
		System.out.println("Hello Employee");
	}
public void printEmpDetails() {
		System.out.println("name:"+getName()+"\n"+"id:"+id+"\n"+"age:"+getAge()+"\n"+"salary:"+salary+"\n"+"dept:"+dept+"\n"+"role:"+getRole());
	}


@Override
public void appraise() {
	// TODO Auto-generated method stub
	
	System.out.println("Hello Appraise");
	
}

}
