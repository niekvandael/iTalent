package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SubscriberDocent extends Subscriber implements Serializable {
	private static final long serialVersionUID = -668971404145096946L;

	@Id
	@GeneratedValue
	@Column(name="subscriber_docent_id")
	private int subscriberDocentId;
	
	@Column(name="backing_pct")
	@NotNull
	private int backingPct;
}
