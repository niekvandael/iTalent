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
public class Picture extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -2266459573075734178L;

	@Id
	@GeneratedValue
	@Column(name="picture_id")
	private int pictureId;
	
	@Size(max=1000000)
	@NotNull
	private String bytes;
	 
	@Size(min=2, max=500)
	@NotNull
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@NotNull
	private Project project;
}