package any.artsoft.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column(name = "username")
	private String username;
	
	@Column
	private String password;
	
	@Column
	private boolean enabled;
	
	@Column
	private Date lastaction;

	@OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Product> products;
	
	public User(){
		
	}

	public User(int id,String name,String pass,Date date){
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastaction() {
		return lastaction;
	}

	public void setLastaction(Date lastaction) {
		this.lastaction = lastaction;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String toString() {
		return "User: " + this.getUser_id() + " " + this.getUsername() + " " + this.getLastaction() +
				" E: " + this.isEnabled() + " " + this.getPassword();
	}
}
