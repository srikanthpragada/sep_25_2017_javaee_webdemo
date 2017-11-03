package jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import oracle.jdbc.rowset.OracleCachedRowSet;

@WebService
public class JobsService {

	@WebMethod
	public boolean updateTitle(String id, String title) {
		return true; 
	}
	
	
	@WebMethod
	public List<Job> getJobs() {
		try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				jobs.add(new Job(crs.getString("job_id"), crs.getString("job_title")));
			}

			return jobs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@WebMethod
	public List<Job> searchJobs(String title) {
		try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where job_title like ?");
			crs.setString(1,  "%" + title + "%");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				jobs.add(new Job(crs.getString("job_id"), crs.getString("job_title")));
			}

			return jobs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	
	@WebMethod
	public String getJobTitle(String id) {
		try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where job_id = ?");
			crs.setString(1, id);
			crs.execute();
			
			if ( crs.next())
				return crs.getString("job_title");
			else
				return null;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
