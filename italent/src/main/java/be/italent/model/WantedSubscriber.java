package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class WantedSubscriber extends AbstractSubscriber implements Serializable {
	private static final long serialVersionUID = 4573804488925223309L;

	@Id
	@GeneratedValue
	@Column(name="wanted_subscriber_id")
	private int wantedSubscriberId;
	
	@NotNull
	private int number;
	
	@OneToOne
	@NotNull
	private Department department;
}