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
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prezi extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -1895055623204245402L;

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
}