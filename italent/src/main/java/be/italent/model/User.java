package be.italent.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 2013292116325497059L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, max=55)
	private String firstname;
	
	@Size(min=2, max=55)
	private String lastname;
	
	@OneToOne
	private Role role;
	
	@OneToOne
	private Department department;
	
	@NotNull
	@Size(min=2, max=55)
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Size(min=8, max=80)
	private String password;
}
