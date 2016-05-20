package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Picture extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 4004089689489104282L;

	@Id
	@GeneratedValue
	private int id;
	
	//Eventueel json post/call converteren en pictures opslaan als bytes
	//@Lob 
	//@Column(length=100000)
	//private byte[] bytes;
	
	@Size(max=10000000)
	private String bytes;
	 
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

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
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