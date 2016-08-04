package any.artsoft.dao;

import java.util.List;
import any.artsoft.model.Product;
import any.artsoft.model.User;


public interface ProductsDaoInterface {
	  
	   public void create(String name,String description,int price, User user);
	
	   public Product getProduct(int product_id);
	 
	   public List<Product> listProducts();
	  
	   public void delete(int product_id);
	  
	   public void update(Product product);

}
