package com.example.core.collections;

import java.util.HashSet;

import com.example.core.oops.Employees1;

public class HashSetExample  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hset = new HashSet();
		Employees1 emp1= new Employees1("Divya", 9, 8456789, "GBS");
		Employees1 emp2= new Employees1("Deepthi", 8, 3445689, "GBC");
		Employees1 emp3= new Employees1("Keerthi", 5, 3456789, "GTS");
		Employees1 emp4= new Employees1("Preethi", 3, 765432, "L&K");
		hset.add(emp2);
		hset.add(emp3);
		hset.add(emp4);
		hset.add(emp4);
		System.out.println(hset);
		
		
		
		
	}

}
