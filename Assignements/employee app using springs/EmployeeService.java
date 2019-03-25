package com.employeeapp.spring;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeeService {

	static Employee e;
	DAO d;
	Scanner sc=new Scanner(System.in);
	
	public void addEmployee() {
		System.out.println("add method called");
		System.out.println("Enter Employee Name:");
		String eName=sc.next();
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		
		System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
		String dob=sc.next();
		int age =calculateAge(dob);
		//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		System.out.println("Enter Employee designation:");
		String designation=sc.next();
		System.out.println("Enter Employee department:");
		String dept=sc.next();
		System.out.println("Enter Employee Salary:");
		double sal=sc.nextDouble();
		e=new Employee(eName,id, age, designation, dept, sal);
		d=new DAO();
		try {
			d.insert(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	private int calculateAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bday=LocalDate.parse(dob, formatter);
		Period p=Period.between(bday, LocalDate.now());
		int age=p.getYears();
		return age;
	}
	public void updateEmployee(int eid) {
		System.out.println("add method called");
		System.out.println("Enter Employee Name:");
		String eName=sc.next();
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		
		System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
		String dob=sc.next();
		int age =calculateAge(dob);
		//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		System.out.println("Enter Employee designation:");
		String designation=sc.next();
		System.out.println("Enter Employee department:");
		String dept=sc.next();
		System.out.println("Enter Employee Salary:");
		double sal=sc.nextDouble();
		e=new Employee(eName,id, age, designation, dept, sal);
		d=new DAO();
		d.update(e, eid);
		
		
	}

	public void viewEmployeeById(int id) {
		d=new DAO();
		d.view(id);
	}

	public void viewEmployees() {
		d=new DAO();
		d.viewAll();
	}

	public void deleteEmployee(int id) {
		d=new DAO();
		d.delete(id);
		
		
	}

	public void statistics() {
		d=new DAO();
		d.statistics();
	}

	public void importData() {
		d=new DAO();
		try {
			d.imports();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void exportData() {
		d=new DAO();
		try {
			d.export();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
