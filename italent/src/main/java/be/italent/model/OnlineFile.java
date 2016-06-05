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
public class OnlineFile extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = -7429965865146376099L;

	@Id
	@GeneratedValue
	@Column(name="online_file_id")
	private int onlineFileId;
	
	@Size(min=5, max=200)
	@NotNull
	private String url;
	
	@Size(max=500)
	@NotNull
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@NotNull
	private Project project;
}