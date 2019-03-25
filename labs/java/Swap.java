package com.example.core.java;

import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a=20; 
		//int b=13; 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a :");
		int a=sc.nextInt();
		System.out.println("Enter b:");
		int b=sc.nextInt();
		System.out.println("Before swapping a is "+a+" b is "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After swapping a is "+a+" b is "+b);
		sc.close();

	}

}
