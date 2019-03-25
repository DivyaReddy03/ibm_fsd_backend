package com.employeeapp.spring;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

public class DAO {
	
	

	private static String jdbcDriver;
	private static String  url;
	private static String user;
	private static String password;
	Connection conn;
	PreparedStatement pstmt;
	
	
	public DAO() {
		
	}
	public DAO(String jdbcDriver, String url, String user, String password) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.url = url;
		this.user = user;
		this.password = password;
		try {
			Class.forName(this.jdbcDriver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			conn=DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void insert(Employee e) throws ClassNotFoundException
	{
		String query="insert into employeemanagement values(?,?,?,?,?,?)";
		System.out.println(this.getJdbcDriver());
		
		try {
			Class.forName(this.jdbcDriver);
			conn=DriverManager.getConnection(this.url, this.user, this.password);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, e.getName());
			pstmt.setInt(2, e.getEmpid());
			pstmt.setInt(3, e.getAge());
			pstmt.setString(4, e.getDesignation());
			pstmt.setString(5, e.getDepartment());
			pstmt.setDouble(6, e.getSalary());
			pstmt.executeUpdate();
			System.out.println("Employee added successfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		
	}
	
	public void update(Employee e, int id)
	{
		String query="update employeemanagement set name=?, empid=?, age=?, designation=?, department=?, salary=? where id=?";
		String searchQuery="select empId from EmployeeManagement where empId=?";
		try {
			Class.forName(this.jdbcDriver);
			conn=DriverManager.getConnection(this.url, this.user, this.password);

			PreparedStatement pstmt1=conn.prepareStatement(searchQuery);
			pstmt1.setInt(1,id);
			ResultSet rs=pstmt1.executeQuery();
			if(rs.next())
			{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, e.getName());
			pstmt.setInt(2, e.getEmpid());
			pstmt.setInt(3,e.getAge());
			pstmt.setString(4,e.getDesignation());
			pstmt.setString(5, e.getDepartment());
			pstmt.setDouble(6,e.getSalary());
			pstmt.setInt(7, id);
			pstmt.executeUpdate();
			}else {
				System.out.println("Employee not found");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void view(int id)
	{
		String searchQuery="select empId from EmployeeManagement where empId=?";
		String viewQuery="select * from EmployeeManagement where empId=?";
		try {
			Class.forName(this.jdbcDriver);
			conn=DriverManager.getConnection(this.url, this.user, this.password);

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
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		

	}
	
	public void viewAll()
	{
		String viewQuery="select * from EmployeeManagement";
		try {
			Class.forName(this.jdbcDriver);
			conn=DriverManager.getConnection(this.url, this.user, this.password);

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void delete(int id) {
		String searchQuery="select empId from EmployeeManagement where empId=?";
		String deleteQuery="delete from EmployeeManagement where empId=?";

		try {
			Class.forName(this.jdbcDriver);
			conn=DriverManager.getConnection(this.url, this.user, this.password);

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
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
		
		try {
			Class.forName(this.jdbcDriver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
	
	public void imports() throws IOException{
		String O;int ctr=0;
        try {
        BufferedReader br=new BufferedReader(new FileReader("C:\\ibm_fsd_backend\\ibm_fsd_backend\\labs\\EmployeeManagementUsingSpring\\src\\com\\employeeapp\\spring\\importemployees.txt"));
        while((O=br.readLine())!=null) {
            ctr++;
            String[] array=O.split(",");
            
            String insertQuery="insert into EmployeeManagement values(?,?,?,?,?,?)";
            try
            {
    			Class.forName(this.jdbcDriver);
    			conn=DriverManager.getConnection(this.url, this.user, this.password);

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
	public void export() throws IOException{
		try {
			List<Employee> empList=new ArrayList();

			String fetchQuery="select * from EmployeeManagement";
			try {
				Class.forName(this.jdbcDriver);
				conn=DriverManager.getConnection(this.url, this.user, this.password);

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
					empList.add(new Employee(name, id, age,  designation, dept, sal));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            BufferedWriter br=new BufferedWriter(new FileWriter("C:\\ibm_fsd_backend\\ibm_fsd_backend\\labs\\EmployeeManagementUsingSpring\\src\\com\\employeeapp\\spring\\exportemployees.txt"));
            br.write("\t\t    #######################################################################################################\n");
            br.write("\t\tName: \t\t Id: \t\t Age: \t\t Designation: \t\t  Department: \t\t  Salary:\n");
            br.write("\t\t    #######################################################################################################\n");
            for(Employee el:empList) {
            	//System.out.println(el.getName());
                br.write("\t\t\t"+el.getName()+"\t\t\t"+el.getEmpid()+"\t\t\t"+el.getAge()+"\t\t\t"+el.getDesignation()+"\t\t\t"+el.getDepartment()+"\t\t\t"+el.getSalary()+"\n");
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
