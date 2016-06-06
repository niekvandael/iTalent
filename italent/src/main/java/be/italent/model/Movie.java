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

/**
 * This class represents a YouTube Movie.
 * 
 * @author Team 1
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Movie extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -3667946646976765309L;

	@Id
	@GeneratedValue
	@Column(name="movie_id")
	private int movieId;
	
	@Size(min=11, max=11)
	@Column(name="youtube_code")
	@NotNull
	private String youTubeCode;
	
	@Size(min=2, max=500)
	@NotNull
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@NotNull
	private Project project;
}