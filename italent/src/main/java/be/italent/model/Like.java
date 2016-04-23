package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
@Table(name="Likes")
public class Like extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -2109302458723083487L;
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private User user;
	
	@JsonManagedReference
	@ManyToOne
	private Project project;
}
