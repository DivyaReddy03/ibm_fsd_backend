package com.example.core.oops;

class EmpDetails{
	public static void main(String[] args)
	{
		Emp emp=new Emp("Divya", 21, 123, 34567890, "GBS","Employee" );
		emp.printEmpDetails();
		Contractor con=new Contractor("Bindu",21, "trainer", 30000000, "3 months","Training", 12345);
		con.printContractorDetails();
		emp.sayHello();
		emp.appraise();
	}
}