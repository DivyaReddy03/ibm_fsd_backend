package com.app.employeemanagement;


import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost/empApp";

	// Database credentials
	 static final String USER = "root";
	 static final String PASS = "pass@word1";
	 Connection conn=null;
	 static Scanner sc=new Scanner(System.in);

	 
	 public EmployeeService()
	 {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 }
	 
	 
	 
	

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

		//Employees e =new Employees(eName, id,  dob,age, designation, dept, sal);
		//System.out.println(eName+","+ id +","+ designation+","+dept+","+ sal);
		String insertQuery= "insert into EmployeeManagement values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, eName);
			pstmt.setInt(2, id);
			pstmt.setInt(3, age);
			pstmt.setString(4, designation);
			pstmt.setString(5, dept);
			pstmt.setDouble(6, sal);
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(e);
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
		
		String searchQuery="select empId from EmployeeManagement where empId=?";
		try {
			PreparedStatement pstmt1=conn.prepareStatement(searchQuery);
			pstmt1.setInt(1,id);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next())
			{
				System.out.println("Choose an action:");
				System.out.println("1. Update Employee Name");
				System.out.println("2. Update Employee id");
				System.out.println("3.update Employee age");
				System.out.println("4. Update Employee designation");
				System.out.println("5. Update Employee department");
				System.out.println("6. Update Employee salary");
				System.out.println("7. update all fields");
				switch(sc.nextInt())
				{
				case 1:String updateName="update  EmployeeManagement set name=? where empId=?";
					try {
						PreparedStatement pstmt =conn.prepareStatement(updateName);
						System.out.println("Enter id to update : ");
						pstmt.setInt(2, sc.nextInt());
						System.out.println("Enter name to update :");
						pstmt.setString(1, sc.next());
						pstmt.execute();
						System.out.println("Employee Scuccesfully updated");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:String updateId="update EmployeeManagement set empId=? where empId=?";
					try {
					PreparedStatement pstmt =conn.prepareStatement(updateId);
					System.out.println("Enter current id to update : ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("Enter new id to update :");
					pstmt.setInt(1, sc.nextInt());
					pstmt.execute();
					System.out.println("Employee Scuccesfully updated");

					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
				case 3:String updateage="update EmployeeManagement set age=? where empId=?";
						try {
							PreparedStatement pstmt =conn.prepareStatement(updateage);
							System.out.println("Enter  id to update employee: ");
							pstmt.setInt(2, sc.nextInt());
							System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
							String dob=sc.next();
							int age =calculateAge(dob);
							pstmt.setInt(1,  age);
							pstmt.execute();
							System.out.println("Employee age Scuccesfully updated");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				case 4:String updateDesignation="update EmployeeManagement set designation=? where empId=?";
					try {
					PreparedStatement pstmt =conn.prepareStatement(updateDesignation);
					System.out.println("Enter  id to update employee: ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("Enter designation: ");
					pstmt.setString(1,  sc.next());
					pstmt.execute();
					System.out.println("Employee designation Scuccesfully updated");

					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
				case 5:String updateDept="update EmployeeManagement set department=? where empId=?";
					try {
					PreparedStatement pstmt =conn.prepareStatement(updateDept);
					System.out.println("Enter  id to update employee: ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("Enter Department to be updated");
					pstmt.setString(1, sc.next());
					pstmt.execute();
					System.out.println("Employee age Scuccesfully updated");

					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
				case 6:String updateSalary="update EmployeeManagement set salary=? where empId=?";
					try {
					PreparedStatement pstmt =conn.prepareStatement(updateSalary);
					System.out.println("Enter  id to update employee: ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("Enter Salary to be updated");
					pstmt.setDouble(1, sc.nextDouble());
					pstmt.execute();
					System.out.println("Employee salary Scuccesfully updated");

					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
				case 7:String updateEmployee="update EmployeeManagement set name=?, empIdid=?, age=?, designation=?, department=?, salary=? where empId=?";
					try {
						PreparedStatement pstmt =conn.prepareStatement(updateEmployee);
						System.out.println("Enter  id to update employee: ");
						pstmt.setInt(7, sc.nextInt());
						System.out.println("Enter name");
						pstmt.setString(1, sc.next());
						System.out.println("Enter new id ");
						pstmt.setInt(2, sc.nextInt());
						System.out.println("Enter Date-Of-Birth(dd-MM-yyyy): ");
						String dob=sc.next();
						int age =calculateAge(dob);
						pstmt.setInt(3,  age);
						System.out.println("Enter designation");
						pstmt.setString(4, sc.next());
						System.out.println("Enter Department");
						pstmt.setString(5,sc.next());
						System.out.println("Enter Salary");
						pstmt.setDouble(6, sc.nextDouble());
							pstmt.execute();
							System.out.println("Employee salary Scuccesfully updated");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default : System.out.println("Choose valid action");
				
				}

			}else {
				System.out.println("Employee Not found");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		

	}

	public void viewEmployeeById(int id)

	{
		String searchQuery="select empId from EmployeeManagement where empId=?";
		String viewQuery="select * from EmployeeManagement where empId=?";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(searchQuery);
			pstmt1.setInt(1,id);
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next())
			{
				try {
					PreparedStatement pstmt=conn.prepareStatement(viewQuery);
					pstmt.setInt(1, id);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next())
					{
						String name=rs.getString("name");
						int eid= rs.getInt("empId");
						int age=rs.getInt("age");
						String designation=rs.getString("designaation");
						String dept=rs.getString("department");
						double salary=rs.getDouble("salary");
						
						System.out.println("-------------------Employee Details---------------------");
						System.out.println("Name: "+ name);
						System.out.println("Emp Id: "+ eid);
						System.out.println("age: "+ age);
						System.out.println("designation: "+ designation);
						System.out.println("department: "+ dept);
						System.out.println("salary: "+ salary);


					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Employee not found");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void viewEmployees()
	{
		String viewQuery="select * from EmployeeManagement";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(viewQuery);
			System.out.println("-------------------Employee Details---------------------");

			while(rs.next())
			{
				String name=rs.getString("name");
				int eid= rs.getInt("empId");
				int age=rs.getInt("age");
				String designation=rs.getString("designaation");
				String dept=rs.getString("department");
				double salary=rs.getDouble("salary");
				System.out.println();
				System.out.println("Name: "+ name);
				System.out.println("Emp Id: "+ eid);
				System.out.println("age: "+ age);
				System.out.println("designation: "+ designation);
				System.out.println("department: "+ dept);
				System.out.println("salary: "+ salary);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteEmployee(int id) {
		String searchQuery="select empId from EmployeeManagement where empId=?";
		String deleteQuery="delete from EmployeeManagement where empId=?";

		try {
			PreparedStatement pstmt1= conn.prepareStatement(searchQuery);
			pstmt1.setInt(1,id);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next())
			{
				try {
					PreparedStatement pstmt=conn.prepareStatement(deleteQuery);
					pstmt.setInt(1, id);
					pstmt.execute();
					System.out.println("Employeee Successfull deleted");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				
			}else {
				System.out.println("Employee Not found");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}
	
	public void statistics()
	{
		String query1="select department, count(empId) from EmployeeManagement group by department order by department";
		String query2="select name, max(salary) as salary from EmployeeManagement";
		String query3="select name, min(salary) as salary from EmployeeManagement";
		String query4="select name, department, max(salary) as salary from EmployeeManagement group by department";
		String query5="select name, empId, age from EmployeeManagement where age>30";
		String query6="select department, count(empId) as count from EmployeeManagement where age>30 group by department ";
		String query7="select name from EmployeeManagement where name like 'S%'";
		String query8="select department, count(empId) as count from EmployeeManagement  group by department having count>3";
		String query9="select avg(age) as average_age from EmployeeManagement group by department";
		

		Statement stmt;
		ResultSet rs;
		try {
			stmt = conn.createStatement();
			 rs=stmt.executeQuery(query1);
			 System.out.println("No of employees in each department");
			while(rs.next())
				
			{
				System.out.print(rs.getString(1) +" : ");
				System.out.println(rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
			
		}
		System.out.println("Highest Salary");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query2);
			while(rs.next())
				
			{
				System.out.print(rs.getString("name")+" : ");
				System.out.println(rs.getDouble("Salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Lowest Salary");
		try {
			stmt=conn.createStatement();
			ResultSet rs1=stmt.executeQuery(query3);
			while(rs1.next())
				
			{
				System.out.print(rs1.getString("name")+" : ");
				System.out.println(rs1.getDouble("Salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Highest Salary in each department");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query4);
			while(rs.next())
				
			{
				System.out.println(rs.getString("department"));
				System.out.print(rs.getString("name")+" : ");
				System.out.println(rs.getDouble("Salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employees Older than 30 years");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query5);
			System.out.println("id "+" "+"name "+" "+"age");

			while(rs.next())
				
			{
				System.out.print(rs.getInt("empId")+ "   ");
				System.out.print(rs.getString("name")+"   ");
				System.out.println(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count of Employees Older than 30 years in each department");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query6);
			while(rs.next())
				
			{
				System.out.print(rs.getString("department")+" : ");
				System.out.println(rs.getInt("count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Average Employee age by dept");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query9);
			while(rs.next())
				
			{
				System.out.println(rs.getInt("average_age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employees whose name starts with s");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query7);
			while(rs.next())
				
			{
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("List of departments which has more than 3 employees");
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query8);
			while(rs.next())
				
			{
				System.out.println(rs.getString("department"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Import() throws IOException {
        String O;int ctr=0;
        try {
        BufferedReader br=new BufferedReader(new FileReader("C:\\java-programs\\Assignements\\Employee Management using JDBC\\EmployeeManagement\\src\\com\\app\\employeemanagement\\importemployees.txt"));
        while((O=br.readLine())!=null) {
            ctr++;
            String[] array=O.split(",");
            
            String insertQuery="insert into EmployeeManagement values(?,?,?,?,?,?)";
            try
            {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, array[0]);
			pstmt.setInt(2, Integer.parseInt(array[1]));
			pstmt.setInt(3, Integer.parseInt(array[2]));
			pstmt.setString(4, array[3]);
			pstmt.setString(5, array[4]);
			pstmt.setDouble(6, Double.parseDouble(array[5]));
			pstmt.execute();
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(ctr+" Employees Imported Successfully");
        
    }
        br.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	//Export Method
	public void Export()throws IOException {
        
		try {
			List<Employees> empList=new ArrayList();

			String fetchQuery="select * from EmployeeManagement";
			try {
				Statement stmt= conn.createStatement();
				ResultSet rs=stmt.executeQuery(fetchQuery);
				while(rs.next())
				{
					String name=rs.getString(1);
					int id=rs.getInt(2);
					int age=rs.getInt(3);
					String designation=rs.getString(4);
					String dept=rs.getString(5);
					double sal=rs.getDouble(6);
					empList.add(new Employees(name, id, age,  designation, dept, sal));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            BufferedWriter br=new BufferedWriter(new FileWriter("C:\\java-programs\\Assignements\\Employee Management using JDBC\\EmployeeManagement\\src\\com\\app\\employeemanagement\\exportemployees.txt"));
            br.write("\t\t    #######################################################################################################\n");
            
            br.write("\t\tName: \t\t Id: \t\t Age: \t\t Designation: \t\t  Department: \t\t  Salary:\n");
            br.write("\t\t    #######################################################################################################\n");
            for(Employees el:empList) {
                br.write("\t\t\t"+el.getEmpName()+"\t\t\t"+el.getEmpId()+"\t\t\t"+el.getAge()+"\t\t\t"+el.getDesignation()+"\t\t\t"+el.getDepartment()+"\t\t\t"+el.getSalary()+"\n");
                br.write("\t\t    --------------------------------------------------------------------------------------------------------\n");
            
        }
        br.close();
        
    }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Export Successful");
}
	
	
	
	
	
	
	
	
	
	

	

}





