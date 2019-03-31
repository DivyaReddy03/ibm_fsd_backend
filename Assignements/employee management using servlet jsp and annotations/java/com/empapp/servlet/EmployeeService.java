package com.empapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

	static Employee e;
	DAO d;
	Scanner sc=new Scanner(System.in);
	
	public void addEmployee(Employee emp) {
		
		
		/*System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
		String dob=sc.next();
		int age =calculateAge(dob);*/
		
		
		d=new DAO();
		try {
			d.insert(emp);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	/*private int calculateAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bday=LocalDate.parse(dob, formatter);
		Period p=Period.between(bday, LocalDate.now());
		int age=p.getYears();
		return age;
	}*/
	public void updateEmployee(Employee e, int eid) {
		
		
		/*System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
		String dob=sc.next();
		int age =calculateAge(dob);*/
		//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		d=new DAO();
		d.update(e, eid);
		//e=new Employee(eName,id, age, designation, dept, sal);
		//d.update(e, eid);
		
		
	}

	public Employee viewEmployeeById(int id) {
		d=new DAO();
		Employee emp=d.view(id);
		return emp;
	}

	public List<Employee> viewEmployees() {
		List<Employee> empList=new ArrayList();
		d=new DAO();
		 empList=d.viewAll();
		 return empList;
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
