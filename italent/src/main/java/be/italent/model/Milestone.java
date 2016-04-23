package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class Milestone extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 4572147731049218685L;
	@Id
	@GeneratedValue
	private long id;
	
	private boolean done;
	
	@JsonManagedReference
	@ManyToOne
	private Project project;
}
