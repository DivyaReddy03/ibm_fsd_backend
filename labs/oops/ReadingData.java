package com.example.core.oops;

import java.util.Scanner;

public class ReadingData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name=sc.next();
		System.out.println("Enter Employee Number:");
		String id=sc.next();
		System.out.println("Enter Age:");
		int age=sc.nextInt();
		System.out.println("Enter dept:");
		String designation=sc.next();
		System.out.println("\t\t\t Employee Details \t\t\t");
		System.out.format("Name \t ID \t Designation \t Age \n");
		System.out.format("%s \t %s \t %s \t %d \n", name, id, designation, age);
		
		
	}

}
