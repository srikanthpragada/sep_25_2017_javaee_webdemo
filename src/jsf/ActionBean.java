package jsf;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ActionBean {
	private String message, timezone = "IST";

	public String getTimezone() {
         return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String process() {
		message = new Date().toString();
		return null;
	}
}
