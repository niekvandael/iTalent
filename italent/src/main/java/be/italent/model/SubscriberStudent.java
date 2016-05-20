package be.italent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SubscriberStudent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 3925239470278575202L;
	
	private int hours;
}
