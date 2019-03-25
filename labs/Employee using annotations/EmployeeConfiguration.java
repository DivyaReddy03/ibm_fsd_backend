package com.annotation.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	 @Bean
	 public Employee employee() {
	        return new Employee(address());
	    }    
	    
	    @Bean
	    public Address address() {
	        return new Address("1/1290", "H.B.S COLONY", "Yemmiganur", "Kurnool", "Andhra Pradesh");
	    }    
	    
	   
}
