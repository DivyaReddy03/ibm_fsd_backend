package com.annotation.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.annotation.example.Address;
public class Employee {
	@Value(value="1")
	int id;
	@Value(value="Divya")
	String name;
	LocalDate dob;

	//@Value(value="21")
	int age;
	@Value(value="developer")
	String designation;
	@Value(value="23244423")
	double salary;
	List skills;
	Address address;
	@Value(value="true")
	boolean fulltime;
	public Employee()
	{
		
	}
	
	/*public Employee(int id, String name, Address address2) 
	{
		super();
		this.id = id;
		this.name = name;
		this.address=address2;
		
	}*/
	
	public Employee(Address address2) {
		// TODO Auto-generated constructor stub
		this.address=address2;
	}

	@Override
	public String toString() {
		return "Employee details [id=" + id + ", name=" + name + ", age=" + this.getAge() + ", designation=" + designation + ", salary="
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
		LocalDate D=LocalDate.now();
		Period P=Period.between(this.getDob(),D);
		int age= P.getYears();
		this.setAge(age);
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
