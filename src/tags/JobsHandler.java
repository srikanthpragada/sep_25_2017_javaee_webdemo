package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		 JspWriter writer = this.getJspContext().getOut();
		 
			try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
				crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
				crs.setUsername("hr");
				crs.setPassword("hr");
				crs.setCommand("select * from jobs");
				crs.execute();
				writer.println("<table border='1' width='100%' cellpadding='5px'><tr><th>Id</th><th>Title</th><th>Min Salary </th></tr>");
				
				while (crs.next()) {
				  writer.println( 
						    String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
		                        crs.getString("job_id"),
		                        crs.getString("job_title"),
		                        crs.getString("min_salary")));
				}
			}
			catch(Exception ex)  {
				System.out.println(ex);
			}
		 
	}
	
	 

}
