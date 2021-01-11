package bijrep.model;
import javax.persistence.*;
import java.util.*;
// @SuppressWarnings("unused")

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String amount;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Orders> orders;
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotal() {
		return amount;
	}

	public void setTotal(String amount) {
		this.amount = amount;
	}

	

}
