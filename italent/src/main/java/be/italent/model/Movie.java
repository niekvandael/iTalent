package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class Movie extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 2075313962607761537L;
	@Id
	@GeneratedValue
	private long id;
	
	@Size(max=40)
	private String youTubeId;
	
	@Size(max=500)
	private String description;
	
	@JsonManagedReference
	@ManyToOne
	private Project project;
}
