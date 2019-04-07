package com.employeerestapi.spring.dao;

import java.util.List;

import com.employeerestapi.spring.model.Employee;

public interface EmployeeDAO {
	 long save(Employee emp);
	 
	   Employee get(long id);
	 
	   List<Employee> list();
	 
	   void update(long id, Employee emp);
	 
	   void delete(long id);
	 

}
