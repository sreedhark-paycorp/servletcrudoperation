package com.demo.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")

public class Demo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Employee ee = new Employee();
	JDBCDemo ej = new JDBCDemo();

	public void service(HttpServletRequest req, HttpServletResponse res) {
		String act = req.getParameter("action");

		/**
		String action = req.getServletPath();

		if (action.contains("insert")) {

			try {
				showNewForm(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}  */

		if ("insert".equals(act)) {
			try {
				ee.setEid(Integer.parseInt(req.getParameter("eid")));
				ee.setEname(req.getParameter("ename"));
				ee.setGender(req.getParameter("gender"));
				ej.insertEmp(ee);
				PrintWriter out = res.getWriter();
				
				out.println("Inserted Successfully");
				res.setContentType("text/html");
				out.println("<!DOCTYPE html>");
		    	out.println("<html lang=\"en\">");
			    out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<a href=\"index.jsp\">Click here</a>");
				out.println("</body>");
				out.println("</html>");
				
				out.close();
			} catch (IOException s) {
				System.out.println(s);
			}
		} else if ("disp".equals(act)) {
			List<Employee> al = new ArrayList<>();
			al = ej.listOfEmp();
			try {
				PrintWriter out = res.getWriter();
				
				    out.println("<!DOCTYPE html>");
				    out.println("<html lang=\"en\">");
				    out.println("<head>");
				    out.println("    <meta charset=\"UTF-8\">");
				    out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
				    out.println("    <title>Employee Details</title>");
				    out.println("    <!-- Bootstrap CSS -->");
				    out.println("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
				    out.println("</head>");
				    out.println("<body>");
				    out.println("<header>\n"
				    		+ "<ul class=\"nav nav-pills nav-fill\">\n"
				    		+ "  <li class=\"nav-item\">\n"
				    		+ "    <a class=\"nav-link bg-light\" href=\"insert.jsp\" target=\"_self\">Insert Employee</a>\n"
				    		+ "  </li>\n"
				    		+ "  <li class=\"nav-item\">\n"
				    		+ "    <a class=\"nav-link bg-light\" href=\"Demo?action=disp\">Display Employees</a>\n"
				    		+ "  </li>\n"
				    		+ "  <li class=\"nav-item\">\n"
				    		+ "    <a class=\"nav-link bg-light\" href=\"update.jsp\">Update Employee</a>\n"
				    		+ "  </li>\n"
				    		+ "  <li class=\"nav-item\">\n"
				    		+ "    <a class=\"nav-link  bg-light\" href=\"delete.jsp\">Delete Employee</a>\n"
				    		+ "  </li>\n"
				    		+ "</ul>\n"
				    		+ "\n"
				    		+ "  </header>");
				    
				    out.println("    <div class=\"container mt-5\">");
				    out.println("        <h2>Employee Details</h2>");
				    out.println("        <table class=\"table\">");
				    out.println("            <thead>");
				    out.println("                <tr>");
				    out.println("                    <th>ID</th>");
				    out.println("                    <th>Name</th>");
				    out.println("                    <th>Gender</th>");
				    out.println("                </tr>");
				    out.println("            </thead>");
				    out.println("            <tbody>");
				    
				    for (Employee e : al) {
				        out.println("                <tr>");
				        out.println("                    <td>" + e.getEid() + "</td>");
				        out.println("                    <td>" + e.getEname() + "</td>");
				        out.println("                    <td>" + e.getGender() + "</td>");
				        out.println("                </tr>");
				    }
				    
				    out.println("            </tbody>");
				    out.println("        </table>");
				    out.println("    </div>");
				    out.println("</body>");
				    out.println("<footer class=\"footer mt-auto py-3 bg-light text-muted text-center\">\n"
				    		+ "    <div class=\"container\">\n"
				    		+ "        <p class=\"small mb-0\">&copy; 2024 paycorp.io</p>\n"
				    		+ "    </div>\n"
				    		+ "</footer>");
				    out.println("</html>");
			
				out.close();
			} catch (IOException i) {
				System.out.println(i);
			}
		} else if ("update".equals(act)) {
			ee.setEname(req.getParameter("uname"));
			ee.setGender(req.getParameter("ugender"));
			ej.updateEmp(Integer.parseInt(req.getParameter("uid")), ee);
			try {
				PrintWriter out = res.getWriter();
				out.println("Updated Successfully");
				res.setContentType("text/html");
				out.println("Inserted");
				out.println("<!DOCTYPE html>");
		    	out.println("<html lang=\"en\">");
			    out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<a href=\"index.jsp\">Click here</a>");
				out.println("</body>");
				out.println("</html>");
			} catch (IOException a) {
				System.out.println(a);
			}

		} else if ("delete".equals(act)) {
			ej.deleteEmp(Integer.parseInt(req.getParameter("did")));
			try {
				PrintWriter out = res.getWriter();
				out.println("Deleted Successfully");
				res.setContentType("text/html");
				out.println("Inserted");
				out.println("<!DOCTYPE html>");
		    	out.println("<html lang=\"en\">");
			    out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<a href=\"index.jsp\">Click here</a>");
				out.println("</body>");
				out.println("</html>");
			} catch (IOException a) {
				System.out.println(a);
			}
		}

	}

	/** 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
		dispatcher.forward(request, response);
	}
	*/
}
