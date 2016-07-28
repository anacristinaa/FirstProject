package service;

import any.artsoft.model.Product;

public interface ProductsServiceInterface {
	
	public void addProduct(Product product, String username);
	public Product getProductById(int product_id);
	public void updateProduct(Product product, String username);
	public void deleteProduct(int product_id, String username);

}
