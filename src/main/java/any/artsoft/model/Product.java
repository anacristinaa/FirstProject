package any.artsoft.model;

public class Product {

	private int product_id;
	private String name;
	private String description;
	private int price;
	private int user_id;
	
	
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String toString(){
		return "ID " + this.product_id + 
				" " + this.name + 
				" " + this.description + 
				" " + this.price + 
				" " + this.user_id;
	}
	
}
