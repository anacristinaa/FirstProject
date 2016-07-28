package service;

import java.util.List;

import any.artsoft.model.Product;
import any.artsoft.model.User;

public interface UsersServiceInterface {
	
	public List<Product> ckeckUserRole(String username, String role);
	public User getUser(String username);
	public void registerUser(User user);
	

}
