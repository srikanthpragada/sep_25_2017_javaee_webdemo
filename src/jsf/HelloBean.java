package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class HelloBean {
	private String name = "Srikanth", title = "";

	public HelloBean() {
		System.out.println("HelloBean()");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}

	// property title
	public String getTitle() {
		System.out.println("getTitle()");
		return title;
	}

	public void greet(ActionEvent evt) {
		System.out.println("greet()");
        title = "Hello, " + name.toUpperCase();
	}
	
	public void changed(ValueChangeEvent evt) {
		System.out.println("changed name. New name : " + evt.getNewValue());
	}
}
