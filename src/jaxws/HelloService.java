package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {

	@WebMethod
	public String hello() {
		return "Hello SOAP World!";
	}
}
