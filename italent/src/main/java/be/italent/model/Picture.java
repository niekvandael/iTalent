package be.italent.model;

import java.io.Serializable;

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
public class Picture extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -3100198079094008798L;

	@Id
	@GeneratedValue
	private int id;
	
	//Eventueel json post/call converteren en pictures opslaan als bytes
	//@Lob 
	//@Column(length=100000)
	//private byte[] bytes;
	
	@Size(max=10000000)
	private String bytes;
	 
	@Size(max=500)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private Project project;
}