package be.italent.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="findAllUserRoles", query="select u from UserRole as u")
@Entity
public class UserRole implements Serializable{
	private static final long serialVersionUID = -6207223955990641498L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private String role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
