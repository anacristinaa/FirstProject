package any.artsoft.model;

import java.io.Serializable;

import javax.persistence.*;

import any.artsoft.dto.UserDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	
	@Column
	private String name;

	@Column
	private String description;
	
	@Column
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Product(){
		
	}
	
	public Product(int id,String user,String descr,int p,UserDTO u){
		
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString(){
		return "ID " + this.product_id + 
				" " + this.name + 
				" " + this.description + 
				" " + this.price;
	}
	
}
