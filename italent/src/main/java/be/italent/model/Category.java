package be.italent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractITalentEntity implements Serializable{
	private static final long serialVersionUID = 4342196308627469467L;

	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int categoryId;
	
	@Size(min=1, max=50)
	@NotNull
	private String description;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private List<Project> projects = new ArrayList<Project>();
}