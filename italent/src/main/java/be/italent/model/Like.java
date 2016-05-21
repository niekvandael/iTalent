package be.italent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="likes")
public class Like extends AbstractITalentEntity implements Serializable {
	private static final long serialVersionUID = 7546092683943395344L;

	@Id
	@GeneratedValue
	@Column(name="like_id")
	private int likeId;
	
	@OneToOne
	private User user;
	
	@JsonIgnore
	@ManyToOne
	private Project project;
}