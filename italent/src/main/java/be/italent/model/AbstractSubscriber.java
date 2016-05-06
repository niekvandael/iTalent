package be.italent.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
public class AbstractSubscriber extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 8880123919043305925L;

	@Id
	@GeneratedValue
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	private Project project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}