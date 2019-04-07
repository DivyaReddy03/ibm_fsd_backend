package com.employeerestapi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employeerestapi.spring.dao.EmployeeDAO;
import com.employeerestapi.spring.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl  implements EmployeeService{
	

	   @Autowired
	   private EmployeeDAO empDAO;

	
	@Transactional
	public long save(Employee emp) {
		 return empDAO.save(emp);
	}

	
	@Transactional
	public Employee get(long id) {
	      return empDAO.get(id);
		
	}

	
	@Transactional
	public List<Employee> list() {
	      return empDAO.list();
	}

	
	@Transactional
	public void update(long id, Employee emp) {
		 empDAO.update(id, emp);
	}

	
	@Transactional
	
	public void delete(long id) {
	      empDAO.delete(id);		
	}

}
