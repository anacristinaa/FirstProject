package service;

import any.artsoft.dto.ProductDTO;

public interface ProductsServiceInterface {
	
	public void addProduct(ProductDTO product, String username);
	public ProductDTO getProductById(int product_id);
	public void updateProduct(ProductDTO product, String username);
	public void deleteProduct(int product_id, String username);

}
