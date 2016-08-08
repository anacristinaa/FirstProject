package any.artsoft.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ProductDTO implements Serializable {
	
	private int product_id;
	private String name;
	private String description;
	private int price;
	private UserDTO userDTO;
	
	public ProductDTO(){
		
	}
	
	public ProductDTO(int id,String user,String descr,int p,UserDTO u){
		
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

	public UserDTO getUser() {
		return userDTO;
	}

	public void setUser(UserDTO user) {
		this.userDTO = user;
	}
	
	public String toString(){
		return "Id " + this.product_id + 
				" " + this.name + 
				" " + this.description + 
				" " + this.price;
	}
	
	

}
