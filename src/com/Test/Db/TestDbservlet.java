package com.Test.Db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDbservlet
 */
@WebServlet("/TestDbservlet")
public class TestDbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Setup connection 
		String user="springstudent";
		String pass="springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
				
				PrintWriter out =response.getWriter();
				
				out.println("connecting to jdbc:"+jdbcUrl);
				
				Class.forName(driver);
				
				Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);	
				out.println(myconn);
				out.println("sucess !!!!!!");
				
				myconn.close();
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		
	}

}
