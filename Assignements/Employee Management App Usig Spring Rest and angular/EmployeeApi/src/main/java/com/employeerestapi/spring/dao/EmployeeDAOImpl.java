package com.employeerestapi.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employeerestapi.spring.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired 
	private SessionFactory sessionFactory;

	
	public long save(Employee emp) {
			
			
		sessionFactory.getCurrentSession().save(emp);
	      return emp.getId();
		
	}

	
	public Employee get(long id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);
		
	}

	public List<Employee> list() {
		 Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	      Root<Employee> root = cq.from(Employee.class);
	      cq.select(root);
	      Query<Employee> query = session.createQuery(cq);
	      return query.getResultList();
		
	}

	
	public void update(long id, Employee emp) {
		 Session session = sessionFactory.getCurrentSession();
	      Employee emp1 = session.byId(Employee.class).load(id);
	      emp1.setDesignation(emp.getDesignation());
	      emp1.setDepartment(emp.getDepartment());
	      session.flush();
		
	}

	
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
	      Employee emp = session.byId(Employee.class).load(id);
	      session.delete(emp);
		
	}

}
