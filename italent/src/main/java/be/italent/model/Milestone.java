package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Milestone extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 8835977245280932297L;

	@Id
	@GeneratedValue
	private int id;
	
	private boolean done;
	
	@JsonIgnore
	@ManyToOne
	private Project project;

	private String description;
}