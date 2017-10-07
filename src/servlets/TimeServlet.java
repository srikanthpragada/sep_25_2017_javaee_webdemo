package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(urlPatterns = { "/time" })
public class TimeServlet extends HttpServlet {

	private int count = 0;
	private String topic;
	
	@Override 
	public void init(ServletConfig config) {
		
		topic = config.getInitParameter("topic");
		System.out.println("init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		out.println("<h1>" + new Date()  + "</h1>");
		out.println("<h1>" + count++ + "</h1>");
		// System.out.println(request.getClass());
		
	}

}
