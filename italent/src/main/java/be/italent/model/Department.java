package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Department extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -990111961817384285L;

	@Id
	@GeneratedValue
	@Column(name="department_id")
	private int departmentId;
	
	@Size(min=1, max=55)
	@NotNull
	private String name;
}