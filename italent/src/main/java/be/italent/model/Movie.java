package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
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
public class Movie extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -3667946646976765309L;

	@Id
	@GeneratedValue
	@Column(name="movie_id")
	private int movieId;
	
	@Size(max=40)
	@Column(name="youtube_code")
	private String youTubeCode;
	
	@Size(max=500)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private Project project;
}