package any.artsoft.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import any.artsoft.model.Product;
import any.artsoft.model.User;

@SuppressWarnings("deprecation")
@Transactional(readOnly=true)
@Repository("daoProduct")
public class ProductsDaoImpl implements ProductsDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void create(String name, String description, int price, User user) {

		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setUser(user);
		Session session =  this.getSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public Product getProduct(int product_id) {
		
		Session session = getSession();
		session.beginTransaction();
		String SQL_QUERY = " from Product  where product_id=? ";
		Query<Product> query = session.createQuery(SQL_QUERY);
		query.setParameter(0, product_id);
		Product product = query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		
		Session session =  this.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = (List<Product>) criteria.list();
		session.getTransaction().commit();
		session.close();
		return products;
	}

	@Override
	public void delete(int product_id) {

		Session session =  this.getSession();
		session.beginTransaction();
		Product product = session.get(Product.class, product_id);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void update(Product product) {
		
		Session session =  this.getSession();
		session.beginTransaction();
		Product prod = session.get(Product.class, product.getProduct_id());
		prod.setProduct_id(product.getProduct_id());
		prod.setName(product.getName());
		prod.setDescription(product.getDescription());
		prod.setPrice(product.getPrice());		
		session.update(prod);
		session.getTransaction().commit();
		session.close();

	}

}
