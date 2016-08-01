package any.artsoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private int user_id;
	private String username;
	private String password;
	private boolean enabled;
	private Date lastaction;
	
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
	
	public String toString(){
		return "User: " + this.getUser_id() +
				" " + this.getUsername() + 
				" " + this.getLastaction();
	}
}
