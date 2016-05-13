package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;

@Data
@Entity
public class SubscriberStudent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 4992941772661082318L;
	
	private int hours;
	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
}
