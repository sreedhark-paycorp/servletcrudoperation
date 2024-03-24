package com.cs.config;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;  
import javax.servlet.http.*;  

public class Configure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    ServletConfig config=getServletConfig();  
		    String driver=config.getInitParameter("driver"); 
		    int num = Integer.parseInt(config.getInitParameter("num"));
		    Enumeration<String> en = config.getInitParameterNames();
		    while(en.hasMoreElements()) {
		    	out.println("Driver is: "+en.nextElement());
		    }
		    out.println("Driver is: "+driver);  
		    out.println("Number is: "+num);     
		    out.close();  
		    }  

}
