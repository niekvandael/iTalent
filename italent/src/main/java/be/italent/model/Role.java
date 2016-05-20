package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "users")
@Entity
public class Role implements Serializable{
	private static final long serialVersionUID = -6836673373609047169L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=20)
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="role")
	private List<User> users = new ArrayList<User>();
}