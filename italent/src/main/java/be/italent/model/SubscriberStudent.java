package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + hours;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscriberStudent other = (SubscriberStudent) obj;
		if (hours != other.hours)
			return false;
		return true;
	}
}
