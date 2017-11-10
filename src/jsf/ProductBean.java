package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class ProductBean {

	private String id;
	private int qty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String sale() {
		return null;
	}

}
