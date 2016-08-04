package any.artsoft.dao;

import java.util.List;
import any.artsoft.model.Product;
import any.artsoft.model.User;

public interface UserDaoInterface {
	
	public User register(String username,String password);
	public User getUser(int user_id);
	public void updateLastAction(User user);
	public List<User> listUsers();
	public User getUserByUsername(String username);
	public List<Product> getUsersProduct(int user_id);
	public void registerUserRole(User user);

}
