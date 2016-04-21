package be.italent.model;

import javax.validation.constraints.Size;


public class Category extends ITalentEntity{
	
	
	
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
