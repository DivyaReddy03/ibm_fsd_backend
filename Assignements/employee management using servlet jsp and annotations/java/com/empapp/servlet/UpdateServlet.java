package com.empapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/update.do")
public class UpdateServlet extends HttpServlet{
	
	public void init()
	{
		System.out.println("UpdateEmployee Servlet");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	
		String name=req.getParameter("name");
		String id=req.getParameter("empid");
		int eid=Integer.parseInt(id);
		int age=Integer.parseInt(req.getParameter("age"));
		String designation=req.getParameter("designation");
		String department=req.getParameter("department");
		double salary=Double.parseDouble(req.getParameter("salary"));
		Employee emp=new Employee(name, eid, age, designation, department, salary);
		EmployeeService es = new EmployeeService();
		es.updateEmployee(emp, eid);
		resp.sendRedirect("displayEmpList.jsp");
		
	
	}
}
