package service;

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
public class ProductsServiceImpl implements ProductsServiceInterface {

	@Autowired
	ProductsDaoImpl daoProduct;

	@Autowired
	UsersDaoImpl daoUser;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addProduct(ProductDTO productDTO, String username) {

		User user = daoUser.getUserByUsername(username);
		daoUser.updateLastAction(user);
		Product product = ConvertModelToDto.convertDtoToProduct(productDTO,user);
		daoProduct.create(product.getName(), product.getDescription(), product.getPrice(), user);

	}

	@Override
	public ProductDTO getProductById(int product_id) {

		Product product = daoProduct.getProduct(product_id);
		User user = daoUser.getUser(product.getUser().getUser_id());
		UserDTO uDTO = ConvertModelToDto.convertUserToDto(user);
		ProductDTO prodDTO = ConvertModelToDto.convertProductToDto(product,uDTO);
		return prodDTO;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateProduct(ProductDTO productDTO, String username) {

		User user = daoUser.getUserByUsername(username);
		daoUser.updateLastAction(user);
		Product product = ConvertModelToDto.convertDtoToProduct(productDTO,user);
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
