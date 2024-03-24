package com.filter;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.*;

public class Demo implements Filter {  
	   
	FilterConfig config;
	  
	public void init(FilterConfig config) throws ServletException {  
		this.config = config;
	}  
	      
	public void doFilter(ServletRequest req, ServletResponse resp,  
	    FilterChain chain) throws IOException, ServletException {  
	          
	    PrintWriter out=resp.getWriter();  
	    out.print("filter is invoked before");  
	    String password=req.getParameter("password"); 

	    String s=config.getInitParameter("construction"); 
	    
	    if("no".equals(s)){  
	    chain.doFilter(req, resp);//sends request to next resource  
	    }  
	    else{  
	    out.print("username or password error!");  
	    resp.setContentType("text/html");
	    RequestDispatcher rd=req.getRequestDispatcher("index.html");  
	    rd.include(req, resp);  
	    } 
	}
	    public void destroy() {}  
	}  

