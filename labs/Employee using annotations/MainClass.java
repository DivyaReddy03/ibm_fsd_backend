package com.annotation.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args)
	{
		ApplicationContext container= new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		Employee emp=(Employee) container.getBean("employee");
		emp.setSkills(Arrays.asList("java","Python"));
		emp.setDob(LocalDate.of(1997, 05, 28));
		
		System.out.println(emp);
		System.out.println(emp.age);

		
	}	

}
