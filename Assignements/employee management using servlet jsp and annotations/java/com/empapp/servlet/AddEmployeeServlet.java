package com.empapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/add.do") 
public class AddEmployeeServlet extends HttpServlet {

	public void init() {
		System.out.println("Init method called");
	}
	/*public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}*/
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String name=req.getParameter("name");
		int empid=Integer.parseInt(req.getParameter("id"));
		int age=Integer.parseInt(req.getParameter("age"));
		String designation=req.getParameter("designation");
		String department=req.getParameter("department");
		double salary=Double.parseDouble(req.getParameter("salary"));
		Employee emp=new Employee(name, empid, age, designation, department, salary);
		EmployeeService es = new EmployeeService();
		es.addEmployee(emp);
		resp.sendRedirect("displayEmpList.jsp");
	}
}
