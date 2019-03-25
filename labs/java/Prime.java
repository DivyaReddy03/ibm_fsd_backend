package com.example.core.java;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a;
		System.out.println("Enter range(n):");
		int num=sc.nextInt();
		for(int i=1; i<=num; i++)
		{
			int counter=2;
			
			
			if(i==1)
			{
				counter++;
			}
			for(int j=2; j<=i-1; j++)
			{
				if(i%j==0)
				{
					counter++;
				}
			}
			if(counter==2)
			{
				System.out.println(i);
			}
		}

	}

}
