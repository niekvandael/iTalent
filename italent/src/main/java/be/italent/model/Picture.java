package be.italent.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class Picture extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -3510424704524592845L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=100000)
	private byte[] bytes;
	
	@Size(max=500)
	private String description;
	
	@JsonManagedReference
	@ManyToOne
	private Project project;
}
