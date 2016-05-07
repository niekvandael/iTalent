package be.italent.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User implements Serializable{
	private static final long serialVersionUID = 2013292116325497059L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, max=55)
	private String firstname;
	
	@Size(min=2, max=55)
	private String lastname;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Role role;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;
	
	@NotNull
	@Size(min=2, max=55)
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Size(min=8, max=80)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
	
	
}