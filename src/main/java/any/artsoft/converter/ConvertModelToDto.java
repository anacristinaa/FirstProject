package any.artsoft.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import any.artsoft.dto.ProductDTO;
import any.artsoft.dto.UserDTO;
import any.artsoft.model.Product;
import any.artsoft.model.User;

public class ConvertModelToDto {

	public static Product convertDtoToProduct(ProductDTO productDTO, User user) {

		Product product = new Product();
		product.setProduct_id(productDTO.getProduct_id());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setUser(user);

		return product;
	}

	public static ProductDTO convertProductToDto(Product product, UserDTO userDTO) {

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(product.getProduct_id());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setUser(userDTO);

		return productDTO;
	}

	public static User convertDtoToUser(UserDTO userDto) {

		User user = new User();
		user.setUser_id(userDto.getUser_id());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEnabled(userDto.isEnabled());
		user.setLastaction(userDto.getLastaction());
		user.setProducts(userDto.getProducts());

		return user;

	}

	public static UserDTO convertUserToDto(User user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(user.getUser_id());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEnabled(user.isEnabled());
		userDTO.setLastaction(user.getLastaction());
		userDTO.setProducts(user.getProducts());
		return userDTO;

	}

	@SuppressWarnings("rawtypes")
	public static List<Product> convertDtoListToEntityList(List<ProductDTO> productsDTO) {

		List<Product> products = new ArrayList<Product>();
		Iterator it = productsDTO.iterator();

		while (it.hasNext()) {
			ProductDTO prod = (ProductDTO) it.next();
			User user = ConvertModelToDto.convertDtoToUser(prod.getUser());
			Product product = ConvertModelToDto.convertDtoToProduct(prod, user);
			products.add(product);

		}

		return products;

	}

	@SuppressWarnings("rawtypes")
	public static List<ProductDTO> convertEntityListToDtoList(List<Product> products) {

		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		Iterator it = products.iterator();

		while (it.hasNext()) {
			Product prod = (Product) it.next();
			UserDTO uDTO = ConvertModelToDto.convertUserToDto(prod.getUser());
			ProductDTO productDTO = ConvertModelToDto.convertProductToDto(prod, uDTO);
			productsDTO.add(productDTO);

		}

		return productsDTO;

	}

}
