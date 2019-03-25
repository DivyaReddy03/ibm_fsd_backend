package com.example.core.oops;

public class Employees1<T> implements Comparable{
	private String name;
	private int id;
	private T salary;
	private String dept;
	public Employees1(String name, int id, T salary, String dept) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public T getSalary() {
		return salary;
	}
	public void setSalary(T salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	@Override
	public int hashCode() {
		
		return this.id % 5;
	}
	
	@Override
	public String toString() {
		return "Employees1 [name=" + name + ", id=" + id + ", salary=" + salary + ", dept=" + dept + "]";
	}
	public void printDetails() {
		System.out.println("name:"+getName()+"\n"+"id:"+id+"\n"+"salary:"+salary+"\n"+"dept:"+dept);
		
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employees1)
		{
			return this.getId() == ((Employees1) obj).getId(); 
		}
		return false; 
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Employees1)
		{		
			return this.getName().compareTo(((Employees1) o).getName());		
		}
		return 0;
		
	}

}
