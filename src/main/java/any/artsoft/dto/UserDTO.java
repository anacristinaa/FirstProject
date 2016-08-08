package any.artsoft.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import any.artsoft.model.Product;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String username;
	private String password;
	private boolean enabled;
	private Date lastaction;
	
	private List<Product> products;
	
	public UserDTO(){
		
	}
	
	public UserDTO(int id,String name,String pass,Date date){
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastaction() {
		return lastaction;
	}

	public void setLastaction(Date lastaction) {
		this.lastaction = lastaction;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String toString() {
		return " U: " + this.getUser_id() + " " + this.getUsername() + " " + this.getLastaction();
	}

}
