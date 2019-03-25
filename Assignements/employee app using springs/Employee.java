package com.employeeapp.spring;

public class Employee {
private static String name;
private int empid;
private int age;
private String designation;
private String department;
private double salary;


public Employee(String name, int empid, int age, String designation, String department, double salary) {
	super();
	this.name = name;
	this.empid = empid;
	this.age = age;
	this.designation = designation;
	this.department = department;
	this.salary = salary;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
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
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}



}
