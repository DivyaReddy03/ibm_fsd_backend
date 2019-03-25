package org.spring.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmploeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new FileSystemXmlApplicationContext("src/employee.xml");
		Employee emp=(Employee) context.getBean("employee");
		System.out.println(emp);
		
	}

}
