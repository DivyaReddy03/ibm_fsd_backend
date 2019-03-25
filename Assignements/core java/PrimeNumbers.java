package com.example.core.java;

public class PrimeNumbers {
	public static void main(String[] args)
	{
		int i=4;
		int status=2;
		
			for(int j=2; j<=i-1; j++) {
				if(i%j==0)
				{
					status++;
				}
				
					
				}
				if(status==2) {
					System.out.println(i+ " is a prime number");
				}
			
			
		}
		
		
		
		
	}


