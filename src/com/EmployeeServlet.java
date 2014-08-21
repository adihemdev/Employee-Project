package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmDB;


/**
 * Servlet implementation class for Servlet: EServlet
 *
 */
 public class EServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("Name");
		String identity=request.getParameter("id");
		String sal=request.getParameter("Salary");
		String manager=request.getParameter("Manager");
		
	     PrintWriter p= response.getWriter(); 	
         System.out.println(name + " " + identity + " "  +sal + " " + manager);
         EmDB ed= new EmDB();
         ed.createConnection();
         /*if(ed.isEmployee(name))
         {
        	 RequestDispatcher r= request.getRequestDispatcher("searchemp.html");
        	 r.forward(request, response);
         }*/
         //else
         //{
        	 ed.addEmployee(identity, name, sal, manager);
        	 RequestDispatcher r= request.getRequestDispatcher("success.html");
        	 r.forward(request, response);
         //}
		ed.closeConnection();
		
		
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}