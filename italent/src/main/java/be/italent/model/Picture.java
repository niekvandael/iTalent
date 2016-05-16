package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import be.italent.views.Views;
import lombok.Data;

@Data
@Entity
public class Picture extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -3510424704524592845L;
	
	@Id
	@GeneratedValue
	private int id;
	
	/* 
	 * TESTING PURPOSES: TO ALLOW IMPORT.SQL INSERING PICTURES TO TEST
	 * @Lob @Basic(fetch = FetchType.LAZY)
	 * @Column(length=100000)
	 * private String bytes; // private byte[] bytes;
	 * END: TESTING PURPOSES: TO ALLOW IMPORT.SQL INSERING PICTURES TO TEST
	 */
	@Size(max=10000000)
	@JsonView(Views.List.class)
	private String bytes;
	
	@Size(max=500)
	@JsonView(Views.List.class)
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