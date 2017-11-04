package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloService {
	
	@GET
	@Produces("text/plain")
	public String get() {
		return "Hello!";
	}
	
	@GET
	@Path("/{name}")
	@Produces("text/html")
	public String wish(@PathParam("name") String name) {
		return  "<h1>" + "Hello, " + name + "</h1>";
	}

}
