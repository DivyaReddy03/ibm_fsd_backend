package com.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorld {

	public static void main(String[] args) {
		Greetings greetings=new Greetings();
		System.out.println(greetings.getMessage());
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
		Greetings greetings1 = (Greetings) context.getBean("greetings");
		System.out.println(greetings1.getMessage());
	}

}
