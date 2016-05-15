package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import be.italent.views.Views;

@Data
@Entity
public class Category extends AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = 8415387598073185560L;

	@Id
	@GeneratedValue
	@JsonView(Views.List.class)
	private int id;
	
	@Size(max=200)
	@JsonView(Views.List.class)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}