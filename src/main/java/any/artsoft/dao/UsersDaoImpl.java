package any.artsoft.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import any.artsoft.model.Product;
import any.artsoft.model.User;
import any.artsoft.model.UserRoles;

@SuppressWarnings("deprecation")
@Repository
@Transactional(readOnly=true)
public class UsersDaoImpl implements UserDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public User register(String username, String password) {
		
		Session session = this.getSession();
		session.beginTransaction();		
		User user = new User();
		String hashedPass = this.generateHashedPassword(password);
		Date date = new Date();
		user.setUsername(username);
		user.setPassword(hashedPass);
		user.setLastaction(date);
		user.setEnabled(true);
		session.save(user);
		session.getTransaction().commit();
		session.close();
 
		return user;
	}

	@Override
	public User getUser(int user_id) {
		
		Session session = getSession();
		session.beginTransaction();
		User user = session.get(User.class, user_id);
		System.out.println("User by ID: " + user.toString());
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public void updateLastAction(User user) {
		Date lastaction = new Date();

		Session session = this.getSession();
		session.beginTransaction();
		User userUpdate = session.get(User.class, user.getUser_id());
		userUpdate.setEnabled(true);
		userUpdate.setLastaction(lastaction);
		userUpdate.setPassword(user.getPassword());
		userUpdate.setUsername(user.getUsername());
		session.update(userUpdate);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		
		Session session = this.getSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		List<User> users = cr.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}


	@Override
	public User getUserByUsername(String username) {

		Session session = getSession();
		session.beginTransaction();		
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();			
		session.getTransaction().commit();
		session.close();
	
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getUsersProduct(int user_id) {
		
		Session session = getSession();
		session.beginTransaction();
		String SQL_QUERY = " from Product  where user_id = ? ";
		Query<Product> query = session.createQuery(SQL_QUERY);
		query.setParameter(0, user_id);
		List<Product> products = query.list();
		session.getTransaction().commit();
		session.close();
		
		return products;
	}

	public void registerUserRole(User user1) {
		
		Session session = this.getSession();
		session.beginTransaction();
		String role = "ROLE_USER";
		User user = (User) session.merge(user1);
		UserRoles userUpdate = new UserRoles();
		userUpdate.setUser_id(user.getUser_id());
		userUpdate.setRole(role);
		session.save(userUpdate);
		session.getTransaction().commit();
		session.close();

	}

	private String generateHashedPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println("Password: " + password + " Hashed: " + hashedPassword);
		return hashedPassword;
	}

}
