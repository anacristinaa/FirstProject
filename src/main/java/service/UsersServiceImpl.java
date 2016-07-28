package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import any.artsoft.dao.ProductsDaoImpl;
import any.artsoft.dao.UsersDaoImpl;
import any.artsoft.model.Product;
import any.artsoft.model.User;

@Service
public class UsersServiceImpl implements UsersServiceInterface {

	@Autowired
	ProductsDaoImpl daoProduct;

	@Autowired
	UsersDaoImpl daoUser;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Product> ckeckUserRole(String username, String role) {

		String rol = "ROLE_ADMIN";
		User user = daoUser.getUserByUsername(username);
		List<Product> products;

		if (role.equals(rol)) {
			products = daoProduct.listProducts();

		} else {
			int user_id = user.getUser_id();
			products = daoUser.getUsersProduct(user_id);

		}

		return products;

	}

	@Override
	public User getUser(String username) {

		User user = daoUser.getUserByUsername(username);

		return user;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registerUser(User user) {
		
			daoUser.register(user.getUsername(), user.getPassword());
			User regUser = daoUser.getUserByUsername(user.getUsername());
			daoUser.registerUserRole(regUser);
		
	}

}
