package be.italent.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class SubscriberDocent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 426095264135386703L;
	private int backingPct;

	public int getBackingPct() {
		return backingPct;
	}

	public void setBackingPct(int backingPct) {
		this.backingPct = backingPct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + backingPct;
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
		SubscriberDocent other = (SubscriberDocent) obj;
		if (backingPct != other.backingPct)
			return false;
		return true;
	} 
}
