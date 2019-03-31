package com.empapp.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/delete.do")
public class DeleteServlet extends HttpServlet {
	public void init() {
		System.out.println("delete Servlet");
	}

		public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
		{
			int id= Integer.parseInt(req.getParameter("id"));
			EmployeeService es=new EmployeeService();
			es.deleteEmployee(id);
			resp.sendRedirect("displayEmpList.jsp");
		}
}
