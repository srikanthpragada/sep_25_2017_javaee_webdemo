package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Jobs3Handler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = this.getJspContext().getOut();
		PageContext ctx = (PageContext) getJspContext();
		JspFragment body = this.getJspBody();

		try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			while (crs.next()) {
                   ctx.setAttribute("id",  crs.getString("job_id"));
                   ctx.setAttribute("title",  crs.getString("job_title"));
                   ctx.setAttribute("minSalary",  crs.getInt("min_salary"));
                   body.invoke(writer);  // process body and write result to client  
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
