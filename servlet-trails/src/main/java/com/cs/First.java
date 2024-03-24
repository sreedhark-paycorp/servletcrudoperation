package com.cs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		
		Integer a = 10;
		
		PrintWriter out = res.getWriter();
		out.println("sum = "+(a+a));
		req.setAttribute("A",a);
		String s = req.getParameter("param");
	    RequestDispatcher rd = req.getRequestDispatcher("second");
	    Cookie k = new Cookie("un",s);
	    res.addCookie(k);
	    out.println("sum = "+k.getValue());
	   // res.setContentType("text/html");
	    rd.include(req, res);
	    
	}

}
