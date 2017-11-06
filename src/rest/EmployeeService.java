package rest;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/employees")
public class EmployeeService {
	
	@GET
	@Produces("application/json")
	public String get() {
		
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartArray();
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees");
			crs.execute();

			while (crs.next()) {
				gen.writeStartObject();
				gen.write("name", crs.getString("first_name"));
				gen.write("salary", crs.getString("salary"));
				gen.writeEnd();  // end of object
			}

			gen.writeEnd();  // end of array
			gen.close();
			return sw.toString();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
		
	}
	
	
	@GET
	@Path("/dept/{dept}")
	@Produces("application/json")
	public String getEmpByDept(@PathParam ("dept") String dept) {
		
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartArray();
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where department_id = ?");
			crs.setString(1,  dept);
			crs.execute();

			while (crs.next()) {
				gen.writeStartObject();
				gen.write("name", crs.getString("first_name"));
				gen.write("salary", crs.getString("salary"));
				gen.writeEnd();  // end of object
			}

			gen.writeEnd();  // end of array
			gen.close();
			return sw.toString();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "[]" ; // empty array
		
	}

	
	@GET
	@Path("/job/{job}")
	@Produces("application/json")
	public String getEmpByJob(@PathParam ("job") String job) {
		
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartArray();
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where job_id = ?");
			crs.setString(1,  job);
			crs.execute();

			while (crs.next()) {
				gen.writeStartObject();
				gen.write("name", crs.getString("first_name"));
				gen.write("salary", crs.getString("salary"));
				gen.writeEnd();  // end of object
			}

			gen.writeEnd();  // end of array
			gen.close();
			return sw.toString();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	    return "[]" ; // empty array
		
	}
	
	
	@GET
	@Path("/jobs")
	@Produces("application/json")
	public String getJobs() {
		
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartArray();
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			while (crs.next()) {
				gen.writeStartObject();
				gen.write("id", crs.getString("job_id"));
				gen.write("title", crs.getString("job_title"));
				gen.writeEnd();  // end of object
			}

			gen.writeEnd();  // end of array
			gen.close();
			return sw.toString();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "[]" ; // empty array
		
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateSalary(@FormParam("id") int id, @FormParam("salary") int salary) {
		// code 
	}



	
}
