package com.cs;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class Profile extends HttpServlet {  
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

request.getRequestDispatcher("link.html").include(request, response);  

Cookie[] cookies = request.getCookies();  
if (cookies != null) {  
for (Cookie cookie : cookies) {
if (cookie.getName().equals("name")) { // Assuming the cookie name is "name"
  String name = cookie.getValue();  
  if (name != null && !name.isEmpty()) {  
      out.print("<b>Welcome to Profile</b>");  
      out.print("<br>Welcome, " + name);  
      out.close();
      return; // Exit the method after successful retrieval
  }  
}
}
}

out.print("Please login first");  
request.getRequestDispatcher("login.html").include(request, response);  
out.close();  
}

}  