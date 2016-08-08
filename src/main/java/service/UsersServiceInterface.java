package service;

import java.util.List;

import any.artsoft.dto.ProductDTO;
import any.artsoft.dto.UserDTO;

public interface UsersServiceInterface {
	
	public List<ProductDTO> ckeckUserRole(UserDTO user, String role);
	public UserDTO getUser(String username);
	public void registerUser(String username,String password);
	

}
