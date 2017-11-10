package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
	private String uname, password, message;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String login() {
		if ( uname.equals("abc") && password.equals("admin"))
			return "home";
		else
		{
			message = "Invalid Login!";
			return "login";
		}
	}
}
