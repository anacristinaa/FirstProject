package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import any.artsoft.dao.ProductsDaoImpl;
import any.artsoft.dao.UsersDaoImpl;
import any.artsoft.model.Product;
import any.artsoft.model.User;

@Service
public class ProductsServiceImpl implements ProductsServiceInterface {

	@Autowired
	ProductsDaoImpl daoProduct;

	@Autowired
	UsersDaoImpl daoUser;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addProduct(Product product, String username) {

		User user = daoUser.getUserByUsername(username);
		daoUser.updateLastAction(user);
		daoProduct.create(product.getName(), product.getDescription(), product.getPrice(), user);

	}

	@Override
	public Product getProductById(int product_id) {

		Product product = daoProduct.getProduct(product_id);
		return product;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateProduct(Product product, String username) {

		User user = daoUser.getUserByUsername(username);
		daoUser.updateLastAction(user);
		daoProduct.update(product);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteProduct(int product_id, String username) {

		daoProduct.delete(product_id);
		User user = daoUser.getUserByUsername(username);
		daoUser.updateLastAction(user);

	}

}
