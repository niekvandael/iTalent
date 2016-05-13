package be.italent.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class SubscriberDocent extends Subscriber implements Serializable {
	private static final long serialVersionUID = 426095264135386703L;
	
	@Column(name="backing_pct")
	private int backingPct;
	
	public int getBackingPct() {
		return backingPct;
	}
	public void setBackingPct(int backingPct) {
		this.backingPct = backingPct;
	}
}
