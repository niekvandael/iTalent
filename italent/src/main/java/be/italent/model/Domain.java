package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Domain extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(max=100)
	private String name;
	
	@Size(max=500)
	private String description;
	
	@Column(name="minimum_hours")
	private int MinimumHours;
	
	@Column(name="maximum_hours")
	private int MaximumHours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinimumHours() {
		return MinimumHours;
	}

	public void setMinimumHours(int minimumHours) {
		MinimumHours = minimumHours;
	}

	public int getMaximumHours() {
		return MaximumHours;
	}

	public void setMaximumHours(int maximumHours) {
		MaximumHours = maximumHours;
	}
}
