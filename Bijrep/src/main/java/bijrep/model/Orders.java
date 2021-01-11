package bijrep.model;

import java.util.List;

import javax.persistence.*;
// @SuppressWarnings("unused")

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String amount;
	
	private String dates;
	
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@ManyToMany
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTotal() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Customer getCustomers() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getDate() {
		return dates;
	}

	public void setDate(String dates) {
		this.dates = dates;
	}

	
	
	

}
