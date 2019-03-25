package com.java.employeemanagement;

import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EmployeeService {
	TreeMap <Integer,Employees>map=new TreeMap<Integer,Employees>();    

	Scanner sc=new Scanner(System.in);
	public void addEmployee()
	{
		System.out.println("add method called");
		System.out.println("Enter Employee Name:");
		String eName=sc.next();
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		
		System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
		String dob=sc.next();
		int age =calculateAge(dob);
		//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		System.out.println("Enter Employee designation:");
		String designation=sc.next();
		System.out.println("Enter Employee department:");
		String dept=sc.next();
		System.out.println("Enter Employee Salary:");
		double sal=sc.nextDouble();

		Employees e =new Employees(eName, id,age, designation, dept, sal);
		map.put(e.getEmpId(),e);
		//System.out.println(eName+","+ id +","+ designation+","+dept+","+ sal);
		System.out.println(e);
	}

	private int calculateAge(String dob) {
		// TODO Auto-generated method stub
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bday=LocalDate.parse(dob, formatter);
		Period p=Period.between(bday, LocalDate.now());
		int age=p.getYears();
		return age;
	}

	public void updateEmployee(int id)
	{
		if(map.containsKey(id))
		{
			System.out.println("update employee "+id);
			System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Date-Of-Birth(YYYY/MM/DD): ");
			String dob=sc.next();
			int age =calculateAge(dob);
			System.out.println("Enter designation:");
			String designation=sc.next();
			System.out.println("Enter dept:");
			String dept=sc.next();
			System.out.println("Enter salary");
			double salary=sc.nextDouble();
			Employees e=new Employees(name, id, age, designation, dept, salary);

			map.replace(id, e);
		}else {
			System.out.println("No employee with id "+ id +" exist");
		}


	}

	public void viewEmployeeById(int id)

	{
		if(map.containsKey(id))
		{
			System.out.println("view employee "+ id);
			System.out.println("Name: "+map.get(id).getEmpName());
			System.out.println("ID: "+map.get(id).getEmpId());
			System.out.println("Age: "+map.get(id).getAge());
			System.out.println("Department: "+map.get(id).getDepartment());
			System.out.println("Designation: "+map.get(id).getDesignation());
			System.out.println("Salary: "+map.get(id).getSalary());

		}else {
			System.out.println("No employee with id "+ id +" exist");

		}

	}
	public void viewEmployees()
	{
		System.out.println("View all method called");
		for(Object o:map.keySet()) {
			System.out.println("Name: "+map.get(o).getEmpName());
			System.out.println("ID: "+map.get(o).getEmpId());
			System.out.println("Age: "+map.get(o).getAge());
			System.out.println("Department: "+map.get(o).getDepartment());
			System.out.println("Designation: "+map.get(o).getDesignation());
			System.out.println("Salary: "+map.get(o).getSalary());

		}
	}
	public void deleteEmployee(int id) {
		if(map.containsKey(id))
		{
			map.remove(id);
			System.out.println("deleted Employee "+ id);
			for(Object o:map.keySet()) {
				System.out.println("Name: "+map.get(o).getEmpName());
				System.out.println("ID: "+map.get(o).getEmpId());
				System.out.println("Age: "+map.get(o).getAge());
				System.out.println("Department: "+map.get(o).getDepartment());
				System.out.println("Designation: "+map.get(o).getDesignation());
				System.out.println("Salary: "+map.get(o).getSalary());

			}
		}else {
			System.out.println("No employee with id "+ id +" exist");

		}



	}

	public void statistics()
	{
		System.out.println("******************************************Statistics****************************************************");
		System.out.println("----------------------------------No Of Employees In Each Dept------------------------------------------");

		TreeMap<String, Integer> duplicates = new TreeMap<String, Integer>();

		for (Object o : map.keySet()) {
			String dept=map.get(o).getDepartment();



			if (duplicates.containsKey(dept)) {
				duplicates.put(dept, duplicates.get(dept) + 1);
			} else {
				duplicates.put(dept, 1);
			}
		}
		System.out.format("Department \t No.of Employees \n");

		for (Entry<String, Integer> entry : duplicates.entrySet()) {
			System.out.format("%s \t \t %d \n", entry.getKey(), entry.getValue());
		}
		/*System.out.println("--------------------No Of Employees In Each Dept----------------");

			TreeMap<String, ArrayList<Employees>> duplicates = new TreeMap<String, ArrayList<Employees>>();

		      for (Object o : map.keySet()) {
		    	  String dept=map.get(o).getDepartment();
		    	  //String name=map.get(o).getEmpName();



		         if (duplicates.containsKey(dept)) {
		             duplicates.put(dept, null);
		         } else {
		        	 ArrayList<Employees> names=new ArrayList<Employees>();
		        	 duplicates.put(dept, names);

		         }
		      }
	    	  System.out.format("Department \t No.of Employees \n");

		      for (Entry<String, ArrayList<Employees>> entry : duplicates.entrySet()) {
		  		System.out.format("%s \t \t %d \n", entry.getKey(), entry.getValue());
		      }*/

		System.out.println("--------------------------------------------------------------------------------------------------------");

		System.out.println("Employees whose salary is grater than 50000");
		System.out.format(" \t Employee Names \n");

		for(Object o:map.keySet()) {
			if(map.get(o).getSalary()>50000) {

				System.out.format(" \t %s \n",map.get(o).getEmpName());
			}
		}
		System.out.println("-----------------------------------Highest Salarary------------------------------------------------------");

		TreeSet <Double> salary= new  TreeSet<Double>();

		for (Object o : map.keySet()) {
			double sal=map.get(o).getSalary();
			salary.add(sal);
		}
		System.out.println("Highest Salary is:"+salary.last());
		System.out.println("------------------------------------Lowest Salary-------------------------------------------------------");
		System.out.println("Lowest Salary is:"+salary.first());

		System.out.println("---------------------------Employees Older thhan 30 Years-----------------------------------------------");
		long c =map.values().stream().filter(a->a.getAge()>=30).count();
		System.out.println("Count Employees older than 30 years: "+ c);

		List<Integer> el= map.values().stream().filter(a->a.getAge()>=30).map(a->a.getEmpId()).collect(Collectors.toList());

		System.out.println("Employees who are older than 30:"+ el);


		List<String> names=map.values().stream().filter(a->a.getAge()>=30).map(a->a.getEmpName()).collect(Collectors.toList());
		System.out.println("Employees names who are older than 30 :"+ names);

		double sum=map.values().stream().map(Employees::getSalary).reduce((double) 0,(a,b)->a.doubleValue()+b.doubleValue()).doubleValue();
		System.out.println("Sum of Salaries: "+sum);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		Map<String, Long> m1=map.values().stream().collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));
		System.out.println(m1);
		for(Object o:m1.keySet())
		{
			int count=m1.get(o).intValue();
			if(count>3)
			{
				System.out.println(o);
			}
		}
		//count of employees in each department in sorted order
		Map m=new TreeMap();
		m=map.values()
				.stream()
				.sorted(Comparator.comparing(Employees::getDepartment))
				.collect(Collectors.groupingBy(Employees::getDepartment, TreeMap::new, Collectors.counting()));
		System.out.println("Count according to the dept is" +m);
		
		System.out.println("---------------------------------------List of departments which has more than 3 employees--------------------------");
		List<Object> dept=m1.entrySet().stream().filter(w->w.getValue()>2).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(dept);

		
	}
	
	public synchronized void imports()
	{
		String file ="C:\\java-programs\\CoreJavaEx1\\src\\com\\java\\employeemanagement\\empexport.txt";
		try
		{
			Employees emp =new Employees();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			while((line = br.readLine())!=null)
			{
				String[] array=line.split(",");
				String name=array[0];
				int age=Integer.parseInt(array[2]);
				String designation=array[3];
				String department=array[4];
				double salary=Double.parseDouble(array[5]);
				emp = new Employees(name, emp.getEmpId(), age, department, designation, salary);
				map.put(emp.getEmpId(), emp);
			}
			System.out.println("Employee Imported Successfully");
			br.close();
		}catch(IOException e)
		{
			System.out.println("ERROR : unable to read file " + file);
			e.printStackTrace();
		}
	}
	
	public synchronized void export() throws IOException {
		BufferedWriter bw = null;
		String str = "";
		try
		{
			File file = new File("C:\\\\java-programs\\\\CoreJavaEx1\\\\src\\\\com\\\\java\\\\employeemanagement\\\\empexport.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(Map.Entry<Integer, Employees> entry: map.entrySet())
			{
				str = "Key: "+ entry.getKey() + ". Value:" + entry.getValue();
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("File written Successfully");
	}

}





