package service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import any.artsoft.converter.ConvertModelToDto;
import any.artsoft.dao.ProductsDaoImpl;
import any.artsoft.dao.UsersDaoImpl;
import any.artsoft.dto.ProductDTO;
import any.artsoft.dto.UserDTO;
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
	public List<ProductDTO> ckeckUserRole(UserDTO userDTO, String role) {

		String rol = "ROLE_ADMIN";
		List<Product> products;
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 

		if (role.equals(rol)) {
			products = daoProduct.listProducts();

		} else {
			User user = ConvertModelToDto.convertDtoToUser(userDTO);
			products = user.getProducts();
		}

		try{
			productsDTO = ConvertModelToDto.convertEntityListToDtoList(products);
		}catch(NullPointerException e){
			System.out.println("Caught the NullPointerException! The User has no products!");
		}
		
				
		return productsDTO;

	}

	@Override
	public UserDTO getUser(String username) {
		
		User user = daoUser.getUserByUsername(username);
		UserDTO userDTO = ConvertModelToDto.convertUserToDto(user);
		return userDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registerUser(String username,String password) {
					
			User regUser = daoUser.register(username,password);
			daoUser.registerUserRole(regUser);
		
	}
	
	
	public boolean validatePassword(String pass1){
		
		Boolean ok = true;
		if(pass1 == null || pass1.length() < 5){
				ok = false;
		}
		
		return ok;
		
	}
	
	

}
