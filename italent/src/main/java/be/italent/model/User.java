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
	private static final long serialVersionUID = 4864695207292402145L;

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
	private String email;
	
	@NotNull
	@Size(min=2, max=55)
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Size(min=8, max=80)
	@JsonIgnore
	private String password;
}