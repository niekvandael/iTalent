package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
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
	private static final long serialVersionUID = -3154047011069517316L;

	@Id
	@GeneratedValue
	@Column(name="comment_id")
	private int commentId;
	
	@JsonIgnore
	@ManyToOne
	private Project project;

	@Lob
	private String message;
	
	@OneToOne
	private User user;
}