package com.empapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/register.do")
public class AdminServlet extends HttpServlet{
	public void init() {
		System.out.println(" adminServlet init method called");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		HttpSession session = req.getSession();
		session.setAttribute("user", name);
		session.setAttribute("password", password);
		RequestDispatcher rd=req.getRequestDispatcher("RegistrationSuccess.jsp");
		rd.forward(req,  resp);		
	}
	/*public void dpPost(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		HttpSession session = req.getSession();
		session.setAttribute("user", name);
		session.setAttribute("password", password);
		RequestDispatcher rd=req.getRequestDispatcher("RegistrationSuccess.jsp");
		rd.forward(req,  resp);
	}*/
}
