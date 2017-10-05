package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateSalary")
public class UpdateSalaryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String salary = request.getParameter("salary");


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
				Statement st = con.createStatement();
				int count = st.executeUpdate("update employees set salary = " + salary + " where employee_id = " + id);
				if ( count == 1)
					out.println("<h3>Updated Successfully!</h3>");
				else
					out.println("<h3>Sorry! Employee Id Not Found!</h3>");
			}

		} catch (Exception ex) {
            out.println("<h3>Sorry! Couldn't update due to error!</h3>");
            System.out.println(ex.getMessage());
		}

	}

}
