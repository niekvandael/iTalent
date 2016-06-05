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
public class Milestone extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -8836948740857309722L;

	@Id
	@GeneratedValue
	@Column(name="milestone_id")
	private int milestoneId;
	
	private boolean done;
	
	@JsonIgnore
	@ManyToOne
	@NotNull
	private Project project;

	@NotNull
	@Size(min=2, max=500)
	private String description;
}