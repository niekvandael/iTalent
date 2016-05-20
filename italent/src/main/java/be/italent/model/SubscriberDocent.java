package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SubscriberDocent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 2181871138971848406L;
	
	@Column(name="backing_pct")
	private int backingPct;
}
