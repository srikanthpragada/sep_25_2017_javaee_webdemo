package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {

	// property jobs
	public RowSet getJobs() {

		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			return crs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	// property jobs
	public List<String> getTitles() {

		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select job_title from jobs");
			crs.execute();

			ArrayList<String> titles = new ArrayList<>();
			while (crs.next()) {
				titles.add(crs.getString("job_title"));
			}
			return titles;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
