package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "users")
@Entity
public class Role implements Serializable{
	private static final long serialVersionUID = 8752830960429310663L;

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int roleId;
	
	@Size(min=1, max=20)
	@NotNull
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="role")
	private List<User> users = new ArrayList<User>();
}