package com.example.core.oops;

public class EmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee.id=10;
		Employee emp=new Employee("Divya",21,"FSD",350000);
		emp.empDetails();
		Employee emp1=new Employee("Bindu",22,"GBS",346789);
		emp1.empDetails();
		
		
	emp.salary=4000000;
	emp.editEmployee("Bindu",123,17,"FSD",540000);
	emp.empDetails();
		
				

	}

}
