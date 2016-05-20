package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Department extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 6396045402832213595L;

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=55)
	private String name;
}