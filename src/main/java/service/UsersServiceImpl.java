package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Product> ckeckUserRole(User user, String role) {

		String rol = "ROLE_ADMIN";
		List<Product> products;

		if (role.equals(rol)) {
			products = daoProduct.listProducts();

		} else {
			products = user.getProducts();

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
	public void registerUser(String username,String password) {
				
			User regUser = daoUser.register(username,password);
			System.out.println("Registered User: " + regUser.toString());
			daoUser.registerUserRole(regUser);
		
	}

}
