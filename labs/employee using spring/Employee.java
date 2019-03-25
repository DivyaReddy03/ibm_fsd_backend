package org.spring.employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Employee {
	int id;
	String name;
	int age;
	String designation;
	double salary;
	List skills;
	Address address;
	boolean fulltime;
	LocalDate dob;
	
	public Employee(int id, String name, int age) 
	{
		super();
		this.id = id;
		this.name = name;
		this.age=age;
		
	}
	
	@Override
	public String toString() {
		return "Employee details [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + ", skills=" + skills + ", address=" + address + ", fulltime=" + fulltime + ", dob ="+ dob +"]";
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List getSkills() {
		return skills;
	}
	public void setSkills(List skills) {
		this.skills = skills;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean isFulltime() {
		return fulltime;
	}
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	
	

}
