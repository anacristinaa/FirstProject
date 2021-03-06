package any.artsoft.dao;

import java.util.List;
import javax.sql.DataSource;
import any.artsoft.model.Product;


public interface ProductsDaoInterface {
	
	
	   public void setDataSource(DataSource ds);
	  
	   public void create(String name,String description,int price,int user_id);
	
	   public Product getProduct(int product_id);
	 
	   public List<Product> listProducts();
	  
	   public void delete(int product_id);
	  
	   public void update(Product product);

}
