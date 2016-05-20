package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Domain extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 2431254846926665096L;

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(max=100)
	private String name;
	
	@Size(max=500)
	private String description;
	
	@Column(name="minimum_hours")
	private int MinimumHours;
	
	@Column(name="maximum_hours")
	private int MaximumHours;
}
