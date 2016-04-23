package be.italent.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Data
@Entity
public class Role implements Serializable{
	private static final long serialVersionUID = -6207223955990641498L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(max=20)
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<User> users = new ArrayList<User>();
}
