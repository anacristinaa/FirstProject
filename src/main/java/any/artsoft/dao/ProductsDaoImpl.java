package any.artsoft.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import any.artsoft.model.Product;

@Repository
public class ProductsDaoImpl implements ProductsDaoInterface {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public void create(String name, String description, int price, int user_id) {

		String SQL = "insert into products (name, description,price,user_id ) values (?, ?, ?, ?)";
		jdbcTemplate.update(SQL, name, description, price, user_id);

	}

	@Override
	public Product getProduct(int product_id) {
		String sql = "select * from products where product_id = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] { product_id }, new ProductMapper());

		return product;
	}

	@Override
	public List<Product> listProducts() {
		String sql = "select * from products";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());

		return products;
	}

	@Override
	public void delete(int product_id) {

		String sql = "delete from products where product_id = ? ";
		jdbcTemplate.update(sql, product_id);
	}

	@Override
	public void update(Product product) {

		String sql = "update products set name = ?, description = ?, price = ? where product_id = ?";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(),
				product.getProduct_id());

	}

}
