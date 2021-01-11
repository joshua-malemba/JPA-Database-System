package bijrep.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String amount;
	
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Orders> orders;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	

}
