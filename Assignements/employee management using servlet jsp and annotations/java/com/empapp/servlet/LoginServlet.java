package com.empapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/login.do")
public class LoginServlet extends HttpServlet{
	public void init() {
		System.out.println("init method called");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RequestDispatcher rd;
		String user =req.getParameter("name");
		String password=req.getParameter("password");
		if((user.equalsIgnoreCase((String) session.getAttribute("user")))&&( password.equals(session.getAttribute("password")))){
			 rd= req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
			
		}else {
			rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}
	}

}
