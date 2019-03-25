package com.example.core.oops;


public class DetailsOfEmployee {

	static Employees1[]  emp;
	static Employees1[] sortedEmployees;
	static Employees1 temp;
	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		Employees1<Integer> emp1= new Employees1<Integer>( "Divya", 989, 8456789, "GBS");
		Employees1<Double>  emp2= new Employees1<Double>("Deepthi", 788, 3445689.0, "GBC");
		Employees1<Integer> emp3= new Employees1<Integer>("Keerthi", 559, 3456789, "GTS");
		Employees1<Integer> emp4= new Employees1<Integer>("Preethi", 397, 765432, "L&K");
		emp =new Employees1[] {emp1, emp2, emp3, emp4};
		
		System.out.println("\t"+"\t"+"Employee Details"+"\t"+"\t");
		for(int index=0; index<=emp.length-1; index++) {
			//System.out.println(emp[index]);
			emp[index].printDetails();
			System.out.println();
		}
		int hcode=emp4.hashCode();
		System.out.println(hcode);
			
		//Update details
		emp1.setDept("Finance");
	    emp2.setSalary( 3456789.98);
		System.out.println("\t"+"\t"+" Updated Employee Details"+"\t"+"\t");
		for(int index=0; index<=emp.length-1; index++) {
			//System.out.println(emp[index]);
			emp[index].printDetails();
			System.out.println();
		}
		/*sortedEmployees=sort();
		System.out.println("\t"+"\t"+" Sorted Employee Details"+"\t"+"\t");
		for(int index=0; index<=sortedEmployees.length-1; index++) {
			//System.out.println(emp[index]);
			sortedEmployees[index].printDetails();
			System.out.println();
		}*/
		//sort();
		deleteEmployee(0);
	}
	public static void deleteEmployee(int removeIndex) {
		for(int i=removeIndex; i<emp.length-1; i++) {
			
			emp[i]=emp[i+1];
		}
		
		System.out.println("\t"+"\t"+"Employee Details"+"\t"+"\t");
		for(int index=0; index<=emp.length-1; index++) {
			if(index==emp.length-1)
			{
				break;
			}
			emp[index].printDetails();
			System.out.println();
		}
		

}//sort method
	/*public static void sort() {
		for(int index=0; index<emp.length; index++) {
			for(int index1=index+1; index1<emp.length; index1++) {
				if(emp[index].getSalary()<emp[index1].getSalary()) {
					temp = emp[index];
					emp[index]=emp[index1];
					emp[index1]=temp;
				}
				
			}
				
				
		}
		System.out.println("\t"+"\t"+" Sorted Employee Details"+"\t"+"\t");
		for(int index=0; index<=emp.length-1; index++) {
			//System.out.println(emp[index]);
			emp[index].printDetails();
			System.out.println();
		}	}*/
		
	
	
	

	
}

	

