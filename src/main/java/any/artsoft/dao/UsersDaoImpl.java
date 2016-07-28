package any.artsoft.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import any.artsoft.model.Product;
import any.artsoft.model.User;

@Repository
public class UsersDaoImpl implements UserDaoInterface {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public void register(String username, String password) {
		String hashedPass = this.generateHashedPassword(password);
		Date date = new Date();
		String sql = "insert into users (username, password, enabled,lastaction) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, username, hashedPass, true, date);
	}

	@Override
	public User getUser(int user_id) {
		String sql = "select * from users where user_id = ?";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { user_id }, new UserMapper());

		return user;
	}

	@Override
	public void updateLastAction(String username) {
		Date lastaction = new Date();
		String sql = "update users set lastaction = ? where username = ?";
		jdbcTemplate.update(sql, lastaction, username);

	}

	@Override
	public List<User> listUsers() {
		String sql = "select * from users";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "select * from users where username = ?";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserMapper());
		return user;
	}

	@Override
	public List<Product> getUsersProduct(int user_id) {
		String sql = "select * from products where user_id = ?";
		List<Product> products = jdbcTemplate.query(sql, new Object[] { user_id }, new ProductMapper());
		return products;
	}

	public void registerUserRole(User user){
		String role = "ROLE_USER";
		String sql = "insert into user_roles (user_id,role) values (?, ?)";
		jdbcTemplate.update(sql,user.getUser_id(),role);
				
	}

	private String generateHashedPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println("Password: " + password + " Hashed: " + hashedPassword);
		return hashedPassword;
	}
		

}
