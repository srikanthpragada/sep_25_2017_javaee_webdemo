package jsf;


import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ManagedBean
public class ProductBean {
	private String id;
    private int qty;

	
	@NotNull(message = "Product Id is required!")
	@Pattern(regexp="^[0-9]{4}$", message="Invalid Product ID")
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	@Min(message = "Minimum qty is 1", value = 1 )
	@Max(message = "Maximum qty is 10", value = 10 ) 
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
