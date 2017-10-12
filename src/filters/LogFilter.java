package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// @WebFilter("*.jsp")
public class LogFilter implements Filter {
	public void destroy() {
		 
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// pre
	    HttpServletRequest req = (HttpServletRequest) request;
	    System.out.println(req.getRequestURL());
	    System.out.println(req.getRemoteAddr());
		chain.doFilter(request, response); // go to original request
		// post
		System.out.println("Done");
	}

	 
	public void init(FilterConfig fConfig) throws ServletException {
		 
	}

}
