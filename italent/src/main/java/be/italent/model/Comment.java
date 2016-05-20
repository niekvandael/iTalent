package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Comment extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -2741183697423201839L;

	@Id
	@GeneratedValue
	private int id;
	
	@JsonIgnore
	@ManyToOne
	private Project project;

	@Lob
	private String message;
	
	@OneToOne
	private User user;
}