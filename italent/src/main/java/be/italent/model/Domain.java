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
	private static final long serialVersionUID = -1569050112924442703L;

	@Id
	@GeneratedValue
	@Column(name="domain_id")
	private int domainId;
	
	@NotNull
	@Size(min=1, max=100)
	private String name;
	
	@Size(min=2, max=500)
	private String description;
	
	@Column(name="minimum_hours")
	private int minimumHours;
	
	@Column(name="maximum_hours")
	private int maximumHours;
}
