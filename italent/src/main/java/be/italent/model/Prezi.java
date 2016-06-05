package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prezi extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -6497186589502207031L;

	@Id
	@GeneratedValue
	@Column(name="prezi_id")
	private int preziId;
	
	@Size(min=2, max=100)
	@NotNull
	@Column(name="prezi_code")
	private String preziCode;
	
	@Size(min=2, max=500)
	@NotNull
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@NotNull
	private Project project;
}