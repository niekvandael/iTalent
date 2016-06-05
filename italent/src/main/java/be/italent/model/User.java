package be.italent.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User implements Serializable{
	private static final long serialVersionUID = -6542852738048028268L;

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Size(min=2, max=55)
	@NotNull
	private String firstname;
	
	@Size(min=2, max=55)
	@NotNull
	private String lastname;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Role role;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;
	
	@NotNull
	@Size(min=5, max=100)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Size(min=2, max=55)
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Size(min=6, max=80)
	@JsonIgnore
	private String password;
}