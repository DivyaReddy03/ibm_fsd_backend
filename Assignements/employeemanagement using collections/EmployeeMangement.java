package com.java.employeemanagement;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmployeeMangement {

	static Scanner sc=new Scanner(System.in);	
	static int op;
	static char choice;
	static boolean flag=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService es=new EmployeeService();
			do {
				System.out.println("Choose an action: ");
				System.out.println("1. add Employee");
				System.out.println("2. update Employee");
				System.out.println("3. View Employee by id");
				System.out.println("4. View All Employees");
				System.out.println("5.Delete Employee");
				System.out.println("6. Statistics");
				System.out.println("7.Import Employees");
				System.out.println("8.Export Employees");
				
					switch(sc.nextInt())
					{
					case 1: es.addEmployee();
							break;
					case 2: System.out.println("Enter employee id:");
							es.updateEmployee(sc.nextInt());
							break;
					case 3: System.out.println("Enter employee id:");
							es.viewEmployeeById(sc.nextInt());
							break;
					case 4:	es.viewEmployees();
							break;
					case 5: System.out.println("Enter employee id:");
							es.deleteEmployee(sc.nextInt());
							break;
					case 6: es.statistics();
							break;
					case 7: Callable<Boolean> importsThreads1 = new Callable<Boolean>()
							{

								@Override
								public Boolean call() throws Exception {
									// TODO Auto-generated method stub
									System.out.println(Thread.currentThread()+ "waiting for 5s");
									Thread.sleep(5000);
									es.imports();
									return null;
								}
						
							};
							ExecutorService executors = Executors.newFixedThreadPool(3);
							@SuppressWarnings("unused")
							Future<Boolean> importfutures = executors.submit(importsThreads1);
							System.out.println(Thread.currentThread().getName() + "Export process triggered");
							break;
					case 8: Callable<Boolean> importsThreads2 = new Callable<Boolean>()
					{

						@Override
						public Boolean call() throws Exception {
							// TODO Auto-generated method stub
							System.out.println(Thread.currentThread()+ "waiting for 5s");
							Thread.sleep(5000);
							es.export();
							return null;
						}
				
					};
					ExecutorService executors1 = Executors.newFixedThreadPool(3);
					@SuppressWarnings("unused")
					Future<Boolean> importfutures1 = executors1.submit(importsThreads2);
					System.out.println(Thread.currentThread().getName() + "Import process triggered");
					break;
					default:System.out.println("choose valid action");
					}
					System.out.println("Do you want to continue Y/N :");
					choice=sc.next().charAt(0);
				
				
			
			}
	
			while(choice=='Y'||choice=='y');
	
	}

			
		
		
	}


