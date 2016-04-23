package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;

@Data
@Entity
public class SubscriberDocent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 426095264135386703L;
	private int backingPct;
}
