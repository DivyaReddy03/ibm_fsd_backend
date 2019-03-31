<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.empapp.servlet.Employee, com.empapp.servlet.EmployeeService, com.empapp.servlet.EmployeeService, java.util.List, java.util.ArrayList"%>
     

<html>
<head>
<title>Employees List</title>
</head>



<body>
	<h2>Employees List</h2>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Name</th>
			<th>Id</th>
			<th>Age</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	<% EmployeeService es=new EmployeeService();
	List<Employee> empList=new ArrayList();
	empList=es.viewEmployees();
	for(Employee emp:empList){
		%>

			<tr>
			
				<td><%out.print(emp.getName());%></td>
				<td><%out.print(emp.getEmpid()); %></td>
				<td><%out.print(emp.getAge()); %></td>
				<td><%out.print(emp.getDesignation()); %></td>
				<td><%out.print(emp.getDepartment()); %></td>
				<td><%out.print(emp.getSalary()); %></td>				
				<td><a href="updateEmployee.jsp?id=<%=emp.getEmpid() %>&name=<%=emp.getName() %>&age=<%=emp.getAge()%>&designation=<%=emp.getDesignation()%>&department=<%=emp.getDepartment() %>&salary=<%=emp.getSalary() %>" >Edit</a></td>
				<td><a href="delete.do?id=<%=emp.getEmpid()%>">Delete</a></td>
				
			</tr>
			<%} %>
	</table>
	<br />

<a href="addEmployee.jsp">Add Employee</a><br><br>

	
</body>
</html>