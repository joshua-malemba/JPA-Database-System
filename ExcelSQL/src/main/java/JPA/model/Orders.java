package JPA.model;
import javax.persistence.*;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "products")
	private String products;
	
	@Column(name = "amount")
	private String amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amounts) {
		this.amount = amounts;
	}
	

}
