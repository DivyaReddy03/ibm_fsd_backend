package com.example.core.oops;

public abstract class Person {
	private String name;
	private int age;
	private String role;
	public Person(String name, int age, String role) {
		super();
		this.name = name;
		this.age = age;
		this.role=role;
	}
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getRole() {
		return role;
	}
	public  void sayHello() {
		System.out.println("Hello Person");
	}

}
