package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Category extends AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = 8415387598073185560L;

	@Id
	@GeneratedValue
	private long id;
	
	@Size(max=200)
	private String description;
}