package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import be.italent.interfaces.ITalentEntity;

@Entity
public class Category extends ITalentEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8415387598073185560L;


	@Id
	@GeneratedValue
	private long id;
	
	@Size(max=200)
	private String description;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}