package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = -6440767198679505981L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=200)
	private String description;
}