package any.artsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import any.artsoft.model.Product;

@Component
public class ProductMapper  implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProduct_id(rs.getInt("product_id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getInt("price"));
		//product.setUser_id(rs.getInt("user_id"));
		return product;
		
	}

}
