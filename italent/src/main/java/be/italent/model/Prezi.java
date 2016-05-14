package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Prezi extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -8069058663611130322L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=100)
	@Column(name="prezi_id")
	private String preziId;
	
	@Size(max=500)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private Project project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreziId() {
		return preziId;
	}

	public void setPreziId(String preziId) {
		this.preziId = preziId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}