package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SubscriberStudent extends Subscriber implements Serializable {
	private static final long serialVersionUID = -390092451124319585L;

	@Id
	@GeneratedValue
	@Column(name="subscriber_student_id")
	private int subscriberStudenId;
	
	private int hours;
}
