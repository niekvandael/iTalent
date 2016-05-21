package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
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
	private static final long serialVersionUID = -8836948740857309722L;

	@Id
	@GeneratedValue
	@Column(name="milestone_id")
	private int milestoneId;
	
	private boolean done;
	
	@JsonIgnore
	@ManyToOne
	private Project project;

	private String description;
}